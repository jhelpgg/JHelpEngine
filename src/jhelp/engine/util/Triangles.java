package jhelp.engine.util;

import java.util.ArrayList;

import jhelp.engine.Vertex;

public class Triangles
{
   public final ArrayList<Triangle> triangles;

   public Triangles()
   {
      this.triangles = new ArrayList<Triangle>();
   }

   public void addTriangle(final Triangle triangle)
   {
      this.triangles.add(triangle);
   }

   public void addTriangle(final Vertex first, final Vertex second, final Vertex third)
   {
      this.triangles.add(new Triangle(first, second, third));
   }

   public void convertInTriangles(final Vertex... polygon)
   {
      if((polygon == null) || (polygon.length < 3))
      {
         return;
      }

      final int length = polygon.length;
      final Vertex first = polygon[0];

      for(int i = 2; i < length; i++)
      {
         this.triangles.add(new Triangle(first, polygon[i - 1], polygon[i]));
      }
   }
}