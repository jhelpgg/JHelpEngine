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

import javax.swing.JPopupMenu;

import jhelp.util.gui.UtilGUI;

/**
 * Launch sample of component 3D integrate in swing interface
 * 
 * @author JHelp
 */
public class SwingExample
{

   /**
    * Launch sample of component 3D integrate in swing interface
    * 
    * @param args
    *           Unused
    */
   public static void main(final String[] args)
   {
      UtilGUI.initializeGUI();
      // To avoid some flicking effect of menu over OpenGL
      JPopupMenu.setDefaultLightWeightPopupEnabled(false);

      final SwingSampleFrame frame = new SwingSampleFrame();
      frame.setVisible(true);
   }
}