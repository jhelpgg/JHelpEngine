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
import jhelp.engine.Object3D;
import jhelp.engine.Scene;
import jhelp.engine.Texture;
import jhelp.engine.anim.MultiAnimation;
import jhelp.engine.anim.texture.AnimationTextureTransformation;
import jhelp.engine.anim.texture.TextureTransformation;
import jhelp.engine.geom.Box;
import jhelp.engine.gui.JHelpFrame3D;
import jhelp.engine.samples.helloWord.HelloWord2;
import jhelp.util.debug.Debug;
import jhelp.util.gui.UtilGUI;
import jhelp.util.resources.Resources;

public class AnimationTextureTransformationSample
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
         final Texture texture1 = new Texture("TextureDiffuse1", Texture.REFERENCE_RESOURCES,
               AnimationTextureTransformationSample.RESOURCES.obtainResourceStream("floor068.jpg"));
         final AnimationTextureTransformation animationTextureTransformation = new AnimationTextureTransformation(texture1);
         final TextureTransformation textureTransformation = new TextureTransformation();
         textureTransformation.setShift(1, 0);
         final TextureTransformation textureTransformation2 = new TextureTransformation();
         textureTransformation2.setShift(1, 1);
         textureTransformation2.setContrast(1.1f);
         final int nb = 20;

         for(int i = 1; i < nb; i++)
         {
            animationTextureTransformation.addFrame(i, textureTransformation);
         }

         animationTextureTransformation.addFrame(nb, textureTransformation2);
         final MultiAnimation multiAnimation = new MultiAnimation(true);
         multiAnimation.addAnimation(animationTextureTransformation);

         material.setTextureDiffuse(texture1);
         sceneRenderer.playAnimation(multiAnimation);
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