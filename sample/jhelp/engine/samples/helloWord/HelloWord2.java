package jhelp.engine.samples.helloWord;

import java.io.IOException;

import jhelp.engine.JHelpSceneRenderer;
import jhelp.engine.Material;
import jhelp.engine.Object3D;
import jhelp.engine.Scene;
import jhelp.engine.Texture;
import jhelp.engine.geom.Box;
import jhelp.engine.gui.JHelpFrame3D;
import jhelp.util.debug.Debug;
import jhelp.util.gui.UtilGUI;
import jhelp.util.resources.Resources;

/**
 * Hello word exemple, a simple cube in middle of the scene
 * 
 * @author JHelp
 */
public class HelloWord2
{
   /** Resources access */
   private static final Resources RESOURCES = new Resources(HelloWord2.class);

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
      final JHelpFrame3D frame3d = new JHelpFrame3D(true, "Sample : Hello word");
      frame3d.setVisible(true);

      // Get the scene renderer
      final JHelpSceneRenderer sceneRenderer = frame3d.getSceneRenderer();
      // Get the scene to modify
      final Scene scene = sceneRenderer.getScene();

      // Create a cube
      final Object3D cube = new Box();

      // Add the cube in the scene
      scene.add(cube);

      // Add texture material to cube
      final Material material = new Material("MaterialCube");
      // Remove comment bellow for have red version
      // material.setColorDiffuse(Color4f.RED);
      try
      {
         final Texture texture = new Texture("TextureDiffuse", Texture.REFERENCE_RESOURCES, HelloWord2.RESOURCES.obtainResourceStream("B100M801.BMP"));
         material.setTextureDiffuse(texture);
      }
      catch(final IOException exception)
      {
         Debug.printException(exception);
      }

      cube.setMaterial(material);

      // Put the scene for being visible
      scene.setPosition(0, 0, -5);
      // Rotate a little for see its 3D
      scene.setAngleX(18f);
      scene.setAngleY(-26f);
      scene.setAngleZ(0f);

      // Show last modifications
      scene.flush();
   }
}