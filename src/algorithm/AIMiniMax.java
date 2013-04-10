package algorithm;

import main.*;

/**
 * MiniMax Algorithm to recursively search a tree of movements and evaluate the ideal path.
 * @author james
 *
 */
public class AIMiniMax {
	static final int MAX_DEPTH = 4;
	public Move best;
	Player player, opponent;
	
	/**
	 * Constructor for the AIMiniMax class.
	 * @param player The player for whom the tree will be searched.
	 */
	public AIMiniMax(Player player){
		this.player = player;
		switch(player.getColour()){
			case BLACK: opponent = Game.getInstance().getRed();
						break;
			case RED: opponent = Game.getInstance().getBlack();
						break;
		}
	}
	
	/**
	 * Recursive tree evaluation method to find the best root movement a player could make, by scoring each node state.
	 * @param depth The current depth of the recursive search.
	 * @param someBoard The last state of the board.
	 * @param signFactor A sign factor to multiply the score by every turn change- Scores will always be from the root player's perspective.
	 * @return Best Integer score of any node underneath the current Node.
	 */
	public int evaluateMovementTree(int depth, BoardState someBoard, int signFactor){
		if(depth >= MAX_DEPTH || someBoard.gameOver()){
			return someBoard.calculateScore();
		}
		
		Move[] moves = someBoard.findMoves();
		
		int posValue = Integer.MIN_VALUE;
		for(Move m : moves){
			
			BoardState newState = makeMove(someBoard,m);
			
			int newValue = 0;
			
			// If the move is a jump that can be continued, a separate function is called to evalutate that tree.
			if(newState.currentBoard.turnComplete() == 1){
				newValue = signFactor * evaluateChainJumpTree(depth, newState, signFactor, m);
			} else {
				newValue = signFactor * evaluateMovementTree(depth + 1, newState, -signFactor);
			}
			
			// The highest scored node will have its root set as the best movement.
			if(newValue > posValue) { 
				if(depth == 0){
					best = m;
				}
				posValue = newValue;
			}
		}
		
		return signFactor * posValue;
		
		
	}
	
	/*
	 * Secondary evaluation tree for a chain of Jumps.
	 * This is recursively called until all chains have been explored, at which time the regular tree will be called.
	 */
	private int evaluateChainJumpTree(int depth, BoardState someBoard, int signFactor, Move parentMove){
		Player player = someBoard.whoseTurn;
		Board aBoard = someBoard.currentBoard;
		Move[] moves = aBoard.checkSquare(parentMove.getEnd()).getAllMoves(player, aBoard, true);
		
		if(moves.length == 0){
			return signFactor * someBoard.calculateScore();
		}
		
		int posValue = Integer.MIN_VALUE;
		for(Move m : moves){
			BoardState newState = makeMove(someBoard,m);
			int newValue = 0;
			
			if(newState.currentBoard.turnComplete() == 1){
				newValue = signFactor * evaluateChainJumpTree(depth, newState, signFactor, m);
			} else {
				newValue = signFactor * evaluateMovementTree(depth + 1, newState, -signFactor);
			}
			
			if(newValue > posValue) { 
				posValue = newValue;
			}
		}
		
		return posValue;
	}
	
	/*
	 * Method to generate a new BoardState from a given movement.
	 */
	BoardState makeMove(BoardState lastState, Move aMove){
		BoardState newState;
		
		// The current player will switch every movement
		if(lastState.whoseTurn.getColour() == player.getColour()){
			newState = new BoardState(opponent, lastState.currentBoard, player);
		} 
		else {
			newState = new BoardState(player, lastState.currentBoard, player);
		}
		
		newState.currentBoard.movePiece(lastState.whoseTurn, aMove);
		
		//If the player can still move, it is still their turn.
		if(newState.currentBoard.turnComplete() == 1){
			newState.whoseTurn = lastState.whoseTurn;
		}
		
		return newState;
	}
	
}
