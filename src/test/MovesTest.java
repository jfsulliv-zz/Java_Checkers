package test;
import main.*;


public class MovesTest {

	public static void main(String[] args) {
		Location start = new Location(1,2);
		Location end = new Location(3,5);
		
		Moves move = new Moves(start, end);
		
		if(move.isJump() == true) {
			System.out.println("The user attempted a jump.");
		}
		else {
			System.out.println("This was not a jump.");
		}
	}

}
