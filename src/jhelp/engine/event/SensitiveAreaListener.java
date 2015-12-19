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

/**
 * Listener of sensitive area events
 * 
 * @author JHelp
 */
public interface SensitiveAreaListener
{
   /**
    * Called when click on an area
    * 
    * @param area
    *           Clicked area
    */
   public void senstiveClick(int area);

   /**
    * Called when enter on an area
    * 
    * @param area
    *           Entered area
    */
   public void senstiveEnter(int area);

   /**
    * Called when exit on an area
    * 
    * @param area
    *           Exited area
    */
   public void senstiveExit(int area);
}