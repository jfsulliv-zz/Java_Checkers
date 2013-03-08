package main;
import java.util.Random;


/**
 * A computerized Player Subclass. Contains methods to randomly generate new movements,
 * with some preferential determination.
 * @author james
 *
 */
public class AIPlayer extends Player {
	private Random generator = new Random();

	/**
	 * Constructor method to call the Player Super's constructor given some parameters.
	 * @param aColour The Colour of the AIPlayer to be made.
	 * @param board The instance of the Board.
	 */
	public AIPlayer(Colour aColour,Board board) {
		super(aColour,false, board);
	}

	
	/**
	 * Accessor Method to return a valid, random Piece for the AIPlayer to move on the Board.
	 * <p>The AIPlayer will seek out any jumps it can perform and prefer those.
	 * @return Location of a Random Piece that can be moved.
	 */
	public Location randomStart(){
		Location[] preferredLocs = new Location[12];
		int tempIndex1 = 0;
		Location[] otherLocs = new Location[12];
		int tempIndex2 = 0;
		for(int i = 0; i < myPieces.length; i++){
			Location tempLoc = myPieces[i].getLocation();
			if (board.emptyJumps(this,tempLoc).length == 0 && board.emptyMoves(this, tempLoc).length == 0) {
				continue;
			} if (board.emptyJumps(this,tempLoc).length > 0) {
				preferredLocs[tempIndex1] = tempLoc;
				tempIndex1++;
			} else if (board.emptyMoves(this,tempLoc).length > 0) {
				otherLocs[tempIndex2] = tempLoc;
				tempIndex2++;
			}
		}

		if(tempIndex1 > 0){
			int randomIndex = generator.nextInt(tempIndex1);
			System.out.println("Computer selects Piece at " + preferredLocs[randomIndex]);
			return preferredLocs[randomIndex];
		} else if (tempIndex2 > 0) {
			int randomIndex = generator.nextInt(tempIndex2);
			System.out.println("Computer selects Piece at " + otherLocs[randomIndex]);
			return otherLocs[randomIndex];
		}

		return null;
	}

	
	/**
	 * Accessor method to return a valid end-point for the location of the selected Piece.
	 * <p>The AIPlayer will seek out any jumps it can perform and prefer those.
	 * @param start The starting location of a Piece that has some valid moves.
	 * @return Location of a random movement for the piece.
	 */
	public Location randomEnd(Location start){
		Location[] allJumps = board.emptyJumps(this,start);
		Location[] allMoves = board.emptyMoves(this,start);
		
		if(allJumps.length > 0){
			int randomIndex = generator.nextInt(allJumps.length);
			System.out.println("Computer moves to " + allJumps[randomIndex]);
			return allJumps[randomIndex];
		} else if (allMoves.length > 0) {
			int randomIndex = generator.nextInt(allMoves.length);
			System.out.println("Computer moves to " + allMoves[randomIndex]);
			return allMoves[randomIndex];
		} else {
			return null;
		}
	}
}