

public enum Colour {
	BLACK(1),RED(2);
	public final int id;
	
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

