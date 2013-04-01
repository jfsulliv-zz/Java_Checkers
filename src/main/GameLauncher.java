package main;

public class GameLauncher implements Runnable {
	int mode = -1;

	public GameLauncher(int mode) {
		this.mode = mode;
	}

	public void run() {
		Game.getInstance(mode);
	}

}
