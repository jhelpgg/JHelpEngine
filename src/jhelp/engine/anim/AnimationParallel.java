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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.media.opengl.GL;

import jhelp.engine.Animation;
import jhelp.util.list.Pair;

/**
 * Animation that does several animation in parallel
 * 
 * @author JHelp
 */
public final class AnimationParallel
      implements Animation
{
   /** List of animation, playing status pairs */
   private final List<Pair<Animation, Boolean>> animations;
   /** Indicates if at least one animation is playing */
   private final AtomicBoolean                  playing = new AtomicBoolean(false);

   /**
    * Create a new instance of AnimationParallel
    */
   public AnimationParallel()
   {
      this.animations = new ArrayList<Pair<Animation, Boolean>>();
   }

   /**
    * Add an animation
    * 
    * @param animation
    *           Animation to add
    * @return {@code true} if animation added
    * @throws IllegalStateException
    *            If animation is playing
    */
   public boolean addAnimation(final Animation animation)
   {
      if(animation == null)
      {
         throw new NullPointerException("animation musn't be null");
      }

      synchronized(this.playing)
      {
         if(this.playing.get() == true)
         {
            throw new IllegalStateException("Can't add animation while playing");
         }
      }

      return this.animations.add(new Pair<Animation, Boolean>(animation, true));
   }

   /**
    * Play the animation <br>
    * <br>
    * <b>Parent documentation:</b><br>
    * {@inheritDoc}
    * 
    * @param gl
    *           Open GL context
    * @param absoluteFrame
    *           Absolute frame
    * @return {@code true} if at least animation playing
    * @see jhelp.engine.Animation#animate(javax.media.opengl.GL, float)
    */
   @Override
   public boolean animate(final GL gl, final float absoluteFrame)
   {
      boolean moreAnimation = false;

      for(final Pair<Animation, Boolean> pair : this.animations)
      {
         if(pair.element2 == true)
         {
            if(pair.element1.animate(gl, absoluteFrame) == true)
            {
               moreAnimation = true;
            }
            else
            {
               pair.element2 = false;
            }
         }
      }

      if(moreAnimation == false)
      {
         synchronized(this.playing)
         {
            this.playing.set(false);
         }
      }

      return moreAnimation;
   }

   /**
    * Indicates if animation playing
    * 
    * @return {@code true} if animation playing
    */
   public boolean isPlaying()
   {
      synchronized(this.playing)
      {
         return this.playing.get();
      }
   }

   /**
    * Remove an animation
    * 
    * @param animation
    *           Animation to remove
    * @return {@code true} if remove succeed
    * @throws IllegalStateException
    *            If animation is playing
    */
   public boolean removeAnimation(final Animation animation)
   {
      if(animation == null)
      {
         return false;
      }

      synchronized(this.playing)
      {
         if(this.playing.get() == true)
         {
            throw new IllegalStateException("Can't remove animation while playing");
         }
      }

      final int size = this.animations.size();
      Pair<Animation, Boolean> pair;

      for(int i = size - 1; i >= 0; i--)
      {
         pair = this.animations.get(i);

         if(pair.element1.equals(animation) == true)
         {
            this.animations.remove(i);
            return true;
         }
      }

      return false;
   }

   /**
    * Called when animation started <br>
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
      synchronized(this.playing)
      {
         this.playing.set(true);
      }

      for(final Pair<Animation, Boolean> pair : this.animations)
      {
         pair.element1.setStartAbsoluteFrame(startAbsoluteFrame);
         pair.element2 = true;
      }
   }
}