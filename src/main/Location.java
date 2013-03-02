package main;

/**
 * A Location Class. Holds X,Y Coordinates on the board.
 * 
 * @param xCoordinate
 *            the X-position
 * @param yCoordinate
 *            the Y-position
 * @author James Sullivan
 */

public class Location {
	private final int xCoordinate;
	private final int yCoordinate;

	/**
	 * Constructor from integer x,y coordinates
	 * <p>
	 * Pre-Condition: 0 <= x < 8; 0 <= y < 8
	 */
	public Location(int x, int y) {
		this.xCoordinate = x;
		this.yCoordinate = y;
	}

	/**
	 * Accessor method for X-position.
	 * 
	 * @return X-Coordinate
	 */
	public int getX() {
		return this.xCoordinate;
	}

	/**
	 * Accessor method for Y-position.
	 * 
	 * @return Y-Coordinate
	 */
	public int getY() {
		return this.yCoordinate;
	}

	public String toString() {
		return xCoordinate + "," + yCoordinate;
	}

}
