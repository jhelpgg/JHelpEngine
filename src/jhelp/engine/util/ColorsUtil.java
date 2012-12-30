/**
 */
package jhelp.engine.util;

import java.awt.Color;

/**
 * Utilities for color manipulation <br>
 * <br>
 * Last modification : 23 janv. 2009<br>
 * Version 0.0.1<br>
 * 
 * @author JHelp
 */
public class ColorsUtil
{
   /** Transparent color */
   public static final Color TRANSPARENT  = new Color(0, 0, 0, 0);
   /** Shadow dark */
   public static final Color SHADOW_DARK  = new Color(0xC0000000, true);
   /** Shadow */
   public static final Color SHADOW       = new Color(0x80404040, true);
   /** Light */
   public static final Color LIGHT        = new Color(0x80C0C0C0, true);
   /** Bright light */
   public static final Color LIGHT_BRIGHT = new Color(0xC0FFFFFF, true);

   /**
    * Take the integer part of a number and put it in [0, 255]<br>
    * That is to say if integer<0, return 0. If integer>255, return 2555. Return the integer on other case
    * 
    * @param number
    *           Number to limit
    * @return Limited value
    */
   public static int limite0_255(double number)
   {
      int integer = (int) number;
      if(integer < 0)
      {
         return 0;
      }
      if(integer > 255)
      {
         return 255;
      }
      return integer;
   }

   /**
    * Compute a brighter color
    * 
    * @param color
    *           Base color
    * @return Brighter color
    */
   public static Color moreBright(Color color)
   {
      return ColorsUtil.changeBright(color, 2);
   }

   /**
    * Compute a darker color
    * 
    * @param color
    *           Base color
    * @return Darker color
    */
   public static Color moreDark(Color color)
   {
      return ColorsUtil.changeBright(color, 0.5f);
   }

   /**
    * Change color bright
    * 
    * @param color
    *           Base color
    * @param factor
    *           Bright factor (factor>1 => more bright | 0<factor<1 => more dark)
    * @return Computed color
    */
   public static Color changeBright(Color color, float factor)
   {
      // Get color parts
      int red = color.getRed();
      int green = color.getGreen();
      int blue = color.getBlue();

      // Convert in YUV
      double y = red * 0.299 + green * 0.587 + blue * 0.114;
      double u = -0.169 * red - 0.331 * green + 0.500 * blue + 128.0;
      double v = 0.500 * red - 0.419 * green - 0.081 * blue + 128.0;

      // Apply the factor
      y *= factor;

      // Convert to RGB
      red = ColorsUtil.limite0_255(y - 0.0009267 * (u - 128) + 1.4016868 * (v - 128));
      green = ColorsUtil.limite0_255(y - 0.3436954 * (u - 128) - 0.7141690 * (v - 128));
      blue = ColorsUtil.limite0_255(y + 1.7721604 * (u - 128) + 0.0009902 * (v - 128));

      // Return the new color
      return new Color(red, green, blue);
   }
}