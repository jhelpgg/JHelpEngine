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
package jhelp.engine;

/**
 * Listener for UV picking <br>
 * <br>
 * Last modification : 26 juil. 2009<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
public interface PickUVlistener
{
   /**
    * Call when UV is pick
    * 
    * @param u
    *           U pick : [0, 255]
    * @param v
    *           V pick : [0, 255]
    * @param node
    *           Node pick
    */
   public void pickUV(int u, int v, Node node);
}