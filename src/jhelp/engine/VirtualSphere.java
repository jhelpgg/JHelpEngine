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

import jhelp.engine.util.Math3D;
import jhelp.util.math.UtilMath;

/**
 * Virtual sphere<br>
 * Could be use for sphere bounding<br>
 * <br>
 *
 * @author JHelp
 */
public class VirtualSphere
{
   public static VirtualSphere add(final VirtualSphere virtualSphere1, final VirtualSphere virtualSphere2)
   {
      final float ray1 = virtualSphere1.getRay();

      if(Math3D.nul(ray1))
      {
         return virtualSphere2;
      }

      final float ray2 = virtualSphere2.getRay();

      if(Math3D.nul(ray2))
      {
         return virtualSphere1;
      }

      final Point3D center1 = virtualSphere1.getCenter();
      final Point3D center2 = virtualSphere2.getCenter();
      final float distance = Point3D.getDistance(center1, center2);

      if(Math3D.nul(distance))
      {
         if(ray1 >= ray2)
         {
            return virtualSphere1;
         }

         return virtualSphere2;
      }

      if((ray1 >= distance) && ((ray1 - distance) >= ray2))
      {
         return virtualSphere1;
      }

      if((ray2 >= distance) && ((ray2 - distance) >= ray1))
      {
         return virtualSphere2;
      }

      final float ray = (distance + ray1 + ray2) / 2f;
      Point3D vector = center2.substract(center1);
      vector.normalize();
      vector = vector.factor(ray - ray1);
      return new VirtualSphere(center1.x + vector.x, center1.y + vector.y, center1.z + vector.z, ray);
   }

   /** Center of sphere */
   private Point3D     center;
   /** Ray of sphere */
   private final float ray;
   /** X center */
   private final float x;
   /** Y center */
   private final float y;
   /** Z center */
   private final float z;

   /**
    * Constructs the sphere
    *
    * @param x
    *           X center
    * @param y
    *           Y center
    * @param z
    *           Z center
    * @param ray
    *           Ray
    */
   public VirtualSphere(final float x, final float y, final float z, final float ray)
   {
      this.x = x;
      this.y = y;
      this.z = z;
      this.ray = ray;
   }

   /**
    * Indicates if a point is in the sphere
    *
    * @param x
    *           X
    * @param y
    *           Y
    * @param z
    *           Y
    * @return {@code true} if a point is in the sphere
    */
   public boolean contains(final float x, final float y, final float z)
   {
      final float distance = Point3D.getDistance(this.x, this.y, this.z, x, y, z);
      return Math3D.equal(distance, this.ray) || (distance < this.ray);
   }

   /**
    * Indicates is an object is equivalent to this sphere
    *
    * @param object
    *           Object tested
    * @return {@code true} is an object is equivalent to this sphere
    * @see java.lang.Object#equals(java.lang.Object)
    */
   @Override
   public boolean equals(final Object object)
   {
      if(object == null)
      {
         return false;
      }
      if(object == this)
      {
         return true;
      }
      if(!(object instanceof VirtualSphere))
      {
         return false;
      }
      return this.equals((VirtualSphere) object);
   }

   /**
    * Indicates if a sphere is equal to this sphere
    *
    * @param sphere
    *           Sphere tested
    * @return {@code true} if a sphere is equal to this sphere
    */
   public boolean equals(final VirtualSphere sphere)
   {
      return Math3D.equal(this.ray, sphere.ray) && Math3D.equal(this.x, sphere.x) && Math3D.equal(this.y, sphere.y) && Math3D.equal(this.z, sphere.z);
   }

   /**
    * Center of the sphere
    *
    * @return Center
    */
   public Point3D getCenter()
   {
      if(this.center == null)
      {
         this.center = new Point3D(this.x, this.y, this.z);
      }
      return this.center;
   }

   /**
    * Ray
    *
    * @return Ray
    */
   public float getRay()
   {
      return this.ray;
   }

   /**
    * Center x
    *
    * @return Center x
    */
   public float getX()
   {
      return this.x;
   }

   /**
    * Center y
    *
    * @return Center y
    */
   public float getY()
   {
      return this.y;
   }

   /**
    * Center z
    *
    * @return Center z
    */
   public float getZ()
   {
      return this.z;
   }

   public VirtualSphere scale(final float scale)
   {
      return new VirtualSphere(this.x, this.y, this.z, this.ray * scale);
   }

   public VirtualSphere scale(final float sx, final float sy, final float sz)
   {
      return this.scale(UtilMath.max(sx, sy, sz));
   }

   public VirtualSphere translate(final float tx, final float ty, final float tz)
   {
      return new VirtualSphere(this.x + tx, this.y + ty, this.z + tz, this.ray);
   }
}