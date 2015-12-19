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
package jhelp.engine.util;

import javax.media.opengl.GL;

/**
 * Rotation aroud an axis <br>
 * <br>
 * Last modification : 25 janv. 2009<br>
 * Version 0.0.1<br>
 * 
 * @author JHelp
 */
public class Rotation
{
   /** Rotation angle */
   public float angle;
   /** Axis' X */
   public float x;
   /** Axis' Y */
   public float y;
   /** Axis' Z */
   public float z;

   /**
    * Constructs Rotation
    */
   public Rotation()
   {
   }

   /**
    * Constructs Rotation
    * 
    * @param x
    *           Axis' X
    * @param y
    *           Axis' Y
    * @param z
    *           Axis' Z
    * @param angle
    *           Rotation angle
    */
   public Rotation(final float x, final float y, final float z, final float angle)
   {
      this.x = x;
      this.y = y;
      this.z = z;
      this.angle = angle;
   }

   /**
    * Apply rotation to OpenGL
    * 
    * @param gl
    *           OpenGL context
    */
   public void glRotatef(final GL gl)
   {
      if(Math3D.nul(this.angle) == false)
      {
         gl.glRotatef(this.angle, this.x, this.y, this.z);
      }
   }
}