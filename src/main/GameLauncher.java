package main;

public class GameLauncher implements Runnable {
	int mode = -1;

	public GameLauncher(int mode) { this.mode = mode; }
	public GameLauncher() { }
	
	public void run() {
		if(mode == -1){
			Game.getInstance();
		} else {
			Game.getInstance(mode);
		}
	}
}
