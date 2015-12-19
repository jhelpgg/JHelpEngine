/**
 * <h1>License :</h1> <br>
 * The following code is deliver as is. I take care that code compile and work, but I am not responsible about any damage it may
 * cause.<br>
 * You can use, modify, the code as your need for any usage. But you can't do any action that avoid me or other person use,
 * modify this code. The code is free for usage and modification, you can't change that fact.<br>
 * <br>
 * 
 * @author JHelp
 */
package jhelp.engine.gui.events;

import jhelp.engine.gui.FrameView3D;

/**
 * Frame 3D view exit listener <br>
 * <br>
 * Last modification : 28 mars 2010<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
public interface Frame3DViewListener
{
   /**
    * Call before frame 3D view will exit
    * 
    * @param frameView3D
    *           Frame that will exit
    */
   public void frame3DExit(FrameView3D frameView3D);
}