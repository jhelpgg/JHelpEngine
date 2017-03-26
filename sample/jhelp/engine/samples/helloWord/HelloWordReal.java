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

import jhelp.engine.Font3D;
import jhelp.engine.JHelpSceneRenderer;
import jhelp.engine.Material;
import jhelp.engine.Node;
import jhelp.engine.Scene;
import jhelp.engine.Texture;
import jhelp.engine.gui.JHelpFrame3D;
import jhelp.util.debug.Debug;
import jhelp.util.gui.UtilGUI;
import jhelp.util.resources.Resources;

/**
 * Hello word exemple, a simple cube in middle of the scene
 *
 * @author JHelp
 */
public class HelloWordReal
{
   /** Resources access */
   private static final Resources RESOURCES = new Resources(HelloWordReal.class);

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
      final Node helloWord = Font3D.createString("Courier New", "Hello world !", 0.001f, 1, 0.2f);

      // Add the cube in the scene
      scene.add(helloWord);

      // Add texture material to cube
      final Material material = new Material("MaterialCube");
      material.setTwoSided(true);
      // Remove comment bellow for have red version
      // material.setColorDiffuse(Color4f.RED);
      try
      {
         Texture texture = new Texture("TextureDiffuse", Texture.REFERENCE_RESOURCES, HelloWordReal.RESOURCES.obtainResourceStream("floor068.jpg"));
         material.setTextureDiffuse(texture);

         texture = new Texture("TextureSpherique", Texture.REFERENCE_RESOURCES, HelloWordReal.RESOURCES.obtainResourceStream("emerald_bk.jpg"));
         material.setTextureSpheric(texture);
         material.setSphericRate(0.5f);
      }
      catch(final IOException exception)
      {
         Debug.printException(exception);
      }

      helloWord.applyMaterialHierarchicaly(material);

      // Put the scene for being visible
      scene.setPosition(0, 0, -7);
      // Rotate a little for see its 3D
      scene.setAngleX(7f);
      scene.setAngleY(-1f);
      scene.setAngleZ(0f);

      // Show last modifications
      scene.flush();
   }
}