/**
 * Project : JHelpSceneGraph<br>
 * Package : jhelp.engine.util<br>
 * Class : Position<br>
 * Date : 4 sept. 2008<br>
 * By JHelp
 */
package jhelp.engine.util;

import jhelp.engine.Node;

/**
 * Position for node <br>
 * <br>
 * Last modification : 23 janv. 2009<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
public class PositionNode
{
   /** Angle for X axis */
   public float angleX;
   /** Angle for Y axis */
   public float angleY;
   /** Angle for Z axis */
   public float angleZ;
   /** Scale on X axis */
   public float scaleX;
   /** Scale on Y axis */
   public float scaleY;
   /** Scale on Z axis */
   public float scaleZ;
   /** X */
   public float x;
   /** Y */
   public float y;
   /** z */
   public float z;

   /**
    * Constructs PositionNode
    */
   public PositionNode()
   {
      this.x = this.y = this.z = this.angleX = this.angleY = this.angleZ = 0;
      this.scaleX = this.scaleY = this.scaleZ = 1;
   }

   /**
    * Constructs PositionNode
    * 
    * @param node
    *           Base node
    */
   public PositionNode(final Node node)
   {
      this.x = node.getX();
      this.y = node.getY();
      this.z = node.getZ();
      this.angleX = node.getAngleX();
      this.angleY = node.getAngleY();
      this.angleZ = node.getAngleZ();
      this.scaleX = node.getScaleX();
      this.scaleY = node.getScaleY();
      this.scaleZ = node.getScaleZ();
   }
}