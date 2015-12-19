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

import jhelp.engine.twoD.Button2D;

/**
 * Listener of button 2D click
 * 
 * @author JHelp
 */
public interface Button2DListener
{
   /**
    * Called when button click
    * 
    * @param button2d
    *           Clicked button
    * @param buttonID
    *           Clicked button ID
    */
   public void button2DClicked(Button2D button2d, int buttonID);
}