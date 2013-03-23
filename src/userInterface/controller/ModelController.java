package userInterface.controller;

import main.GameLauncher;
import userInterface.GUI.GamePanel;
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
	private GameLauncher gameMode = new GameLauncher();
	
	public ModelController(GamePanel gamePanel) {
	}

	/**
	 * Accessor method
	 */
	public void gameInstance(Thread gameMode) {
		System.out.println("GameModeModel event: Recieved");
		gameLauncher = gameMode;
		gameMode.start();
		gameLauncher.start();
	}

	/**
	 * Accessor method
	 */
	public void scoreBoardInstance() {
		System.out.println("ScoreBoardModel event: Recieved");
	}

}
