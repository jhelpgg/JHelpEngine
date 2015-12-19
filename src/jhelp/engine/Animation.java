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

import javax.media.opengl.GL;

/**
 * Animation.<br>
 * When animation is add to the play list, the render give him the absolute frame of the start,. And on play it gives the actual
 * absolute frame. So to know the relative frame for the animation, you have to store the start absolute frame, and make the
 * difference between the given on play and the start.<br>
 * See <code>jhelp.engine.anim.AnimationKeyFrame</code> for an example <br>
 * <br>
 * Last modification : 25 janv. 2009<br>
 * Version 0.0.1<br>
 * 
 * @author JHelp
 */
public interface Animation
{
   /**
    * Call by the renderer each time the animation is refresh on playing
    * 
    * @param gl
    *           OpenGL context
    * @param absoluteFrame
    *           Actual absolute frame
    * @return {@code true} if the animation need to be refresh one more time. {@code false} if the animation is end
    */
   public boolean animate(GL gl, float absoluteFrame);

   /**
    * Call by the renderer to indicates the start absolute frame
    * 
    * @param startAbsoluteFrame
    *           Start absolute frame
    */
   public void setStartAbsoluteFrame(float startAbsoluteFrame);
}