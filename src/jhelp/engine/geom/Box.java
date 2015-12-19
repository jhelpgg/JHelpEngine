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
package jhelp.engine.geom;

import jhelp.engine.NodeType;
import jhelp.engine.Object3D;
import jhelp.engine.Vertex;
import jhelp.xml.MarkupXML;

/**
 * Box, cube <br>
 * <br>
 * Last modification : 23 janv. 2009<br>
 * Version 0.0.1<br>
 * 
 * @author JHelp
 */
public class Box
      extends Object3D
{
   /**
    * Constructs Box
    */
   public Box()
   {
      this.nodeType = NodeType.BOX;

      this.add(new Vertex(-0.5f, 0.5f, 0.5f,//
            0f, 0f,//
            0f, 0f, -1f));
      this.add(new Vertex(0.5f, 0.5f, 0.5f,//
            1f, 0f,//
            0f, 0f, -1f));
      this.add(new Vertex(0.5f, -0.5f, 0.5f,//
            1f, 1f,//
            0f, 0f, -1f));
      this.add(new Vertex(-0.5f, -0.5f, 0.5f,//
            0f, 1f,//
            0f, 0f, -1f));
      //
      this.nextFace();
      this.add(new Vertex(-0.5f, 0.5f, -0.5f,//
            1f, 1f,//
            0f, -1f, 0f));
      this.add(new Vertex(0.5f, 0.5f, -0.5f,//
            0f, 1f,//
            0f, -1f, 0f));
      this.add(new Vertex(0.5f, 0.5f, 0.5f,//
            0f, 0f,//
            0f, -1f, 0f));
      this.add(new Vertex(-0.5f, 0.5f, 0.5f,//
            1f, 0f,//
            0f, -1f, 0f));
      //
      this.nextFace();
      this.add(new Vertex(0.5f, -0.5f, 0.5f,//
            0f, 1f,//
            -1f, 0f, 0f));
      this.add(new Vertex(0.5f, 0.5f, 0.5f,//
            0f, 0f,//
            -1f, 0f, 0f));
      this.add(new Vertex(0.5f, 0.5f, -0.5f,//
            1f, 0f,//
            -1f, 0f, 0f));
      this.add(new Vertex(0.5f, -0.5f, -0.5f,//
            1f, 1f,//
            -1f, 0f, 0f));
      //
      this.nextFace();
      this.add(new Vertex(-0.5f, -0.5f, -0.5f,//
            1f, 1f,//
            0f, 0f, 1f));
      this.add(new Vertex(0.5f, -0.5f, -0.5f,//
            0f, 1f,//
            0f, 0f, 1f));
      this.add(new Vertex(0.5f, 0.5f, -0.5f,//
            0f, 0f,//
            0f, 0f, 1f));
      this.add(new Vertex(-0.5f, 0.5f, -0.5f,//
            1f, 0f,//
            0f, 0f, 1f));
      //
      this.nextFace();
      this.add(new Vertex(-0.5f, -0.5f, 0.5f,//
            0f, 0f,//
            0f, 1f, 0f));
      this.add(new Vertex(0.5f, -0.5f, 0.5f,//
            1f, 0f,//
            0f, 1f, 0f));
      this.add(new Vertex(0.5f, -0.5f, -0.5f,//
            1f, 1f,//
            0f, 1f, 0f));
      this.add(new Vertex(-0.5f, -0.5f, -0.5f,//
            0f, 1f,//
            0f, 1f, 0f));
      //
      this.nextFace();
      this.add(new Vertex(-0.5f, -0.5f, -0.5f,//
            0f, 1f,//
            1f, 0f, 0f));
      this.add(new Vertex(-0.5f, 0.5f, -0.5f,//
            0f, 0f,//
            1f, 0f, 0f));
      this.add(new Vertex(-0.5f, 0.5f, 0.5f,//
            1f, 0f,//
            1f, 0f, 0f));
      this.add(new Vertex(-0.5f, -0.5f, 0.5f,//
            1f, 1f,//
            1f, 0f, 0f));
   }

   /**
    * Call when pase done
    * 
    * @see jhelp.engine.Node#endParseXML()
    */
   @Override
   protected void endParseXML()
   {
   }

   /**
    * Read from XML
    * 
    * @param markupXML
    *           Markup to parse
    * @see jhelp.engine.Node#readFromMarkup
    */
   @Override
   protected void readFromMarkup(final MarkupXML markupXML)
   {
      this.readMaterialFromMarkup(markupXML);
   }

   /**
    * Write on XML
    * 
    * @param markupXML
    *           Markup to fill
    * @see jhelp.engine.Node#writeInMarkup
    */
   @Override
   protected void writeInMarkup(final MarkupXML markupXML)
   {
      this.writeMaterialInMarkup(markupXML);
   }
}