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
	protected boolean myTurn;
	protected Piece[] myPieces;
	protected final Colour playerColour;
	protected Board board = Board.getInstance();
	protected Location currentStart, currentEnd;
	protected boolean isHuman;
	
	protected boolean continueMove = false;

	/**
	 * Constructor for creating a Player given a Colour enumeration, its Human status, and the Board instance.
	 * 
	 * @param aColour
	 *            the Colour enumeration given
	 */
	public Player(Colour aColour, Board board) {
		this.playerColour = aColour;
		updatePieces();
	}
	
	/**
	 * @return True if the player is a Human.
	 */
	public boolean isHuman(){
		return isHuman;
	}

	/**
	 * @return playerColour the Colour enumeration of the player
	 */
	public Colour getColour() {
		return this.playerColour;
	}

	/**
	 * <!--Mutator method-->
	 * <ul><li><b>Player</b></li></ul>
	 * <ul>
	 * 	Updates the Players Piece array with the current state of the board. 
	 * 	<p>
	 *	@return myPieces The Players updated Pieces
	 * </ul>
	 */
	public Piece[] updatePieces() {
		return this.myPieces = board.getPieces(this.playerColour);
	}

	/**
	 * <!--Accessor method-->
	 * <ul><li><b>Player</b></li></ul>
	 * <ul>
	 * 	Getter method that gathers, in real time, the amount of Pieces that the current player is holding.
	 * 	<p>
	 * 	@return Piece[] myPieces, an array containing every piece on the board available to the player.
	 * </ul>
	 */
	public Piece[] getPieces() {
		return updatePieces();
	}
	
	public void makeCurrentMove() {
		if(currentStart == null || currentEnd == null || myTurn == false) {
			if(isHuman == false) {
				setStart();
				setEnd();
			} else {
				return;
			}
		}
		
		Move move = new Move(this,currentStart,currentEnd,false);
		
		if (currentEnd.inBounds() == false) {
			return;
		} else if (move.isValid() == false) {
			return;
		}
		
		board.movePiece(this,move);
		
		if(move.isJump(currentStart,currentEnd) 
		&& board.checkSquare(currentEnd).emptyJumps(this).length > 0) {
			System.out.println("This piece can continue to jump.");
			continueMove = true;
			currentStart = currentEnd;
			setEnd();
		} else {
			resetLocations();
			myTurn = false;
		}
	}
	
	public abstract void setStart(Location start);
	public abstract void setEnd(Location end);
	public abstract void setStart();
	public abstract void setEnd();
	
	public Location getStart() { return currentStart; }
	public Location getEnd() { return currentEnd; }
	
	public boolean validStartSelected() {
		return (currentStart != null);
	}
	
	public boolean validEndSelected() {
		return (currentEnd != null);
	}
	
	public void resetLocations(){
		continueMove = false;
		currentStart = null;
		currentEnd = null;
	}
	
	public void myTurn(){
		myTurn = true;
	}
	
	public boolean isMyTurn(){
		return myTurn;
	}
	
	public boolean isContinueMove(){
		return continueMove;
	}
	
	public String toString(){
		return "Player: " + this.playerColour;
	}
}