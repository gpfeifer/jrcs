/*
 * Copyright (c) 1999-2006 Juancarlo A�ez
 * All rights reserved.
 *
 * $Id: MyersDiffTests.java,v 1.2 2006/06/08 01:22:27 juanca Exp $
 *
 * For usage rights please see the LICENSE.* files that 
 * come bundled with legal distributions of this resource.
 *  
 * Fore more information please email Juancarlo A�ez at:
 *      juanca@suigeneris.org
 *      juancarlo.anez@gmail.com
 */

package org.suigeneris.jrcs.diff;

import org.suigeneris.jrcs.diff.myers.MyersDiff;

public class MyersDiffTests extends DiffTest
{

    public MyersDiffTests(String name)
    {
        super(name, new MyersDiff());
    }

}
