public class BoardTest {
    public static void main(String[] args){
       Board board = new Board();
       int[][] boardArray = board.intializeBoard();
       board.printArray();
       System.out.print("\n\n\n");
       
       Location l1 = new Location(2,2);
       Location l2 = new Location(3,3);
       
       board.movePiece(l1,l2);
       board.printArray();
    }
}
   