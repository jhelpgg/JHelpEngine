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

/**
 * Animation that not need Open GL and direct link to JOGL.<br>
 * So can be used from external easily
 * 
 * @author JHelp
 */
public interface ExternalAnimation
{
   /**
    * Called when animation initialized
    */
   public void initializeAnimation();

   /**
    * Called when animation refreshed
    * 
    * @param frame
    *           Animation frame
    * @return {@code true} if animation have to continue. {@code false} if animation finished
    */
   public boolean playAnimation(final float frame);
}