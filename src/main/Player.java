package main;

/**
 * This class represents our player which owns the pieces, can win, can loose,
 * and can quit.
 * 
 * @author Zsanett
 * 
 */
public class Player {
	public static final int MAX_PIECES = 12;
	public Piece[] pieces = new Piece[MAX_PIECES];
	private Colour playerColour;
	private int piecesLeft = MAX_PIECES;

	/**
	 * Constructor for creating a Player given a Colour enumeration
	 * 
	 * @param aColour
	 *            the Colour enumeration given
	 */
	public Player(Colour aColour) {
		this.playerColour = aColour;

		for (int i = 0; i < MAX_PIECES; i++) {
			pieces[i] = new Piece(playerColour);
		}
	}

	/**
	 * Accessor method to return the Player's Colour
	 * 
	 * @return playerColour the Colour enumeration of the player
	 */
	public Colour getColour() {
		return this.playerColour;
	}
	
	public void losePiece(){
		piecesLeft -= 1;
	}
	
	public int piecesLeft(){
		return piecesLeft;
	}
	
	public String toString(){
		return "Player: " + this.playerColour;
	}
}