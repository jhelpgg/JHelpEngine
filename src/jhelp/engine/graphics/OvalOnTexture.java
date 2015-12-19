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
import java.awt.geom.Ellipse2D;

import jhelp.engine.Texture;

/**
 * Rectangle on texture<br>
 * <br>
 * Last modification : 23 juin 2009<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
class OvalOnTexture
      extends DrawOnTexture
{
   /** Line color */
   private final Color   color;
   /** Indicates if oval should be fill */
   private final boolean fill;
   /** Indicates if we mix with alpha ({@code true}) or override ( {@code false}) */
   private final boolean mix;
   /** First point's X */
   private final int     x1;
   /** Second point's X */
   private int           x2;
   /** First point's Y */
   private final int     y1;
   /** Second point's Y */
   private int           y2;

   /**
    * Constructs RectangleOnTexture
    * 
    * @param x1
    *           First point's X
    * @param y1
    *           First point's Y
    * @param x2
    *           Second point's X
    * @param y2
    *           Second point's Y
    * @param color
    *           Line color
    * @param fill
    *           Indicate if have to fill the oval
    * @param mix
    *           Indicates if we mix with alpha ({@code true}) or override ({@code false})
    */
   OvalOnTexture(final int x1, final int y1, final int x2, final int y2, final Color color, final boolean fill, final boolean mix)
   {
      this.x1 = x1;
      this.y1 = y1;
      this.x2 = x2;
      this.y2 = y2;
      this.color = color;
      this.fill = fill;
      this.mix = mix;
   }

   /**
    * Change oval last point
    * 
    * @param x
    *           Last X
    * @param y
    *           Last Y
    */
   public void changeLastPoint(final int x, final int y)
   {
      this.x2 = x;
      this.y2 = y;
   }

   /**
    * Draw rectangle on texture
    * 
    * @param texture
    *           Texture where draw
    * @see jhelp.engine.graphics.DrawOnTexture#draw(jhelp.engine.Texture)
    */
   @Override
   public void draw(final Texture texture)
   {

      if(this.fill == true)
      {
         texture.fillOval(Math.min(this.x1, this.x2), Math.min(this.y1, this.y2), Math.abs(this.x1 - this.x2) + 1, Math.abs(this.y1 - this.y2) + 1, this.color,
               this.mix);
      }
      else
      {
         texture.draw(new Ellipse2D.Double(Math.min(this.x1, this.x2), Math.min(this.y1, this.y2), Math.abs(this.x1 - this.x2) + 1,
               Math.abs(this.y1 - this.y2) + 1), this.color, this.mix, 5);
      }
   }
}