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