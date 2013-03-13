package main;
import java.util.Scanner;

/**
 * A singleton of the Game.
 * 
 * @param instance The single Game instance
 * @param blackPlayer A Human, Black Player @param redPlayer A Human, Red Player
 * @param blackAIPlayer An AI, Black Player @param redAIPlayer An AI, Red Player
 * @param mode The Player Mode of the game, Integer (1,2)
 * @author james
 *
 */
public class Game {
	public static Game instance;
	private Board board = Board.getInstance();
	private Player blackPlayer, redPlayer;
	private int mode;
	private boolean gameOver;
	private Scanner input = new Scanner(System.in);
	
	private Game() {
		
	}
	
	/**
	 * Accessor Method to return the Singleton instance of the game, or call the constructor if it does not exist.
	 * @return The instance of the Game.
	 */
	public static Game getInstance(){
		if(instance == null){
			instance = new Game();
		}
		return instance;
	}
	
	/**
	 * Accessor Method to return the Player Mode of the game.
	 * @return Integer Player Mode (Corresponds to number of Human Players).
	 */
	public Integer getMode(){
		return mode;
	}
	
	/**
	 * Mutator method to initialize the game, including the Board's initialization and setting up the Players.
	 */
	public void initialize(){
		board.initializeBoard();
		System.out.println("Welcome to Checkers!\n RED will play first.");
		System.out.println("Enter locations when prompted in the form \"x,y\".");
		System.out.println("The board is arranged with 0,0 at the Top-Left," + 
			 " 7,7 at the Bottom-Right.");
		
		boolean valid = false;
		while(!valid){
			System.out.println("Do you want to play 1 or 2 player?");
			
			try { 
				String selection = input.nextLine();
				mode = Integer.parseInt(selection);
				if(mode != 1 && mode != 2) {
					System.out.println("Invalid entry- Setting to 1-player.");
					mode = 1;
				}
				valid = true;
			} catch(IndexOutOfBoundsException e) {
				System.out.print("Invalid entry- try again. ");
			} catch(NumberFormatException e) {
				System.out.print("Invalid entry- try again. ");
			}
		}
		
		switch(mode) {
			case 1:
				System.out.println("Playing against an AI Player.");
				blackPlayer = new AIPlayer(Colour.BLACK,board);
				redPlayer = new HumanPlayer(Colour.RED,board); 
				break;
			case 2: 
				System.out.println("Red will move first.");
				blackPlayer = new HumanPlayer(Colour.BLACK,board);
				redPlayer = new HumanPlayer(Colour.RED,board); 
				break;
		}
		
		board.printArray();
	}
	
	/**
	 * Method to run a single Turn for a Human Player.
	 * <p>A player can move a single Piece in a turn. If they jump a piece, they can continue to move
	 * the same piece, as long as they can continue to jump other pieces.
	 * @param aPlayer The Human Player who's turn it is.
	 */
	private void turn(Player aPlayer){
		board.resetTurn();
		aPlayer.queryPieces();
		if(aPlayer.myPieces.length == 0 || canMove(aPlayer) == false){
			gameOver(aPlayer);
			return;
		}
		
		System.out.println("Turn: "+aPlayer.toString());
		
		Location start = new Location(0,0);
		Location end = new Location(0,0);
			
		while(board.turnComplete() == 0) {
			start = aPlayer.selectStart();
			end = aPlayer.selectEnd(start);
			aPlayer.movePiece(start,end);
		}
		
		board.printArray();
		start = end;
		while(board.turnComplete() == 1 && board.checkSquare(start).emptyJumps(aPlayer).length > 0){
			System.out.println("You took a piece and can continue to move!");
			end = aPlayer.selectEnd(start);
			aPlayer.movePiece(start, end);
			board.printArray();
			start = end;
		}
		board.endTurn();
	}
	
	public void nextTurn(Colour aColour) {
		switch(aColour) {
		case BLACK: turn(blackPlayer);
		case RED: turn(redPlayer);
		}
	}
	
	/*
	 * Accessor method to determine if a Player has any valid moves on the board.
	 */
	private boolean canMove(Player aPlayer) {
		for (int i = 0; i < aPlayer.myPieces.length; i++) {
			if (aPlayer.myPieces[i].emptyMoves(aPlayer).length > 0 
					|| aPlayer. myPieces[i].emptyJumps(aPlayer).length > 0){
				return true;
			} 
		}
		return false;
	}
	
	/*
	 * Method to end the game for a given Player.
	 */
	private void gameOver(Player aPlayer){
		System.out.println(aPlayer.toString()+" no longer has any pieces to move!"
			+ " They lose.");
		gameOver = true;
	}
	
	public boolean gameOver(){
		return gameOver;
	}
}
