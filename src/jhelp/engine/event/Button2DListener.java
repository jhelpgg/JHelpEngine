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