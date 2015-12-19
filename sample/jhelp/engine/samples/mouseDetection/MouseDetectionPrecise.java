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
package jhelp.engine.samples.mouseDetection;

import java.io.IOException;

import jhelp.engine.Color4f;
import jhelp.engine.JHelpSceneRenderer;
import jhelp.engine.Material;
import jhelp.engine.Node;
import jhelp.engine.NodeWithMaterial;
import jhelp.engine.NodeWithMaterial.TwoSidedState;
import jhelp.engine.ObjectClone;
import jhelp.engine.PickUVlistener;
import jhelp.engine.Point2D;
import jhelp.engine.Scene;
import jhelp.engine.Texture;
import jhelp.engine.event.NodeListener;
import jhelp.engine.geom.PathGeom;
import jhelp.engine.gui.JHelpFrame3D;
import jhelp.engine.samples.helloWord.HelloWord3;
import jhelp.util.debug.Debug;
import jhelp.util.debug.DebugLevel;
import jhelp.util.gui.UtilGUI;
import jhelp.util.resources.Resources;

public class MouseDetectionPrecise
      implements NodeListener, PickUVlistener
{
   /** Resources access */
   private static final Resources    RESOURCES = new Resources(HelloWord3.class);
   private static JHelpSceneRenderer sceneRenderer;

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
      final JHelpFrame3D frame3d = new JHelpFrame3D(true, "Sample : Mouse detection precise");
      frame3d.setVisible(true);

      // Get the scene renderer
      MouseDetectionPrecise.sceneRenderer = frame3d.getSceneRenderer();
      // Get the scene to modify
      final Scene scene = MouseDetectionPrecise.sceneRenderer.getScene();

      // Create a object
      final PathGeom object = new PathGeom(16, 16);
      object.nodeName = "Original";
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
         Texture texture = new Texture("TextureDiffuse", Texture.REFERENCE_RESOURCES, MouseDetectionPrecise.RESOURCES.obtainResourceStream("floor068.jpg"));
         material.setTextureDiffuse(texture);

         texture = new Texture("TextureSpherique", Texture.REFERENCE_RESOURCES, MouseDetectionPrecise.RESOURCES.obtainResourceStream("emerald_bk.jpg"));
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

      final MouseDetectionPrecise detection = new MouseDetectionPrecise();
      object.addNodeListener(detection);
      object.setPosition(0, 0, 2);
      object.pickUVlistener = detection;

      final ObjectClone objectClone = new ObjectClone(object);
      objectClone.setPosition(0, 0, -2);
      scene.add(objectClone);
      objectClone.addNodeListener(detection);
      objectClone.setTwoSidedState(TwoSidedState.FORCE_TWO_SIDE);
      objectClone.nodeName = "Clone";
      objectClone.pickUVlistener = detection;

      // Show last modifications
      scene.flush();
   }

   @Override
   public void mouseClick(final Node node, final boolean leftButton, final boolean rightButton)
   {
      node.setShowWire(rightButton);
      MouseDetectionPrecise.sceneRenderer.setPickUVnode(node);
   }

   @Override
   public void mouseEnter(final Node node)
   {
      ((NodeWithMaterial) node).getMaterial().setColorDiffuse(Color4f.LIGHT_RED);
   }

   @Override
   public void mouseExit(final Node node)
   {
      ((NodeWithMaterial) node).getMaterial().setColorDiffuse(Color4f.WHITE);
   }

   @Override
   public void pickUV(final int u, final int v, final Node node)
   {
      Debug.println(DebugLevel.VERBOSE, "Pick (", u, ", ", v, ") on ", node);
      MouseDetectionPrecise.sceneRenderer.disablePickUV();
   }
}