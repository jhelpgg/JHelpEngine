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

import java.awt.Color;

import jhelp.engine.Texture;

/**
 * Order to clear a texture
 * 
 * @author JHelp
 */
class ClearTexture
      extends DrawOnTexture
{
   /** Color used to clear */
   private final Color color;

   /**
    * Create a new instance of ClearTexture
    * 
    * @param color
    *           Color used to clear
    */
   public ClearTexture(final Color color)
   {
      this.color = color;
   }

   /**
    * Clear the given texture <br>
    * <br>
    * <b>Parent documentation:</b><br>
    * {@inheritDoc}
    * 
    * @param texture
    *           Texture to clear
    * @see jhelp.engine.graphics.DrawOnTexture#draw(jhelp.engine.Texture)
    */
   @Override
   public void draw(final Texture texture)
   {
      texture.clear(this.color);
   }

   /**
    * Indicates that this drawing modify completely the texture and can't be reversed <br>
    * <br>
    * <b>Parent documentation:</b><br>
    * {@inheritDoc}
    * 
    * @return {@code true}
    * @see jhelp.engine.graphics.DrawOnTexture#isAbsorber()
    */
   @Override
   public boolean isAbsorber()
   {
      return true;
   }
}