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
package jhelp.engine.samples.video;

import java.io.IOException;

import jhelp.engine.JHelpSceneRenderer;
import jhelp.engine.Material;
import jhelp.engine.Node;
import jhelp.engine.Scene;
import jhelp.engine.TextureVideo;
import jhelp.engine.geom.Sphere;
import jhelp.engine.gui.JHelpFrame3D;
import jhelp.engine.samples.helloWord.HelloWordReal;
import jhelp.util.debug.Debug;
import jhelp.util.gui.UtilGUI;
import jhelp.util.resources.Resources;
import jhelp.video.VideoReader;

public class VideoSample
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
      final JHelpFrame3D frame3d = new JHelpFrame3D(true, "Sample : Video");
      frame3d.setVisible(true);

      // Get the scene renderer
      final JHelpSceneRenderer sceneRenderer = frame3d.getSceneRenderer();
      // Get the scene to modify
      final Scene scene = sceneRenderer.getScene();

      // Create a cube
      final Node helloWord = new Sphere();
      helloWord.setAngleX(90);
      helloWord.setAngleZ(90);

      // Add the cube in the scene
      scene.add(helloWord);

      // Add texture material to cube
      final Material material = new Material("MaterialCube");

      try
      {
         final TextureVideo textureVideo = new TextureVideo(new VideoReader(VideoSample.RESOURCES.obtainResourceURL("video.gg")), 25);
         material.setTextureDiffuse(textureVideo);
         textureVideo.startVideo();
      }
      catch(final IOException exception)
      {
         Debug.printException(exception);
      }

      helloWord.applyMaterialHierarchicaly(material);

      // Put the scene for being visible
      scene.setPosition(0, 0, -5);

      // Show last modifications
      scene.flush();
   }
}