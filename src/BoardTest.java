
/**
    *Tests the Board class by initializing a game board
    *and printing it to the screen, along with testing
    *the methods movePiece() and checkSquare() and printing the 
    *results to the screen following the initialized board.
    *@author Dylan Dobbyn
    */
public class BoardTest {
    public static void main(String[] args){
       Board board = new Board();
       int[][] boardArray = board.intializeBoard();
       board.printArray();
       System.out.print("\n\n\nAfter moving piece at 2,2 to 3,3\n");
       
       Location l1 = new Location(2,2);
       Location l2 = new Location(3,3);
       
       board.movePiece(l1,l2);
       System.out.println(board.checkSquare(l2));
       board.printArray();
    }
}
   