package main;

/**
 * A Checkers Piece. Holds information on piece colour, and King status.
 * <p>
 * King status determines whether the piece can move bidirectionally.
 * 
 * @param king
 *            Boolean of king status
 * @param Colour
 *            enum of colour (BLACK("B")/RED("R"))
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

	/**
	 * Constructor using an integer parameter to set colour Pre-Condition: int
	 * aColour is 0(BLACK) or 1(RED)
	 */
	public Piece(int aColour) {
		this.king = false;
		if (aColour == 0 || aColour == 1) {
			this.colour = Colour.values()[aColour]; // Enum.values()[ordinal]
													// will return the
													// corresponding enumeration
		} else {
			this.colour = null;
			System.out.print("Invalid colour");
		}

	}

	/**
	 * Mutator method to King-a- a piece.
	 * <p>
	 * Post-Condition: Piece becomes a King.
	 */
	public void makeKing() { king = true; }
/**
	 * Accessor method to see King status.
	 * 
	 * @return true if the piece is a King.
	 */
	public boolean isKing() { return king; }

	public Location getLocation(){ return location; }
	
	public void setLocation(Location newLoc) {
		this.location = newLoc;
		if(newLoc.getY() == 0 && this.colour == Colour.RED){
			makeKing();
		} else if(newLoc.getY() == 7 && this.colour == Colour.BLACK){
			makeKing();
		}
	}

	/**
	 * Accessor method to return the Piece's colour.
	 * 
	 * @return Colour enumeration of the piece
	 */
	public Colour getColour() {
		return colour;
	}
	
	/**
	 * Accessor Method to return an array of all of the empty movements available to the Piece.
	 * @param player The Player who owns the Piece to be moved.
	 * @param start The Location the Piece starts in.
	 * @return An array that contains any and all movements a piece could legally make.
	 */
	public Location[] emptyMoves(Player owner){
		boolean silent = true;
		int numMoves = 0;
		Location[] maxMoves = new Location[4];

		for(int x = -1; x <= 1; x += 2) {
			for(int y = -1; y <= 1; y += 2){
				int tempX = location.getX() + x;
				int tempY = location.getY() + y;
				Location tempLoc = new Location(tempX,tempY);
				Move move = new Move(owner,location,tempLoc,silent);
				if(tempLoc.inBounds() && move.isValid()) { 
					maxMoves[numMoves] = tempLoc;
					numMoves++;
				}
 			}
		}

		Location[] legalMoves = new Location[numMoves];
		for(int index = 0; index < numMoves; index++) {
			legalMoves[index] = maxMoves[index];
		}
		return legalMoves;
	}	
	
	/**
	 * Accessor Method to return an array of all of the empty jumps from a given location.
	 * @param player The Player who owns the Piece to be moved.
	 * @param start The Location the Piece starts in.
	 * @return An array that contains any and all jumps a piece could legally make.
	 */
	public Location[] emptyJumps(Player owner){
		boolean silent = true;
		int numMoves = 0;
		Location[] maxJumps = new Location[4];

		for(int x = -2; x <= 2; x += 4){
			for(int y = -2; y <= 2; y += 4){
				int tempX = location.getX() + x;
				int tempY = location.getY() + y;
				Location tempLoc = new Location(tempX,tempY);
				Move move = new Move(owner,location,tempLoc,silent);
				if (tempLoc.inBounds() && move.isValid()){
					maxJumps[numMoves] = tempLoc;
					numMoves++;
				}
			}
		}

		Location[] legalJumps = new Location[numMoves];
		for(int index = 0; index < numMoves; index++){
			legalJumps[index] = maxJumps[index];
		}		
		return legalJumps;
	}
	
	public String toString() {
		if(king) {
			return colour.toString();
		} else {
			return colour.toString().toLowerCase();
		}
	}
}
