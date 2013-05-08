package jhelp.engine.samples.morph;

import java.io.IOException;

import javax.media.opengl.GL;

import jhelp.engine.Animation;
import jhelp.engine.JHelpSceneRenderer;
import jhelp.engine.Material;
import jhelp.engine.Object3D;
import jhelp.engine.Scene;
import jhelp.engine.Texture;
import jhelp.engine.geom.Sphere;
import jhelp.engine.gui.JHelpFrame3D;
import jhelp.engine.samples.helloWord.HelloWord2;
import jhelp.util.debug.Debug;
import jhelp.util.gui.UtilGUI;
import jhelp.util.math.UtilMath;
import jhelp.util.resources.Resources;

public class MorphSample
      implements Animation
{
   private static Object3D        morph;
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
      final JHelpFrame3D frame3d = new JHelpFrame3D(true, "Sample : Morph");
      frame3d.setVisible(true);

      // Get the scene renderer
      final JHelpSceneRenderer sceneRenderer = frame3d.getSceneRenderer();
      // Get the scene to modify
      final Scene scene = sceneRenderer.getScene();

      // Create a cube
      MorphSample.morph = new Sphere();

      // Add the cube in the scene
      scene.add(MorphSample.morph);

      // Add texture material to cube
      final Material material = new Material("MaterialCube");
      material.setTwoSided(true);
      try
      {
         final Texture texture = new Texture("TextureDiffuse", Texture.REFERENCE_RESOURCES, MorphSample.RESOURCES.obtainResourceStream("floor068.jpg"));
         material.setTextureDiffuse(texture);
      }
      catch(final IOException exception)
      {
         Debug.printException(exception);
      }

      MorphSample.morph.setMaterial(material);

      // (0.0f, 0.0f, -5.0f) | AngleX=-56.0f | AngleY=-159.0f | AngleZ=0.0f
      // Put the scene for being visible
      scene.setPosition(0, 0, -5);
      // Rotate a little for see its 3D
      scene.setAngleX(-56f);
      scene.setAngleY(-159f);
      scene.setAngleZ(0f);

      // Show last modifications
      scene.flush();

      sceneRenderer.playAnimation(new MorphSample());
   }

   private float startAbsoluteFrame;

   @Override
   public boolean animate(final GL gl, final float absoluteFrame)
   {
      final float t = (float) UtilMath.moduloInterval((absoluteFrame - this.startAbsoluteFrame) / 100.0, -1, 1);

      MorphSample.morph.movePoint(0, 0, 0, t * 0.02f, 0.9f, 2);

      return true;
   }

   @Override
   public void setStartAbsoluteFrame(final float startAbsoluteFrame)
   {
      this.startAbsoluteFrame = startAbsoluteFrame;
   }
}