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

import jhelp.engine.geom.Equation3D;

/**
 * Listener to know when equation 3D is ready<br>
 * <br>
 * Last modification : 12 aoet 2010<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
public interface Equation3DListener
{
   /**
    * Call when an equation 3D is ready
    * 
    * @param equation3D
    *           Equation ready
    */
   public void equation3Dready(Equation3D equation3D);
}