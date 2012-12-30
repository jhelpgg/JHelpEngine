/**
 * Project : JHelpSceneGraph<br>
 * Package : jhelp.engine.util<br>
 * Class : PositionObject2D<br>
 * Date : 4 sept. 2008<br>
 * By JHelp
 */
package jhelp.engine.util;

import jhelp.engine.twoD.Object2D;

/**
 * 2D object position <br>
 * <br>
 * Last modification : 23 janv. 2009<br>
 * Version 0.0.1<br>
 * 
 * @author JHelp
 */
public class PositionObject2D
{
   /** Height */
   public int height;
   /** Width */
   public int width;
   /** X */
   public int x;
   /** Y */
   public int y;

   /**
    * Constructs PositionObject2D
    */
   public PositionObject2D()
   {
   }

   /**
    * Constructs PositionObject2D
    * 
    * @param object2D
    *           Base object
    */
   public PositionObject2D(final Object2D object2D)
   {
      this.x = object2D.getX();
      this.y = object2D.getX();
      this.width = object2D.getWidth();
      this.height = object2D.getHeight();
   }
}