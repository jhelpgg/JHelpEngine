package jhelp.engine.samples.ribbon;

import java.io.IOException;

import jhelp.engine.JHelpSceneRenderer;
import jhelp.engine.Material;
import jhelp.engine.NodeWithMaterial.TwoSidedState;
import jhelp.engine.Object3D;
import jhelp.engine.Scene;
import jhelp.engine.Texture;
import jhelp.engine.geom.Ribbon3D;
import jhelp.engine.gui.JHelpFrame3D;
import jhelp.engine.samples.helloWord.HelloWord3;
import jhelp.util.debug.Debug;
import jhelp.util.gui.UtilGUI;
import jhelp.util.resources.Resources;

public class RibbonSample
{
   private static final Resources RESOURCES = new Resources(HelloWord3.class);

   /**
    * @param args
    */
   public static void main(final String[] args)
   {
      UtilGUI.initializeGUI();

      // Create a frame 3D with default size and show it
      final JHelpFrame3D frame3d = new JHelpFrame3D(true, "Sample : Ribbon 3D");
      frame3d.setVisible(true);

      // Get the scene renderer
      final JHelpSceneRenderer sceneRenderer = frame3d.getSceneRenderer();
      // Get the scene to modify
      final Scene scene = sceneRenderer.getScene();

      final Object3D mobius = new Ribbon3D(1, 4, 1);
      mobius.setTwoSidedState(TwoSidedState.FORCE_TWO_SIDE);

      // Add texture material to moebius
      final Material material = new Material("MaterialEquation");
      try
      {
         Texture texture = new Texture("TextureDiffuse", Texture.REFERENCE_RESOURCES, RibbonSample.RESOURCES.obtainResourceStream("floor068.jpg"));
         material.setTextureDiffuse(texture);

         texture = new Texture("TextureSpherique", Texture.REFERENCE_RESOURCES, RibbonSample.RESOURCES.obtainResourceStream("emerald_bk.jpg"));
         material.setTextureSpheric(texture);
         material.setSphericRate(0.5f);
      }
      catch(final IOException exception)
      {
         Debug.printException(exception);
      }

      // mobius.setShowWire(true);
      mobius.setMaterial(material);

      // Add the moebius in the scene
      scene.add(mobius);

      // (-0.56000006f, 0.029999992f, -5.5299816f) | AngleX=381.0f | AngleY=-240.0f | AngleZ=0.0f
      // Put the scene for being visible
      scene.setPosition(-0.56000006f, 0.029999992f, -5.5299816f);
      // Rotate a little for see its 3D
      scene.setAngleX(381.0f);
      scene.setAngleY(-240.0f);
      scene.setAngleZ(0.0f);

      // Show last modifications
      scene.flush();
   }
}