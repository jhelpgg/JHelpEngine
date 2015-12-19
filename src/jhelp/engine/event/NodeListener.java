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

import jhelp.engine.Node;

/**
 * Node event's listener <br>
 * <br>
 * Last modification : 21 janv. 2009<br>
 * Version 0.0.1<br>
 * 
 * @author JHelp
 */
public interface NodeListener
{
   /**
    * Call when mouse click on a node
    * 
    * @param node
    *           Node click
    * @param leftButton
    *           Indicates if the left button is down
    * @param rightButton
    *           Indicates if the right button is down
    */
   public void mouseClick(Node node, boolean leftButton, boolean rightButton);

   /**
    * Call when mouse enter on a node
    * 
    * @param node
    *           Node enter
    */
   public void mouseEnter(Node node);

   /**
    * Call when mouse exit on a node
    * 
    * @param node
    *           Node exit
    */
   public void mouseExit(Node node);
}