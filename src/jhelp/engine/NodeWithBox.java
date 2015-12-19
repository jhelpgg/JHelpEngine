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

/**
 * Node with bounding box
 * 
 * @author JHelp
 */
public abstract class NodeWithBox
      extends Node
{
   /**
    * Create a new instance of NodeWithBox
    */
   public NodeWithBox()
   {
   }

   /**
    * Bonding box
    * 
    * @return Bonding box
    */
   public abstract VirtualBox getBox();

   /**
    * Compute the bounding box and projected it in world space
    * 
    * @return Computed projected in world space bounding box
    */
   public VirtualBox getProjectedBox()
   {
      final VirtualBox projected = new VirtualBox();
      final VirtualBox virtualBox = this.getBox();

      if(virtualBox.isEmpty() == true)
      {
         return projected;
      }

      Point3D point = new Point3D(virtualBox.getMinX(), virtualBox.getMinY(), virtualBox.getMinZ());
      point = this.getProjection(point);
      projected.add(point);

      point = new Point3D(virtualBox.getMinX(), virtualBox.getMinY(), virtualBox.getMaxZ());
      point = this.getProjection(point);
      projected.add(point);

      point = new Point3D(virtualBox.getMinX(), virtualBox.getMaxY(), virtualBox.getMinZ());
      point = this.getProjection(point);
      projected.add(point);

      point = new Point3D(virtualBox.getMinX(), virtualBox.getMaxY(), virtualBox.getMaxZ());
      point = this.getProjection(point);
      projected.add(point);

      point = new Point3D(virtualBox.getMaxX(), virtualBox.getMinY(), virtualBox.getMinZ());
      point = this.getProjection(point);
      projected.add(point);

      point = new Point3D(virtualBox.getMaxX(), virtualBox.getMinY(), virtualBox.getMaxZ());
      point = this.getProjection(point);
      projected.add(point);

      point = new Point3D(virtualBox.getMaxX(), virtualBox.getMaxY(), virtualBox.getMinZ());
      point = this.getProjection(point);
      projected.add(point);

      point = new Point3D(virtualBox.getMaxX(), virtualBox.getMaxY(), virtualBox.getMaxZ());
      point = this.getProjection(point);
      projected.add(point);

      return projected;
   }
}