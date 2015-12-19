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
package jhelp.engine.twoD;

/**
 * Option pane buttons.<br>
 * List allowed for create option pane : {@link #OK}, {@link #YES_NO} and {@link #YES_NO_CANCEL}.<br>
 * List of button response : {@link #OK}, {@link #YES}, {@link #NO} and {@link #CANCEL}
 * 
 * @author JHelp
 */
public enum OptionPaneButtons
      implements OptionPaneButtonCodes
{
   /** Cancel button : Indicates "Cancel" button is pressed */
   CANCEL(OptionPaneButtonCodes.CODE_CANCEL),
   /** No button : Indicates "No" button is pressed */
   NO(OptionPaneButtonCodes.CODE_NO),
   /** OK button : Create "OK" dialog and indicates that "OK" button is pressed */
   OK(OptionPaneButtonCodes.CODE_OK),
   /** Yes button : Indicates "Yes" button is pressed */
   YES(OptionPaneButtonCodes.CODE_YES),
   /** Yes/No option : Create "Yes/No" dialog */
   YES_NO(OptionPaneButtonCodes.CODE_YES | OptionPaneButtonCodes.CODE_NO),
   /** Yes/No/Cancel option : Create "Yes/No/Cancel" dialog */
   YES_NO_CANCEL(OptionPaneButtonCodes.CODE_YES | OptionPaneButtonCodes.CODE_NO | OptionPaneButtonCodes.CODE_CANCEL);

   /** Button code */
   private final int code;

   /**
    * Create a new instance of OptionPaneButtons
    * 
    * @param code
    *           Button code
    */
   OptionPaneButtons(final int code)
   {
      this.code = code;
   }

   /**
    * Button code
    * 
    * @return Button code
    */
   public int getCode()
   {
      return this.code;
   }

   /**
    * Indicates if contains cancel button
    * 
    * @return {@code true} if contains cancel button
    */
   public boolean hasCancel()
   {
      return (this.code & OptionPaneButtonCodes.CODE_CANCEL) != 0;
   }

   /**
    * Indicates if contains no button
    * 
    * @return {@code true} if contains no button
    */
   public boolean hasNo()
   {
      return (this.code & OptionPaneButtonCodes.CODE_NO) != 0;
   }

   /**
    * Indicates if contains OK button
    * 
    * @return {@code true} if contains OK button
    */
   public boolean hasOk()
   {
      return (this.code & OptionPaneButtonCodes.CODE_OK) != 0;
   }

   /**
    * Indicates if contains yes button
    * 
    * @return {@code true} if contains yes button
    */
   public boolean hasYes()
   {
      return (this.code & OptionPaneButtonCodes.CODE_YES) != 0;
   }

   /**
    * Indicates if allowed to use it in option pane creation
    * 
    * @return {@code true} if allowed to use it in option pane creation
    */
   public boolean validForSpecifyOptionPaneButtons()
   {
      switch(this)
      {
         case YES_NO:
         case YES_NO_CANCEL:
         case OK:
            return true;
         default:
            return false;
      }
   }
}