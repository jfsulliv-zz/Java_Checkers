package test;

import main.Board;
import main.Colour;
import main.HumanPlayer;
import main.Location;
import main.Move;

public class TestRedPlayer {
	
	private static boolean SILENT = true;
	private String errors = " ";
	private Board board = Board.getInstance();
	private HumanPlayer playerRed = new HumanPlayer(Colour.RED, board);
	private HumanPlayer playerBlack = new HumanPlayer(Colour.BLACK, board);

	private void setup() {
		board.resetBoard();
	}
	
	private boolean red_moves_too_far_up() {
		setup();
		Location start = new Location(1,5);
		Location end = new Location(2,3);
		boolean testPassed = true;
		Move move = new Move(playerRed,start,end,SILENT);
		if(move.isValid()) {
			testPassed = false;
			errors += String
					.format("red_moves_too_far_up failed: Red should not be able to move "
							+ "too far up, but did. \n");
		}
		return testPassed;
	}

	private boolean red_moves_to_a_space_occupied_by_black() {
		setup();
		Location blackStart = new Location( 0,2);
		Location blackMiddle = new Location(1,3);
		Location blackEnd = new Location(2,4);
		Location redStart = new Location(1,5);
		playerBlack.movePiece(blackStart,blackMiddle);
		playerBlack.movePiece(blackMiddle, blackEnd);
		boolean testPassed = true;
		Move move = new Move(playerRed,redStart,blackEnd,SILENT);
		if(move.isValid()) {
			testPassed = false;
			errors += String
					.format("red_moves_to_a_space_occupied_by_black failed: Red "
							+ "should not be able to move to a space occupied by a black piece. \n");
		}
		return testPassed;
	}

	private boolean red_moves_to_a_space_occupied_by_red() {
		setup();
		Location redStart = new Location(2,6);
		Location redEnd = new Location(3,5);
		boolean testPassed = true;
		Move move = new Move(playerRed,redStart,redEnd,SILENT);
		if(move.isValid()) {
			testPassed = false;
			errors += String
					.format("red_moves_to_a_space_occupied_by_red failed: Red should"
							+ " not be able to move to a space occupied by a friendly piece. \n");
		}
		return testPassed;
	}

	private boolean red_moves_up() {
		setup();
		Location start = new Location(1,5);
		Location end = new Location(2,4);
		boolean testPassed = true;
		Move move = new Move(playerRed,start,end,SILENT);
		if(!move.isValid()) {
			testPassed = false;
			errors += String
					.format("red_moves_up failed: Red should be able to "
							+ "move up. \n");
		}
		return testPassed;
	}

	private boolean red_moves_down() {
		setup();
		Location start = new Location(1,5);
		Location end = new Location(2,4);
		boolean testPassed = true;
		playerRed.movePiece(start, end);
		Move move = new Move(playerRed,end,start,SILENT);
		if(move.isValid()) {
			testPassed = false;
			errors += String.format("red_moves_down failed: Red should not be"
					+ " able to move down.\n");
		}
		return testPassed;
	}

	private boolean red_jumps_a_black_piece_to_an_empty_space() {
		setup();
		Location blackStart = new Location(0,2);
		Location blackMiddle = new Location(1,3);
		Location blackEnd = new Location(2,4);
		Location redStart = new Location(1,5);
		Location redEnd = new Location(3,3);
		playerBlack.movePiece(blackStart,blackMiddle);
		playerBlack.movePiece(blackMiddle, blackEnd);
		boolean testPassed = true;
		Move move = new Move(playerRed,redStart,redEnd,SILENT);
		if(!move.isValid()) {
			testPassed = false;
			errors += String
					.format("red_jumps_a_black_piece_to_an_empty_space failed: Red"
							+ " should be able to make this jump on a black to an empty space. \n");
		}
		return testPassed;
	}

