package main;

import javax.swing.SwingWorker;

public class GameLauncher extends SwingWorker{
	int mode = -1;

	
	/**
	 * Constructor method to set the 'Mode' of the game from a given integer, 1 or 2, to decide the number of Human Players.
	 * @param mode Integer value, 1 or 2, of the number of human players- the remainder will be AI.
	 */
	public GameLauncher(int mode) {
		this.mode = mode;
	}
	
	/**
	 * Run method for the game's Thread. Initializes and plays the game in its own thread.
	 */
	public void runGame() {
		Game game = Game.getInstance();
		game.initialize(mode);
		game.play();
	}
	@Override
	protected String doInBackground() throws Exception {
		runGame();
		return "Start game";
	}

}
