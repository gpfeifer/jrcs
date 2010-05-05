/*
 * Copyright (c) 1999-2006 Juancarlo A�ez
 * All rights reserved.
 *
 * $Id: Lines.java,v 1.1 2006/06/08 15:07:11 juanca Exp $
 *
 * For usage rights please see the LICENSE.* files that 
 * come bundled with legal distributions of this resource.
 *  
 * Fore more information please email Juancarlo A�ez at:
 *      juanca@suigeneris.org
 *      juancarlo.anez@gmail.com
 */

package org.suigeneris.jrcs.rcs.impl;

import java.text.Format;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;

import org.suigeneris.jrcs.diff.Diff;
import org.suigeneris.jrcs.rcs.Archive;

/**
 * A list of the lines in the text of a revision annotated with the version that
 * corresponds to each line.
 * 
 * @see Line
 * @see Archive
 * 
 * @author <a href="mailto:juanco@suigeneris.org">Juanco Anez</a>
 * @version $Id: Lines.java,v 1.1 2006/06/08 15:07:11 juanca Exp $
 */
public class Lines extends ArrayList
{

    public static final Format annotationFormat = new MessageFormat(
            "{0,,        } ({1} {2,  date,dd-MMM-yyyy}):");

    public Lines()
    {
    }

    public Lines(String text)
    {
        this(null, Diff.stringToArray(text));
    }

    public Lines(Node release, String text)
    {
        this(release, Diff.stringToArray(text));
    }

    public Lines(Object[] text)
    {
        this(null, text);
    }

    public Lines(Node release, Object[] text)
    {
        for (int i = 0; i < text.length; i++)
        {
            super.add(new Line(release, text[i]));
        }
    }

    public boolean add(Object o)
    {
        return super.add((Line) o);
    }

    public Object[] toArray()
    {
        return toArray(false);
    }

    public Object[] toArray(boolean annotate)
    {
        Object[] result = new Object[this.size()];
        Iterator r = this.iterator();
        int i = 0;
        while (r.hasNext())
        {
            Line l = (Line) r.next();
            Object o = l.getText();
            if (annotate)
            {
                Node rev = l.getRevision();
                o = annotationFormat.format(new Object[]
                { rev.getVersion(), rev.getAuthor(), rev.getDate() });
            }
            result[i++] = o;
        }
        return result;
    }

    public String toString()
    {
        return toString(false);
    }

    public String toString(boolean annotate)
    {
        return Diff.arrayToString(this.toArray(annotate));
    }
}
