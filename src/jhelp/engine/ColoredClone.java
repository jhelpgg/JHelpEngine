package jhelp.engine;

import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;

/**
 * Clone of object with only one color (no texture on it)
 * 
 * @author JHelp
 */
public class ColoredClone
      extends NodeWithBox
{
   /** Current color */
   private int            color;
   /** Cloned object */
   private final Object3D object3d;

   /**
    * Create a new instance of ColoredClone
    * 
    * @param object3d
    *           Object to clone
    */
   public ColoredClone(final Object3D object3d)
   {
      this(object3d, 0xCAFEFACE);
   }

   /**
    * Create a new instance of ColoredClone
    * 
    * @param object3d
    *           Object to clone
    * @param color
    *           Initial color
    */
   public ColoredClone(final Object3D object3d, final int color)
   {
      if(object3d == null)
      {
         throw new NullPointerException("object3d musn't be null");
      }

      this.object3d = object3d;
      this.color = color;
   }

   /**
    * Render specific <br>
    * <br>
    * <b>Parent documentation:</b><br>
    * {@inheritDoc}
    * 
    * @param gl
    *           Open GL link
    * @param glu
    *           GLU link
    * @see jhelp.engine.Node#renderSpecific(javax.media.opengl.GL, javax.media.opengl.glu.GLU)
    */
   @Override
   protected synchronized void renderSpecific(final GL gl, final GLU glu)
   {
      Material.DEFAULT_MATERIAL.getColorDiffuse().set(this.color);
      Material.DEFAULT_MATERIAL.setTwoSided(false);
      Material.DEFAULT_MATERIAL.setTransparency((this.color >>> 24) / 255f);
      Material.DEFAULT_MATERIAL.prepareMaterial(gl);
      this.object3d.drawObject(gl, glu);
      Material.DEFAULT_MATERIAL.originalSettings();
   }

   /**
    * Bonding box
    * 
    * @return Bonding box
    * @see jhelp.engine.NodeWithMaterial#getBox()
    */
   @Override
   public VirtualBox getBox()
   {
      return this.object3d.getBox();
   }

   /**
    * Object center
    * 
    * @return Object center
    * @see jhelp.engine.Node#getCenter()
    */
   @Override
   public Point3D getCenter()
   {
      return this.object3d.getCenter();
   }

   /**
    * Current color
    * 
    * @return Current color
    */
   public int getColor()
   {
      return this.color;
   }

   /**
    * Change clone color
    * 
    * @param color
    *           New color
    */
   public void setColor(final int color)
   {
      this.color = color;
   }
}