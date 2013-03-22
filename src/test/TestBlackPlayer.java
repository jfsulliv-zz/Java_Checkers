package test;

import main.*;
/**
 * Tester class to perform a series of test cases on the Black Player's movements.
 * Tests a wide variety of posible legal and illegal movements.
 *
 */
public class TestBlackPlayer {

	private String errors = " ";
	private Board board = Board.getInstance();
	private HumanPlayer playerRed = new HumanPlayer(Colour.RED, board);
	private HumanPlayer playerBlack = new HumanPlayer(Colour.BLACK, board);
	private static boolean SILENT = true;
	
	private void setup() {
		board.resetBoard();
	}

	private boolean black_moves_too_far_down() throws OutOfBoundsException {
		setup();
		boolean testPassed = true;
		Location start = new Location(0,2);
		Location end = new Location(2,3);
		Move move = new Move(playerBlack,start,end,SILENT);
		if(move.isValid()) {
			testPassed = false;
			errors += String
					.format("black_moves_too_far_down failed: Black should not"
							+ " be able to move too far down. \n");
		}
		return testPassed;
	}

	private boolean black_moves_to_a_space_occupied_by_black() throws OutOfBoundsException {
		setup();
		boolean testPassed = true;
		Location start = new Location(1,1);
		Location end = new Location(2,2);
		Move move = new Move(playerBlack,start,end,SILENT);
		if(move.isValid()) {
			testPassed = false;
			errors += String
					.format("black_moves_to_a_space_occupied_by_black failed: "
							+ "Black should not be able to move a space occupied by a friendly. \n");
		}
		return testPassed;
	}

	private boolean black_moves_to_a_space_occupied_by_red() throws OutOfBoundsException {
		setup();
		boolean testPassed = true;
		Location blackStart = new Location(2,2);
		Location redStart = new Location(1,5);
		Location redMid = new Location(0,4);
		Location end = new Location(1,3);
		playerRed.movePiece(redStart,redMid);
		playerRed.movePiece(redMid,end);
		Move move = new Move(playerBlack,blackStart,end,SILENT);
		if(move.isValid()) {
			testPassed = false;
			errors += String
					.format("black_moves_to_a_space_occupied_by_red failed: Black"
							+ " should not be able to move to a space occupied by a red. \n");
		}
		return testPassed;
	}

	private boolean black_moves_up() throws OutOfBoundsException {
		setup();
		boolean testPassed = true;
		Location start = new Location(2,2);
		Location end = new Location(3,3);
		playerBlack.movePiece(start,end);
		Move move = new Move(playerBlack,start,end,SILENT);
		if(move.isValid()) {
			testPassed = false;
			errors += String.format("black_moves_up failed: Black should not"
					+ " be able to move up. \n");
		}
		return testPassed;
	}

	private boolean black_moves_down() throws OutOfBoundsException {
		setup();
		boolean testPassed = true;
		Location start = new Location(6,2);
		Location end = new Location(5,3);
		Move move = new Move(playerBlack,start,end,SILENT);
		if(!move.isValid()) {
			testPassed = false;
			errors += String.format("black_moves_down failed: Black should be"
					+ " able to move down. \n");
		}
		return testPassed;
	}

	private boolean black_jumps_a_red_piece_to_an_empty_space() throws OutOfBoundsException {
		setup();
		boolean testPassed = true;
		Location blackStart = new Location(2,2);
		Location blackEnd = new Location(3,3);
		Location redStart = new Location(1,5);
		Location redEnd = new Location(2,4);
		playerBlack.movePiece(blackStart,blackEnd);
		playerRed.movePiece(redStart,redEnd);
		Move move = new Move(playerBlack,blackEnd,redStart,SILENT);
		if(!move.isValid()) {
			testPassed = false;
			errors += String
					.format("black_jumps_a_red_piece_to_an_empty_space failed: "
							+ " Black should have been able to jump a red piece to a space"
							+ " that is not occupied by any piece. \n");
		}
		return testPassed;
	}

	private boolean black_jumps_a_red_piece_to_an_occupied_space() throws OutOfBoundsException {
		setup();
		boolean testPassed = true;
		Location blackStart = new Location(2,2);
		Location blackMid = new Location(1,3);
		Location blackEnd = new Location(3,5);
		Location red1Start = new Location(1,5);
		Location red1End = new Location(2,4);
		playerRed.movePiece(red1Start,red1End);
		playerBlack.movePiece(blackStart,blackMid);
		Move move = new Move(playerBlack,blackMid,blackEnd,SILENT);
		if(move.isValid()) {
			testPassed = false;
			errors += String
					.format("black_jumps_a_red_piece_to_an_occupied_space failed: "
							+ "Black should not be able to jump a red piece to a space"
							+ " that is occupied by any colour. \n");
		}
		return testPassed;
	}

	private boolean black_jumps_a_friendly_piece() throws OutOfBoundsException {
		setup();
		boolean testPassed = true;
		Location start = new Location(1,1);
		Location end = new Location(3,3);
		Move move = new Move(playerBlack,start,end,SILENT);
		if(move.isValid()) {
			testPassed = false;
			errors += String
					.format("black_jumps_a_friendly_piece failed: Black should "
							+ "not be able to jump a friendly piece. \n");
		}
		return testPassed;
	}

	private boolean black_jumps_too_far() throws OutOfBoundsException {
		setup();
		boolean testPassed = true;
		Location blackStart = new Location(4,2);
		Location redStart = new Location(1,5);
		Location redMid = new Location(2,4);
		Location redEnd = new Location(3,3);
		playerRed.movePiece(redStart,redMid);
		playerRed.movePiece(redMid,redEnd);
		Move move = new Move(playerBlack,blackStart,redStart,SILENT);
		if(move.isValid()) {
			testPassed = false;
			errors += String.format("black_jumps_too_far failed: Black"
					+ " should not be able to jump greater than 2 rows. \n");
		}
		return testPassed;
	}

	private boolean black_attempts_moving_black_piece() throws OutOfBoundsException {
		setup();
		boolean testPassed = true;
		Location redStart = new Location(1,5);
		Location redEnd = new Location(2,4);
		Move move = new Move(playerBlack,redStart,redEnd,SILENT);
		if(move.isValid()) {
			testPassed = false;
			errors += String
					.format("black_attempts_moving_black_piece failed: "
							+ "Black should not be able to move a red piece. \n");
		}
		return testPassed;
	}

	public void run() throws OutOfBoundsException {
		boolean testsPassed = true;
		TestBlackPlayer test = new TestBlackPlayer();
		
		try {
			testsPassed &= test.black_moves_too_far_down();
			testsPassed &= test.black_moves_to_a_space_occupied_by_black();
			testsPassed &= test.black_moves_to_a_space_occupied_by_red();
			testsPassed &= test.black_moves_up();
			testsPassed &= test.black_moves_down();
			testsPassed &= test.black_jumps_a_red_piece_to_an_empty_space();
			testsPassed &= test.black_jumps_a_red_piece_to_an_occupied_space();
			testsPassed &= test.black_jumps_a_friendly_piece();
			testsPassed &= test.black_jumps_too_far();
			testsPassed &= test.black_attempts_moving_black_piece();
		} catch (OutOfBoundsException oobe){
			System.out.println("There was an error in the tested Locations!");
			testsPassed = false;
		}
		if (testsPassed) {
			System.out.println("All tests on Black pieces passed\n\n");
		} else {
			System.out.println(test.errors + "\n\n");
		}
	}

}

