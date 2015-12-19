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

import java.util.EventListener;

/**
 * Listener when user click not in 3D object, nor 2D object
 * 
 * @author JHelp
 */
public interface ClickInSpaceListener
      extends EventListener
{
   /**
    * Called when user click not in 3D object, nor 2D object
    * 
    * @param mouseX
    *           Mouse X
    * @param mouseY
    *           Mouse Y
    * @param leftButton
    *           Indicates if left mouse button is down
    * @param rightButton
    *           Indicates if right mouse button is down
    */
   public void clickInSpace(int mouseX, int mouseY, boolean leftButton, boolean rightButton);
}