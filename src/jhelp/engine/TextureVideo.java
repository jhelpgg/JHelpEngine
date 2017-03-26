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

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;

import jhelp.util.Utilities;
import jhelp.video.VideoReader;

/**
 * Texture witch carry a video<br>
 * Video is read loop, if it is possible <br>
 * <br>
 * Last modification : 22 janv. 2009<br>
 * Version 0.0.1<br>
 *
 * @author JHelp
 */
public class TextureVideo
      extends Texture
      implements Runnable
{
   /** Video FPS play */
   private int               fps;
   /** Indicates if the video is on pause */
   private boolean           pause;
   /** Thread for refresh the video */
   private Thread            thread;
   /** Video reader */
   private final VideoReader videoReader;

   /**
    * Constructs TextureVideo with standard 25 FPS
    *
    * @param videoReader
    *           Video reader
    */
   public TextureVideo(final VideoReader videoReader)
   {
      this(videoReader, 25);
   }

   /**
    * Constructs TextureVideo with a FPS.<br>
    * The texture is refresh on trying to respect the chosen FPS, but if it's too big, it refresh as soon as it cans
    *
    * @param videoReader
    *           Video reader
    * @param fps
    *           FPS for read video
    */
   public TextureVideo(final VideoReader videoReader, final int fps)
   {
      super(videoReader.getName(), Texture.REFERENCE_VIDEO);
      int width;
      int height;

      this.videoReader = videoReader;
      this.setFPS(fps);
      this.pause = false;

      width = this.videoReader.getWidth();
      height = this.videoReader.getHeight();

      if((width < 1) || (height < 1))
      {
         throw new IllegalArgumentException("The video must have width>0 and height>0");
      }

      this.setPixels(width, height, new byte[width * height * 4]);
      this.fillRect(0, 0, width, height, Color.WHITE, false);
   }

   /**
    * Video FPS
    *
    * @return Video FPS
    */
   public int getFPS()
   {
      return this.fps;
   }

   /**
    * Indicates if the video is on pause
    *
    * @return {@code true} if the video is on pause
    */
   public boolean isPause()
   {
      return this.pause;
   }

   /**
    * Don't call it directly !<br>
    * It is called by the thread<br>
    * This method refresh the video
    *
    * @see java.lang.Runnable#run()
    */
   @Override
   public void run()
   {
      Image image;
      long sleep;
      long start;

      // While the video is alive
      while(this.thread != null)
      {
         // Wait until we are not in pause
         while((this.pause) && (this.thread != null))
         {
            try
            {
               Thread.sleep(1000);
            }
            catch(final Exception ignored)
            {
            }
         }
         // Refresh the video
         while((!this.pause) && (this.thread != null))
         {
            // Is an other image to read ?
            if(this.videoReader.hasNextImage())
            {
               // Prepare the FPS synchronization
               sleep = 1000L / this.fps;
               start = System.currentTimeMillis();
               // Read and print the next image
               try
               {
                  image = this.videoReader.nextImage();

                  while((image.getWidth(null) < 1) || (image.getHeight(null) < 1))
                  {
                     Utilities.sleep(4);
                  }

                  while((this.pause) && (this.thread != null))
                  {
                     try
                     {
                        Thread.sleep(1000);
                     }
                     catch(final Exception ignored)
                     {
                     }
                  }

                  this.drawImage(0, 0, image);
               }
               catch(final IOException ignored)
               {
               }

               // If left time before the FPS, wait a moment
               sleep = sleep - (System.currentTimeMillis() - start);
               if(sleep < 1)
               {
                  sleep = 1;
               }
               try
               {
                  Thread.sleep(sleep);
               }
               catch(final Exception ignored)
               {
               }
            }
            else
            {
               // No more image
               this.thread = null;
            }
         }
      }

      image = null;
   }

   /**
    * Change the FPS
    *
    * @param fps
    *           New FPS
    */
   public void setFPS(int fps)
   {
      if(fps < 1)
      {
         fps = 1;
      }

      if(fps > 100)
      {
         fps = 100;
      }

      this.fps = fps;
   }

   /**
    * Change pause state
    *
    * @param pause
    *           New pause state
    */
   public void setPause(final boolean pause)
   {
      this.pause = pause;
   }

   /**
    * Start read the video
    */
   public void startVideo()
   {
      this.pause = false;
      if(this.thread == null)
      {
         this.thread = new Thread(this);
         this.thread.start();
      }
   }

   /**
    * Stop read the video
    */
   public void stopVideo()
   {
      this.thread = null;
   }
}