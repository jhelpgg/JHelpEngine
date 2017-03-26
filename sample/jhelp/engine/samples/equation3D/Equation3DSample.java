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
package jhelp.engine.samples.equation3D;

import java.io.IOException;

import jhelp.engine.JHelpSceneRenderer;
import jhelp.engine.Material;
import jhelp.engine.NodeWithMaterial.TwoSidedState;
import jhelp.engine.Point2D;
import jhelp.engine.Scene;
import jhelp.engine.Texture;
import jhelp.engine.event.Equation3DListener;
import jhelp.engine.geom.Equation3D;
import jhelp.engine.gui.JHelpFrame3D;
import jhelp.engine.samples.helloWord.HelloWord3;
import jhelp.engine.twoD.Path;
import jhelp.engine.util.Math3D;
import jhelp.util.debug.Debug;
import jhelp.util.debug.DebugLevel;
import jhelp.util.gui.UtilGUI;
import jhelp.util.resources.Resources;

public class Equation3DSample
      implements Equation3DListener
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
      final JHelpFrame3D frame3d = new JHelpFrame3D(true, "Sample : Equation 3D");
      frame3d.setVisible(true);

      // Get the scene renderer
      final JHelpSceneRenderer sceneRenderer = frame3d.getSceneRenderer();
      // Get the scene to modify
      final Scene scene = sceneRenderer.getScene();

      // Create an equation
      final Path path = new Path();
      path.appendQuad(new Point2D(-0.5f, 0.5f), new Point2D(0, 0.75f), new Point2D(0.5f, 0.5f));
      path.appendQuad(new Point2D(0.5f, 0.5f), new Point2D(0.75f, 0f), new Point2D(0.5f, -0.5f));
      path.appendQuad(new Point2D(0.5f, -0.5f), new Point2D(0, -0.75f), new Point2D(-0.5f, -0.5f));
      path.appendQuad(new Point2D(-0.5f, -0.5f), new Point2D(-0.75f, 0), new Point2D(-0.5f, 0.5f));
      final Equation3D spiral = new Equation3D(path, 16, -2 * Math3D.TWO_PI, 2 * Math3D.TWO_PI, Math3D.PI / 32f, "10*cos(t)", "10*sin(t)", "t",
            new Equation3DSample());
      spiral.setTwoSidedState(TwoSidedState.FORCE_TWO_SIDE);

      // Add texture material to spiral
      final Material material = new Material("MaterialEquation");
      try
      {
         Texture texture = new Texture("TextureDiffuse", Texture.REFERENCE_RESOURCES, Equation3DSample.RESOURCES.obtainResourceStream("floor068.jpg"));
         material.setTextureDiffuse(texture);

         texture = new Texture("TextureSpherique", Texture.REFERENCE_RESOURCES, Equation3DSample.RESOURCES.obtainResourceStream("emerald_bk.jpg"));
         material.setTextureSpheric(texture);
         material.setSphericRate(0.5f);
      }
      catch(final IOException exception)
      {
         Debug.printException(exception);
      }

      spiral.setMaterial(material);

      // Add the spiral in the scene
      scene.add(spiral);

      // (0.0f, 0.0f, -32.76f) | AngleX=2.0f | AngleY=94.0f | AngleZ=0.0f
      // Put the scene for being visible
      scene.setPosition(0, 0, -32.76f);
      // Rotate a little for see its 3D
      scene.setAngleX(2.0f);
      scene.setAngleY(94.0f);
      scene.setAngleZ(0f);

      // Show last modifications
      scene.flush();
   }

   @Override
   public void equation3Dready(final Equation3D equation3d)
   {
      Debug.printMark(DebugLevel.INFORMATION, "Ready !");
   }
}