/*
 * Cree le 4 oct. 06 Pour cedreo
 */
package jhelp.engine.util;

/**
 * Math for 3D and utilities <br>
 * <br>
 * Last modification : 23 janv. 2009<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
public class Math3D
{
   /** 2 PI */
   public static final float  DEUX_PI                             = (float) (2d * Math.PI);
   /** 255 in byte */
   public static final byte   BYTE_255                            = (byte) 255;
   /** 0 in byte */
   public static final byte   BYTE_0                              = (byte) 0;
   /** Difference between tow succeed picking color number */
   public static final int    PICKING_PRECISION                   = 8;
   /** Epsilon to say if two color are the same */
   public static final float  PICK_EPSILON                        = 1e-5f;
   /** Theorical maximum of objects */
   public static final int    NUMBER_THEORICAL_MAXIMUM_OF_OBJECTS = (256 * 256 * 256) / PICKING_PRECISION;
   /** Power of 2 list */
   private static final int[] powerOf2                            =
                                                                  {
         1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024
                                                                  };

   /**
    * Compute square of a number
    * 
    * @param f
    *           Number to multiply by himself
    * @return The square
    */
   public static float square(float f)
   {
      return f * f;
   }

   /**
    * Compute square of a number
    * 
    * @param f
    *           Number to multiply by himself
    * @return The square
    */
   public static double square(double f)
   {
      return f * f;
   }

   /**
    * Compute the bigger power of 2 lesser or equal to integer in parameter, and return couple made of the LOG2 of the power of
    * 2 number and the power of 2 it self.<br>
    * For example, for 5, the power of 2 is 4=2^2, return (2, 4).<br>
    * Other example 9 => (3, 8) ...
    * 
    * @param integer
    *           Integer look for near power of 2
    * @return The (LOG2, power 2) couple
    */
   public static int[] computePowerOf2couple(int integer)
   {
      // For integer less or equal than 1, the return couple is (0, 1)
      if(integer <= 1)
      {
         return new int[]
         {
               0, 1
         };
      }

      // If the integer is bigger or equal than the maximum value, the return
      // the maximum
      int end = powerOf2.length - 1;
      if(integer >= powerOf2[end])
      {
         return new int[]
         {
               end, powerOf2[end]
         };
      }

      // Search the value
      int start = 0;
      while(start + 1 < end)
      {
         int middle = (start + end) >> 1;
         int pui = powerOf2[middle];
         if(pui == integer)
         {
            return new int[]
            {
                  middle, pui
            };
         }
         if(pui > integer)
         {
            end = middle;
         }
         else
         {
            start = middle;
         }
      }

      return new int[]
      {
            start, powerOf2[start]
      };
   }

   /**
    * Compute the nearest power of 2 of an integer
    * 
    * @param integer
    *           Integer considered
    * @return Nearest power of 2
    */
   public static int computeNearestPowerOf2(int integer)
   {
      int nb = powerOf2.length - 1;
      int index = 0;
      while(index < nb && integer > powerOf2[index])
      {
         index++;
      }
      return powerOf2[index];
   }

   /**
    * Indicates if 2 floats are equals
    * 
    * @param f1
    *           First float
    * @param f2
    *           Second float
    * @return {@code true} if floats are equal
    */
   public static final boolean equal(float f1, float f2)
   {
      return Math.abs(f1 - f2) < 1e-5f;
   }

   /**
    * Indicates if 2 floats (in picking precision) are equals
    * 
    * @param f1
    *           First float
    * @param f2
    *           Second float
    * @return {@code true} if floats are equal
    */
   public static final boolean equalPick(float f1, float f2)
   {
      return Math.abs(f1 - f2) < PICK_EPSILON;
   }

   /**
    * Indicates if a float is nul
    * 
    * @param f
    *           Float to test
    * @return {@code true} if the float is nul
    */
   public static final boolean nul(float f)
   {
      return Math.abs(f) < 1e-5f;
   }

   /**
    * Create a copy of array
    * 
    * @param array
    *           Array to copy
    * @return Copy
    */
   public static final float[] getCopy(float[] array)
   {
      if(array == null)
         return null;
      float[] copy = new float[array.length];
      System.arraycopy(array, 0, copy, 0, array.length);
      return copy;
   }

   /**
    * Create a copy of array
    * 
    * @param array
    *           Array to copy
    * @return Copy
    */
   public static final int[] getCopy(int[] array)
   {
      if(array == null)
         return null;
      int[] copy = new int[array.length];
      System.arraycopy(array, 0, copy, 0, array.length);
      return copy;
   }

   /**
    * Transform radian angle to degre
    * 
    * @param radian
    *           Radian angle
    * @return Degre angle
    */
   public static float radianToDegre(float radian)
   {
      return (360f * radian) / DEUX_PI;
   }

   /**
    * Transform degre angle to radian
    * 
    * @param degre
    *           Degre angle
    * @return Radian angle
    */
   public static float degreToRadian(float degre)
   {
      return (DEUX_PI * degre) / 360f;
   }

   /**
    * Transform float that progress linear [0, 1] to sinusoidal progression [0, 1]
    * 
    * @param rate
    *           Linear progression
    * @return Sinusoidal progression
    */
   public static float linearToSinusoidal(float rate)
   {
      return (float) ((Math.sin(rate * Math.PI - Math.PI / 2d) + 1d) / 2d);
   }

   /**
    * Extract decimal part
    * 
    * @param f
    *           Float to extract
    * @return Decimal part
    */
   public static float decimalPart(float f)
   {
      return f - (int) f;
   }
}