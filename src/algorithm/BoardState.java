package algorithm;

import main.Board;
import main.Colour;
import main.Game;
import main.Location;
import main.Move;
import main.OutOfBoundsException;
import main.Piece;
import main.Player;

/**
 * A representation of a single Board State, including information on its evaluated score.
 * @author james
 *
 */
public class BoardState{
	Player whoseTurn, otherPlayer;
	Player rootPlayer;
	int scoreRed, scoreBlack;
	int netScore;
	boolean terminalNode;
	Board currentBoard;
	Piece[] availablePieces;
	
	/**
	 * Constructor method for the BoardState.
	 * @param whoseTurn The Player whose turn it is.
	 * @param lastBoard The last instance of the Board to be generated from.
	 * @param rootPlayer The Root Player, for use in the evaluative functions.
	 */
	public BoardState(Player whoseTurn, Board lastBoard, Player rootPlayer){
		this.whoseTurn = whoseTurn;
		
		switch(whoseTurn.getColour()){
		case BLACK: otherPlayer = Game.getInstance().getRed();
					break;
		case RED: otherPlayer = Game.getInstance().getBlack();
					break;
		}
		
		this.rootPlayer = rootPlayer;
		this.currentBoard = lastBoard.cloneBoard(lastBoard);
		availablePieces = currentBoard.getPieces(whoseTurn.getColour());
	}
	
	/**
	 * Method to find all available moves on the Board for the current Player.
	 * @return Move[] containing all moves available to the current Player.
	 */
	public Move[] findMoves(){
		Move[] possibleMoves = new Move[64];
		int numMoves = 0;
		
		int index = 0;
		for(Piece p : availablePieces){
			for(Move m : availablePieces[index].getAllMoves(whoseTurn, currentBoard, false)){
				possibleMoves[numMoves] = m;
				numMoves++;
			}
			index++;
		}
		
		Move[] allMovesTrimmed = new Move[numMoves];
		for(int i = 0; i < numMoves; i++){
			allMovesTrimmed[i] = possibleMoves[i];
		}
		return allMovesTrimmed;
		
	}
	
	/**
	 * Evaluation function on the board.
	 * @return Integer score of the board, positive if favoring the Root player.
	 */
	public int calculateScore() {
		for(int row = 0; row < Board.BOARD_ROWS; row++) {
			for(int col = 0; col < Board.BOARD_ROWS; col++){
				Location loc = null;
				try {
					loc = new Location(col,row);
				} catch (OutOfBoundsException e) {
					System.exit(1);
				}
				if (currentBoard.checkSquare(loc) == null){
					continue;
				} 
				
				else if (currentBoard.checkSquare(loc).getColour() == Colour.RED){
					scoreRed++;
					
					if((1 < loc.getX() || loc.getX() < 6) &&
							(1 < loc.getY() || loc.getY() < 6)){
						scoreRed++;
					} 
					
					if(currentBoard.checkSquare(loc).isKing()) {
						scoreRed+=2;
					} 
					
					if(whoseTurn.getColour() == Colour.RED){
						if(currentBoard.checkSquare(loc).getAllMoves(whoseTurn, currentBoard, false).length == 0){
							scoreRed-=1;
						}
					} else {
						if(currentBoard.checkSquare(loc).getAllMoves(otherPlayer, currentBoard, false).length == 0){
							scoreBlack-=1;
						}
					}
				} 
				
				else if (currentBoard.checkSquare(loc).getColour() == Colour.BLACK){
					scoreBlack++;
					
					if((1 < loc.getX() || loc.getX() < 6) &&
							(1 < loc.getY() || loc.getY() < 6)){
						scoreBlack++;
					} 
					
					if(currentBoard.checkSquare(loc).isKing()){
						scoreBlack+=2;
					}
					
					if(whoseTurn.getColour() == Colour.BLACK){
						if(currentBoard.checkSquare(loc).getAllMoves(whoseTurn, currentBoard, false).length == 0){
							scoreBlack-=1;
						}
					} else {
						if(currentBoard.checkSquare(loc).getAllMoves(otherPlayer, currentBoard, false).length == 0){
							scoreRed-=1;
						}
					}
				}
			}
		}

		if(currentBoard.getPieces(rootPlayer.getColour()).length == 0){
			netScore = Integer.MIN_VALUE;
			return netScore;
		} else if(currentBoard.getPieces(otherPlayer.getColour()).length == 0) {
			netScore = Integer.MAX_VALUE;
			return netScore;
		}
		
		switch(rootPlayer.getColour()){
			case BLACK: 
					netScore = scoreBlack - scoreRed;
					break;
					
			case RED: netScore = scoreRed - scoreBlack;
					break;
		}
		
		return netScore;
		
	}
	
	/**
	 * @return True if the game is over.
	 */
	boolean gameOver(){
		if(currentBoard.getPieces(Colour.BLACK).length == 0 ||
				currentBoard.getPieces(Colour.RED).length == 0){
			return true;
		}
		return false;
	}
}
