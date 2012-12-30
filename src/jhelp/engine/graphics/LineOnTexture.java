/**
 * Project : JHelpEngine<br>
 * Package : jhelp.engine.graphics<br>
 * Class : LineOnTexture<br>
 * Date : 23 juin 2009<br>
 * By JHelp
 */
package jhelp.engine.graphics;

import java.awt.Color;

import jhelp.engine.Texture;

/**
 * Line on texture<br>
 * <br>
 * Last modification : 23 juin 2009<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
class LineOnTexture
      extends DrawOnTexture
{
   /** Line color */
   private final Color   color;
   /**
    * Indicates if we mix with alpha ({@code true}) or override ( {@code false})
    */
   private final boolean mix;
   /** First point's X */
   private final int     x1;
   /** Second point's X */
   private final int     x2;
   /** First point's Y */
   private final int     y1;
   /** Second point's Y */
   private final int     y2;

   /**
    * Constructs LineOnTexture
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
    * @param mix
    *           Indicates if we mix with alpha ({@code true}) or override ({@code false})
    */
   LineOnTexture(final int x1, final int y1, final int x2, final int y2, final Color color, final boolean mix)
   {
      this.x1 = x1;
      this.y1 = y1;
      this.x2 = x2;
      this.y2 = y2;
      this.color = color;
      this.mix = mix;
   }

   /**
    * Draw line on texture
    * 
    * @param texture
    *           Texture where draw
    * @see jhelp.engine.graphics.DrawOnTexture#draw(jhelp.engine.Texture)
    */
   @Override
   public void draw(final Texture texture)
   {
      texture.drawLine(this.x1, this.y1, this.x2, this.y2, this.color, this.mix);
   }
}