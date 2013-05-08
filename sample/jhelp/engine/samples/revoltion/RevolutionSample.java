package jhelp.engine.samples.revoltion;

import java.io.IOException;

import jhelp.engine.JHelpSceneRenderer;
import jhelp.engine.Material;
import jhelp.engine.Point2D;
import jhelp.engine.Scene;
import jhelp.engine.Texture;
import jhelp.engine.geom.Revolution;
import jhelp.engine.gui.JHelpFrame3D;
import jhelp.engine.samples.helloWord.HelloWord3;
import jhelp.util.debug.Debug;
import jhelp.util.gui.UtilGUI;
import jhelp.util.resources.Resources;

public class RevolutionSample
{
   /** Resources access */
   private static final Resources RESOURCES = new Resources(HelloWord3.class);

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
      final JHelpFrame3D frame3d = new JHelpFrame3D(true, "Sample : Revolution");
      frame3d.setVisible(true);

      // Get the scene renderer
      final JHelpSceneRenderer sceneRenderer = frame3d.getSceneRenderer();
      // Get the scene to modify
      final Scene scene = sceneRenderer.getScene();

      // Create a object
      final Revolution object = new Revolution(360f, 32, 64, 1f);
      object.appendQuad(new Point2D(0f, 0.5f), new Point2D(0.25f, 0.75f), new Point2D(0.5f, 0.5f));
      object.appendLine(new Point2D(0.5f, 0.5f), new Point2D(0.5f, 0f));
      object.appendLine(new Point2D(0.5f, 0f), new Point2D(0.2f, -0.5f));

      object.scale(1, 2, 1);

      object.refreshRevolution();

      // Add the object in the scene
      scene.add(object);

      // Add texture material to object
      final Material material = new Material("Materialobject");
      material.setTwoSided(true);
      try
      {
         Texture texture = new Texture("TextureDiffuse", Texture.REFERENCE_RESOURCES, RevolutionSample.RESOURCES.obtainResourceStream("floor068.jpg"));
         material.setTextureDiffuse(texture);

         texture = new Texture("TextureSpherique", Texture.REFERENCE_RESOURCES, RevolutionSample.RESOURCES.obtainResourceStream("emerald_bk.jpg"));
         material.setTextureSpheric(texture);
         material.setSphericRate(0.25f);
      }
      catch(final IOException exception)
      {
         Debug.printException(exception);
      }

      object.setMaterial(material);

      // (0.109999955f, 0.23999989f, -4.0400004f) | AngleX=152.0f | AngleY=8.0f | AngleZ=0.0f
      // Put the scene for being visible
      scene.setPosition(0.101f, 0.24f, -4.04f);
      // Rotate a little for see its 3D
      scene.setAngleX(152f);
      scene.setAngleY(8f);
      scene.setAngleZ(0f);

      // Show last modifications
      scene.flush();
   }
}