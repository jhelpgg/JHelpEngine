/**
 * Project : JHelpEngine<br>
 * Package : jhelp.engine.gui.layout<br>
 * Class : RelativeLayout<br>
 * Date : 6 juil. 2010<br>
 * By JHelp
 */
package jhelp.engine.gui.layout;

import java.awt.Dimension;

import jhelp.util.debug.Debug;

/**
 * Relative layout<br>
 * <br>
 * Last modification : 6 juil. 2010<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
public class RelativeLayout
      extends Layout
{

   /**
    * Constructs RelativeLayout
    */
   public RelativeLayout()
   {
   }

   /**
    * Compute Preferred size
    * 
    * @param width
    *           Space width
    * @param height
    *           Space height
    * @param elements
    *           Elements to layout
    * @return Preferred size
    * @see jhelp.engine.gui.layout.Layout#computePrefferedSize(int, int, jhelp.engine.gui.layout.LayoutElement[])
    */
   @Override
   public Dimension computePrefferedSize(final int width, final int height, final LayoutElement... elements)
   {
      Debug.printTodo();
      return null;
   }

   /**
    * Layout components
    * 
    * @param width
    *           Space width
    * @param height
    *           Space height
    * @param elements
    *           Elements to layout
    * @see jhelp.engine.gui.layout.Layout#layout(int, int, jhelp.engine.gui.layout.LayoutElement[])
    */
   @Override
   public void layout(final int width, final int height, final LayoutElement... elements)
   {
      Debug.printTodo();
   }
}