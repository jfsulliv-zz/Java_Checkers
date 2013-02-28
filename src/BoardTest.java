
public class BoardTest {
	public static void main(String[] args) {
		Player player1 = new Player(Colour.BLACK);
		Player player2 = new Player(Colour.RED);

		Board board = new Board();
		board.initializeBoard();

		Location l1 = new Location(2, 2);
		Location l2 = new Location(3, 3);
		if (board.checkMove(player1, l1, l2) == true) {
			board.movePiece(l1, l2);
		}

		Location l3 = new Location(5, 5);
		Location l4 = new Location(4, 4);
		if (board.checkMove(player2, l3, l4) == true) {
			System.out.println("This test illistrates a move being made, first the pieces make" +
					" two legal moves.");
			board.movePiece(l3, l4);
		}

		board.printArray();
		if (board.checkJump(player1, l2, l4, l3) == true) {
			board.movePiece(l2, l3);
			System.out.println("\nValid jump made.\n");
			System.out.println("Here the red piece has been jumped by the black and removed.");
			board.printArray();
		} else {
			System.out.println("Invalid move made.");
			board.printArray();
		}

	}
}
