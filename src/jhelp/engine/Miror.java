package jhelp.engine;

import java.util.concurrent.atomic.AtomicInteger;

import jhelp.engine.util.PositionNode;

public class Miror
{
   private static final AtomicInteger NEXT_ID = new AtomicInteger(0);
   private final Material             material;
   private final NodeWithMaterial     nodeWithMaterial;
   private PositionNode               originalPosition;
   private final PositionNode         positionNode;
   private final Texture              texture;
   public float                       backgroundAlpha;
   public float                       backgroundBlue;
   public float                       backgroundGreen;
   public float                       backgroundRed;

   public Miror(final NodeWithMaterial nodeWithMaterial, final PositionNode positionNode)
   {
      this.nodeWithMaterial = nodeWithMaterial;
      this.positionNode = positionNode;
      final String name = "JHelpMirror" + Miror.NEXT_ID.getAndIncrement();
      this.material = new Material(name);
      this.texture = new Texture(name, 16, 16, 0xCAFEFACE);
      this.material.setTextureDiffuse(this.texture);
      nodeWithMaterial.setMaterial(this.material);
   }

   void endRender(final Scene scene)
   {
      final Node root = scene.getRoot();
      root.setPosition(this.originalPosition.x, this.originalPosition.y, this.originalPosition.z);
      root.setAngleX(this.originalPosition.angleX);
      root.setAngleY(this.originalPosition.angleY);
      root.setAngleZ(this.originalPosition.angleZ);
      root.setScale(this.originalPosition.scaleX, this.originalPosition.scaleY, this.originalPosition.scaleZ);

      this.material.setTextureDiffuse(this.texture);
      this.nodeWithMaterial.setVisible(true);
   }

   Texture startRender(final Scene scene)
   {
      if(this.nodeWithMaterial.isVisible() == false)
      {
         return null;
      }

      this.nodeWithMaterial.setVisible(false);
      final Node root = scene.getRoot();
      this.originalPosition = new PositionNode(root);
      root.setPosition(this.positionNode.x, this.positionNode.y, this.positionNode.z);
      root.setAngleX(this.positionNode.angleX);
      root.setAngleY(this.positionNode.angleY);
      root.setAngleZ(this.positionNode.angleZ);
      root.setScale(this.positionNode.scaleX, this.positionNode.scaleY, this.positionNode.scaleZ);
      return this.texture;
   }

   public Material getMaterial()
   {
      return this.material;
   }

   public NodeWithMaterial getNodeWithMaterial()
   {
      return this.nodeWithMaterial;
   }

   public PositionNode getPositionNode()
   {
      return this.positionNode;
   }
}