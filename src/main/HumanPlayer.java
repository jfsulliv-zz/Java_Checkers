package main;
import java.util.Scanner;

/**
 * A human Player Subclass. Contains methods to take user input and turn it into a Location.
 * @author james
 *
 */
public class HumanPlayer extends Player {
	Scanner scanner = new Scanner(System.in);

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
	public Location takeInput(boolean pieceSelection){
		if(pieceSelection){
			System.out.print("Please select the piece to move: ");
		} else {
			System.out.print("Enter a location to move to: ");
		}

		int tempX = 0;
		int tempY = 0;
		try {
			String in = scanner.nextLine();
			tempX = Integer.parseInt(in.substring(0,in.indexOf(",")));
			tempY = Integer.parseInt(in.substring(in.indexOf(",") + 1));
		} catch(IndexOutOfBoundsException e) {
			System.out.print("Invalid entry- try again. ");
			takeInput(pieceSelection);
		} catch(NumberFormatException e) {
			System.out.print("Invalid entry- try again. ");
			takeInput(pieceSelection);
		}

		Location loc = new Location(tempX, tempY);

		if(pieceSelection == true) {
			if(board.checkSquare(loc) == null) {
				System.out.println("There is no piece there.");
				takeInput(pieceSelection);
			} else if(board.checkSquare(loc).getColour() != this.playerColour) {
				System.out.println("That is not your piece to move.");
				takeInput(pieceSelection);
			} else if(board.emptyMoves(this,loc) == null 
				&& board.emptyJumps(this,loc) == null) {
				System.out.println("That piece has no available moves.");
				takeInput(pieceSelection);
			}
		}
		return loc;			
	}
}