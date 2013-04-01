package main;
import java.util.Random;


/**
 * A computerized Player Subclass. Contains methods to randomly generate new movements,
 * with some preferential determination.
 * <p> Examples of this include preferring to King its own piece, or take enemy Pieces.
 * @author james
 *
 */
public class AIPlayer extends Player {
	private Random generator = new Random();

	/**
	 * Constructor method to call the Player super's constructor given some parameters.
	 * @param aColour The Colour of the AIPlayer to be made.
	 * @param board The singleton instance of the Board.
	 */
	public AIPlayer(Colour aColour,Board board) {
		super(aColour,board);
		isHuman = false;
	}
	
	public void setStart(Location start) {
		currentStart = start;
	}
	
	public void setEnd(Location end) {
		currentEnd = end;
	}
	
	public void setStart(){
		currentStart = selectStart();
	}
	
	public void setEnd(){
		currentEnd = selectEnd();
		
	}
	/*
	 * Accessor Method to return a random, usable Piece's Location for the AIPlayer to move on the Board.
	 * <p>The AIPlayer will seek out any jumps it can perform and prefer those.
	 * @return Location of a Random Piece that can be moved.
	 */
	private Location selectStart(){
		updatePieces(); // AIPlayer's myPieces array is updated to reflect the current board state
		Location[] preferredLocs = new Location[myPieces.length]; // Starting piece locations that have 'preferred' locations to move to
		int numPreferredMoves = 0;
		Location[] otherLocs = new Location[myPieces.length]; // All other starting piece Locations available
		int numOtherMoves = 0;
		
		for(int i = 0; i < myPieces.length; i++){
			Location tempLoc = myPieces[i].getLocation();
			Piece tempPiece = board.checkSquare(tempLoc);
			// If a Piece can jump, its location is added to the Preferred array
			if (tempPiece.emptyJumps(this).length > 0) {
				preferredLocs[numPreferredMoves] = tempLoc; 
				numPreferredMoves++;
			} 
			// If a Piece can be Kinged, its location is added to the Preferred array.
			// For a piece to be Kinged it has to move to the opposite end of the board.
			else if ((tempPiece.getLocation().getY() == 6 && this.playerColour == Colour.BLACK) 
					|| (tempPiece.getLocation().getY() == 1 && this.playerColour == Colour.RED)) {
				if(tempPiece.emptyMoves(this).length > 0 && !tempPiece.isKing()) {
					preferredLocs[numPreferredMoves] = tempLoc; 
					numPreferredMoves++;
				}
			}
			// All other pieces' locations will be added to the Other array if they can move
			else if (tempPiece.emptyMoves(this).length > 0) {
				otherLocs[numOtherMoves] = tempLoc;
				numOtherMoves++;
			}
		}

		// A random Location will be selected from the arrays- PreferredLocs will be checked first.
		if(numPreferredMoves > 0){
			int randomIndex = generator.nextInt(numPreferredMoves);
			System.out.println("Computer selects Piece at " + preferredLocs[randomIndex]);
			return preferredLocs[randomIndex];
		} else if (numOtherMoves > 0) {
			int randomIndex = generator.nextInt(numOtherMoves);
			System.out.println("Computer selects Piece at " + otherLocs[randomIndex]);
			return otherLocs[randomIndex];
		} 
		
		
		return null;
	}

	
	/*
	 * Accessor method to return a valid end-point for the location of the selected Piece.
	 * <p>The AIPlayer will seek out any jumps it can perform, or pieces it could king, and return those.
	 * @return Location of a random movement for the piece.
	 */
<<<<<<< HEAD
	private Location selectEnd(){
=======
	private Location setEnd(){
		pause(3);
>>>>>>> e18325937f5efafd4b7cd146a8a0679965fa64a0
		Piece tempPiece = board.checkSquare(currentStart);
		Location[] allJumps = tempPiece.emptyJumps(this);  // Arrays containing possible movements and jumps
		Location[] allMoves = tempPiece.emptyMoves(this);  // for a given Piece's location.
		
		// If a jump can be made, that will first be selected.
		if(allJumps.length > 0){
			int randomIndex = generator.nextInt(allJumps.length);
			System.out.println("Computer moves to " + allJumps[randomIndex]);
			return allJumps[randomIndex];
		}
		// Otherwise a random move will be selected. If a Piece can be Kinged, that will be selected first.
		else if (allMoves.length > 0) {
			for (int i = 0; i < allMoves.length; i++){
				if ((allMoves[i].getY() == 0 && this.playerColour == Colour.RED) 
				|| (allMoves[i].getY() == 7 && this.playerColour == Colour.BLACK)) {
					return allMoves[i];
				}
			}
			int randomIndex = generator.nextInt(allMoves.length);
			System.out.println("Computer moves to " + allMoves[randomIndex]);
			return allMoves[randomIndex];
		}
		
		
		return null;
	}
	/**
	 * 	<!--Mutator method-->
	 * 
	 * 	<style>
	 * 		#method {
	 * 			text-indent: 10.0px;
	 * 		}
	 * 	</style>
	 * 
	 * 	<ul><li><b>AIPlayer</b></li></ul>
	 * 	<ul><div ID="method">private void pause()</div></ul>
	 * 	<ul>
	 * 		<p>
	 * 			This method pauses the AI players move by a declared number of seconds.
	 * 		</p>
	 * 	</ul>
	 * 	<ul>
	 * 		@param timeToWaitInSeconds The specified time to wait in seconds.
	 * 	</ul>
	 */
	private void pause(int timeToWaitInSeconds) {
		int timeToMilli = 1000 * timeToWaitInSeconds;
		long t0, t1;
        t0 =  System.currentTimeMillis();
        do{
            t1 = System.currentTimeMillis();
        }
        while (t1 - t0 < timeToMilli);
	}
}