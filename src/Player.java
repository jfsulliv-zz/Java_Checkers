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
	/**
	 * Each player owns 12 pieces.
	 */

	public Player(Colour colour) {
		for (int i = 0; i < MAX_PIECES; i++){
			pieces[i] = new Piece(colour);
		}
	}
}