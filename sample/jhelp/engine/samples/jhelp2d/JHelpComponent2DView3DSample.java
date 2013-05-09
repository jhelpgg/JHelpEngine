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