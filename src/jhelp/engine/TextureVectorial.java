package jhelp.engine;

import jhelp.vectorial.event.CanvasChangeListener;
import jhelp.vectorial.layer.Canvas;
import jhelp.vectorial.layer.Layer;

/**
 * Texture with vectorial drawing
 * 
 * @author JHelp
 */
public class TextureVectorial
      extends Texture
      implements CanvasChangeListener
{
   /** Canvas with vectorial drawing */
   private final Canvas canvas;

   /**
    * Create a new instance of TextureVectorial
    * 
    * @param name
    *           Texture name
    * @param width
    *           Texture width
    * @param height
    *           Texture height
    */
   public TextureVectorial(final String name, final int width, final int height)
   {
      super(name, width, height);
      this.canvas = new Canvas(width, height);
      this.canvas.registerCanvasChangeListener(this);
   }

   /**
    * Called when canvas changed <br>
    * <br>
    * <b>Parent documentation:</b><br>
    * {@inheritDoc}
    * 
    * @param canvas
    *           Canvas changed
    * @see jhelp.vectorial.event.CanvasChangeListener#canvasChanged(jhelp.vectorial.layer.Canvas)
    */
   @Override
   public void canvasChanged(final Canvas canvas)
   {
      this.setImage(this.canvas.updateImage());
   }

   /**
    * Create a new layer
    * 
    * @return New layer
    */
   public Layer createLayer()
   {
      return this.canvas.createNewLayer();
   }

   /**
    * Create a new layer
    * 
    * @param name
    *           Layer name
    * @return New layer
    */
   public Layer createLayer(final String name)
   {
      return this.canvas.createNewLayer(name);
   }

   /**
    * Embed canvas where vectorial draw
    * 
    * @return Embed canvas where vectorial draw
    */
   public Canvas getCanvas()
   {
      return this.canvas;
   }

   /**
    * Obtain a layer
    * 
    * @param index
    *           Layer index
    * @return The layer
    */
   public Layer getLayer(final int index)
   {
      return this.canvas.getLayer(index);
   }

   /**
    * Number of layer
    * 
    * @return Number of layer
    */
   public int numberOfLayer()
   {
      return this.canvas.numberOfLayer();
   }

   /**
    * Obtain layer by name
    * 
    * @param name
    *           Searched name
    * @return Found layer OR {@code null} if not found
    */
   public Layer obtainLayerByName(final String name)
   {
      return this.canvas.obtainLayerByName(name);
   }
}