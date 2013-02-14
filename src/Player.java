/**
 * This class represents our player which owns the pieces, can win, can loose,
 * and can quit.
 * 
 * @author Zsanett
 * 
 */
public class Player {
	public static final int MAX_PIECES = 12;
	Piece[] pieces = new Piece[MAX_PIECES];
	public Colour playerColour;
	/**
	 * Each player owns 12 pieces.
	 */

	public Player(Colour aColour) {
		this.playerColour = aColour;
		
		for (int i = 0; i < MAX_PIECES; i++){
			pieces[i] = new Piece(playerColour);
		}
	}
}