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
package jhelp.engine.anim;

import jhelp.engine.Node;
import jhelp.engine.util.PositionNode;

/**
 * Animation witch move a node <br>
 * <br>
 * <br>
 * Last modification : 21 janv. 2009<br>
 * Version 0.0.1<br>
 * 
 * @author JHelp
 */
public class AnimationPositionNode
      extends AnimationKeyFrame<Node, PositionNode>
{
   /**
    * Constructs AnimationPositionNode
    * 
    * @param object
    *           Node to move
    */
   public AnimationPositionNode(final Node object)
   {
      super(object);
   }

   /**
    * Interpolate a value
    * 
    * @param object
    *           Node to move
    * @param before
    *           Position just before the computed position
    * @param after
    *           Position just after the computed position
    * @param percent
    *           Percent of interpolation
    * @see jhelp.engine.anim.AnimationKeyFrame#interpolateValue(java.lang.Object, java.lang.Object, java.lang.Object, float)
    */
   @Override
   protected void interpolateValue(final Node object, final PositionNode before, final PositionNode after, final float percent)
   {
      float anti;

      anti = 1f - percent;

      object.setPosition((before.x * anti) + (after.x * percent), (before.y * anti) + (after.y * percent), (before.z * anti) + (after.z * percent));
      object.setAngleX((before.angleX * anti) + (after.angleX * percent));
      object.setAngleY((before.angleY * anti) + (after.angleY * percent));
      object.setAngleZ((before.angleZ * anti) + (after.angleZ * percent));
      object.setScale((before.scaleX * anti) + (after.scaleX * percent), (before.scaleY * anti) + (after.scaleY * percent), (before.scaleZ * anti)
            + (after.scaleZ * percent));
   }

   /**
    * Compute node position
    * 
    * @param object
    *           Node to get it's position
    * @return Node's position
    * @see jhelp.engine.anim.AnimationKeyFrame#obtainValue(java.lang.Object)
    */
   @Override
   protected PositionNode obtainValue(final Node object)
   {
      return new PositionNode(object);
   }

   /**
    * Change node position
    * 
    * @param object
    *           Node to change
    * @param value
    *           New value
    * @see jhelp.engine.anim.AnimationKeyFrame#setValue(java.lang.Object, java.lang.Object)
    */
   @Override
   protected void setValue(final Node object, final PositionNode value)
   {
      object.setPosition(value.x, value.y, value.z);
      object.setAngleX(value.angleX);
      object.setAngleY(value.angleY);
      object.setAngleZ(value.angleZ);
      object.setScale(value.scaleX, value.scaleY, value.scaleZ);
   }
}