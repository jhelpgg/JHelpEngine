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
package jhelp.engine.gui.components;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import jhelp.engine.JHelpSceneRenderer;
import jhelp.engine.Node;
import jhelp.engine.Scene;
import jhelp.engine.geom.Plane;
import jhelp.engine.gui.ComponentView3D;
import jhelp.engine.gui.events.InternalFrameListener;
import jhelp.util.text.UtilText;

/**
 * 3D view like a desktop, contains some {@link InternalFrame}<br>
 * <br>
 * Last modification : 26 juin 2010<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
public class Desktop3D
      extends ComponentView3D
{
   /**
    * Manage mouse and internal frame events <br>
    * <br>
    * Last modification : 2 déc. 2010<br>
    * Version 0.0.0<br>
    * 
    * @author JHelp
    */
   private class EventManager
         implements MouseListener, MouseMotionListener, MouseWheelListener, InternalFrameListener
   {
      /** Indicates if mouse button left is down */
      private boolean left;
      /** Indicates if mouse button right is down */
      private boolean right;
      /** Mouse X */
      private int     x;
      /** Mouse Y */
      private int     y;

      /**
       * Constructs EventManager
       */
      EventManager()
      {
         this.left = this.right = false;
      }

      /**
       * Call when internal frame select
       * 
       * @param internalFrame
       *           Internal frame select
       * @see jhelp.engine.gui.events.InternalFrameListener#internalFrameSelect(jhelp.engine.gui.components.InternalFrame)
       */
      @Override
      public void internalFrameSelect(final InternalFrame internalFrame)
      {
         Desktop3D.this.manipulatedNode = Desktop3D.this.scene.getFirstNode(internalFrame.objectName);
      }

      /**
       * Call when mouse click
       * 
       * @param e
       *           Event description
       * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
       */
      @Override
      public void mouseClicked(final MouseEvent e)
      {
         this.x = e.getX();
         this.y = e.getY();

         Desktop3D.this.sceneRenderer.setDetectPosition(e.getX(), e.getY(), this.left, this.right, false);
      }

      /**
       * Call when mouse drag
       * 
       * @param e
       *           Event description
       * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
       */
      @Override
      public void mouseDragged(final MouseEvent e)
      {
         if(Desktop3D.this.manipulatedNode != null)
         {
            final boolean left = SwingUtilities.isLeftMouseButton(e);
            final boolean right = SwingUtilities.isRightMouseButton(e);

            if((left == true) && (right == true))
            {
               Desktop3D.this.manipulatedNode.translate((e.getX() - this.x) * Desktop3D.FACTOR, (this.y - e.getY()) * Desktop3D.FACTOR, 0);
            }
            else if(left == true)
            {
               Desktop3D.this.manipulatedNode.rotateAngleY(e.getX() - this.x);
               Desktop3D.this.manipulatedNode.rotateAngleX(e.getY() - this.y);
            }
            else if(right == true)
            {
               Desktop3D.this.manipulatedNode.translate(0, 0, (e.getY() - this.y) * Desktop3D.FACTOR);
            }
         }

         this.x = e.getX();
         this.y = e.getY();

         Desktop3D.this.sceneRenderer.setDetectPosition(e.getX(), e.getY(), this.left, this.right, true);
      }

      /**
       * Call when mouse enter
       * 
       * @param e
       *           Event description
       * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
       */
      @Override
      public void mouseEntered(final MouseEvent e)
      {
         this.x = e.getX();
         this.y = e.getY();

         Desktop3D.this.sceneRenderer.setDetectPosition(e.getX(), e.getY(), false, false, false);
      }

      /**
       * Call when mouse exit
       * 
       * @param e
       *           Event description
       * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
       */
      @Override
      public void mouseExited(final MouseEvent e)
      {
         this.x = e.getX();
         this.y = e.getY();

         Desktop3D.this.sceneRenderer.setDetectPosition(e.getX(), e.getY(), false, false, false);
      }

      /**
       * Call when mouse move
       * 
       * @param e
       *           Event description
       * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
       */
      @Override
      public void mouseMoved(final MouseEvent e)
      {
         this.x = e.getX();
         this.y = e.getY();

         Desktop3D.this.sceneRenderer.setDetectPosition(e.getX(), e.getY(), false, false, false);
      }

      /**
       * Call when mouse press
       * 
       * @param e
       *           Event description
       * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
       */
      @Override
      public void mousePressed(final MouseEvent e)
      {
         this.x = e.getX();
         this.y = e.getY();

         this.left |= SwingUtilities.isLeftMouseButton(e);
         this.right |= SwingUtilities.isRightMouseButton(e);

         Desktop3D.this.sceneRenderer.setDetectPosition(e.getX(), e.getY(), this.left, this.right, false);
      }

      /**
       * Call when mouse release
       * 
       * @param e
       *           Event description
       * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
       */
      @Override
      public void mouseReleased(final MouseEvent e)
      {
         this.x = e.getX();
         this.y = e.getY();

         this.left &= !SwingUtilities.isLeftMouseButton(e);
         this.right &= !SwingUtilities.isRightMouseButton(e);

         Desktop3D.this.sceneRenderer.setDetectPosition(e.getX(), e.getY(), this.left, this.right, false);
      }

      /**
       * Call when mouse wheel move
       * 
       * @param e
       *           Event description
       * @see java.awt.event.MouseWheelListener#mouseWheelMoved(java.awt.event.MouseWheelEvent)
       */
      @Override
      public void mouseWheelMoved(final MouseWheelEvent e)
      {
         if(Desktop3D.this.manipulatedNode != null)
         {
            Desktop3D.this.manipulatedNode.translate(0, 0, (e.getWheelRotation()) * 0.1f);
         }

         this.x = e.getX();
         this.y = e.getY();
      }
   }

   /** Mouse factor */
   private static final float             FACTOR  = 0.01f;

   /** Next ID */
   private static int                     NEXT_ID = 0;

   /** Listener to events */
   private final EventManager             eventManager;
   /** Internal frame list */
   private final ArrayList<InternalFrame> internalFrameList;
   /** Last start placement */
   private float                          last;
   /** Current node manipulate */
   Node                                   manipulatedNode;
   /** Scene */
   Scene                                  scene;
   /** Scene renderer */
   JHelpSceneRenderer                     sceneRenderer;

   /**
    * Constructs Dessktop3D
    * 
    * @param width
    *           Width
    * @param height
    *           Heught
    */
   public Desktop3D(final int width, final int height)
   {
      super(width, height);

      this.internalFrameList = new ArrayList<InternalFrame>();

      this.sceneRenderer = this.getSceneRenderer();
      this.scene = this.sceneRenderer.getScene();

      this.scene.translate(0f, 0f, -2.3456789f);

      this.last = -0.1f;

      this.eventManager = new EventManager();

      this.sceneRenderer.addMouseListener(this.eventManager);
      this.sceneRenderer.addMouseMotionListener(this.eventManager);
      this.sceneRenderer.addMouseWheelListener(this.eventManager);
   }

   /**
    * Add internal frame
    * 
    * @param internalFrame
    *           Internal frame to add
    */
   public void addInternalFrame(final InternalFrame internalFrame)
   {
      this.internalFrameList.add(internalFrame);

      internalFrame.objectName = UtilText.concatenate("InternalFrame", Desktop3D.NEXT_ID++);
      final Plane plane = new Plane(false, true);
      plane.translate(this.last, this.last, 0);
      this.last += 0.1f;
      plane.nodeName = internalFrame.objectName;
      this.scene.add(plane);

      final WindowMaterial windowMaterial = new WindowMaterial(internalFrame.objectName, plane);
      windowMaterial.setMainComponent(internalFrame);
      this.sceneRenderer.registerWindowMaterial(windowMaterial);

      this.manipulatedNode = plane;

      internalFrame.addInternalFrameListener(this.eventManager);
   }
}