package jhelp.engine.event;

import jhelp.engine.twoD.OptionPaneButtons;

/**
 * Listener of option pane events
 * 
 * @author JHelp
 */
public interface OptionPane2DListener
{
   /**
    * Called on option pane button click
    * 
    * @param optionPaneID
    *           Option pane ID
    * @param button
    *           Button clicked
    */
   public void optionPaneClicked(int optionPaneID, OptionPaneButtons button);
}