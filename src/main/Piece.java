package main;

import java.util.ArrayList;

import algorithm.BoardState;

/**
 * A Checkers Piece. Holds information on piece colour, location, and King status.
 * <p>
 * Additionally holds methods to determine all available movements a Piece could make.
 * <p>
 * King status determines whether the piece can move bidirectionally.
 * 
 * @author James Sullivan
 */

public class Piece {
	private boolean king;
	private Colour colour;
	private Location location;

	/**
	 * Constructor using a Colour enumeration
	 * 
	 * @param aColour
	 *            A Colour enumeration
	 */
	public Piece(Colour aColour, Location aLocation) {
		this.colour = aColour;
		this.location = aLocation;
		
	}

	/*
	 * Private Mutator method to King a piece.
	 */
	private void makeKing() { king = true; }
	
	/**
	 * Accessor method to see King status.
	 * 
	 * @return true if the piece is a King.
	 */
	public boolean isKing() { return king; }

	/**
	 * Accessor method to determine Piece location.
	 * @return Location of the Piece
	 */
	public Location getLocation(){ return location; }
	
	/**
	 * Mutator method to change the Piece's location. Piece becomes a King if necessary.
	 * @param newLoc The new location of the Piece.
	 */
	public void setLocation(Location newLoc) {
		if(newLoc.inBounds() == false) {
			return;
		}
		
		this.location = newLoc;
		if(newLoc.getY() == 0 && this.colour == Colour.RED){
			makeKing();
		} else if(newLoc.getY() == 7 && this.colour == Colour.BLACK){
			makeKing();
		}
	}

	/**
	 * Accessor method to return the Piece's colour.
	 * @return Colour enumeration of the piece
	 */
	public Colour getColour() {
		return colour;
	}
	
	/**
	 * Accessor Method to return a Location array of all of the empty movements available to the Piece.
	 * @param player The Player who owns the Piece to be moved.
	 * @param start The Location the Piece starts in.
	 * @return An array that contains any and all movements a piece could legally make.
	 */
	public Location[] emptyMoves(Player owner, Board aBoard){
		boolean silentMovementChecks = true;
		int numMoves = 0;
		Location[] maxMoves = new Location[4];

		for(int x = -1; x <= 1; x += 2) {		// Check all squares of distance +/-1 
			for(int y = -1; y <= 1; y += 2){	// located diagonally from the Piece
				int tempX = location.getX() + x;
				int tempY = location.getY() + y;
				Location tempLoc;
				
				try {
					tempLoc = new Location(tempX,tempY);
				} catch (OutOfBoundsException oobe) {
					continue;
				}
				
				Move move = new Move(owner,location,tempLoc, aBoard, silentMovementChecks);
				if(tempLoc.inBounds() && move.isValid()) { 
					maxMoves[numMoves] = tempLoc;	// All valid locations will be added to a temporary Array
					numMoves++;
				}
 			}
		}

		Location[] legalMoves = new Location[numMoves];
		for(int index = 0; index < numMoves; index++) {	// A new array of correct length is generated
			legalMoves[index] = maxMoves[index];		// and returned
		}
		return legalMoves;
	}	
	
	/**
	 * Accessor Method to return a Location array of all of the empty jumps from a given location.
	 * @param player The Player who owns the Piece to be moved.
	 * @param start The Location the Piece starts in.
	 * @return An array that contains any and all jumps a piece could legally make.
	 */
	public Location[] emptyJumps(Player owner, Board aBoard){
		boolean silentMovementChecks = true;
		int numMoves = 0;
		Location[] maxJumps = new Location[4];

		for(int x = -2; x <= 2; x += 4){		// Check all squares of distance +/- 2
			for(int y = -2; y <= 2; y += 4){	// located diagonally from the Piece
				int tempX = location.getX() + x;
				int tempY = location.getY() + y;
				Location tempLoc;
				
				try {
					tempLoc = new Location(tempX,tempY);
				} catch (OutOfBoundsException oobe) {
					continue;
				}
				
				Move move = new Move(owner,location,tempLoc, aBoard, silentMovementChecks);
				if (tempLoc.inBounds() && move.isValid()){
					maxJumps[numMoves] = tempLoc;	// All valid locations will be added to a temporary Array
					numMoves++;
				}
			}
		}

		Location[] legalJumps = new Location[numMoves];
		for(int index = 0; index < numMoves; index++){	// A new array of correct Length is generated
			legalJumps[index] = maxJumps[index];		// and returned
		}
		return legalJumps;
	}
	
	
	/**
	 * Returns a list of all movements for a given piece, with a given Board.
	 * @param owner The owner of the Piece.
	 * @param aBoard a given Board.
	 * @param jumpsOnly a boolean of whether only jumps will be searched.
	 * @return A Move[] containing all of the legal moves the Piece could make.
	 */
	public Move[] getAllMoves(Player owner, Board aBoard, boolean jumpsOnly){
		Location[] moves = emptyMoves(owner, aBoard);
		Location[] jumps = emptyJumps(owner, aBoard);
		
		Move[] allMoves;
		
		if(owner.getColour() != colour){
			return new Move[0];
		}
		
		if(jumpsOnly){
			allMoves = new Move[jumps.length];
		} else {
			allMoves = new Move[moves.length + jumps.length];
		}
		
		int index = 0;
		if(jumpsOnly == false){
			for(Location move: moves){
				Move m = new Move(owner,location,move,aBoard,true);
				allMoves[index] = m;
				index++;
			}
		}
		
		for(Location jump: jumps){
			Move m = new Move(owner,location,jump,aBoard,true);
			allMoves[index] = m;
			index++;
		}
		
		return allMoves;
		
	}
	
	public String toString() {
		if(king) {
			return colour.toString();
		} else {
			return colour.toString().toLowerCase();
		}
	}
}
