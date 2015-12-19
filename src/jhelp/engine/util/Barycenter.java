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

/**
 * Barycenter of set of value <br>
 * <br>
 * Last modification : 23 janv. 2009<br>
 * Version 0.0.0<br>
 * 
 * @author JHelp
 */
public class Barycenter
{
   /** Actual barycenter */
   private double barycenter;
   /** Number of elements put in the set */
   private int    count;

   /**
    * Constructs Barycenter
    */
   public Barycenter()
   {
      this.count = 0;
   }

   /**
    * Add a value to the set
    * 
    * @param value
    *           Value add
    */
   public void add(final double value)
   {
      if(this.count == 0)
      {
         this.barycenter = value;
         this.count = 1;
         return;
      }
      //
      this.barycenter = ((this.count * this.barycenter) + value) / (this.count + 1d);
      this.count++;
   }

   /**
    * The actual barycenter
    * 
    * @return Actual barycenter
    */
   public double getBarycenter()
   {
      return this.barycenter;
   }

   /**
    * Indicates if the barycenter is empty
    * 
    * @return {@code true} if the barycenter is empty
    */
   public boolean isEmpty()
   {
      return this.count == 0;
   }
}