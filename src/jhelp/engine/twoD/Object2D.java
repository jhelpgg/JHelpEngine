/**
 */
package jhelp.engine.twoD;

import java.util.ArrayList;

import jhelp.engine.Texture;
import jhelp.engine.event.Object2DListener;
import jhelp.util.list.Queue;
import jhelp.util.thread.ThreadManager;
import jhelp.util.thread.ThreadedSimpleTask;

/**
 * 2D object.<br>
 * It it an image on the 3D.<br>
 * You are able to link listeners to react when event append.<br>
 * To optimize the drawing, it is a good idea to disable the detection for objects who don't need signal events.<br>
 * 2D object can be on foreground or background of the 3D. <br>
 * <br>
 * Last modification : 21 janv. 2009<br>
 * Version 0.0.1<br>
 * 
 * @author JHelp
 */
public class Object2D
{
   /**
    * Mouse information
    * 
    * @author JHelp
    */
   static class MouseInformation
   {
      /** Indicates if mouse left button is down */
      final boolean          left;
      /** Event nature */
      final int              nature;
      /** Object 2D where mouse event happen */
      final Object2D         object2d;
      /** Listener to alert */
      final Object2DListener object2DListener;
      /** Indicates if mouse right button is down */
      final boolean          right;
      /** Mouse position X on object 2D */
      final int              x;
      /** Mouse position Y on object 2D */
      final int              y;

      /**
       * Create a new instance of MouseInformation
       * 
       * @param object2d
       *           Object 2D where mouse event happen
       * @param object2DListener
       *           Listener to alert
       * @param nature
       *           Event nature
       * @param x
       *           Mouse position X on object 2D
       * @param y
       *           Mouse position Y on object 2D
       */
      MouseInformation(final Object2D object2d, final Object2DListener object2DListener, final int nature, final int x, final int y)
      {
         this(object2d, object2DListener, nature, x, y, false, false);
      }

      /**
       * Create a new instance of MouseInformation
       * 
       * @param object2d
       *           Object 2D where mouse event happen
       * @param object2DListener
       *           Listener to alert
       * @param nature
       *           Event nature
       * @param x
       *           Mouse position X on object 2D
       * @param y
       *           Mouse position Y on object 2D
       * @param left
       *           Indicates if mouse left button is down
       * @param right
       *           Indicates if mouse right button is down
       */
      MouseInformation(final Object2D object2d, final Object2DListener object2DListener, final int nature, final int x, final int y, final boolean left,
            final boolean right)
      {
         this.object2d = object2d;
         this.object2DListener = object2DListener;
         this.nature = nature;
         this.x = x;
         this.y = y;
         this.left = left;
         this.right = right;
      }
   }

   /**
    * Signal to listener a mouse event
    * 
    * @author JHelp
    */
   static class TaskFireMouse
         extends ThreadedSimpleTask<MouseInformation>
   {
      /**
       * Create a new instance of TaskFireMouse
       */
      TaskFireMouse()
      {

      }

      /**
       * Do the task <br>
       * <br>
       * <b>Parent documentation:</b><br>
       * {@inheritDoc}
       * 
       * @param parameter
       *           Mouse event description
       * @see jhelp.util.thread.ThreadedSimpleTask#doSimpleAction(java.lang.Object)
       */
      @Override
      protected void doSimpleAction(final MouseInformation parameter)
      {
         switch(parameter.nature)
         {
            case CLICK:
               parameter.object2DListener.mouseClick(parameter.object2d, parameter.x, parameter.y, parameter.left, parameter.right);
            break;
            case DRAG:
               parameter.object2DListener.mouseDrag(parameter.object2d, parameter.x, parameter.y, parameter.left, parameter.right);
            break;
            case ENTER:
               parameter.object2DListener.mouseEnter(parameter.object2d, parameter.x, parameter.y);
            break;
            case EXIT:
               parameter.object2DListener.mouseExit(parameter.object2d, parameter.x, parameter.y);
            break;
            case MOVE:
               parameter.object2DListener.mouseMove(parameter.object2d, parameter.x, parameter.y);
            break;
         }
      }
   }

