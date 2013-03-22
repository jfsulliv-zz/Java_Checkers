package userInterface.controller;

import main.GameLauncher;
import userInterface.GUI.IModel;

/**
 * 
 * @author Daniel
 * 
 * Controls the instances that are called. 
 *
 */
public class ModelController implements IModel {
	
	/**
	 * Accessor method
	 */
	public void gameInstance(GameLauncher gameMode) {
		System.out.println("GameModeModel event: Recieved");
		gameMode.run();
	}

	/**
	 * Accessor method
	 */
	public void scoreBoardInstance() {
		System.out.println("ScoreBoardModel event: Recieved");
	}

}
