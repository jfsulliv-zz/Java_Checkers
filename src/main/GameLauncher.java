package main;

public class GameLauncher {
	public static void main(String[] args){
		Game game = Game.getInstance();
		game.initialize();
		int turn = 0;
		while(!game.gameOver()){
			if (turn == 0){
				game.nextTurn(Colour.RED);
				turn += 1;
			} else {
				game.nextTurn(Colour.BLACK);
				turn -= 1;
			}
		}
	}
}
