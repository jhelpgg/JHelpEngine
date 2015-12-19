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
package jhelp.engine.samples.animation;

import java.io.IOException;

import jhelp.engine.JHelpSceneRenderer;
import jhelp.engine.Material;
import jhelp.engine.Node;
import jhelp.engine.Point2D;
import jhelp.engine.Scene;
import jhelp.engine.Texture;
import jhelp.engine.anim.AnimationPositionNode;
import jhelp.engine.anim.AnimationPositionObject2D;
import jhelp.engine.event.NodeListener;
import jhelp.engine.event.Object2DListener;
import jhelp.engine.geom.PathGeom;
import jhelp.engine.gui.JHelpFrame3D;
import jhelp.engine.samples.helloWord.HelloWord3;
import jhelp.engine.twoD.GUI2D;
import jhelp.engine.twoD.Object2D;
import jhelp.engine.util.PositionNode;
import jhelp.engine.util.PositionObject2D;
import jhelp.util.debug.Debug;
import jhelp.util.gui.UtilGUI;
import jhelp.util.resources.Resources;

public class AnimationKeyFrameSample
      implements NodeListener, Object2DListener
{
   private static AnimationPositionNode     animationPositionNode;
   private static AnimationPositionObject2D animationPositionObject2D;
   /** Resources access */
   private static final Resources           RESOURCES = new Resources(HelloWord3.class);
   private static JHelpSceneRenderer        sceneRenderer;

   /**
    * Launch the hello word
    * 
    * @param args
    *           Unused
    */
   public static void main(final String[] args)
   {
      UtilGUI.initializeGUI();

      // Create a frame 3D with default size and show it
      final JHelpFrame3D frame3d = new JHelpFrame3D(true, "Sample : Animation key frame");
      frame3d.setVisible(true);

      // Get the scene renderer
      AnimationKeyFrameSample.sceneRenderer = frame3d.getSceneRenderer();
      // Get the scene to modify
      final Scene scene = AnimationKeyFrameSample.sceneRenderer.getScene();

      final GUI2D gui2d = AnimationKeyFrameSample.sceneRenderer.getGui2d();

      // Create a object
      final PathGeom object = new PathGeom(16, 16);
      // U
      object.appendQuadU(new Point2D(-0.5f, 0.5f), new Point2D(0, 0.75f), new Point2D(0.5f, 0.5f));
      object.appendQuadU(new Point2D(0.5f, 0.5f), new Point2D(0.75f, 0f), new Point2D(0.5f, -0.5f));
      object.appendQuadU(new Point2D(0.5f, -0.5f), new Point2D(0, -0.75f), new Point2D(-0.5f, -0.5f));
      object.appendQuadU(new Point2D(-0.5f, -0.5f), new Point2D(-0.75f, 0), new Point2D(-0.5f, 0.5f));
      // V
      object.appendQuadV(new Point2D(-0.5f, 0.5f), new Point2D(0, 0.75f), new Point2D(0.5f, 0.5f));
      object.appendQuadV(new Point2D(0.5f, 0.5f), new Point2D(0.75f, 0f), new Point2D(0.5f, -0.5f));
      object.appendQuadV(new Point2D(0.5f, -0.5f), new Point2D(0, -0.75f), new Point2D(-0.5f, -0.5f));

      object.refreshJoinedPath(2, false, true);

      // Add the object in the scene
      scene.add(object);

      // Add texture material to object
      final Material material = new Material("Materialobject");
      material.setTwoSided(true);
      try
      {
         Texture texture = new Texture("TextureDiffuse", Texture.REFERENCE_RESOURCES, AnimationKeyFrameSample.RESOURCES.obtainResourceStream("floor068.jpg"));
         material.setTextureDiffuse(texture);

         texture = new Texture("TextureSpherique", Texture.REFERENCE_RESOURCES, AnimationKeyFrameSample.RESOURCES.obtainResourceStream("emerald_bk.jpg"));
         material.setTextureSpheric(texture);
         material.setSphericRate(0.25f);
      }
      catch(final IOException exception)
      {
         Debug.printException(exception);
      }

      object.setMaterial(material);

      // Put the scene for being visible
      scene.setPosition(0, 0, -8);
      // Rotate a little for see its 3D
      scene.setAngleX(37f);
      scene.setAngleY(-90f);
      scene.setAngleZ(0f);

      final AnimationKeyFrameSample detection = new AnimationKeyFrameSample();
      object.addNodeListener(detection);

      final Object2D object2d = new Object2D(100, 100, 100, 100);
      object2d.setTexture(Texture.obtainTexture("TextureDiffuse"));
      object2d.addObject2DListener(detection);
      gui2d.addOver3D(object2d);

      // Show last modifications
      scene.flush();

      AnimationKeyFrameSample.animationPositionNode = new AnimationPositionNode(object);
      AnimationKeyFrameSample.animationPositionNode.addFrame(100, new PositionNode(0, 0, 0, -57.0f, -203.0f, 0.0f));
      AnimationKeyFrameSample.animationPositionNode.addFrame(500, new PositionNode(0, 0, 0, 187.0f, -61.0f, 0.0f));
      AnimationKeyFrameSample.animationPositionNode.addFrame(1000, new PositionNode(0, 0, 0));
      AnimationKeyFrameSample.animationPositionNode.addFrame(1500, new PositionNode(0, 0, 0, 0, 0, 0, 1, 0.5f, 1));
      AnimationKeyFrameSample.animationPositionNode.addFrame(2000, new PositionNode(0, 0, 0, 0, 0, 0, 0.75f, 0.5f, 2f));

      AnimationKeyFrameSample.animationPositionObject2D = new AnimationPositionObject2D(object2d);
      AnimationKeyFrameSample.animationPositionObject2D.addFrame(100, new PositionObject2D(250, 250, 100, 100));
      AnimationKeyFrameSample.animationPositionObject2D.addFrame(500, new PositionObject2D(250, 250, 250, 250));
      AnimationKeyFrameSample.animationPositionObject2D.addFrame(1000, new PositionObject2D(500, 500, 100, 100));

      AnimationKeyFrameSample.sceneRenderer.setAnimationsFps(100);
   }

   @Override
   public void mouseClick(final Node node, final boolean leftButton, final boolean rightButton)
   {
      AnimationKeyFrameSample.sceneRenderer.playAnimation(AnimationKeyFrameSample.animationPositionNode);
   }

   @Override
   public void mouseClick(final Object2D object2d, final int x, final int y, final boolean leftButton, final boolean rightButton)
   {
      AnimationKeyFrameSample.sceneRenderer.playAnimation(AnimationKeyFrameSample.animationPositionObject2D);
   }

   @Override
   public void mouseDrag(final Object2D object2d, final int x, final int y, final boolean leftButton, final boolean rightButton)
   {
   }

   @Override
   public void mouseEnter(final Node node)
   {
   }

   @Override
   public void mouseEnter(final Object2D object2d, final int x, final int y)
   {
   }

   @Override
   public void mouseExit(final Node node)
   {
   }

   @Override
   public void mouseExit(final Object2D object2d, final int x, final int y)
   {
   }

   @Override
   public void mouseMove(final Object2D object2d, final int x, final int y)
   {
   }
}