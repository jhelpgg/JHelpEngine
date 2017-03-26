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

import java.awt.Color;
import java.io.IOException;

import javax.media.opengl.GL;

import jhelp.util.gui.GIF;
import jhelp.util.gui.dynamic.font.FontGif;
import jhelp.util.gui.dynamic.font.GifPosition;
import jhelp.util.gui.dynamic.font.GifText;

/**
 * Texture based on font based on GIF
 * 
 * @author JHelp
 */
public class TextureFontGif
      extends Texture
      implements Animation
{
   /** Font based on GIF */
   private final FontGif fontGif;
   /** Text with GIF */
   private GifText       gifText;
   /** Start animation absolute frame */
   private float         startAbsoluteFrame;
   /** Text to draw */
   private String        text;

   /**
    * Create a new instance of TextureFontGif
    * 
    * @param fontGifName
    *           Font based on GIF name
    */
   public TextureFontGif(final String fontGifName)
   {
      this(fontGifName, "");
   }

   /**
    * Create a new instance of TextureFontGif
    * 
    * @param fontGifName
    *           Font based on GIF
    * @param text
    *           Text to draw
    */
   public TextureFontGif(final String fontGifName, final String text)
   {
      super(fontGifName, Texture.REFERENCE_FONT_GIF);

      if(text == null)
      {
         throw new NullPointerException("text musn't be null");
      }

      try
      {
         this.fontGif = new FontGif(fontGifName);
      }
      catch(final IOException exception)
      {
         throw new IllegalArgumentException("The font GIF " + fontGifName + " can't be parsed ", exception);
      }

      this.text = text;
      this.setPixels(1, 1, new byte[4]);
      this.setAutoFlush(false);
      this.updateText();
      this.drawTexture(0);
   }

   /**
    * Draw/refresh the texture
    * 
    * @param index
    *           GIF animation index
    */
   private void drawTexture(final int index)
   {
      synchronized(this.fontGif)
      {
         final int width = this.gifText.getWidth();
         final int height = this.gifText.getHeight();

         if((this.getWidth() != width) || (this.getHeight() != height))
         {
            this.setPixels(width, height, new byte[4 * width * height]);
         }

         this.clear(new Color(0, true));
         GIF gif;

         for(final GifPosition position : this.gifText.getGifPositions())
         {
            gif = position.getGif();
            this.drawImage(position.getX(), position.getY(), gif.getImage(index % gif.numberOfImage()));
         }

         this.flush();
      }
   }

   /**
    * Update the text to draw
    */
   private void updateText()
   {
      synchronized(this.fontGif)
      {
         this.gifText = this.fontGif.computeGifText(this.text);
      }
   }

   /**
    * Animate the texture text <br>
    * <br>
    * <b>Parent documentation:</b><br>
    * {@inheritDoc}
    * 
    * @param gl
    *           Open GL link
    * @param absoluteFrame
    *           Current absolute frame
    * @return Indicates if animate should continue
    * @see jhelp.engine.Animation#animate(javax.media.opengl.GL, float)
    */
   @Override
   public boolean animate(final GL gl, final float absoluteFrame)
   {
      this.drawTexture((int) ((absoluteFrame - this.startAbsoluteFrame) / 4f));
      return true;
   }

   /**
    * Current text
    * 
    * @return Current text
    */
   public String getText()
   {
      return this.text;
   }

   /**
    * Called on when animation start <br>
    * <br>
    * <b>Parent documentation:</b><br>
    * {@inheritDoc}
    * 
    * @param startAbsoluteFrame
    *           Started frame
    * @see jhelp.engine.Animation#setStartAbsoluteFrame(float)
    */
   @Override
   public void setStartAbsoluteFrame(final float startAbsoluteFrame)
   {
      this.startAbsoluteFrame = startAbsoluteFrame;
      this.drawTexture(0);
   }

   /**
    * Change the text
    * 
    * @param text
    *           New text
    */
   public void setText(final String text)
   {
      if(text == null)
      {
         throw new NullPointerException("text musn't be null");
      }

      if(this.text.equals(text))
      {
         return;
      }

      this.text = text;
      this.updateText();
      this.drawTexture(0);
   }
}