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
		if(aPlayer.piecesLeft() == 0){
			gameOver(aPlayer);
		}
		
		board.printArray();
		System.out.println("Turn: "+aPlayer.toString());
		
		Location start;
		Location end;
		while(board.turnComplete() != 2){

			start = aPlayer.takeInput(true);
			end = aPlayer.takeInput(false);

			aPlayer.movePiece(start,end);
			
			if(board.turnComplete() == 1 && board.emptyJumps(aPlayer, end) != null){
				Location tempStart = new Location(start.getX(),start.getY());
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
		if(aPlayer.piecesLeft() == 0){
			gameOver(aPlayer);
		}
		
		System.out.println("Turn: "+aPlayer.toString());
		
		board.printArray();
		
		Location start = new Location(0,0);
		Location end;
		while(board.turnComplete() != 2){

			start = aPlayer.randomStart();
			end = aPlayer.randomEnd(start);

			aPlayer.movePiece(start,end);
			
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

	public void gameOver(Player aPlayer){
		System.out.println(aPlayer.toString()+" no longer has any pieces to move!"
			+ " They lose.");
		System.exit(0);
	}
}
