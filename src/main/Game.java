package main;

public class Game {
	private static Game instance;
	private Board board = Board.getInstance();
	private Player redPlayer, blackPlayer, currentPlayer;
	private boolean gameOver = false;
	
	private Game(){	}
	
	public static synchronized Game getInstance(){
		if(instance == null){
			instance = new Game();
		}
		return instance;
	}
	
	public void initialize(int mode) {
		switch(mode) {
			case 1:
				blackPlayer = new AIPlayer(Colour.BLACK,board);
				redPlayer = new HumanPlayer(Colour.RED,board); 
				break;
			case 2: 
				blackPlayer = new HumanPlayer(Colour.BLACK,board);
				redPlayer = new HumanPlayer(Colour.RED,board); 
				break;
		}
		board.printArray();
	}
	
	public void play() {
		int turn = 1;
		while(!gameOver) {
			board.resetTurn();
			switch(turn) {
				case 0: currentPlayer = blackPlayer;
						turn +=1;
						break;
				case 1: currentPlayer = redPlayer;
						turn -=1;
						break;
			}
			System.out.println("Turn: "+ currentPlayer.toString());
			board.printArray();
			while(!board.hasChanged()) {
				currentPlayer.myTurn();
				if(currentPlayer.isHuman() == false){
					currentPlayer.setStart(null);
					currentPlayer.setEnd(null);
					currentPlayer.makeCurrentMove();
				}
			}
		}

	}
	
	
	public Player currentPlayer() { 
		return currentPlayer; 
	}
	
}
