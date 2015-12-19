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
package jhelp.engine;

/**
 * Node with material <br>
 * <br>
 * Last modification : 11 juin 2009<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
public abstract class NodeWithMaterial
      extends NodeWithBox
{
   /**
    * Tow side "philosophy" <br>
    * <br>
    * Last modification : 2 déc. 2010<br>
    * Version 0.0.0<br>
    * 
    * @author JHelp
    */
   public enum TwoSidedState
   {
      /** Use the material setting for the tow side mode */
      AS_MATERIAL,
      /** Force the object be one sided */
      FORCE_ONE_SIDE,
      /** Force the object be 2 sided */
      FORCE_TWO_SIDE
   }

   /** 2 sided "philosophy" */
   private TwoSidedState twoSidedState = TwoSidedState.AS_MATERIAL;

   /**
    * Object material
    * 
    * @return Object material
    */
   public abstract Material getMaterial();

   /**
    * Selection material
    * 
    * @return Selection material
    */
   public abstract Material getMaterialForSelection();

   /**
    * Return twoSidedState
    * 
    * @return twoSidedState
    */
   public final TwoSidedState getTwoSidedState()
   {
      return this.twoSidedState;
   }

   /**
    * Change material
    * 
    * @param material
    *           New material
    */
   public abstract void setMaterial(Material material);

   /**
    * Define material for selection
    * 
    * @param materialForSelection
    *           New selection material
    */
   public abstract void setMaterialForSelection(Material materialForSelection);

   /**
    * Modify twoSidedState
    * 
    * @param twoSidedState
    *           New twoSidedState value
    */
   public final void setTwoSidedState(final TwoSidedState twoSidedState)
   {
      if(twoSidedState == null)
      {
         throw new NullPointerException("twoSidedState musn't be null");
      }

      this.twoSidedState = twoSidedState;
   }
}