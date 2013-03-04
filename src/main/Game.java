package main;

/*
 * Skeleton of the main Game logic- NOT complete!
 * Author: James
 */
public class Game {
	static Game instance;
	HumanPlayer blackPlayer;
	AIPlayer blackAIPlayer;
	HumanPlayer redPlayer;
	AIPlayer redAIPlayer;
	Board board = new Board();

	
	public static Game getInstance(){
		if(instance == null){
			instance = new Game();
		}
		return instance;
	}
	
	public void initialize(){
		board.initializeBoard();
		System.out.println("Welcome to Checkers!\n RED will play first.");
		System.out.println("Enter locations when prompted in the form \"x,y\".");
		System.out.println("The board is arranged with 0,0 at the Top-Left," + 
			 " 7,7 at the Bottom-Right.");

		blackAIPlayer = new AIPlayer(Colour.BLACK,board);
		redPlayer = new HumanPlayer(Colour.RED,board);
	}
	
	public void turn(HumanPlayer aPlayer){
		board.resetTurn();
		aPlayer.queryPieces();
		if(aPlayer.piecesLeft() == 0 || canMove(aPlayer) == false){
			gameOver(aPlayer);
		}
		
		board.printArray();
		System.out.println("Turn: "+aPlayer.toString());
		
		Location start = new Location(0,0);
		Location end = new Location(0,0);
		while(board.turnComplete() != 2){
			
			while(board.turnComplete() == 0) {
				start = aPlayer.takeInput(true);
				end = aPlayer.takeInput(false);

				aPlayer.movePiece(start,end);
			}
			
			if(board.turnComplete() == 1 && board.emptyJumps(aPlayer, end) != null){
				Location tempStart = new Location(end.getX(),end.getY());
				start = tempStart;
				board.printArray();
				while(board.turnComplete() != 2){
					System.out.println("You took a piece and can continue to move!");
					end = aPlayer.takeInput(false);
					aPlayer.movePiece(start, end);
				}
			} else {
				board.endTurn();
			}
		}
		board.printArray();
	}
	
	public void AITurn(AIPlayer aPlayer){
		board.resetTurn();
		aPlayer.queryPieces();
		if(aPlayer.piecesLeft() == 0 || canMove(aPlayer) == false){
			gameOver(aPlayer);
		}
		
		System.out.println("Turn: "+aPlayer.toString());
		
		board.printArray();
		
		Location start = new Location(0,0);
		Location end = new Location(0,0);
		while(board.turnComplete() != 2){

			while(board.turnComplete() == 0){
				start = aPlayer.randomStart();
				end = aPlayer.randomEnd(start);
				aPlayer.movePiece(start,end);				
			}

			
			if(board.turnComplete() == 1 && board.emptyJumps(aPlayer, end) != null){
				Location tempStart = new Location(end.getX(),end.getY());
				start = tempStart;
				board.printArray();
				while(board.turnComplete() != 2){
					end = aPlayer.randomEnd(start);
					aPlayer.movePiece(start, end);
				}
			} else {
				board.endTurn();
			}
			
		}
		board.printArray();
	}

	public boolean canMove(Player aPlayer) {
		for (int i = 0; i < aPlayer.myPieces.length; i++) {
			if (board.emptyMoves(aPlayer, aPlayer.myPieces[i].getLocation()) != null 
					|| board.emptyJumps(aPlayer, aPlayer.myPieces[i].getLocation())  != null){
				return true;
			} 
		}
		return false;
	}
	
	public void gameOver(Player aPlayer){
		System.out.println(aPlayer.toString()+" no longer has any pieces to move!"
			+ " They lose.");
		System.exit(0);
	}
}
