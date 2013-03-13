package main;

/**
 * A Player class with subtypes HumanPlayer and AIPlayer. Holds information about the Player and their pieces.
 * 
 * @param myPieces - Piece Array containing all of the Player's remaining Pieces.
 * @param playerColour - Colour Enumeration denoting the Player's Colour.
 * @param human - Boolean parameter of whether the Player is a Human or not.
 * @param Board - The Board object's instance to be referenced in some methods.
 * 
 * @author Zsanett
 * 
 */
public abstract class Player {
	protected Piece[] myPieces;
	protected final Colour playerColour;
	protected final boolean human;
	protected Board board = Board.getInstance();

	/**
	 * Constructor for creating a Player given a Colour enumeration, its Human status, and the Board instance.
	 * 
	 * @param aColour
	 *            the Colour enumeration given
	 */
	public Player(Colour aColour, boolean isHuman, Board board) {
		this.playerColour = aColour;
		this.human = isHuman;
		queryPieces();
	}

	/**
	 * Accessor method to return the Player's Colour
	 * 
	 * @return playerColour the Colour enumeration of the player
	 */
	public Colour getColour() {
		return this.playerColour;
	}

	/**
	 * Mutator method to update the Player's Piece array with the current state of the board.
	 */
	public void queryPieces() {
		this.myPieces = board.getPieces(this.playerColour);
	}

	/**
	 * Accessor method to return the Player's Piece array.
	 * @return
	 */
	public Piece[] getPieces() {
		return this.myPieces;
	}

	/**
	 * A method for the player to send the Movement command to the Board.
	 * @param start - The starting location
	 * @param end - The ending location
	 */
	public void movePiece(Location start, Location end) {
		Boolean silent = false;
		Move move = new Move(this,start,end,silent);
		if (end.inBounds() == false) {
			return; 
		} else if (move.isValid() == false) {
			return;
		}
		board.movePiece(this,move);
	}

	/**
	 * An Accessor method to return the Human status of the Player.
	 * @return true if the Player is a Human.
	 */
	public boolean isHuman(){
		return human;
	}
	
	public abstract Location selectStart();
	public abstract Location selectEnd(Location start);
	
	public String toString(){
		return "Player: " + this.playerColour;
	}
}