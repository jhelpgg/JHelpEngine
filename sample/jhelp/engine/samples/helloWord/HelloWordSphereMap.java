/**
 * <h1>License :</h1> <br>
 * The following code is deliver as is. I take care that code compile and work, but I am not responsible about any
 * damage it may
 * cause.<br>
 * You can use, modify, the code as your need for any usage. But you can't do any action that avoid me or other person use,
 * modify this code. The code is free for usage and modification, you can't change that fact.<br>
 * <br>
 *
 * @author JHelp
 */
package jhelp.engine.samples.helloWord;

import jhelp.engine.JHelpSceneRenderer;
import jhelp.engine.Material;
import jhelp.engine.Node;
import jhelp.engine.Object3D;
import jhelp.engine.Scene;
import jhelp.engine.Texture;
import jhelp.engine.geom.Sphere;
import jhelp.engine.gui.JHelpFrame3D;
import jhelp.util.Utilities;
import jhelp.util.debug.Debug;
import jhelp.util.gui.UtilGUI;
import jhelp.util.math.UtilMath;

/**
 * Hello word exemple, a simple cube in middle of the scene
 *
 * @author JHelp
 */
public class HelloWordSphereMap
        extends Thread
{
    private final Object3D object;
    private final Texture  texture;
    HelloWordSphereMap(final Object3D object, final Texture texture)
    {
        this.object = object;
        this.texture = texture;
    }

    /**
     * Launch the hello word
     *
     * @param args Unused
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

        final Sphere   sphere    = new Sphere();
        final Material sphereMap = new Material("SphereMap");
        sphere.setMaterial(sphereMap);

        try
        {
            final Texture texture = new Texture("TextureSphere", Texture.REFERENCE_RESOURCES,
                                                HelloWord.class.getResourceAsStream("gl_map.jpg"));
            sphereMap.setTextureDiffuse(texture);
            sphereMap.setSphericRate(1);
            sphere.computeUVfromPlaneXY(1, 1);
            final HelloWordSphereMap helloWordSphereMap = new HelloWordSphereMap(sphere, texture);
            helloWordSphereMap.start();
        }
        catch (final Exception exception)
        {
            Debug.printException(exception, "Faled to load texture !");
        }

        // Add the cube in the scene
        scene.add(sphere);

        // Put the scene for being visible
        scene.setPosition(0, 0, -5);

        // Show last modifications
        scene.flush();
    }

    @Override
    public void run()
    {
        int oldX = 0;
        int oldY = 0;
        int time = Integer.MAX_VALUE - 1;

        while (time > Integer.MIN_VALUE)
        {
            float angleX = 0;
            float angleY = 0;
            Node  node   = this.object;

            while (node != null)
            {
                angleX += node.getAngleX() * 0;
                angleY += node.getAngleY();
                node = node.getParent();
            }

            final int x = (int) angleX;
            final int y = (int) angleY;
            this.texture.shift((UtilMath.modulo(x - oldX, 360) * 512) / 360, (UtilMath.modulo(y - oldY, 360) * 512) / 360);
            oldX = x;
            oldY = y;
            Utilities.sleep(16);

            time--;
        }
    }
}