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
package jhelp.test.engine;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import jhelp.engine.Color4f;
import jhelp.engine.JHelpSceneRenderer;
import jhelp.engine.Material;
import jhelp.engine.Object3D;
import jhelp.engine.Scene;
import jhelp.engine.Texture;
import jhelp.engine.TextureVideo;
import jhelp.engine.event.Object2DListener;
import jhelp.engine.geom.Box;
import jhelp.engine.gui.JHelpFrame3D;
import jhelp.engine.io.obj.ObjLoader;
import jhelp.engine.twoD.Object2D;
import jhelp.gui.FileChooser;
import jhelp.util.Utilities;
import jhelp.util.debug.Debug;
import jhelp.util.thread.ThreadManager;
import jhelp.util.thread.ThreadedVerySimpleTask;

/**
 * Test of 3D
 * 
 * @author JHelp
 */
public class ZOrderTest
      implements Object2DListener
{
   private static Object3D     box;
   private static FileChooser  fileChooser;
   private static JHelpFrame3D helpFrame;
   private static Material     material;
   private static Scene        scene;
   private static TextureVideo textureVideo;
   static Object2D             object2dLoadOBJ;
   static Object2D             object2dLoadTexture;

   /**
    * Launch the test
    * 
    * @param args
    *           Unused
    */
   @SuppressWarnings("unused")
   public static void main(final String[] args)
   {
      final ZOrderTest zOrderTest = new ZOrderTest();

      ZOrderTest.helpFrame = new JHelpFrame3D();

      ZOrderTest.fileChooser = new FileChooser(ZOrderTest.helpFrame);

      //
      // ComponentView3D helpFrame = new ComponentView3D(500, 500);
      // JFrame frame = new JFrame();
      // frame.setLayout(new BorderLayout());
      // frame.add(helpFrame, BorderLayout.CENTER);
      // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // frame.pack();
      // frame.setVisible(true);
      //

      final JHelpSceneRenderer helpSceneRenderer = ZOrderTest.helpFrame.getSceneRenderer();
      ZOrderTest.scene = helpSceneRenderer.getScene();
      helpSceneRenderer.setDetectionActivate(true);
      ZOrderTest.scene.translate(0, 0, -5);

      ZOrderTest.object2dLoadOBJ = new Object2D(20, 20, 100, 100);
      ZOrderTest.object2dLoadOBJ.setVisible(true);
      ZOrderTest.object2dLoadOBJ.setCanBeDetected(true);
      ZOrderTest.object2dLoadOBJ.addObject2DListener(zOrderTest);

      helpSceneRenderer.getGui2d().addOver3D(ZOrderTest.object2dLoadOBJ);

      ZOrderTest.object2dLoadTexture = new Object2D(20, 150, 100, 100);
      ZOrderTest.object2dLoadTexture.setVisible(true);
      ZOrderTest.object2dLoadTexture.setCanBeDetected(true);
      ZOrderTest.object2dLoadTexture.addObject2DListener(zOrderTest);

      helpSceneRenderer.getGui2d().addOver3D(ZOrderTest.object2dLoadTexture);

      ZOrderTest.box = new Box();

      ZOrderTest.box.setWireColor(Color4f.BLACK);

      ZOrderTest.material = new Material("Red");
      ZOrderTest.material.getColorDiffuse().set(1, 1, 1);
      ZOrderTest.material.setTransparency(1f);
      ZOrderTest.material.setTwoSided(true);
      ZOrderTest.material.setCubeMapRate(0.25f);

      ZOrderTest.box.setMaterial(ZOrderTest.material);

      try
      {
         // final VideoReader videoReader = new VideoReader(new File(
         // "/home/jhelp/jhelpApi/api0by0jhelp~jhelp-api/JHelpVideo/video.gg"));
         // textureVideo = new TextureVideo(videoReader, 1);

         final Texture texture = new Texture("Part_mCloSwim08Upper.jpg", Texture.REFERENCE_RESOURCES,
               ZOrderTest.class.getResourceAsStream("Part_mCloSwim08Upper.jpg"));

         ZOrderTest.material.setTextureDiffuse(texture);// textureVideo);//
                                                        // CacheResources.CACHE.getTexture("tex/Part_mCloSwim08Upper.jpg"));

         ZOrderTest.object2dLoadOBJ.setTexture(texture);
         ZOrderTest.object2dLoadTexture.setTexture(texture);
      }
      catch(final Exception exception)
      {
         Debug.printException(exception);
      }

      ZOrderTest.box.setMaterial(ZOrderTest.material);

      ZOrderTest.scene.add(ZOrderTest.box);
      ZOrderTest.box.setMaterial(ZOrderTest.material);

      ZOrderTest.box.nodeName = "Bleu";
      ZOrderTest.scene.flush();

      if(ZOrderTest.textureVideo != null)
      {
         Utilities.sleep(1024);
         ZOrderTest.textureVideo.startVideo();
      }

      ZOrderTest.helpFrame.setVisible(true);

      zOrderTest.loadOBJ();
   }

   private final ThreadedVerySimpleTask threadedLoadOBJ     = new ThreadedVerySimpleTask()
                                                            {

                                                               @Override
                                                               protected void doVerySimpleAction()
                                                               {
                                                                  ZOrderTest.this.loadOBJ();
                                                               }
                                                            };
   private final ThreadedVerySimpleTask threadedLoadTexture = new ThreadedVerySimpleTask()
                                                            {

                                                               @Override
                                                               protected void doVerySimpleAction()
                                                               {
                                                                  ZOrderTest.this.loadTexture();
                                                               }
                                                            };

   void loadOBJ()
   {
      final File file = ZOrderTest.fileChooser.showOpenFile();

      if(file != null)
      {
         if(ZOrderTest.textureVideo != null)
         {
            ZOrderTest.textureVideo.setPause(true);

            Utilities.sleep(1024);
         }

         try
         {
            final Object3D object3d = new Object3D();

            ObjLoader.loadObj(object3d, new FileInputStream(file));
            object3d.flush();
            object3d.applyMaterialHierarchicaly(ZOrderTest.material);

            ZOrderTest.scene.remove(ZOrderTest.box);
            ZOrderTest.box = object3d;
            ZOrderTest.scene.add(ZOrderTest.box);

            ZOrderTest.scene.flush();
         }
         catch(final IOException e)
         {
            Debug.printException(e);
         }

         if(ZOrderTest.textureVideo != null)
         {
            Utilities.sleep(1024);

            ZOrderTest.textureVideo.setPause(false);
         }
      }
   }

   void loadTexture()
   {
      final File file = FileChooser.loadAnImage();

      if(file == null)
      {
         return;
      }

      final String name = file.getAbsolutePath();

      Texture texture = Texture.obtainTexture(name);

      if(texture == null)
      {
         InputStream inputStream = null;
         try
         {
            inputStream = new FileInputStream(file);

            texture = new Texture(name, Texture.REFERENCE_IMAGE, inputStream);
         }
         catch(final Exception exception)
         {
            Debug.printException(exception, "Issue while loading texture ", name);
         }
         finally
         {
            if(inputStream != null)
            {
               try
               {
                  inputStream.close();
               }
               catch(final Exception exception)
               {
               }
            }
         }
      }

      if(texture != null)
      {
         ZOrderTest.material.setTextureDiffuse(texture);

         ZOrderTest.object2dLoadOBJ.setTexture(texture);
         ZOrderTest.object2dLoadTexture.setTexture(texture);
      }
   }

   @Override
   public void mouseClick(final Object2D object2d, final int x, final int y, final boolean leftButton, final boolean rightButton)
   {
      if(object2d == ZOrderTest.object2dLoadOBJ)
      {
         ThreadManager.THREAD_MANAGER.doThread(this.threadedLoadOBJ, null);
      }
      else if(object2d == ZOrderTest.object2dLoadTexture)
      {
         ThreadManager.THREAD_MANAGER.doThread(this.threadedLoadTexture, null);
      }
   }

   @Override
   public void mouseDrag(final Object2D object2d, final int x, final int y, final boolean leftButton, final boolean rightButton)
   {
   }

   @Override
   public void mouseEnter(final Object2D object2d, final int x, final int y)
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