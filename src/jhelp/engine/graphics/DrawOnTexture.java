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
package jhelp.engine.graphics;

import jhelp.engine.Texture;

/**
 * Layer on texture<br>
 * <br>
 * Last modification : 23 juin 2009<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
abstract class DrawOnTexture
{
   /**
    * Draw the layer
    * 
    * @param texture
    *           Texture where draw
    */
   public abstract void draw(Texture texture);

   /**
    * Indicates if this draw change the texture so that any action before is useless
    * 
    * @return {@code true} if this draw change the texture so that any action before is useless
    */
   public boolean isAbsorber()
   {
      return false;
   }
}