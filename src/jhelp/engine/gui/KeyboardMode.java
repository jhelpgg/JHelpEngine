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
package jhelp.engine.gui;

/**
 * Represents the mode of key board.<br>
 * By mode mean where keyboard user action are redirect to :
 * <ul>
 * <li>For capture the key code : Generally for associate key to game action</li>
 * <li>Edit text : When need to key some text from player</li>
 * <li>Game : To convert key pressed to action game</li>
 * </ul>
 * 
 * @author JHelp
 */
public enum KeyboardMode
{
   /** Mode capture next key press and return its code */
   CAPTURE_KEY_CODE,
   /** Mode get input text from player */
   EDIT_TEXT,
   /** Mode playing game */
   GAME
}