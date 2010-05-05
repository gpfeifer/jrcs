/*
 * Copyright (c) 1999-2006 Juancarlo A�ez
 * All rights reserved.
 *
 * $Id: BranchNotFoundException.java,v 1.3 2006/06/08 15:07:11 juanca Exp $
 *
 * For usage rights please see the LICENSE.* files that 
 * come bundled with legal distributions of this resource.
 *  
 * Fore more information please email Juancarlo A�ez at:
 *      juanca@suigeneris.org
 *      juancarlo.anez@gmail.com
 */

package org.suigeneris.jrcs.rcs;

import org.suigeneris.jrcs.rcs.impl.NodeNotFoundException;

public class BranchNotFoundException extends NodeNotFoundException
{
    public BranchNotFoundException()
    {
        super();
    }

    public BranchNotFoundException(Version v)
    {
        super(v);
    }
}
