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
	
	private Thread gameLauncher = new Thread(new GameLauncher());
	
	public ModelController() {
		
	}

	/**
	 * Accessor method
	 */
	public void gameInstance() {
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
