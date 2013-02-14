/**
 * Enumerated type for Colour, used by various other Checkers components <p>
 * BLACK = 1; RED = 2;
 * 
 * @author James Sullivan
 *
 */
public enum Colour {
	BLACK(1),RED(2);
	private final int id;
	
    Colour(int id){ this.id = id; }
    
    public int getID(){ return this.id; }
    
    public Colour fromID(int x) {
    	switch(x) {
    	case 1:
    		return BLACK;
    	
    	case 2:
    		return RED;
    	}
    	return null;
    }	
}

