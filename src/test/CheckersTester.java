package test;
import main.Board;
import main.Colour;
import main.Location;
import main.Player;


public class CheckersTester {
	private String errors = "";
	private Player player1 = new Player(Colour.BLACK);
	private Player player2 = new Player(Colour.RED);
	//private Moves[] isLegal;

	private boolean test_red_piece_moves_up() {
		boolean testPassed = true;
		Board board = new Board();
		board.initializeBoard();
		Location start = new Location(5, 5);
		Location end = new Location(4, 4);
		if (board.checkMove(player2, start, end) == false) {
			testPassed = false;
			errors += String
					.format("test_red_piece_moves_up failed: The starting location is %s and ending"
							+ " location is %s which should work fine. Perhaps"
							+ " a good location to start debugging is in the method checkMove or"
							+ " checkJump in the Board class.", start, end);
		}
		return testPassed;
	}

	private boolean test_red_piece_moves_down() {
		boolean testPassed = true;
		Board board = new Board();
		board.initializeBoard();
		Location start = new Location(5, 5);
		Location end = new Location(4, 4);
		board.movePiece(player2,start, end);
		if (board.checkMove(player2, end, start) == true) {
			testPassed = false;
			errors += String
					.format("test_red_piece_moves_down failed: The starting location is %s and ending"
							+ " location is %s which should'nt work. Perhaps"
							+ " a good location to start debugging is in the method checkMove or"
							+ " checkJump in the Board class.", end, start);
		}
		return testPassed;
	}

	private boolean test_black_piece_moves_down() {
		boolean testPassed = true;
		Board board = new Board();
		board.initializeBoard();
		Location start = new Location(2, 2);
		Location end = new Location(3, 3);
		if (board.checkMove(player1, start, end) == false) {
			testPassed = false;
			errors += String
					.format("test_black_piece_moves_down failed: The starting location is %s and ending"
							+ " location is %s which should work. Perhaps"
							+ " a good location to start debugging is in the method checkMove or"
							+ " checkJump in the Board class.", end, start);
		}
		return testPassed;
	}

	private boolean test_black_piece_moves_up() {
		boolean testPassed = true;
		Board board = new Board();
		board.initializeBoard();
		Location start = new Location(2, 2);
		Location end = new Location(3, 3);
		board.movePiece(player1,start, end);
		if (board.checkMove(player1, end, start) == true) {
			testPassed = false;
			errors += String
					.format("test_black_piece_moves_up failed: The starting location is %s and ending"
							+ " location is %s which shouldn't work. Perhaps"
							+ " a good location to start debugging is in the method checkMove or"
							+ " checkJump in the Board class.", end, start);
		}
		return testPassed;
	}

	private boolean test_black_piece_jumps_legally() {
		boolean testPassed = true;
		Board board = new Board();
		board.initializeBoard();
		Location blackStart = new Location(2, 2);
		Location blackEnd = new Location(3, 3);
		if (board.checkMove(player1, blackStart, blackEnd) == true) {
			board.movePiece(player1,blackStart, blackEnd);
		}
		Location redStart = new Location(5, 5);
		Location redEnd = new Location(4, 4);
		Location blackJump = new Location(5,5);
		if (board.checkMove(player2, redStart, redEnd) == true) {
			board.movePiece(player2,redStart, redEnd);
		}
		
		if (board.checkJump(player1, blackEnd, redEnd, blackJump) == false) {
			testPassed = false;
			errors += String
					.format("test_black_piece_jumps_legally failed: This jump should have" +
							"been perfectly legal. checkJump has failed.");
		}
		return testPassed;
	}

	private boolean test_black_piece_out_of_bound_jump() {
		boolean testPassed = true;
		Board board = new Board();
		board.initializeBoard();
		Location blackStart = new Location(2, 2);
		Location blackEnd = new Location(3, 3);
		if (board.checkMove(player1, blackStart, blackEnd) == true) {
			board.movePiece(player1,blackStart, blackEnd);
		}
		Location redStart = new Location(5, 5);
		Location redEnd = new Location(4, 4);
		Location blackJump = new Location(5,5);
		if (board.checkMove(player2, redStart, redEnd) == true) {
			board.movePiece(player2,redStart, redEnd);
		}
		Location secondRedStart = new Location(6,6);
		Location secondRedEnd = new Location(5,5);
		if (board.checkMove(player2, secondRedStart, secondRedEnd) == true) {
			board.movePiece(player2,secondRedStart, secondRedEnd);
		}
		
		if (board.checkJump(player1, blackEnd, redEnd, blackJump) == false) {
			testPassed = false;
			errors += String
					.format("test_black_piece_out_of_bound_jump failed: This jump shouldn't have" +
							"worked. checkJump has failed.");
		}
		return testPassed;
	}

	private boolean test_red_piece_jumps_legally() {
		boolean testPassed = true;
		Board board = new Board();
		board.initializeBoard();
		Location blackStart = new Location(2, 2);
		Location blackEnd = new Location(3, 3);
		if (board.checkMove(player1, blackStart, blackEnd) == true) {
			board.movePiece(player1,blackStart, blackEnd);
		}
		Location redStart = new Location(5, 5);
		Location redEnd = new Location(4, 4);
		Location redJump = new Location(2,2);
		if (board.checkMove(player2, redStart, redEnd) == true) {
			board.movePiece(player2,redStart, redEnd);
		}
		
		if (board.checkJump(player2, redEnd, blackEnd, redJump) == false) {
			testPassed = false;
			errors += String
					.format("test_red_piece_jumps_legally failed: This jump should have" +
							"been perfectly legal. checkJump has failed.");
		}
		return testPassed;
	}

	private boolean test_red_piece_out_of_bound_jump() {
		boolean testPassed = true;
		Board board = new Board();
		board.initializeBoard();
		Location blackStart = new Location(2, 2);
		Location blackEnd = new Location(3, 3);
		if (board.checkMove(player1, blackStart, blackEnd) == true) {
			board.movePiece(player1,blackStart, blackEnd);
		}
		Location redStart = new Location(5, 5);
		Location redEnd = new Location(4, 4);
		Location redJump = new Location(2,2);
		if (board.checkMove(player2, redStart, redEnd) == true) {
			board.movePiece(player2,redStart, redEnd);
		}
		Location secondBlackStart = new Location(1,1);
		Location secondBlackEnd = new Location(2,2);
		if (board.checkMove(player1, secondBlackStart, secondBlackEnd)) {
			board.movePiece(player1,secondBlackStart, secondBlackEnd);
		}
		if (board.checkJump(player2, redEnd, blackEnd, redJump) == false) {
			testPassed = false;
			errors += String
					.format("test_red_piece_out_of_bound_jump failed: This jump shouldn't have" +
							"worked. checkJump has failed.");
		}
		return testPassed;
	}

	public static void main(String[] args) {
		boolean testsPassed = true;
		CheckersTester test = new CheckersTester();

		testsPassed &= test.test_red_piece_moves_up();
		testsPassed &= test.test_red_piece_moves_down();
		testsPassed &= test.test_black_piece_moves_up();
		testsPassed &= test.test_black_piece_moves_down();
		testsPassed &= test.test_black_piece_jumps_legally();
		testsPassed &= test.test_red_piece_jumps_legally();
		testsPassed &= test.test_black_piece_out_of_bound_jump();
		testsPassed &= test.test_red_piece_out_of_bound_jump();
		
		if (testsPassed) {
			System.out.println("All tests passed");
		} else {
			System.out.println(test.errors);
		}
	}

}
