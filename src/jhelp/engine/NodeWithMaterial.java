/**
 * Project : JHelpEngine<br>
 * Package : jhelp.engine<br>
 * Class : HaveMaterial<br>
 * Date : 11 juin 2009<br>
 * By JHelp
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
      extends Node
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
      /** Force the object be 2 sided */
      FORCE_TWO_SIDE,
      /** Force the object be one sided */
      FORCE_ONE_SIDE
   }

   /** 2 sided "philosophy" */
   private TwoSidedState twoSidedState = TwoSidedState.AS_MATERIAL;

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
    * Bonding box
    * 
    * @return Bonding box
    */
   public abstract VirtualBox getBox();

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
    * Modify twoSidedState
    * 
    * @param twoSidedState
    *           New twoSidedState value
    */
   public final void setTwoSidedState(TwoSidedState twoSidedState)
   {
      if(twoSidedState == null)
      {
         throw new NullPointerException("twoSidedState musn't be null");
      }

      this.twoSidedState = twoSidedState;
   }
}