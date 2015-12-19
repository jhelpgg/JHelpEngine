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
package jhelp.engine.event;

import jhelp.engine.geom.Ribbon3D;

/**
 * Listner to know when ribbon is ready
 * 
 * @author JHelp
 */
public interface Ribbon3DListener
{
   /**
    * Called when ribbon ready
    * 
    * @param ribbon3d
    *           Ready ribbon
    */
   public void ribbonReady(Ribbon3D ribbon3d);
}