
public class BoardTest {
	public static void main(String[] args){
		Board board = new Board();
		board.initializeBoard();
		board.printArray();
		
		Location l1 = new Location(2,2);
		Location l2 = new Location(3,3);
		System.out.print("\n\n\nAfter moving piece at " + l1 + " to " + l2 + "\n");
		board.movePiece(l1,l2);
		
		System.out.println(board.checkSquare(l2));
		board.printArray();
	}
}
