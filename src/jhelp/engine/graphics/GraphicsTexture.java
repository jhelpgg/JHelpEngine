/**
 * Project : JHelpEngine<br>
 * Package : jhelp.engine.graphics<br>
 * Class : GraphicsTexture<br>
 * Date : 23 juin 2009<br>
 * By JHelp
 */
package jhelp.engine.graphics;

import java.awt.Color;
import java.util.ArrayList;

import jhelp.engine.Texture;

/**
 * Graphics on texture with layer<br>
 * <br>
 * Last modification : 23 juin 2009<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
public class GraphicsTexture
{
   /** Texture where draw */
   private Texture                  texture;
   /** Layers */
   private ArrayList<DrawOnTexture> layers;

   /**
    * Constructs GraphicsTexture
    * 
    * @param texture
    *           Texture where draw
    */
   public GraphicsTexture(Texture texture)
   {
      if(texture == null)
      {
         throw new NullPointerException("texture musn't be null");
      }

      this.texture = texture;
      this.layers = new ArrayList<DrawOnTexture>();
   }

   /**
    * Change the texture
    * 
    * @param texture
    *           New texture where draw
    */
   public void setTexture(Texture texture)
   {
      if(texture == null)
      {
         throw new NullPointerException("texture musn't be null");
      }

      this.texture = texture;
   }

   /**
    * Draw a line
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
    *           Indicates if we mix alpha ({@code true}) or override ( {@code false})
    */
   public void drawLine(int x1, int y1, int x2, int y2, Color color, boolean mix)
   {
      this.layers.add(new LineOnTexture(x1, y1, x2, y2, color, mix));
   }

   /**
    * Remove last layer
    */
   public void removeLast()
   {
      if(this.layers.size() > 0)
      {
         this.layers.remove(this.layers.size() - 1);
      }
   }

   /**
    * Aplly layers on texture
    */
   public void apply()
   {
      for(DrawOnTexture drawOnTexture : this.layers)
      {
         drawOnTexture.draw(this.texture);
      }

      this.texture.flush();
   }
}