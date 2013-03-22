package main;

public class GameLauncher implements Runnable {
	public static void main(String[] args){
		new Thread(new GameLauncher()).start();
	}
	
	public void run() {
		Game.getInstance();
	}
}
