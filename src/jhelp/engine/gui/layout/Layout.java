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
package jhelp.engine.gui.layout;

import java.awt.Dimension;

/**
 * Layout components<br>
 * <br>
 * Last modification : 29 juil. 2009<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
public abstract class Layout
{
   /**
    * Constructs Layout
    */
   public Layout()
   {
   }

   /**
    * Compute preferred size
    * 
    * @param width
    *           Space width
    * @param height
    *           Space height
    * @param elements
    *           Elements to layout
    * @return Preferred size
    */
   public abstract Dimension computePrefferedSize(int width, int height, LayoutElement... elements);

   /**
    * Layout components
    * 
    * @param width
    *           Space with
    * @param height
    *           Space height
    * @param elements
    *           Element to layout
    */
   public abstract void layout(int width, int height, LayoutElement... elements);
}