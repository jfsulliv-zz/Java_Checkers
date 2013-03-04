package main;
import java.util.Scanner;

public class HumanPlayer extends Player {
	Scanner scanner = new Scanner(System.in);

	public HumanPlayer(Colour aColour,Board board) {
		super(aColour,true,board);
	}

	public Location takeInput(boolean pieceSelection){
		queryPieces();
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

		if(pieceSelection) {
	 		if(board.checkSquare(loc).getColour() != this.playerColour) {
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