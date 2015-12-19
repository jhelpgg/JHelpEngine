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
 * Vertical layout constraints<br>
 * <br>
 * Last modification : 29 juil. 2009<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
public final class VerticalLayoutConstraints
      implements Constraints
{
   /** Next code */
   private static int NEXT_CODE = 0;

   /**
    * Create new Vertical layout constraints
    * 
    * @return Vertical layout constraints
    */
   public static VerticalLayoutConstraints obtainVerticalLayoutConstraints()
   {
      return new VerticalLayoutConstraints();
   }

   /** Layout code */
   private final int code;

   /**
    * Constructs VerticalLyoutConstraints
    */
   private VerticalLayoutConstraints()
   {
      this.code = VerticalLayoutConstraints.NEXT_CODE++;
   }

   /**
    * Compare with an other constraints
    * 
    * @param constraints
    *           Constraints to compare
    * @return {@code true} if equals
    * @see jhelp.engine.gui.layout.Constraints#equals(jhelp.engine.gui.layout.Constraints)
    */
   @Override
   public boolean equals(final Constraints constraints)
   {
      return ((VerticalLayoutConstraints) constraints).code == this.code;
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
      return this.code;
   }
}