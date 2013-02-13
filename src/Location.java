/**
 *  A Location Class. Holds X,Y Coordinates on the board.
 *  @param xCoordinate the X-position
 *  @param yCoordinate the Y-position
 *  @author James Sullivan
 */

public class Location {
    private final int xCoordinate;
    private final int yCoordinate;
    
    public Location(int x,int y){
        if (x > 0 && y > 0 && x <= 8 && y <= 8){
            this.xCoordinate = x;
            this.yCoordinate = y;
        } else {
            System.out.print("Invalid coordinates");
            this.xCoordinate = 1;
            this.yCoordinate = 1;
        }
    }
    
    /**
     *  Accessor method for X-position.
     *  @return X-Coordinate
     */
    public int getX() {
        return this.xCoordinate;
    }
    
    /**
     *  Accessor method for Y-position.
     *  @return Y-Coordinate
     */
    public int getY() {
        return this.yCoordinate;
    }
    
    public String toString() {
        return xCoordinate + "," + yCoordinate;
    }
    
}
