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
package jhelp.engine.gui.layout;

import jhelp.engine.gui.components.Component;

/**
 * Layout informations<br>
 * <br>
 * Last modification : 29 juil. 2009<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
public class LayoutElement
{
   /** Component */
   private Component   component;
   /** Constraints apply */
   private Constraints constraints;

   /**
    * Constructs LayoutElement
    * 
    * @param component
    *           Component
    * @param constraints
    *           Constraints to apply
    */
   public LayoutElement(final Component component, final Constraints constraints)
   {
      if(component == null)
      {
         throw new NullPointerException("component musn't be null");
      }

      if(constraints == null)
      {
         throw new NullPointerException("constraints musn't be null");
      }

      this.component = component;
      this.constraints = constraints;
   }

   /**
    * Destroy the component
    */
   public void destroy()
   {
      this.component = null;
      this.constraints = null;
   }

   /**
    * Return component
    * 
    * @return component
    */
   public Component getComponent()
   {
      return this.component;
   }

   /**
    * Return constraints
    * 
    * @return constraints
    */
   public Constraints getConstraints()
   {
      return this.constraints;
   }

   /**
    * Modify component
    * 
    * @param component
    *           New component value
    */
   public void setComponent(final Component component)
   {
      if(component == null)
      {
         throw new NullPointerException("component musn't be null");
      }

      this.component = component;
   }

   /**
    * Modify constraints
    * 
    * @param constraints
    *           New constraints value
    */
   public void setConstraints(final Constraints constraints)
   {
      if(constraints == null)
      {
         throw new NullPointerException("constraints musn't be null");
      }

      this.constraints = constraints;
   }
}