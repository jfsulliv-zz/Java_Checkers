package main;

public class GameLauncher implements Runnable {
	public void run() {
		Game.getInstance();
	}
}
