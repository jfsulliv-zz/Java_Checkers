package userInterface.controller;

import main.GameLauncher;
import userInterface.view.IModel;

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
	public void gameInstance(int mode) {
		Thread gameLauncher = new Thread(new GameLauncher(mode));
		System.out.println("GameInstance event: Recieved");
		gameLauncher.start();
	}

	/**
	 * Accessor method
	 */
	public void scoreBoardInstance() {
		System.out.println("ScoreBoardInstance event: Recieved");
	}

}
