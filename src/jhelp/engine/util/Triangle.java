package jhelp.engine.util;

import jhelp.engine.Vertex;

public class Triangle
{
   public Vertex first;
   public Vertex second;
   public Vertex third;

   public Triangle()
   {
      this.first = new Vertex();
      this.second = new Vertex();
      this.third = new Vertex();
   }

   public Triangle(final Vertex first, final Vertex second, final Vertex third)
   {
      this.first = first;
      this.second = second;
      this.third = third;
   }
}