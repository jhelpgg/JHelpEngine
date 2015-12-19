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

import jhelp.engine.gui.components.InternalFrame;

/**
 * Listener selection internal frame<br>
 * <br>
 * Last modification : 28 juin 2010<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
public interface InternalFrameListener
{
   /**
    * Call on internal frame selection
    * 
    * @param internalFrame
    *           Internal frame selected
    */
   public void internalFrameSelect(InternalFrame internalFrame);
}