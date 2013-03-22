<<<<<<< HEAD
package main;


/**
 * Class containing information and checks on a movement from one location to the next.
 * @author james
 *
 */
public class Move {
	private boolean valid;
	private Board board = Board.getInstance();
	private Location start, end;
	private Player owner;
	
	/**
	 * @param aPlayer The player making the Move.
	 * @param start The start location.
	 * @param end The end location.
	 * @param silentMovementChecks Whether the checks should be done silently or not.
	 */
	public Move(Player aPlayer, Location start, Location end, boolean silentMovementChecks){
		this.owner = aPlayer;
		this.start = start;
		this.end = end;
		this.valid = validMove(silentMovementChecks);
		
	}
	
	/**
	 * @return start Location
	 */
	public Location getStart(){
		return start;
	}
	
	/**
	 * @return end Location
	 */
	public Location getEnd(){
		return end;
	}
	
	/**
	 * @return true if the Move is a valid one.
	 */
	public boolean isValid() { 
		return valid;
	}
	
	/**
	 * Checks to see if a given move is a Jump or not (moving across two spaces)
	 * @param start The starting location
	 * @param end The ending location
	 * @return true if the movement is a Jump.
	 */
	public boolean isJump(Location start, Location end){
		if (board.deltaX(start,end) == 2 && board.deltaY(start,end) == 2){
			return true;
		} return false;
	}
	
	/**
	 * Accessor method that will check the general case legality of a move.
	 * Ensures that all moves performed are legal.
	 * 
	 * 
	 * @param owner
	 *            the owner owner of the moved Piece.
	 * @param start
	 *            the Starting Location.
	 * @param end
	 *            the Ending location.
	 * 
	 * @return true if the move is valid.
	 */
	public boolean validMove(boolean silentMovementChecks) {
		int maxDistance;
		if (isJump(start,end)) {
			maxDistance = 2;
		} else {
			maxDistance = 1;
		}
		
		if (board.checkSquare(start) == null) {
			if(!silentMovementChecks) {System.out.println("No piece on that starting position."); }
			return false;
		} else if (board.checkSquare(end) != null) {
			if(!silentMovementChecks) { System.out.println("The end position is already taken."); }
			return false;
		} else if (board.checkSquare(start).getColour() != owner.getColour()) {
			if(!silentMovementChecks) {System.out.println("That is not your piece.");}
			return false;
		} else if (board.deltaX(start, end) != maxDistance || board.deltaY(start, end) != maxDistance) {
			if(!silentMovementChecks) {System.out.println("You cannot move that far."); }
			return false;
		} else if (board.checkSquare(start).isKing() == false) {
			if (end.getY() >= start.getY() && owner.getColour() == Colour.RED) {
				if(!silentMovementChecks) { System.out.println("That piece can only move up."); }
				return false;
			} else if (end.getY() <= start.getY() && owner.getColour() == Colour.BLACK) {
				if(!silentMovementChecks) { System.out.println("That piece can only move down."); }
				return false;
			} 
		} 
		
		if(isJump(start,end) == false) { return true; } 
		else { return validJump(silentMovementChecks); } // A series of checks pertaining to Jumps will be made

	}

	/**
	 * Accessor method that contains checks applicable to a piece that is jumping.
	 * @param silentMovementChecks Whether the checks should be done silently or not.
	 * @return true if the movement is a legal jump.
	 */
	public boolean validJump(boolean silentMovementChecks) {
		int tempY = (end.getY() + start.getY()) / 2;
		int tempX = (end.getX() + start.getX()) / 2;
		Location middle;
		
		try {
			middle = new Location(tempX, tempY);
		} catch(OutOfBoundsException oobe) {
			return false;
		}
 
		if (board.checkSquare(middle) == null) {
			if(!silentMovementChecks) { System.out.println("No piece to jump over."); }
			return false;
		} else if (board.checkSquare(middle).getColour() == board.checkSquare(start).getColour()) {
			if(!silentMovementChecks) { System.out.println("You cannot jump your own chip."); }
			return false;
		} else if (start.getX() + 1 == middle.getX()) {
			if (start.getX() + 2 != end.getX()) {
				if(!silentMovementChecks) { System.out.println("You can only jump in a straight line."); }
				return false;
			}
		} else if (start.getX() - 1 == middle.getX()) {
			if (start.getX() - 2 != end.getX()) {
				if(!silentMovementChecks) { System.out.println("You can only jump in a straight line."); }
				return false;
			}
		}
		
		return true;
	}

	
	public String toString(){
		if(start != null && end != null){
			return (start.toString()+"to "+end.toString()+". Valid: "+valid);
		}
		return("Invalid");
	}
}
=======
package main;


