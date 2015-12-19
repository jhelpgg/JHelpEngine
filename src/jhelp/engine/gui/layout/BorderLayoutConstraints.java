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

/**
 * Border layout constraints<br>
 * <br>
 * Last modification : 26 juin 2010<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
public enum BorderLayoutConstraints
      implements Constraints
{
   /** Bottom position */
   BOTTOM,
   /** Bottom left position */
   BOTTOM_LEFT,
   /** Bottom right position */
   BOTTOM_RIGHT,
   /** Center position */
   CENTER,
   /** Left position */
   LEFT,
   /** Right position */
   RIGHT,
   /** Top position */
   TOP,
   /** Top left position */
   TOP_LEFT,
   /** Top right position */
   TOP_RIGHT;
   /**
    * Indicates if constraints equals
    * 
    * @param constraints
    *           Constraints test
    * @return {@code true} if equals
    * @see jhelp.engine.gui.layout.Constraints#equals(jhelp.engine.gui.layout.Constraints)
    */
   @Override
   public boolean equals(final Constraints constraints)
   {
      return constraints == this;
   }
}