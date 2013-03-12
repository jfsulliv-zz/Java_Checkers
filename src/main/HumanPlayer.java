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
	 * Accessor Method to take user input and return a valid Location on the board.
	 * <p>This method handles both selection of a Piece and selection of where to move it. Extra
	 * checks apply if the Player is selecting a Piece to move.
	 * @param pieceSelection whether the Player is selecting its Piece to move or not.
	 * @return Location of a Random Piece that can be moved.
	 */
	public Location selectStart(){
		System.out.print("Please select the Piece to move: ");
		Location start = takeInput();
		
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
	
	
	public Location selectEnd(Location start) {
		boolean silent = false;
		System.out.print("Enter a location to move to: ");
		Location end = takeInput();
		
		Move move = new Move(this,start,end,silent);
		if (move.isValid() == false){
			if(board.turnComplete() == 0){
				start = selectStart();
				selectEnd(start);
			} else {
				System.out.print("Invalid location. ");
				selectEnd(start);
			}
		} return end;
	}
	
	
	public Location takeInput(){
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