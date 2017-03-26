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

import java.awt.Insets;

import jhelp.util.gui.JHelpImage;
import jhelp.util.gui.JHelpPaint;
import jhelp.util.gui.JHelpTextAlign;
import jhelp.util.gui.alphabet.Alphabet;
import jhelp.util.gui.alphabet.AlphabetText;

/**
 * Texture with alphabet text.<br>
 * Its possible to precise an empty margin around the alphabet text area to free draw something on the border
 * 
 * @author JHelp
 */
public class TextureAlphabetText
      extends Texture
{
   /** Alphabet text */
   private final AlphabetText alphabetText;
   /** Image that draws the alphabet text and its margin */
   private JHelpImage         embedImage;
   /** Alphabet text X inside embed image */
   private int                x;
   /** Alphabet text Y inside embed image */
   private int                y;

   /**
    * Create a new instance of TextureAlphabetText without margin
    * 
    * @param alphabet
    *           Alphabet to use
    * @param numberCharacterPerLine
    *           Number character per line
    * @param numberLine
    *           Number visible line
    * @param text
    *           Initial text
    * @param textAlign
    *           Text alignment
    * @param borderColor
    *           Border color
    * @param background
    *           Background color
    */
   public TextureAlphabetText(final Alphabet alphabet, final int numberCharacterPerLine, final int numberLine, final String text,
         final JHelpTextAlign textAlign, final int borderColor, final int background)
   {
      this(alphabet, numberCharacterPerLine, numberLine, text, textAlign, borderColor, background, null);
   }

   /**
    * Create a new instance of TextureAlphabetText
    * 
    * @param alphabet
    *           Alphabet to use
    * @param numberCharacterPerLine
    *           Number character per line
    * @param numberLine
    *           Number visible line
    * @param text
    *           Initial text
    * @param textAlign
    *           Text alignment
    * @param borderColor
    *           Border color
    * @param background
    *           Background color
    * @param margin
    *           Margin to add. Use {@code null} for no margin
    */
   public TextureAlphabetText(final Alphabet alphabet, final int numberCharacterPerLine, final int numberLine, final String text,
         final JHelpTextAlign textAlign, final int borderColor, final int background, final Insets margin)
   {
      super(alphabet.getClass().getName(), Texture.REFERENCE_ALPHABET);
      this.alphabetText = new AlphabetText(alphabet, numberCharacterPerLine, numberLine, text, textAlign, borderColor, background);
      this.initializeImage(margin);
   }

   /**
    * Create a new instance of TextureAlphabetText without margin
    * 
    * @param alphabet
    *           Alphabet to use
    * @param numberCharacterPerLine
    *           Number character per line
    * @param numberLine
    *           Number visible line
    * @param text
    *           Initial text
    * @param textAlign
    *           Text alignment
    * @param borderColor
    *           Border color
    * @param background
    *           Background image
    */
   public TextureAlphabetText(final Alphabet alphabet, final int numberCharacterPerLine, final int numberLine, final String text,
         final JHelpTextAlign textAlign, final int borderColor, final JHelpImage background)
   {
      this(alphabet, numberCharacterPerLine, numberLine, text, textAlign, borderColor, background, null);
   }

   /**
    * Create a new instance of TextureAlphabetText
    * 
    * @param alphabet
    *           Alphabet to use
    * @param numberCharacterPerLine
    *           Number character per line
    * @param numberLine
    *           Number visible line
    * @param text
    *           Initial text
    * @param textAlign
    *           Text alignment
    * @param borderColor
    *           Border color
    * @param background
    *           Background image
    * @param margin
    *           Margin to add. Use {@code null} for no margin
    */
   public TextureAlphabetText(final Alphabet alphabet, final int numberCharacterPerLine, final int numberLine, final String text,
         final JHelpTextAlign textAlign, final int borderColor, final JHelpImage background, final Insets margin)
   {
      super(alphabet.getClass().getName(), Texture.REFERENCE_ALPHABET);
      this.alphabetText = new AlphabetText(alphabet, numberCharacterPerLine, numberLine, text, textAlign, borderColor, background);
      this.initializeImage(margin);
   }

   /**
    * Create a new instance of TextureAlphabetText without margin
    * 
    * @param alphabet
    *           Alphabet to use
    * @param numberCharacterPerLine
    *           Number character per line
    * @param numberLine
    *           Number visible line
    * @param text
    *           Initial text
    * @param textAlign
    *           Text alignment
    * @param borderColor
    *           Border color
    * @param background
    *           Background paint
    */
   public TextureAlphabetText(final Alphabet alphabet, final int numberCharacterPerLine, final int numberLine, final String text,
         final JHelpTextAlign textAlign, final int borderColor, final JHelpPaint background)
   {
      this(alphabet, numberCharacterPerLine, numberLine, text, textAlign, borderColor, background, null);
   }

   /**
    * Create a new instance of TextureAlphabetText
    * 
    * @param alphabet
    *           Alphabet to use
    * @param numberCharacterPerLine
    *           Number character per line
    * @param numberLine
    *           Number visible line
    * @param text
    *           Initial text
    * @param textAlign
    *           Text alignment
    * @param borderColor
    *           Border color
    * @param background
    *           Background paint
    * @param margin
    *           Margin to add. Use {@code null} for no margin
    */
   public TextureAlphabetText(final Alphabet alphabet, final int numberCharacterPerLine, final int numberLine, final String text,
         final JHelpTextAlign textAlign, final int borderColor, final JHelpPaint background, final Insets margin)
   {
      super(alphabet.getClass().getName(), Texture.REFERENCE_ALPHABET);
      this.alphabetText = new AlphabetText(alphabet, numberCharacterPerLine, numberLine, text, textAlign, borderColor, background);
      this.initializeImage(margin);
   }

   /**
    * Initialize embed image
    * 
    * @param margin
    *           Margin to add OR {@code null} if no margin
    */
   private void initializeImage(final Insets margin)
   {
      final JHelpImage alphabetImage = this.alphabetText.getImage();
      this.x = 0;
      this.y = 0;
      int width = alphabetImage.getWidth();
      int height = alphabetImage.getHeight();

      if(margin != null)
      {
         this.x = margin.left;
         this.y = margin.top;
         width += margin.left + margin.right;
         height += margin.top + margin.bottom;
      }

      this.embedImage = new JHelpImage(width, height);
      this.updateImage(true);
   }

   /**
    * Update the image
    * 
    * @param clear
    *           Indicates if have to clear all embed image ({@code true}) or only the alphabet area (let the margin as is) (
    *           {@code false})
    */
   private void updateImage(final boolean clear)
   {
      final JHelpImage alphabetImage = this.alphabetText.getImage();
      this.embedImage.startDrawMode();

      if(clear)
      {
         this.embedImage.clear(0);
      }
      else
      {
         this.embedImage.fillRectangle(this.x, this.y, alphabetImage.getWidth(), alphabetImage.getHeight(), 0, false);
      }

      this.embedImage.drawImage(this.x, this.y, alphabetImage);
      this.embedImage.endDrawMode();
      this.setImage(this.embedImage);
   }

   /**
    * Embed image<br>
    * If modify, don't forget to call {@link JHelpImage#endDrawMode()} and {@code #refresh()} to see the modification<br>
    * Remember, that the alphabet area can be redraw at any time, so you will loose any modification on this area, only margin
    * is kept until the next {@code #setText(String)}
    * 
    * @return Embed image
    */
   public JHelpImage getEmbedImage()
   {
      return this.embedImage;
   }

   /**
    * Current text
    * 
    * @return Current text
    */
   public String getText()
   {
      return this.alphabetText.getText();
   }

   /**
    * Indicates if the text have a next part
    * 
    * @return {@code true} if the text have a next part
    */
   public boolean hasNext()
   {
      return this.alphabetText.hasNext();
   }

   /**
    * Indicates if text have a previous part
    * 
    * @return {@code true} if the text have a next part
    */
   public boolean hasPrevious()
   {
      return this.alphabetText.hasPrevious();
   }

   /**
    * Draw next part of the text (Margin is kept).<br>
    * Does nothing if no next part
    */
   public void next()
   {
      if(!this.alphabetText.hasNext())
      {
         return;
      }

      this.alphabetText.next();
      this.updateImage(false);
   }

   /**
    * Draw previous part of the text (Margin is kept).<br>
    * Does nothing if no previous part
    */
   public void previous()
   {
      if(!this.alphabetText.hasPrevious())
      {
         return;
      }

      this.alphabetText.previous();
      this.updateImage(false);
   }

   /**
    * Refresh that changed made on embed image
    */
   public void refresh()
   {
      this.updateImage(false);
   }

   /**
    * Change the text to draw.<br>
    * Margin will be deleted to empty
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

      this.alphabetText.setText(text);
      this.updateImage(true);
   }
}