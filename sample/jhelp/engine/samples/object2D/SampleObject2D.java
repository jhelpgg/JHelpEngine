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
package jhelp.engine.samples.object2D;

import java.io.IOException;

import jhelp.engine.JHelpSceneRenderer;
import jhelp.engine.Material;
import jhelp.engine.NodeWithMaterial.TwoSidedState;
import jhelp.engine.Object3D;
import jhelp.engine.Point2D;
import jhelp.engine.Scene;
import jhelp.engine.Texture;
import jhelp.engine.event.Object2DListener;
import jhelp.engine.geom.Equation3D;
import jhelp.engine.gui.JHelpFrame3D;
import jhelp.engine.samples.helloWord.HelloWord3;
import jhelp.engine.twoD.GUI2D;
import jhelp.engine.twoD.Object2D;
import jhelp.engine.twoD.Path;
import jhelp.engine.util.Math3D;
import jhelp.util.debug.Debug;
import jhelp.util.gui.UtilGUI;
import jhelp.util.resources.Resources;

public class SampleObject2D
      implements Object2DListener
{
   /** Resources access */
   private static final Resources RESOURCES = new Resources(HelloWord3.class);

   /**
    * TODO Explains what does the method main in jhelp.engine.samples.equation3D [JHelpEngine]
    * 
    * @param args
    */
   public static void main(final String[] args)
   {
      UtilGUI.initializeGUI();

      // Create a frame 3D with default size and show it
      final JHelpFrame3D frame3d = new JHelpFrame3D(true, "Sample : Sample Object 2D");
      frame3d.setVisible(true);

      // Get the scene renderer
      final JHelpSceneRenderer sceneRenderer = frame3d.getSceneRenderer();
      // Get the scene to modify
      final Scene scene = sceneRenderer.getScene();
      final GUI2D gui2d = sceneRenderer.getGui2d();

      // Create an equation
      final Path path = new Path();
      path.appendQuad(new Point2D(-0.5f, 0.5f), new Point2D(0, 0.75f), new Point2D(0.5f, 0.5f));
      path.appendQuad(new Point2D(0.5f, 0.5f), new Point2D(0.75f, 0f), new Point2D(0.5f, -0.5f));
      path.appendQuad(new Point2D(0.5f, -0.5f), new Point2D(0, -0.75f), new Point2D(-0.5f, -0.5f));
      path.appendQuad(new Point2D(-0.5f, -0.5f), new Point2D(-0.75f, 0), new Point2D(-0.5f, 0.5f));
      final Object3D knot = new Equation3D(path, 16, -Math3D.PI, Math3D.PI, Math3D.PI / 64f, "2*(sin(t)+2*sin(2*t))", "2*(cos(t)-2*cos(2*t))", "2*(-sin(3*t))");
      knot.setTwoSidedState(TwoSidedState.FORCE_TWO_SIDE);

      // Add texture material to knot
      final Material material = new Material("MaterialEquation");
      try
      {
         Texture texture = new Texture("TextureDiffuse", Texture.REFERENCE_RESOURCES, SampleObject2D.RESOURCES.obtainResourceStream("floor068.jpg"));
         material.setTextureDiffuse(texture);

         texture = new Texture("TextureSpherique", Texture.REFERENCE_RESOURCES, SampleObject2D.RESOURCES.obtainResourceStream("001-Fog01.png"));
         material.setTextureSpheric(texture);
         material.setSphericRate(0.25f);

         texture = new Texture("TextureDiffuse2", Texture.REFERENCE_RESOURCES, SampleObject2D.RESOURCES.obtainResourceStream("B100M801.BMP"));
      }
      catch(final IOException exception)
      {
         Debug.printException(exception);
      }

      final SampleObject2D sampleObject2D = new SampleObject2D();

      Object2D object2d = new Object2D(100, 100, 100, 100);
      object2d.setTexture(Texture.obtainTexture("TextureDiffuse"));
      object2d.addObject2DListener(sampleObject2D);
      gui2d.addOver3D(object2d);

      object2d = new Object2D(500, 500, 100, 100);
      object2d.setTexture(Texture.obtainTexture("TextureDiffuse2"));
      object2d.addObject2DListener(sampleObject2D);
      gui2d.addUnder3D(object2d);

      knot.setMaterial(material);

      // Add the knot in the scene
      scene.add(knot);

      // (0.0f, 0.0f, -20.279984f) | AngleX=183.0f | AngleY=13.0f | AngleZ=0.0f
      // Put the scene for being visible
      scene.setPosition(0, 0, -20.279984f);
      // Rotate a little for see its 3D
      scene.setAngleX(183.0f);
      scene.setAngleY(13.0f);
      scene.setAngleZ(0f);

      // Show last modifications
      scene.flush();
   }

   @Override
   public void mouseClick(final Object2D object2d, final int x, final int y, final boolean leftButton, final boolean rightButton)
   {
      Material.obtainMaterial("MaterialEquation").setTextureDiffuse(object2d.getTexture());
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