/**
 */
package jhelp.engine.twoD;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 2D manager.<br>
 * It have two layer, one under the 3D, other over the 3D <br>
 * <br>
 * Last modification : 21 janv. 2009<br>
 * Version 0.0.1<br>
 * 
 * @author JHelp
 */
public class GUI2D
{
   /** Over 3D layer */
   private final ArrayList<Object2D> arrayListObject2DOver3D;
   /** Under 3D layer */
   private final ArrayList<Object2D> arrayListObject2DUnder3D;
   /** If not {@code null} only this object can be detected */
   private Object2D                  exclusiveObject;

   /**
    * Constructs GUI2D
    */
   public GUI2D()
   {
      this.arrayListObject2DOver3D = new ArrayList<Object2D>();
      this.arrayListObject2DUnder3D = new ArrayList<Object2D>();
   }

   /**
    * Add object over the 3D
    * 
    * @param object2D
    *           Object to add
    */
   public void addOver3D(final Object2D object2D)
   {
      this.arrayListObject2DOver3D.add(object2D);
   }

   /**
    * Add object under 3D
    * 
    * @param object2D
    *           Object to add
    */
   public void addUnder3D(final Object2D object2D)
   {
      this.arrayListObject2DUnder3D.add(object2D);
   }

   /**
    * Put detection to noraml, that is to say all objects will be able to be detected
    */
   public void allCanBeDetected()
   {
      this.exclusiveObject = null;
   }

   public void clearAll()
   {
      this.clearUnder3D();
      this.clearOver3D();
   }

   public void clearOver3D()
   {
      this.arrayListObject2DOver3D.clear();
   }

   public void clearUnder3D()
   {
      this.arrayListObject2DUnder3D.clear();
   }

   /**
    * Looking for an object over 3D and under a position
    * 
    * @param x
    *           X
    * @param y
    *           Y
    * @return The found object or {@code null}
    */
   public Object2D detectOver3D(final int x, final int y)
   {
      if(this.exclusiveObject != null)
      {
         if(this.exclusiveObject.isDetected(x, y) == true)
         {
            return this.exclusiveObject;
         }

         return null;
      }

      final int nb = this.arrayListObject2DOver3D.size();
      Object2D object2D;
      for(int i = nb - 1; i >= 0; i--)
      {
         object2D = this.arrayListObject2DOver3D.get(i);
         if(object2D.isDetected(x, y) == true)
         {
            return object2D;
         }
      }
      return null;
   }

   /**
    * Looking for an object under a position
    * 
    * @param x
    *           X
    * @param y
    *           Y
    * @return The found object or {@code null}
    */
   public Object2D detectOver3DorUnder3D(final int x, final int y)
   {
      if(this.exclusiveObject != null)
      {
         if(this.exclusiveObject.isDetected(x, y) == true)
         {
            return this.exclusiveObject;
         }

         return null;
      }

      // search over first
      Object2D object2D = this.detectOver3D(x, y);
      if(object2D != null)
      {
         return object2D;
      }

      // Search under
      final int nb = this.arrayListObject2DUnder3D.size();
      for(int i = nb - 1; i >= 0; i--)
      {
         object2D = this.arrayListObject2DUnder3D.get(i);
         if(object2D.isDetected(x, y) == true)
         {
            return object2D;
         }
      }

      return null;
   }

   /**
    * Iterator for list all objects over 3D
    * 
    * @return Iterator for list all objects over 3D
    */
   public Iterator<Object2D> getIteratorOver3D()
   {
      return this.arrayListObject2DOver3D.iterator();
   }

   /**
    * Iterator for list all objects under 3D
    * 
    * @return Iterator for list all objects under 3D
    */
   public Iterator<Object2D> getIteratorUnder3D()
   {
      return this.arrayListObject2DUnder3D.iterator();
   }

   /**
    * Call when mouse state changed
    * 
    * @param x
    *           Mouse X
    * @param y
    *           Mouse Y
    * @param buttonLeft
    *           Indicates if the button left is down
    * @param buttonRight
    *           Indicates if the button right is down
    * @param drag
    *           Indicates if we are on drag mode
    * @param over
    *           Object under the mouse
    */
   public void mouseState(final int x, final int y, final boolean buttonLeft, final boolean buttonRight, final boolean drag, final Object2D over)
   {
      for(final Object2D object2D : this.arrayListObject2DUnder3D)
      {
         object2D.mouseState(x, y, buttonLeft, buttonRight, drag, over == object2D);
      }
      for(final Object2D object2D : this.arrayListObject2DOver3D)
      {
         object2D.mouseState(x, y, buttonLeft, buttonRight, drag, over == object2D);
      }
   }

   /**
    * Remove object over the 3D
    * 
    * @param object2D
    *           Object to remove
    */
   public void removeOver3D(final Object2D object2D)
   {
      this.arrayListObject2DOver3D.remove(object2D);
   }

   /**
    * Remove object under 3D
    * 
    * @param object2D
    *           Object to remove
    */
   public void removeUnder3D(final Object2D object2D)
   {
      this.arrayListObject2DUnder3D.remove(object2D);
   }

   /**
    * For the detection restricted to only one object<br>
    * This object will be the only one detected
    * 
    * @param object2d
    *           Object to detect exclusively (Can use {@code null} for detect all objects)
    */
   public void setExclusiveDetection(final Object2D object2d)
   {
      this.exclusiveObject = object2d;
   }
}