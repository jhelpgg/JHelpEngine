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
package jhelp.engine.samples.helloWord;

import java.io.IOException;

import jhelp.engine.CubeMap;
import jhelp.engine.JHelpSceneRenderer;
import jhelp.engine.Material;
import jhelp.engine.Point2D;
import jhelp.engine.Scene;
import jhelp.engine.Texture;
import jhelp.engine.geom.Revolution;
import jhelp.engine.gui.JHelpFrame3D;
import jhelp.util.debug.Debug;
import jhelp.util.gui.UtilGUI;
import jhelp.util.resources.Resources;

/**
 * Hello word exemple, a simple cube in middle of the scene
 * 
 * @author JHelp
 */
public class HelloWord4
{
   /** Resources access */
   private static final Resources RESOURCES = new Resources(HelloWord4.class);

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
      final Revolution revolution = new Revolution(360, 1, 90, 1);
      revolution.appendLine(new Point2D(0, 0.5f), new Point2D(0.5f, 0.5f));
      revolution.appendLine(new Point2D(0.5f, 0.5f), new Point2D(0.5f, -0.5f));
      revolution.appendLine(new Point2D(0.5f, -0.5f), new Point2D(0, -0.5f));
      revolution.refreshRevolution();

      // Add the cube in the scene
      scene.add(revolution);

      // Add texture material to cube
      final Material material = new Material("MaterialCube");
      // Remove comment bellow for have red version
      // material.setColorDiffuse(Color4f.RED);
      try
      {
         Texture texture = new Texture("TextureDiffuse", Texture.REFERENCE_RESOURCES, HelloWord4.RESOURCES.obtainResourceStream("floor068.jpg"));
         material.setTextureDiffuse(texture);

         texture = new Texture("TextureCubique", Texture.REFERENCE_RESOURCES, HelloWord4.RESOURCES.obtainResourceStream("uffizi_cube.jpg"));
         final CubeMap cubeMap = new CubeMap();
         cubeMap.crossTexture(texture);
         material.setCubeMap(cubeMap);
         material.setCubeMapRate(0.25f);
      }
      catch(final IOException exception)
      {
         Debug.printException(exception);
      }

      revolution.setMaterial(material);

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