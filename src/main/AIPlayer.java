package main;
import java.util.Random;

import algorithm.AIMiniMax;
import algorithm.BoardState;


/**
 * A computerized Player Subclass. Contains methods to randomly generate new movements,
 * with some preferential determination.
 * <p> Examples of this include preferring to King its own piece, or take enemy Pieces.
 * @author james
 *
 */
public class AIPlayer extends Player {
	private Random generator = new Random();
	private Move bestMove;

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
		if(bestMove == null){
			setBestMove();
		}
		currentStart = bestMove.getStart();
	}
	
	public void setEnd(){
		// A null bestMove indicates that the player must continue to move in a given direction.
		if(bestMove == null){
			Location[] possibleEnds = board.checkSquare(currentStart).emptyJumps(this, board);
			currentEnd = possibleEnds[generator.nextInt(possibleEnds.length)];
		} else {
			currentEnd = bestMove.getEnd();
		}
		
		bestMove = null;
		
	}
	
	/**
	 * Sets the player's best movement based on a MiniMax algorithm.
	 * If no favourable moves are found (ie 100% loss scenarios),a random move is selected.
	 */
	public void setBestMove(){
		BoardState b = new BoardState(this,board, this);
		AIMiniMax alg = new AIMiniMax(this);
		alg.evaluateMovementTree(0,b,1);
		bestMove = alg.best;
		
		if(bestMove == null){
			Piece selectedPiece = myPieces[generator.nextInt(myPieces.length)];
			Move[] availableMoves = selectedPiece.getAllMoves(this, board, false);
			bestMove = availableMoves[generator.nextInt(availableMoves.length)];
		}
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