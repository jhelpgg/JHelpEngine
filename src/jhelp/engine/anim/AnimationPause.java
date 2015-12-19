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
package jhelp.engine.anim;

import javax.media.opengl.GL;

import jhelp.engine.Animation;

/**
 * Special animation that make a pause inside animation.<br>
 * Animation does nothing an amount of time
 * 
 * @author JHelp
 */
public class AnimationPause
      implements Animation
{
   /** Pause duration express in frame */
   private final int durationPauseInFrame;
   /** Start absolute frame */
   private float     startAbsoluteFrame;

   /**
    * Create a new instance of AnimationPause
    * 
    * @param durationPauseInFrame
    *           Pause duration express in frame
    */
   public AnimationPause(final int durationPauseInFrame)
   {
      this.durationPauseInFrame = durationPauseInFrame;
   }

   /**
    * Called when animation played <br>
    * <br>
    * <b>Parent documentation:</b><br>
    * {@inheritDoc}
    * 
    * @param gl
    *           Open GL context
    * @param absoluteFrame
    *           Absolute frame
    * @return {@code true} if animation have to continue. {@code false} if aniumation finished
    * @see jhelp.engine.Animation#animate(javax.media.opengl.GL, float)
    */
   @Override
   public boolean animate(final GL gl, final float absoluteFrame)
   {
      return (absoluteFrame - this.startAbsoluteFrame) <= this.durationPauseInFrame;
   }

   /**
    * Called when animation start <br>
    * <br>
    * <b>Parent documentation:</b><br>
    * {@inheritDoc}
    * 
    * @param startAbsoluteFrame
    *           Start absolute frame
    * @see jhelp.engine.Animation#setStartAbsoluteFrame(float)
    */
   @Override
   public void setStartAbsoluteFrame(final float startAbsoluteFrame)
   {
      this.startAbsoluteFrame = startAbsoluteFrame;
   }
}