	private boolean red_jumps_a_black_piece_to_an_occupied_space() {
		setup();
		Location blackStart = new Location(0,2);
		Location blackMiddle = new Location(1,3);
		Location redStart = new Location(1,5);
		Location redMiddle= new Location(0,4);
		Location redEnd = new Location(2,2);
		playerBlack.movePiece(blackStart,blackMiddle);
		playerRed.movePiece(redStart, redMiddle);
		boolean testPassed = true;
		Move move = new Move(playerRed,redMiddle,redEnd,SILENT);
		if(move.isValid()) {
			testPassed = false;
			errors += String
					.format("red_jumps_a_black_piece_to_an_occupied_space failed: Red"
							+ " should not be able to jump a black piece, to a spot that is"
							+ " already occupied by any piece. \n");
		}
		return testPassed;
	}

	private boolean red_jumps_a_friendly_piece() {
		setup();
		boolean testPassed = true;
		Location redStart = new Location(1,5);
		Location redEnd = new Location(2,4);
		Location otherRedStart = new Location(3,5);
		Location otherRedEnd = new Location(1,3);
		playerRed.movePiece(redStart,redEnd);
		Move move = new Move(playerRed,otherRedStart,otherRedEnd,SILENT);
		if(move.isValid()) {
			testPassed = false;
			errors += String
					.format("red_jumps_a_friendly_piece failed: Red should not"
							+ " be able to jump a friendly. \n");
		}
		return testPassed;
	}

	private boolean red_jumps_an_empty_space() {
		setup();
		Location start = new Location(1,5);
		Location end = new Location(3,3);
		boolean testPassed = true;
		Move move = new Move(playerRed,start,end,SILENT);
		if(move.isValid()) {
			testPassed = false;
			errors += String
					.format("red_jumps_an_empty_space failed: Red should not be"
							+ " able to jump \"nothing\".\n");
		}
		return testPassed;
	}

	private boolean red_jumps_too_far() {
		setup();
		Location blackStart = new Location(0,2);
		Location blackMiddle = new Location(1,3);
		Location blackEnd = new Location(2,4);
		Location otherBlackStart = new Location(4,2);
		Location otherBlackEnd = new Location(4,2);
		Location redStart = new Location(1,5);
		Location redEnd = new Location(5,3);
		playerBlack.movePiece(blackStart,blackMiddle);
		playerBlack.movePiece(blackMiddle, blackEnd);
		playerBlack.movePiece(otherBlackStart, otherBlackEnd);
		boolean testPassed = true;
		Move move = new Move(playerRed,redStart,redEnd,SILENT);
		if(move.isValid()) {
			testPassed = false;
			errors += String.format("red_jumps_too_far failed: Red should not"
					+ " be able to jump more than 2 rows. \n");
		}
		return testPassed;
	}

	private boolean red_attempts_moving_black_piece() {
		setup();
		Location start = new Location(2,2);
		Location end = new Location(3,3);
		boolean testPassed = true;
		Move move = new Move(playerRed,start,end,SILENT);
		if(move.isValid()) {
			testPassed = false;
			errors += String.format("red_attempts_moving_black_piece failed: "
					+ "Red should not be able to move a black piece. \n");
		}
		return testPassed;
	}

	public void run() {
		boolean testsPassed = true;
		TestRedPlayer test = new TestRedPlayer();

		testsPassed &= test.red_moves_too_far_up();
		testsPassed &= test.red_moves_to_a_space_occupied_by_black();
		testsPassed &= test.red_moves_to_a_space_occupied_by_red();
		testsPassed &= test.red_moves_up();
		testsPassed &= test.red_moves_down();
		testsPassed &= test.red_jumps_a_black_piece_to_an_empty_space();
		testsPassed &= test.red_jumps_a_black_piece_to_an_occupied_space();
		testsPassed &= test.red_jumps_a_friendly_piece();
		testsPassed &= test.red_jumps_an_empty_space();
		testsPassed &= test.red_jumps_too_far();
		testsPassed &= test.red_attempts_moving_black_piece();
		
		if (testsPassed) {
			System.out.println("All tests on Red Pieces passed\n\n");
		} else {
			System.out.println(test.errors + "\n\n");
		}
	}

}

