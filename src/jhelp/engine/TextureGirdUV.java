/**
 * Project : JHelpEngine<br>
 * Package : jhelp.engine<br>
 * Class : TextureGirdUV<br>
 * Date : 1 juin 2009<br>
 * By JHelp
 */
package jhelp.engine;

import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;

/**
 * Texture with "grid" based on Object UV <br>
 * <br>
 * Last modification : 1 juin 2009<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
public class TextureGirdUV
      extends Texture
{
   /**
    * Shape description <br>
    * <br>
    * Last modification : 2 déc. 2010<br>
    * Version 0.0.0<br>
    * 
    * @author JHelp
    */
   static class Shape
   {
      /** Shape */
      public Polygon polygon;
      /** Color to fill */
      public int     color;

      /**
       * Constructs Shape
       */
      public Shape()
      {
      }
   }

   /** Shape list */
   private ArrayList<Shape> shapes;
   /** Background color */
   private Color            backgroundColor;
   /** Border color */
   private Color            borderColor;

   /**
    * Constructs TextureGirdUV
    * 
    * @param name
    *           Texture name
    * @param width
    *           Width
    * @param height
    *           Height
    */
   public TextureGirdUV(String name, int width, int height)
   {
      super(name, width, height, 0xFFFFFFFF);

      this.shapes = new ArrayList<Shape>();

      this.backgroundColor = Color.WHITE;
      this.borderColor = Color.BLACK;
   }

   /**
    * Create grid from mesh
    * 
    * @param mesh
    *           Mesh to "extract" grid
    */
   public void createGird(Mesh mesh)
   {
      this.shapes = mesh.obtainUVshapes(this.width, this.height);

      this.refreshShapes();
   }

   /**
    * Refresh shapes drawing
    */
   public void refreshShapes()
   {
      this.fillRect(0, 0, this.width, this.height, this.backgroundColor, false);

      for(Shape shape : this.shapes)
      {
         this.draw(shape.polygon, this.borderColor, false, 1);
         this.fill(shape.polygon, new Color(shape.color, true), true);
      }

      this.flush();
   }

   /**
    * Create grid from object
    * 
    * @param object3D
    *           Object to "extract" grid
    */
   public void createGird(Object3D object3D)
   {
      this.createGird(object3D.mesh);
   }

   /**
    * Number of shape
    * 
    * @return Number of shape
    */
   public int getNumberOfShape()
   {
      return this.shapes.size();
   }

   /**
    * Change shape color
    * 
    * @param shape
    *           Shape index
    * @param color
    *           Color to apply
    */
   public void setColorOnShape(int shape, int color)
   {
      this.shapes.get(shape).color = color;
   }

   /**
    * Obtain a shape for a position
    * 
    * @param x
    *           X
    * @param y
    *           Y
    * @return Shape index under the position or -1
    */
   public int obtainShape(int x, int y)
   {
      int nb = this.shapes.size();
      for(int i = 0; i < nb; i++)
      {
         if(this.shapes.get(i).polygon.contains(x, y) == true)
         {
            return i;
         }
      }

      return -1;
   }

   /**
    * Shape color
    * 
    * @param shape
    *           Shape index
    * @return Shape color
    */
   public int colorOnShape(int shape)
   {
      return this.shapes.get(shape).color;
   }

   /**
    * Return backgroundColor
    * 
    * @return backgroundColor
    */
   public Color getBackgroundColor()
   {
      return this.backgroundColor;
   }

   /**
    * Modify backgroundColor
    * 
    * @param backgroundColor
    *           New backgroundColor value
    */
   public void setBackgroundColor(Color backgroundColor)
   {
      this.backgroundColor = backgroundColor;
      this.refreshShapes();
   }

   /**
    * Return borderColor
    * 
    * @return borderColor
    */
   public Color getBorderColor()
   {
      return this.borderColor;
   }

   /**
    * Modify borderColor
    * 
    * @param borderColor
    *           New borderColor value
    */
   public void setBorderColor(Color borderColor)
   {
      this.borderColor = borderColor;
      this.refreshShapes();
   }
}