/**
 * Class containing information and checks on a movement from one location to the next.
 * @author james
 *
 */
public class Move {
	private boolean valid;
	private Board board = Board.getInstance();
	private Location start, end, empty;
	private Player owner;
	
	/**
	 * @param aPlayer The player making the Move.
	 * @param start The start location.
	 * @param end The end location.
	 * @param silentMovementChecks Whether the checks should be done silently or not.
	 */
	public Move(Player aPlayer, Location start, Location end, boolean silentMovementChecks){
		this.owner = aPlayer;
		this.start = start;
		this.end = end;
		this.valid = validMove(silentMovementChecks);
		this.empty = new Location(0,0);
	}
	
	/**
	 * @return start Location
	 */
	public Location getStart(){
		return start;
	}
	
	/**
	 * @return end Location
	 */
	public Location getEnd(){
		return end;
	}
	
	/**
	 * @return true if the Move is a valid one.
	 */
	public boolean isValid() { 
		return valid;
	}
	
	/**
	 * Checks to see if a given move is a Jump or not (moving across two spaces)
	 * @param start The starting location
	 * @param end The ending location
	 * @return true if the movement is a Jump.
	 */
	public boolean isJump(Location start, Location end){
		if (board.deltaX(start,end) == 2 && board.deltaY(start,end) == 2){
			return true;
		} return false;
	}
	
	/**
	 * Accessor method that will check the general case legality of a move.
	 * Ensures that all moves performed are legal.
	 * 
	 * 
	 * @param owner
	 *            the owner owner of the moved Piece.
	 * @param start
	 *            the Starting Location.
	 * @param end
	 *            the Ending location.
	 * 
	 * @return true if the move is valid.
	 */
	public boolean validMove(boolean silentMovementChecks) {
		int maxDistance;
		if (isJump(start,end)) {
			maxDistance = 2;
		} else {
			maxDistance = 1;
		}
		
		if (board.checkSquare(start) == null) {
			if(!silentMovementChecks) {System.out.println("No piece on that starting position."); }
			return false;
		} else if (board.checkSquare(end) != null) {
			if(!silentMovementChecks) { System.out.println("The end position is already taken."); }
			return false;
		} else if (board.checkSquare(start).getColour() != owner.getColour()) {
			if(!silentMovementChecks) {System.out.println("That is not your piece.");}
			return false;
		} else if (board.deltaX(start, end) != maxDistance || board.deltaY(start, end) != maxDistance) {
			if(!silentMovementChecks) {System.out.println("You cannot move that far."); }
			return false;
		} else if (board.checkSquare(start).isKing() == false) {
			if (end.getY() >= start.getY() && owner.getColour() == Colour.RED) {
				if(!silentMovementChecks) { System.out.println("That piece can only move up."); }
				return false;
			} else if (end.getY() <= start.getY() && owner.getColour() == Colour.BLACK) {
				if(!silentMovementChecks) { System.out.println("That piece can only move down."); }
				return false;
			} 
		} 
		
		if(isJump(start,end) == false) { return true; } 
		else { return validJump(silentMovementChecks); } // A series of checks pertaining to Jumps will be made

	}

	/**
	 * Accessor method that contains checks applicable to a piece that is jumping.
	 * @param silentMovementChecks Whether the checks should be done silently or not.
	 * @return true if the movement is a legal jump.
	 */
	public boolean validJump(boolean silentMovementChecks) {
		int tempY = (end.getY() + start.getY()) / 2;
		int tempX = (end.getX() + start.getX()) / 2;
		Location middle = new Location(tempX, tempY);

		if (board.checkSquare(middle) == null) {
			if(!silentMovementChecks) { System.out.println("No piece to jump over."); }
			return false;
		} else if (board.checkSquare(middle).getColour() == board.checkSquare(start).getColour()) {
			if(!silentMovementChecks) { System.out.println("You cannot jump your own chip."); }
			return false;
		} else if (start.getX() + 1 == middle.getX()) {
			if (start.getX() + 2 != end.getX()) {
				if(!silentMovementChecks) { System.out.println("You can only jump in a straight line."); }
				return false;
			}
		} else if (start.getX() - 1 == middle.getX()) {
			if (start.getX() - 2 != end.getX()) {
				if(!silentMovementChecks) { System.out.println("You can only jump in a straight line."); }
				return false;
			}
		}
		
		return true;
	}

	
	public String toString(){
		if(start != null && end != null){
			return (start.toString()+"to "+end.toString()+". Valid: "+valid);
		}
		return("Invalid");
	}
}
>>>>>>> Updated MouseHandlers and partial GUI implemented