   /** Task for signal mouse events */
   private static final TaskFireMouse        TASK_FIRE_MOUSE = new TaskFireMouse();
   /** Nature : mouse clicked */
   static final int                          CLICK           = 0;
   /** Nature : mouse dragged */
   static final int                          DRAG            = 1;
   /** Nature : mouse entered */
   static final int                          ENTER           = 2;
   /** Nature : mouse exited */
   static final int                          EXIT            = 3;
   /** Nature : mouse moved */
   static final int                          MOVE            = 4;
   /** Developer additional information */
   private Object                            additionalInformation;
   /** Listeners register for this object */
   private final ArrayList<Object2DListener> arrayListListeners;
   /** Indicates if the object signal events */
   private boolean                           canBeDetected;
   /** Indicates if we are in firing events to listeners */
   private boolean                           firing;
   /** Object's height */
   private int                               height;
   /** Indicates if the mouse is over the object */
   private boolean                           over;
   /** List of listeners to add */
   private final Queue<Object2DListener>     toAdd;
   /** List of listeners to remove */
   private final Queue<Object2DListener>     toRemove;
   /** Indicates if the object is visible */
   private boolean                           visible;
   /** Object's width */
   private int                               width;
   /** Object's abscissa */
   private int                               x;
   /** Object's ordinate */
   private int                               y;
   /** Object's texture */
   protected Texture                         texture;

   /**
    * Create an object
    * 
    * @param x
    *           Abscissa
    * @param y
    *           Ordinate
    * @param width
    *           Width
    * @param height
    *           Height
    */
   public Object2D(final int x, final int y, final int width, final int height)
   {
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
      this.canBeDetected = true;
      this.visible = true;
      this.arrayListListeners = new ArrayList<Object2DListener>();
      this.firing = false;
      this.toRemove = new Queue<Object2DListener>();
      this.toAdd = new Queue<Object2DListener>();
      this.over = false;
   }

   /**
    * Reaction on mouse state
    * 
    * @param x
    *           Mouse X
    * @param y
    *           Mouse Y
    * @param buttonLeft
    *           Indicates if the left button is down
    * @param buttonRight
    *           Indicates if the right button is down
    * @param drag
    *           Indicates if drag mode is on
    * @param over
    *           Indicates if the mouse is over the object
    */
   void mouseState(int x, int y, final boolean buttonLeft, final boolean buttonRight, final boolean drag, final boolean over)
   {
      this.firing = true;

      try
      {
         // Compute relative object position
         x -= this.x;
         y -= this.y;
         // If the over state change, the the mouse enter or exit
         if(this.over != over)
         {
            this.over = over;
            if(this.over == true)
            {
               this.fireMouseEnter(x, y);
            }
            else
            {
               this.fireMouseExit(x, y);
            }
            return;
         }
         // If the mouse is not on the object, do nothing
         if(over == false)
         {
            return;
         }
         // Drag mode test
         if(drag)
         {
            this.fireMouseDrag(x, y, buttonLeft, buttonRight);
            return;
         }
         // Click mode test
         if(buttonLeft || buttonRight)
         {
            this.fireMouseClick(x, y, buttonLeft, buttonRight);
            return;
         }
         // Move mode
         this.fireMouseMove(x, y);
      }
      finally
      {
         while(this.toRemove.isEmpty() == false)
         {
            this.arrayListListeners.remove(this.toRemove.outQueue());
         }

         while(this.toAdd.isEmpty() == false)
         {
            this.arrayListListeners.add(this.toAdd.outQueue());
         }

         this.firing = false;
      }
   }

   /**
    * Signals to listeners that mouse click on the object
    * 
    * @param x
    *           Mouse X
    * @param y
    *           Mouse Y
    * @param leftButton
    *           Indicates if the left button is down
    * @param rightButton
    *           Indicates if the right button is down
    */
   protected void fireMouseClick(final int x, final int y, final boolean leftButton, final boolean rightButton)
   {
      for(final Object2DListener object2DListener : this.arrayListListeners)
      {
         ThreadManager.THREAD_MANAGER.doThread(Object2D.TASK_FIRE_MOUSE, new MouseInformation(this, object2DListener, Object2D.CLICK, x, y, leftButton,
               rightButton));
      }
   }

   /**
    * Signals to listeners that mouse drag on the object
    * 
    * @param x
    *           Mouse X
    * @param y
    *           Mouse Y
    * @param leftButton
    *           Indicates if the left button is down
    * @param rightButton
    *           Indicates if the right button is down
    */
   protected void fireMouseDrag(final int x, final int y, final boolean leftButton, final boolean rightButton)
   {
      for(final Object2DListener object2DListener : this.arrayListListeners)
      {
         ThreadManager.THREAD_MANAGER.doThread(Object2D.TASK_FIRE_MOUSE, new MouseInformation(this, object2DListener, Object2D.DRAG, x, y, leftButton,
               rightButton));
      }
   }

   /**
    * Signals to listeners that mouse enter on the object
    * 
    * @param x
    *           Mouse X
    * @param y
    *           Mouse Y
    */
   protected void fireMouseEnter(final int x, final int y)
   {
      for(final Object2DListener object2DListener : this.arrayListListeners)
      {
         ThreadManager.THREAD_MANAGER.doThread(Object2D.TASK_FIRE_MOUSE, new MouseInformation(this, object2DListener, Object2D.ENTER, x, y));
      }
   }

