/**
 *  A Checkers Piece. Holds information on piece colour, and King status.
 *  <p> King status determines whether the piece can move bidirectionally.
 *
 *  @param king Boolean of king status
 *  @param Colour enum of Colour (BLACK(1)/RED(2))
 *  @author James Sullivan
 */

public class Piece {
	/**
	 * Enum for holding Piece Colour.
	 * <p> BLACK = 1 <p> RED = 2
	 */
    public enum Colour {
    	BLACK(1),RED(2);
    	
        public final int id;
        Colour(int id){ this.id = id; }
        
        public int getID(){ return this.id; }
    }
    
    private boolean king = false;
    private final Colour colour;
    
    public Piece(Colour aColour){
        this.colour =  aColour;
    }
    
    /**
     *  Mutator method to King-a- a piece.
     *  <p> Post-Condition: Piece becomes a King.
     */
    public void makeKing() {
        king = true;    
    }
    
    /**
     *  Accessor method to see King status.
     *  @return true if the piece is a King.
     */
    public boolean isKing() {
        return king;    
    }
    
    public String toString() {
        return colour.toString() + " is King: " + king;
    }
    
}

