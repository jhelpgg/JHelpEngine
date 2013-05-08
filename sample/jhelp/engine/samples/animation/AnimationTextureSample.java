package jhelp.engine.samples.animation;

import java.io.IOException;

import jhelp.engine.JHelpSceneRenderer;
import jhelp.engine.Material;
import jhelp.engine.Object3D;
import jhelp.engine.Scene;
import jhelp.engine.Texture;
import jhelp.engine.TextureInterpolator.InterpolationType;
import jhelp.engine.anim.AnimationTexture;
import jhelp.engine.geom.Box;
import jhelp.engine.gui.JHelpFrame3D;
import jhelp.engine.samples.helloWord.HelloWord2;
import jhelp.util.debug.Debug;
import jhelp.util.gui.UtilGUI;
import jhelp.util.resources.Resources;

public class AnimationTextureSample
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
      final JHelpFrame3D frame3d = new JHelpFrame3D(true, "Sample : Animation texture");
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
      try
      {
         final Texture texture1 = new Texture("TextureDiffuse1", Texture.REFERENCE_RESOURCES, AnimationTextureSample.RESOURCES.obtainResourceStream("floor068.jpg"));
         final Texture texture2 = new Texture("TextureDiffuse2", Texture.REFERENCE_RESOURCES, AnimationTextureSample.RESOURCES.obtainResourceStream("001-Fog01.png"));

         final AnimationTexture animationTextureSample = new AnimationTexture(100, texture1, texture2, true, InterpolationType.UNDEFINED);

         material.setTextureDiffuse(animationTextureSample.getInterpolatedTexture());
         sceneRenderer.playAnimation(animationTextureSample);
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