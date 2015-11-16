package jhelp.engine.twoD;

import java.util.ArrayList;
import java.util.List;

import jhelp.engine.Texture;
import jhelp.engine.event.Button2DListener;
import jhelp.engine.event.Object2DListener;
import jhelp.util.gui.JHelpImage;
import jhelp.util.list.Pair;
import jhelp.util.thread.ThreadManager;
import jhelp.util.thread.ThreadedSimpleTask;

/**
 * Button 2D
 * 
 * @author JHelp
 */
public class Button2D
      extends Object2D
      implements Object2DListener
{
   /**
    * Task for fire button click event
    * 
    * @author JHelp
    */
   static class TaskFireButtonClick
         extends ThreadedSimpleTask<Pair<Button2D, Button2DListener>>
   {
      /**
       * Create a new instance of TaskFireButtonClick
       */
      TaskFireButtonClick()
      {
      }

      /**
       * Do the task : Fire click event <br>
       * <br>
       * <b>Parent documentation:</b><br>
       * {@inheritDoc}
       * 
       * @param parameter
       *           Couple of click button and listener to alert
       * @see jhelp.util.thread.ThreadedSimpleTask#doSimpleAction(java.lang.Object)
       */
      @Override
      protected void doSimpleAction(final Pair<Button2D, Button2DListener> parameter)
      {
         parameter.element2.button2DClicked(parameter.element1, parameter.element1.getButtonID());
      }
   }

   /** Task for fire button click event */
   private static final TaskFireButtonClick TASK_FIRE_BUTTON_CLICK = new TaskFireButtonClick();

   /** Button ID */
   private final int                        buttonID;
   /** Image for clicked state */
   private final JHelpImage                 clicked;
   /** Listeners of click event */
   private final List<Button2DListener>     listeners;
   /** Image for normal state */
   private final JHelpImage                 normal;
   /** Image for over state */
   private final JHelpImage                 over;
   /** Button texture */
   private final Texture                    texture;

   /**
    * Create a new instance of Button2D
    * 
    * @param buttonID
    *           Button ID
    * @param x
    *           X position
    * @param y
    *           Y position
    * @param width
    *           Button width
    * @param height
    *           Button height
    * @param normal
    *           Image for normal state
    */
   public Button2D(final int buttonID, final int x, final int y, final int width, final int height, final JHelpImage normal)
   {
      this(buttonID, x, y, width, height, normal, normal, normal);
   }

   /**
    * Create a new instance of Button2D
    * 
    * @param buttonID
    *           Button ID
    * @param x
    *           X position
    * @param y
    *           Y position
    * @param width
    *           Button width
    * @param height
    *           Button height
    * @param normal
    *           Image for normal state
    * @param over
    *           Image for over state
    */
   public Button2D(final int buttonID, final int x, final int y, final int width, final int height, final JHelpImage normal, final JHelpImage over)
   {
      this(buttonID, x, y, width, height, normal, over, over);
   }

   /**
    * Create a new instance of Button2D
    * 
    * @param buttonID
    *           Button ID
    * @param x
    *           X position
    * @param y
    *           Y position
    * @param width
    *           Button width
    * @param height
    *           Button height
    * @param normal
    *           Image for normal state
    * @param over
    *           Image for over state
    * @param clicked
    *           Image for clicked state
    */
   public Button2D(final int buttonID, final int x, final int y, final int width, final int height, final JHelpImage normal, final JHelpImage over,
         final JHelpImage clicked)
   {
      super(x, y, width, height);

      if(normal == null)
      {
         throw new NullPointerException("normal musn't be null");
      }

      if(over == null)
      {
         throw new NullPointerException("over musn't be null");
      }

      if(clicked == null)
      {
         throw new NullPointerException("clicked musn't be null");
      }

      this.listeners = new ArrayList<Button2DListener>();
      this.buttonID = buttonID;
      this.normal = normal;
      this.over = over;
      this.clicked = clicked;
      this.texture = new Texture("Button2D_" + Math.random(), this.normal);
      this.setTexture(this.texture);

      this.addObject2DListener(this);
   }

   /**
    * Signal to listeners a click on button
    */
   protected void fireClick()
   {
      synchronized(this.listeners)
      {
         for(final Button2DListener listener : this.listeners)
         {
            ThreadManager.THREAD_MANAGER.doThread(Button2D.TASK_FIRE_BUTTON_CLICK, new Pair<Button2D, Button2DListener>(this, listener));
         }
      }
   }

   /**
    * Button ID
    * 
    * @return Button ID
    */
   public int getButtonID()
   {
      return this.buttonID;
   }

   /**
    * Called when mouse click on button <br>
    * <br>
    * <b>Parent documentation:</b><br>
    * {@inheritDoc}
    * 
    * @param object2d
    *           Object reference
    * @param x
    *           Mouse X
    * @param y
    *           Mouse Y
    * @param leftButton
    *           Indicates if left button is down
    * @param rightButton
    *           Indicates if right button is down
    * @see jhelp.engine.event.Object2DListener#mouseClick(jhelp.engine.twoD.Object2D, int, int, boolean, boolean)
    */
   @Override
   public void mouseClick(final Object2D object2d, final int x, final int y, final boolean leftButton, final boolean rightButton)
   {
      this.texture.setImage(this.clicked);
      this.fireClick();
   }

   /**
    * Called when mouse drag on button <br>
    * <br>
    * <b>Parent documentation:</b><br>
    * {@inheritDoc}
    * 
    * @param object2d
    *           Object reference
    * @param x
    *           Mouse X
    * @param y
    *           Mouse Y
    * @param leftButton
    *           Indicates if left button is down
    * @param rightButton
    *           Indicates if right button is down
    * @see jhelp.engine.event.Object2DListener#mouseDrag(jhelp.engine.twoD.Object2D, int, int, boolean, boolean)
    */
   @Override
   public void mouseDrag(final Object2D object2d, final int x, final int y, final boolean leftButton, final boolean rightButton)
   {
      this.texture.setImage(this.clicked);
   }

   /**
    * Called when mouse enter on button <br>
    * <br>
    * <b>Parent documentation:</b><br>
    * {@inheritDoc}
    * 
    * @param object2d
    *           Object reference
    * @param x
    *           Mouse X
    * @param y
    *           Mouse Y
    * @see jhelp.engine.event.Object2DListener#mouseEnter(jhelp.engine.twoD.Object2D, int, int)
    */
   @Override
   public void mouseEnter(final Object2D object2d, final int x, final int y)
   {
      this.texture.setImage(this.over);
   }

   /**
    * Called when mouse exit from button <br>
    * <br>
    * <b>Parent documentation:</b><br>
    * {@inheritDoc}
    * 
    * @param object2d
    *           Object reference
    * @param x
    *           Mouse X
    * @param y
    *           Mouse Y
    * @see jhelp.engine.event.Object2DListener#mouseExit(jhelp.engine.twoD.Object2D, int, int)
    */
   @Override
   public void mouseExit(final Object2D object2d, final int x, final int y)
   {
      this.texture.setImage(this.normal);
   }

   /**
    * Called when mouse move over button <br>
    * <br>
    * <b>Parent documentation:</b><br>
    * {@inheritDoc}
    * 
    * @param object2d
    *           Object reference
    * @param x
    *           Mouse X
    * @param y
    *           Mouse Y
    * @see jhelp.engine.event.Object2DListener#mouseMove(jhelp.engine.twoD.Object2D, int, int)
    */
   @Override
   public void mouseMove(final Object2D object2d, final int x, final int y)
   {
      this.texture.setImage(this.over);
   }

   /**
    * Register button click listener
    * 
    * @param listener
    *           Listener to register
    */
   public void registerButton2DListener(final Button2DListener listener)
   {
      if(listener == null)
      {
         return;
      }

      synchronized(this.listeners)
      {
         if(this.listeners.contains(listener) == false)
         {
            this.listeners.add(listener);
         }
      }
   }

   /**
    * Unregister button click listener
    * 
    * @param listener
    *           Listener to unregister
    */
   public void unregisterButton2DListener(final Button2DListener listener)
   {
      synchronized(this.listeners)
      {
         this.listeners.remove(listener);
      }
   }
}