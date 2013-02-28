package test;
import main.Piece;


public class PieceTest{
    public static void main(String[] args){ 
        Piece piece1 = new Piece(0);
        Piece piece2 = new Piece(1);
        
        piece1.makeKing();
        System.out.println("piece1 is expected to be a black king and is " + piece1.getColour() +" and isKing() is: " + piece1.isKing());
        System.out.println("piece2 is expected to be red and not be a king and is " + piece2.getColour() +" and isKing()is: " +piece2.isKing());
        
    }
}