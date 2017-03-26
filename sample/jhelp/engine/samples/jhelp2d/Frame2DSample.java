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

import jhelp.engine.JHelpSceneRenderer;
import jhelp.engine.Scene;
import jhelp.engine.anim.AnimationPositionNode;
import jhelp.engine.anim.MultiAnimation;
import jhelp.engine.geom.Box;
import jhelp.engine.gui.JHelp2DFrame;
import jhelp.engine.gui.JHelpComponent2DView3D;
import jhelp.engine.util.PositionNode;
import jhelp.gui.twoD.FoldingAreaTitle;
import jhelp.gui.twoD.JHelpBorderLayout;
import jhelp.gui.twoD.JHelpBorderLayout.JHelpBorderLayoutConstraints;
import jhelp.gui.twoD.JHelpFoldable2D;
import jhelp.gui.twoD.JHelpFoldable2D.FoldingAreaPosition;
import jhelp.gui.twoD.JHelpLabelImage2D;
import jhelp.util.gui.JHelpFont;
import jhelp.util.gui.JHelpTextAlign;
import jhelp.util.text.UtilText;

/**
 * The frame of first sample
 * 
 * @author JHelp
 */
public class Frame2DSample
      extends JHelp2DFrame
{
   /** Font used by text */
   private static final JHelpFont FONT      = new JHelpFont("Arial", 14);
   /** Font used by fold panel title */
   private static final JHelpFont FONT_FOLD = new JHelpFont("Arial", 14, true);

   /**
    * Create a new instance of Frame2DSample
    */
   public Frame2DSample()
   {
      super("2D sample with 3D", new JHelpBorderLayout());

      this.createTop();
      this.createLeft();
      this.createCenter();
      this.createRight();
      this.createBottom();

      // Try remove comment bellow :)
      // this.addComponent2D(JHelpLabelImage2D.createTextLabel("Bottom\nLeft", Frame2DSample.FONT, 0xFF000000, 0xFFFFFFFF,
      // JHelpTextAlign.CENTER), JHelpBorderLayoutConstraints.BOTTOM_LEFT);
   }

   /**
    * Create bottom component
    */
   private void createBottom()
   {
      this.addComponent2D(this.createFoldable("Bottom", "bottom", true, FoldingAreaPosition.TOP), JHelpBorderLayoutConstraints.BOTTOM);
   }

   /**
    * Create center component
    */
   private void createCenter()
   {
      final JHelpComponent2DView3D view3d = this.createJHelpComponent2DView3D(512, 512);
      this.addComponent2D(view3d, JHelpBorderLayoutConstraints.CENTER);

      final JHelpSceneRenderer sceneRenderer = view3d.getJHelpSceneRenderer();
      final Scene scene = sceneRenderer.getScene();

      final Box box = new Box();
      scene.add(box);

      scene.setPosition(0, 0, -5);

      final MultiAnimation multiAnimation = new MultiAnimation(true);
      final AnimationPositionNode animationPositionNode = new AnimationPositionNode(box);
      animationPositionNode.addFrame(100, new PositionNode(0, 0, 0, 90, 0, 0));
      animationPositionNode.addFrame(200, new PositionNode(0, 0, 0, 0, 90, 0));
      animationPositionNode.addFrame(300, new PositionNode(0, 0, 0, 0, 0, 90));
      animationPositionNode.addFrame(400, new PositionNode(0, 0, 0, 0, 0, 0));
      multiAnimation.addAnimation(animationPositionNode);
      sceneRenderer.playAnimation(multiAnimation);
   }

   /**
    * Create a fold panel
    * 
    * @param title
    *           Title
    * @param nature
    *           Nature of the panel
    * @param horizontal
    *           Indicate is panel is horizontal ({@code true}) or vertical ({@code false})
    * @param foldingAreaPosition
    *           Position of click zone
    * @return Create fold panel
    */
   private JHelpFoldable2D createFoldable(final String title, final String nature, final boolean horizontal, final FoldingAreaPosition foldingAreaPosition)
   {
      return new JHelpFoldable2D(JHelpLabelImage2D.createTextLabel(
            UtilText.replaceHole("This is the {0} of the border layout.\nThis text can be hide or show\nby click on yellow bar", nature), Frame2DSample.FONT,
            0xFF000000, 0xFFFFFFFF, JHelpTextAlign.CENTER), new FoldingAreaTitle(0xFF0000FF, horizontal
            ? JHelpFoldable2D.DEFAULT_PAINT_HORIZONTAL
            : JHelpFoldable2D.DEFAULT_PAINT_VERTICAL, title, Frame2DSample.FONT_FOLD, 0xFF000000, null), foldingAreaPosition);
   }

   /**
    * Create left component
    */
   private void createLeft()
   {
      this.addComponent2D(this.createFoldable("Left", "left", false, FoldingAreaPosition.RIGHT), JHelpBorderLayoutConstraints.LEFT);
   }

   /**
    * Create right component
    */
   private void createRight()
   {
      // Try on replace RIGHT_EXPANDED by RIGHT to see the difference
      this.addComponent2D(this.createFoldable("Right", "right", false, FoldingAreaPosition.LEFT), JHelpBorderLayoutConstraints.RIGHT_EXPANDED);
   }

   /**
    * Create top component
    */
   private void createTop()
   {
      this.addComponent2D(this.createFoldable("Top", "top", true, FoldingAreaPosition.BOTTOM), JHelpBorderLayoutConstraints.TOP);
   }
}