   /**
    * Signals to listeners that mouse exit from the object
    * 
    * @param x
    *           Mouse X
    * @param y
    *           Mouse Y
    */
   protected void fireMouseExit(final int x, final int y)
   {
      for(final Object2DListener object2DListener : this.arrayListListeners)
      {
         ThreadManager.THREAD_MANAGER.doThread(Object2D.TASK_FIRE_MOUSE, new MouseInformation(this, object2DListener, Object2D.EXIT, x, y));
      }
   }

   /**
    * Signals to listeners that mouse move on the object
    * 
    * @param x
    *           Mouse X
    * @param y
    *           Mouse Y
    */
   protected void fireMouseMove(final int x, final int y)
   {
      for(final Object2DListener object2DListener : this.arrayListListeners)
      {
         ThreadManager.THREAD_MANAGER.doThread(Object2D.TASK_FIRE_MOUSE, new MouseInformation(this, object2DListener, Object2D.MOVE, x, y));
      }
   }

   /**
    * Add object event listener
    * 
    * @param object2DListener
    *           Listener to add
    */
   public void addObject2DListener(final Object2DListener object2DListener)
   {
      if(this.firing == true)
      {
         this.toAdd.inQueue(object2DListener);
         return;
      }

      this.arrayListListeners.add(object2DListener);
   }

   /**
    * Actual additionalInformation value
    * 
    * @return Actual additionalInformation value
    */
   public Object getAdditionalInformation()
   {
      return this.additionalInformation;
   }

   /**
    * Object's height
    * 
    * @return Object's height
    */
   public int getHeight()
   {
      return this.height;
   }

   /**
    * Object's texture.<br>
    * If the object is not visible, the method return {@code null}
    * 
    * @return Object's texture
    */
   public Texture getTexture()
   {
      if(this.visible == false)
      {
         return null;
      }

      return this.texture;
   }

   /**
    * Object's width
    * 
    * @return Object's width
    */
   public int getWidth()
   {
      return this.width;
   }

   /**
    * Object's X
    * 
    * @return Object's X
    */
   public int getX()
   {
      return this.x;
   }

   /**
    * Object's Y
    * 
    * @return Object's Y
    */
   public int getY()
   {
      return this.y;
   }

   /**
    * Indicates if the detection of this object is enable
    * 
    * @return {@code true} if the detection of this object is enable
    */
   public boolean isCanBeDetected()
   {
      return this.canBeDetected;
   }

   /**
    * Indicates if the object contains a point
    * 
    * @param x
    *           Point's X
    * @param y
    *           Point's Y
    * @return {@code true} if the point is over the object
    */
   public boolean isDetected(final int x, final int y)
   {
      if((this.canBeDetected == false) || (this.visible == false))
      {
         return false;
      }

      return (x >= this.x) && (y >= this.y) && (x < (this.x + this.width)) && (y < (this.y + this.height));
   }

   /**
    * Indicates if the object is visible
    * 
    * @return {@code true} if the object is visible
    */
   public boolean isVisible()
   {
      return this.visible;
   }

   /**
    * Remove object event listener
    * 
    * @param object2DListener
    *           Listener to remove
    */
   public void removeObject2DListener(final Object2DListener object2DListener)
   {
      if(this.firing == true)
      {
         this.toRemove.inQueue(object2DListener);
         return;
      }

      this.arrayListListeners.remove(object2DListener);
   }

   /**
    * Change additionalInformation
    * 
    * @param additionalInformation
    *           New additionalInformation value
    */
   public void setAdditionalInformation(final Object additionalInformation)
   {
      this.additionalInformation = additionalInformation;
   }

   /**
    * Change the detection sates
    * 
    * @param canBeDetected
    *           New detection state
    */
   public void setCanBeDetected(final boolean canBeDetected)
   {
      this.canBeDetected = canBeDetected;
   }

   /**
    * Change object's height
    * 
    * @param height
    *           New height
    */
   public void setHeight(final int height)
   {
      this.height = height;
   }

   /**
    * Change object's texture
    * 
    * @param texture
    *           New object's texture
    */
   public void setTexture(final Texture texture)
   {
      this.texture = texture;
   }

   /**
    * Change object's visibility
    * 
    * @param visible
    *           New visibility
    */
   public void setVisible(final boolean visible)
   {
      this.visible = visible;
   }

   /**
    * Change object's width
    * 
    * @param width
    *           New width
    */
   public void setWidth(final int width)
   {
      this.width = width;
   }

   /**
    * Change object's X
    * 
    * @param x
    *           New X
    */
   public void setX(final int x)
   {
      this.x = x;
   }

   /**
    * Change object's Y
    * 
    * @param y
    *           New Y
    */
   public void setY(final int y)
   {
      this.y = y;
   }
}