package jhelp.engine.gui;

import java.awt.event.KeyEvent;

public enum ActionKey
{
   ACTION(KeyEvent.VK_SPACE), BACKWARD(KeyEvent.VK_PAGE_DOWN), CANCEL(KeyEvent.VK_X), DOWN(KeyEvent.VK_DOWN), DUCK(KeyEvent.VK_CONTROL), EXIT(KeyEvent.VK_ESCAPE), FORWARD(KeyEvent.VK_PAGE_UP), JUMP(KeyEvent.VK_W), LEFT(
         KeyEvent.VK_LEFT), MENU(KeyEvent.VK_M), RIGHT(KeyEvent.VK_RIGHT), ROTATE_DOWN(KeyEvent.VK_S), ROTATE_LEFT(KeyEvent.VK_Q), ROTATE_RIGHT(KeyEvent.VK_D), ROTATE_UP(KeyEvent.VK_Z), SPECIAL(KeyEvent.VK_C), UP(KeyEvent.VK_UP);
   private final int defaultKeyCode;

   ActionKey(final int defaultKeyCode)
   {
      this.defaultKeyCode = defaultKeyCode;
   }

   public int getDefaultKeyCode()
   {
      return this.defaultKeyCode;
   }
}