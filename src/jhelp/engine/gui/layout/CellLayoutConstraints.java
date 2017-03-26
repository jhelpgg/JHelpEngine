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

import jhelp.util.HashCode;

/**
 * Cells layout constraints<br>
 * <br>
 * Last modification : 27 juin 2010<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
public class CellLayoutConstraints
      implements Constraints
{
   /** Number of cell in height */
   final int height;
   /** Number of cell in width */
   final int width;
   /** X cell */
   final int x;
   /** Y cell */
   final int y;

   /**
    * Constructs CellLayoutConstraints
    * 
    * @param x
    *           X cell
    * @param y
    *           Y cell
    * @param width
    *           Number of cell in width
    * @param height
    *           Number of cell in height
    */
   public CellLayoutConstraints(final int x, final int y, final int width, final int height)
   {
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
   }

   /**
    * Indicates if constraints is equals
    * 
    * @param constraints
    *           Constraints tested
    * @return {@code true} if constraints is equals
    * @see jhelp.engine.gui.layout.Constraints#equals(jhelp.engine.gui.layout.Constraints)
    */
   @Override
   public boolean equals(final Constraints constraints)
   {
      if(constraints == this)
      {
         return true;
      }

      if(!(constraints instanceof CellLayoutConstraints))
      {
         return false;
      }

      final CellLayoutConstraints cellLayoutConstraints = (CellLayoutConstraints) constraints;

      return (this.x == cellLayoutConstraints.x) && (this.y == cellLayoutConstraints.y) && (this.width == cellLayoutConstraints.width)
            && (this.height == cellLayoutConstraints.height);
   }

   /**
    * Hash code
    * 
    * @return Hash code
    * @see java.lang.Object#hashCode()
    */
   @Override
   public int hashCode()
   {
      return HashCode.computeHashCode(this.x, this.y, this.width, this.height);
   }
}