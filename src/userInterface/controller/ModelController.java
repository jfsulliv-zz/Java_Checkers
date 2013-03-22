package userInterface.controller;

import main.GameLauncher;
import userInterface.GUI.IModel;

public class ModelController implements IModel {
	
	
	public void gameInstance(GameLauncher gameMode) {
		System.out.println("GameModeModel event: Recieved");
		gameMode.run();
	}

	public void scoreBoardInstance() {
		System.out.println("ScoreBoardModel event: Recieved");
	}

}
