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

import jhelp.engine.Vertex;

/**
 * A triangle
 * 
 * @author JHelp
 */
public class Triangle
{
   /** Triangle first vertex */
   public Vertex first;
   /** Triangle second vertex */
   public Vertex second;
   /** Triangle third vertex */
   public Vertex third;

   /**
    * Create a new instance of Triangle
    */
   public Triangle()
   {
      this.first = new Vertex();
      this.second = new Vertex();
      this.third = new Vertex();
   }

   /**
    * Create a new instance of Triangle
    * 
    * @param first
    *           Firt vertex
    * @param second
    *           Second vertex
    * @param third
    *           Third vertex
    */
   public Triangle(final Vertex first, final Vertex second, final Vertex third)
   {
      this.first = first;
      this.second = second;
      this.third = third;
   }
}