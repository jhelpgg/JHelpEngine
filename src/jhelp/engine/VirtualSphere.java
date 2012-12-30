/**
 */
package jhelp.engine;

import jhelp.engine.util.Math3D;

/**
 * Virtual sphere<br>
 * Could be use for sphere bounding<br>
 * <br>
 * 
 * @author JHelp
 */
public class VirtualSphere
{
   /** X center */
   private float   x;
   /** Y center */
   private float   y;
   /** Z center */
   private float   z;
   /** Ray of sphere */
   private float   ray;
   /** Center of sphere */
   private Point3D center;
   /** Precision */
   public int      precision;

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
   public VirtualSphere(float x, float y, float z, float ray)
   {
      this.precision = 0;
      this.x = x;
      this.y = y;
      this.z = z;
      this.ray = ray;
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
   public boolean contains(float x, float y, float z)
   {
      float distance = Point3D.getDistance(this.x, this.y, this.z, x, y, z);
      return Math3D.equal(distance, this.ray) || distance < this.ray;
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
    * Indicates is an object is equivalent to this sphere
    * 
    * @param object
    *           Object tested
    * @return {@code true} is an object is equivalent to this sphere
    * @see java.lang.Object#equals(java.lang.Object)
    */
   @Override
   public boolean equals(Object object)
   {
      if(object == null)
      {
         return false;
      }
      if(object == this)
      {
         return true;
      }
      if((object instanceof VirtualSphere) == false)
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
   public boolean equals(VirtualSphere sphere)
   {
      return this.precision == sphere.precision && Math3D.equal(this.ray, sphere.ray) && Math3D.equal(this.x, sphere.x) && Math3D.equal(this.y, sphere.y) && Math3D.equal(this.z, sphere.z);
   }
}