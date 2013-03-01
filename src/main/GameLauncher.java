package main;

public class GameLauncher {
	public static void main(String[] args){
		Game game = Game.getInstance();
		game.initialize();
		int turn = 0;
		while(1==1){
			if (turn == 0){
				game.turn(game.redPlayer);
				turn += 1;
			} else {
				game.turn(game.blackPlayer);
				turn -= 1;
			}
		}
	}
}
