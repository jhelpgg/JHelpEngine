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
package jhelp.engine.samples.nodechain;

/**
 * Launch the test of Node chain.<br>
 * Arrow keys and page-up, page-up, moves the blue ball.<br>
 * Mouse drag move the scene, depends on witch mouse button is down :
 * <table border=1>
 * <tr>
 * <th></th>
 * <th>Left up</th>
 * <th>Left down</th>
 * </tr>
 * <tr>
 * <th>Right up</th>
 * <td><center>No movement</center></td>
 * <td><center>Rotation</center></td>
 * </tr>
 * <tr>
 * <th>Right down</th>
 * <td><center>Zoom</center></td>
 * <td><center>Translation</center></td>
 * </tr>
 * </table>
 * <br>
 * Mouse wheel do also a zoom.<br>
 * <b>Space</b> key, launch animation, <b>Escape</b> stop it.<br>
 * <b>S</b> show FPS, <b>H</b> hide it.
 *
 * @author JHelp
 */
public class TestNodeChain
{

   /**
    * Launch the test of Node chain
    *
    * @param args
    *           Unused
    */
   public static void main(final String[] args)
   {
      final NodeChainFrame nodeChainFrame = new NodeChainFrame();
      nodeChainFrame.showFrame();
   }
}