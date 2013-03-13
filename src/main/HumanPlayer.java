package main;
import java.util.Scanner;

/**
 * A human Player Subclass. Contains methods to take user input and turn it into a Location.
 * @author james
 *
 */
public class HumanPlayer extends Player {
	private Scanner scanner = new Scanner(System.in);

	/**
	 * Constructor method to call the Player Super's constructor given some parameters.
	 * @param aColour The Colour of the HumanPlayer to be made.
	 * @param board The instance of the Board.
	 */
	public HumanPlayer(Colour aColour,Board board) {
		super(aColour,true,board);
	}

	/**
	 * Accessor Method to determine, validate and return  a starting Piece for a Player to move.
	 * 
	 * @return Location of a Random Piece that can be moved.
	 */
	public Location selectStart(){
		System.out.print("Please select the Piece to move: ");
		Location start = takeInput();
		
		
		// Recursion is used while invalid input is given. Only when the input is correct
		// will a Location be returned.
		Piece tempPiece = board.checkSquare(start);
		if(tempPiece == null) {
			System.out.println("There is no piece there.");
			start = selectStart();
		} else if(tempPiece.getColour() != this.playerColour) {
			System.out.println("That is not your piece to move.");
			start = selectStart();
		} else if(tempPiece.emptyMoves(this).length == 0 
				&& tempPiece.emptyJumps(this).length == 0) {
			System.out.println("That piece has no available moves.");
			start = selectStart();
		}
		return start;			
	}
	
	/** 
	 * Accessor Method to determine, validate and return an end location for the Player to move.
	 * 
	 * @param Start Location
	 * @return End Location
	 */
	public Location selectEnd(Location start) {
		boolean silent = false;
		System.out.print("Enter a location to move to: ");
		Location end = takeInput();
		
		// Again recursion is used to protect from invalid input, the function will
		// call itself (or the selectStart() method) until valid input is given.
		Move move = new Move(this,start,end,silent);
		if (move.isValid() == false){
			if(board.turnComplete() == 0){
				start = selectStart();	// The player will have the opportunity to reselect the Start position.
				selectEnd(start);
			} else {
				System.out.print("Invalid location. ");	// The player cannot select a new Starting piece 
				selectEnd(start);						// (was performing a second jump).
			}
		} return end;
	}
	
	/*
	 * Private method to take String input and check for validity.
	 * If the string is valid, it will be converted to a usable Location.
	 * 
	 * Correct format: "int,int"
	 */
	private Location takeInput(){
		int tempX = 0;
		int tempY = 0;
		try {
			String in = scanner.nextLine();
			tempX = Integer.parseInt(in.substring(0,in.indexOf(",")));
			tempY = Integer.parseInt(in.substring(in.indexOf(",") + 1));
		} catch(IndexOutOfBoundsException e) {
			System.out.print("Invalid entry- try again. ");
			takeInput();
		} catch(NumberFormatException e) {
			System.out.print("Invalid entry- try again. ");
			takeInput();
		}
		Location loc = new Location(tempX, tempY);
		return loc;
	}
}