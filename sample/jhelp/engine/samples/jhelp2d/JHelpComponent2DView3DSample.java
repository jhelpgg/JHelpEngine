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
package jhelp.engine.samples.jhelp2d;

/**
 * Launch sample of 3D scene in 2D frame
 * 
 * @author JHelp
 */
public class JHelpComponent2DView3DSample
{
   /**
    * Launch sample of 3D scene in 2D frame
    * 
    * @param args
    *           Unused
    */
   public static void main(final String[] args)
   {
      // Create the frame
      final Frame2DSample frame2dSample = new Frame2DSample();

      // Show the frame
      // It is recommend to put the visibility outside of the constructor
      frame2dSample.setVisible(true);

      // Activate automatic refresh for animated component like fold panel and scroll
      // It is strongly recommend to activate the automatic refresh after the first show of the frame
      frame2dSample.setAutomaticRefresh(true);
   }
}