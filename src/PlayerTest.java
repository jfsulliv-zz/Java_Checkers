public class PlayerTest {
	public static void main(String[] args){
		Player p1 = new Player(Colour.BLACK);
		if (p1.pieces[0].colour == p1.playerColour){
			System.out.println("The first player has been initialized, as colour "+ p1.playerColour.toString());
		}
		Player p2 = new Player(Colour.RED);
		if (p2.pieces[0].colour == p2.playerColour){
			System.out.println("The second player has been initialized, as colour "+ p2.playerColour.toString());
		}
		
		Piece test = new Piece(1);
		System.out.println("The test piece's colour should be BLACK, and is " + test.colour.toString());
	}
}