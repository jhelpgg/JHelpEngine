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
 * Layout constraints<br>
 * <br>
 * Last modification : 29 juil. 2009<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
public interface Constraints
{
   /**
    * Indicates if equals to other constraints
    * 
    * @param constraints
    *           Constraints tested
    * @return {@code true} if equals to other constraints
    */
   public boolean equals(Constraints constraints);

   /**
    * Hash code
    * 
    * @return Hash code
    */
   @Override
   public int hashCode();
}