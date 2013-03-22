package userInterface.GUI;

import main.GameLauncher;

/**
 * 
 * @author Daniel
 *
 * This interface is defined for use by ModelController class. 
 */
public interface IModel {

	public void gameInstance(GameLauncher gameMode);
	
	public void scoreBoardInstance();
}
