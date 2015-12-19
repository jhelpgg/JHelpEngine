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
package jhelp.engine.util;

import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLCapabilitiesChooser;

import jhelp.util.debug.Debug;
import jhelp.util.debug.DebugLevel;

/**
 * Constructs a canvas for 3D<br>
 * <br>
 * 
 * @author JHelp
 */
public class CanvasOpenGLMaker
      implements GLCapabilitiesChooser
{
   /** The singleton */
   public static CanvasOpenGLMaker CANVAS_OPENGL_MAKER = new CanvasOpenGLMaker();
   /** Last capabilities choose */
   private GLCapabilities          capabilities;

   /**
    * Constructs the singleton
    */
   private CanvasOpenGLMaker()
   {
      LibraryInstaller.install();
   }

   /**
    * Compute point for capabilities
    * 
    * @param tested
    *           Capabilities tested
    * @param desired
    *           Desired capabilities
    * @return Capabilities point
    */
   private int computePoint(final GLCapabilities tested, final GLCapabilities desired)
   {
      if(tested == null)
      {
         return -1;
      }
      int point = 0;
      if(tested.getDoubleBuffered() == desired.getDoubleBuffered())
      {
         point += 10;
      }
      if(tested.getHardwareAccelerated() == desired.getHardwareAccelerated())
      {
         point += 10;
      }
      if(tested.getSampleBuffers() == desired.getSampleBuffers())
      {
         point += 10;
      }
      if(tested.getSampleBuffers() == true)
      {
         point += 100 - (Math.abs(tested.getNumSamples() - desired.getNumSamples()) * 10);
      }
      point += 100 - (Math.abs(tested.getDepthBits() - desired.getDepthBits()) * 10);

      point += tested.getAlphaBits();
      point += tested.getRedBits();
      point += tested.getGreenBits();
      point += tested.getBlueBits();
      point += tested.getStencilBits();

      //
      Debug.println(DebugLevel.VERBOSE, "Test : ");
      Debug.println(DebugLevel.VERBOSE, tested);
      Debug.println(DebugLevel.VERBOSE, "With ", point, " points");
      return point;
   }

   /**
    * Choose the best capabilities
    * 
    * @param desired
    *           Capabilities desired
    * @param available
    *           Capabilities available
    * @param windowSystemRecommendedChoice
    *           Default choice
    * @return The best capabilities
    * @see javax.media.opengl.GLCapabilitiesChooser#chooseCapabilities(javax.media.opengl.GLCapabilities,
    *      javax.media.opengl.GLCapabilities[], int)
    */
   @Override
   public int chooseCapabilities(final GLCapabilities desired, final GLCapabilities[] available, final int windowSystemRecommendedChoice)
   {
      int chosen = -1;
      int actualPointChoice = 0;
      final int length = available.length;
      //
      if((windowSystemRecommendedChoice >= 0) && (windowSystemRecommendedChoice < length))
      {
         chosen = windowSystemRecommendedChoice;
         actualPointChoice = this.computePoint(available[chosen], desired) + 1;
         Debug.printMark(DebugLevel.VERBOSE, "windowSystemRecommendedChoice=" + windowSystemRecommendedChoice + " | " + actualPointChoice);
      }
      //
      for(int i = 0; i < length; i++)
      {
         final int point = this.computePoint(available[i], desired);
         if(point > actualPointChoice)
         {
            chosen = i;
            actualPointChoice = point;
         }
      }
      //
      Debug.printMark(DebugLevel.VERBOSE, "Chosen capability");
      Debug.println(DebugLevel.VERBOSE, available[chosen]);
      Debug.println(DebugLevel.VERBOSE, "With ", actualPointChoice, " points");
      //
      this.capabilities = available[chosen];
      //
      return chosen;
   }

   /**
    * Constructs a canvas for 3D
    * 
    * @return Canvas constructed
    */
   public GLCanvas newGLCanvas()
   {
      if(this.capabilities != null)
      {
         return new GLCanvas(this.capabilities);
      }

      //

      final GLCapabilities capabilities = new GLCapabilities();
      capabilities.setDoubleBuffered(true);
      capabilities.setHardwareAccelerated(true);
      capabilities.setSampleBuffers(true);
      capabilities.setNumSamples(4);
      capabilities.setDepthBits(32);
      return this.newGLCanvas(capabilities);
   }

   /**
    * Constructs a canvas for 3D
    * 
    * @param capabilities
    *           Capabilities to use
    * @return Canvas constructed
    */
   public GLCanvas newGLCanvas(final GLCapabilities capabilities)
   {
      return new GLCanvas(capabilities, this, null, null);
   }
}