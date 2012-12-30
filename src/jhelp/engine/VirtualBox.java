/**
 */
package jhelp.engine;

import jhelp.util.text.UtilText;

/**
 * Virtual box.<br>
 * It's a box could be use for collision, or know bounding box for a set of points. <br>
 * <br>
 * 
 * @author JHelp
 */
public class VirtualBox
{
   /** Indicates it's the box is empty */
   private boolean empty;
   /** Maximum x */
   private float   maxX;
   /** Maximum y */
   private float   maxY;
   /** Maximum z */
   private float   maxZ;
   /** Minimum x */
   private float   minX;
   /** Minimum y */
   private float   minY;
   /** Minimum z */
   private float   minZ;

   /**
    * Constructs an empty box
    */
   public VirtualBox()
   {
      this.empty = true;
   }

   /**
    * Add a point to the box
    * 
    * @param x
    *           X
    * @param y
    *           Y
    * @param z
    *           Z
    */
   public void add(final float x, final float y, final float z)
   {
      if(this.empty)
      {
         this.minX = this.maxX = x;
         this.minY = this.maxY = y;
         this.minZ = this.maxZ = z;
         this.empty = false;
         return;
      }
      this.minX = Math.min(this.minX, x);
      this.minY = Math.min(this.minY, y);
      this.minZ = Math.min(this.minZ, z);
      //
      this.maxX = Math.max(this.maxX, x);
      this.maxY = Math.max(this.maxY, y);
      this.maxZ = Math.max(this.maxZ, z);
   }

   /**
    * Add a point to the box
    * 
    * @param point
    *           Point to add
    */
   public void add(final Point3D point)
   {
      this.add(point.getX(), point.getY(), point.getZ());
   }

   /**
    * Box center
    * 
    * @return Box center
    */
   public Point3D getCenter()
   {
      return new Point3D((this.maxX + this.minX) / 2f, (this.maxY + this.minY) / 2f, (this.maxZ + this.minZ) / 2f);
   }

   /**
    * X maximum
    * 
    * @return X maximum
    */
   public float getMaxX()
   {
      return this.maxX;
   }

   /**
    * Y maximum
    * 
    * @return Y maximum
    */
   public float getMaxY()
   {
      return this.maxY;
   }

   /**
    * Z maximum
    * 
    * @return Z maximum
    */
   public float getMaxZ()
   {
      return this.maxZ;
   }

   /**
    * X minimum
    * 
    * @return X minimum
    */
   public float getMinX()
   {
      return this.minX;
   }

   /**
    * Y minimum
    * 
    * @return Y minimum
    */
   public float getMinY()
   {
      return this.minY;
   }

   /**
    * Z minimum
    * 
    * @return Z minimum
    */
   public float getMinZ()
   {
      return this.minZ;
   }

   /**
    * Indicates if the box is empty
    * 
    * @return {@code true} if the box is empty
    */
   public boolean isEmpty()
   {
      return this.empty;
   }

   /**
    * String representation
    * 
    * @return String representation
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString()
   {
      return UtilText.concatenate("VirtualBox [", this.minX, ", ", this.minY, ", ", this.minZ, "] x [", this.maxX, ", ", this.maxY, ", ", this.maxZ, ']');
   }
}