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
package jhelp.engine.samples.swing;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import jhelp.engine.JHelpSceneRenderer;
import jhelp.engine.Scene;
import jhelp.engine.geom.Sphere;
import jhelp.engine.gui.ComponentView3D;
import jhelp.gui.JHelpFrame;

/**
 * Swing frame with 3D component and an other swing component
 * 
 * @author JHelp
 */
public class SwingSampleFrame
      extends JHelpFrame
      implements MouseMotionListener, MouseListener
{
   /** 3D component view */
   private ComponentView3D componentView3D;
   /** Label for haveswing component */
   private JLabel          label;
   /** Last mouse X */
   private int             mouseX;
   /** Last mouse Y */
   private int             mouseY;

   /**
    * Create a new instance of SwingSampleFrame
    */
   public SwingSampleFrame()
   {
      super("Swing sample");

      this.setResizable(false);
   }

   /**
    * Add components listeners <br>
    * <br>
    * <b>Parent documentation:</b><br>
    * {@inheritDoc}
    * 
    * @see jhelp.gui.JHelpFrame#addListeners()
    */
   @Override
   protected void addListeners()
   {
      this.componentView3D.addMouseListener(this);
      this.componentView3D.addMouseMotionListener(this);
   }

   /**
    * Create frame components <br>
    * <br>
    * <b>Parent documentation:</b><br>
    * {@inheritDoc}
    * 
    * @see jhelp.gui.JHelpFrame#createComponents()
    */
   @Override
   protected void createComponents()
   {
      this.componentView3D = new ComponentView3D(512, 512);
      this.label = new JLabel("Label in swing");

      final JHelpSceneRenderer sceneRenderer = this.componentView3D.getSceneRenderer();
      final Scene scene = sceneRenderer.getScene();

      scene.add(new Sphere(4, 90));
      scene.setPosition(0, 0, -5);
      scene.flush();
   }

   /**
    * Layout components <br>
    * <br>
    * <b>Parent documentation:</b><br>
    * {@inheritDoc}
    * 
    * @see jhelp.gui.JHelpFrame#layoutComponents()
    */
   @Override
   protected void layoutComponents()
   {
      this.setLayout(new BorderLayout());
      this.add(this.componentView3D, BorderLayout.CENTER);
      this.add(this.label, BorderLayout.SOUTH);
   }

   /**
    * Called when mouse clicked <br>
    * <br>
    * <b>Parent documentation:</b><br>
    * {@inheritDoc}
    * 
    * @param e
    *           Mouse event description
    * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
    */
   @Override
   public void mouseClicked(final MouseEvent e)
   {
      this.mouseX = e.getX();
      this.mouseY = e.getY();
   }

   /**
    * Called when mouse dragged <br>
    * <br>
    * <b>Parent documentation:</b><br>
    * {@inheritDoc}
    * 
    * @param e
    *           Mouse event description
    * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
    */
   @Override
   public void mouseDragged(final MouseEvent e)
   {
      final int dx = e.getX() - this.mouseX;
      final int dy = e.getY() - this.mouseY;
      final boolean left = SwingUtilities.isLeftMouseButton(e);
      final boolean right = SwingUtilities.isRightMouseButton(e);

      float factor = 0.01f;
      if(e.isShiftDown() == true)
      {
         factor = 0.1f;

         if(e.isControlDown() == true)
         {
            factor = 1f;
         }
      }
      else if(e.isAltDown() == true)
      {
         factor = 0.001f;

         if(e.isControlDown() == true)
         {
            factor = 0.0001f;
         }
      }

      final Scene scene = this.componentView3D.getSceneRenderer().getScene();
      if((left == true) && (right == true))
      {
         scene.translate(dx * factor, -dy * factor, 0);
      }
      else if(left == true)
      {
         scene.rotateAngleX(dy);
         scene.rotateAngleY(dx);
      }
      else if(right == true)
      {
         scene.translate(0, 0, -dy * factor);
      }

      this.mouseX = e.getX();
      this.mouseY = e.getY();
   }

   /**
    * Called when mouse entered <br>
    * <br>
    * <b>Parent documentation:</b><br>
    * {@inheritDoc}
    * 
    * @param e
    *           Mouse event description
    * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
    */
   @Override
   public void mouseEntered(final MouseEvent e)
   {
      this.mouseX = e.getX();
      this.mouseY = e.getY();
   }

   /**
    * Called when mouse exited <br>
    * <br>
    * <b>Parent documentation:</b><br>
    * {@inheritDoc}
    * 
    * @param e
    *           Mouse event description
    * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
    */
   @Override
   public void mouseExited(final MouseEvent e)
   {
      this.mouseX = e.getX();
      this.mouseY = e.getY();
   }

   /**
    * Called when mouse moved <br>
    * <br>
    * <b>Parent documentation:</b><br>
    * {@inheritDoc}
    * 
    * @param e
    *           Mouse event description
    * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
    */
   @Override
   public void mouseMoved(final MouseEvent e)
   {
      this.mouseX = e.getX();
      this.mouseY = e.getY();
   }

   /**
    * Called when mouse pressed <br>
    * <br>
    * <b>Parent documentation:</b><br>
    * {@inheritDoc}
    * 
    * @param e
    *           Mouse event description
    * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
    */
   @Override
   public void mousePressed(final MouseEvent e)
   {
      this.mouseX = e.getX();
      this.mouseY = e.getY();
   }

   /**
    * Called when mouse released <br>
    * <br>
    * <b>Parent documentation:</b><br>
    * {@inheritDoc}
    * 
    * @param e
    *           Mouse event description
    * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
    */
   @Override
   public void mouseReleased(final MouseEvent e)
   {
      this.mouseX = e.getX();
      this.mouseY = e.getY();
   }
}