package main;
/**
 * 
 * This class simply checks whether the desired move is a jump or not. This
 * class does not check whether the move is legal or a proper jump even, that
 * will be done in another class that will utilize this class.
 * 
 * 
 * @author Daniel
 * 
 */
public class Moves {

	private Location start, end;

	public Moves(Location start, Location end) {
		this.start = start;
		this.end = end;
	}

	public boolean isJump() {

		return ((start.getX() - end.getX() == 2) || (start.getX() - end.getX() == -2));

	}
}
