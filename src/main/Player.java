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
	public Piece[] myPieces;
	protected Colour playerColour;
	protected int piecesLeft = MAX_PIECES;
	protected final boolean human;
	protected Board board;

	/**
	 * Constructor for creating a Player given a Colour enumeration
	 * 
	 * @param aColour
	 *            the Colour enumeration given
	 */
	public Player(Colour aColour, boolean isHuman, Board board) {
		this.playerColour = aColour;
		this.human = isHuman;
		this.board = board;

	}

	/**
	 * Accessor method to return the Player's Colour
	 * 
	 * @return playerColour the Colour enumeration of the player
	 */
	public Colour getColour() {
		return this.playerColour;
	}

	public void queryPieces() {
		this.myPieces = board.getPieces(this.playerColour);
	}

	public Piece[] getPieces() {
		return this.myPieces;
	}

	public void movePiece(Location start, Location end) {
		board.movePiece(this,start,end);
	}
	
	public void losePiece(){
		piecesLeft -= 1;
	}
	
	public int piecesLeft(){
		return piecesLeft;
	}

	public boolean isHuman(){
		return human;
	}
	
	public String toString(){
		return "Player: " + this.playerColour;
	}
}