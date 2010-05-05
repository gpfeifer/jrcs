/*
 * Copyright (c) 1999-2006 Juancarlo A�ez
 * All rights reserved.
 *
 * $Id: DiffNode.java,v 1.2 2006/06/08 01:22:27 juanca Exp $
 *
 * For usage rights please see the LICENSE.* files that 
 * come bundled with legal distributions of this resource.
 *  
 * Fore more information please email Juancarlo A�ez at:
 *      juanca@suigeneris.org
 *      juancarlo.anez@gmail.com
 */

package org.suigeneris.jrcs.diff.myers;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

/**
 * A diffnode in a diffpath.
 * <p>
 * A DiffNode and its previous node mark a delta between two input sequences,
 * that is, two differing subsequences between (possibly zero length) matching
 * sequences.
 * 
 * {@link DiffNode DiffNodes} and {@link Snake Snakes} allow for compression of
 * diffpaths, as each snake is represented by a single {@link Snake Snake} node
 * and each contiguous series of insertions and deletions is represented by a
 * single {@link DiffNode DiffNodes}.
 * 
 * @version $Revision: 1.2 $ $Date: 2006/06/08 01:22:27 $
 * @author <a href="mailto:juanco@suigeneris.org">Juanco Anez</a>
 * 
 */
public final class DiffNode extends PathNode
{
    /**
     * Constructs a DiffNode.
     * <p>
     * DiffNodes are compressed. That means that the path pointed to by the
     * <code>prev</code> parameter will be followed using
     * {@link PathNode#previousSnake} until a non-diff node is found.
     * 
     * @param the
     *            position in the original sequence
     * @param the
     *            position in the revised sequence
     * @param prev
     *            the previous node in the path.
     */
    public DiffNode(int i, int j, PathNode prev)
    {
        super(i, j, (prev == null ? null : prev.previousSnake()));
    }

    /**
     * {@inheritDoc}
     * 
     * @return false, always
     */
    public boolean isSnake()
    {
        return false;
    }

}