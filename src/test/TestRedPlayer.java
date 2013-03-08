package test;

import main.Board;
import main.Colour;
import main.HumanPlayer;
import main.Location;

public class TestRedPlayer {

	private String errors = " ";
	private Board board = new Board();
	private HumanPlayer playerRed = new HumanPlayer(Colour.RED, board);
	private HumanPlayer playerBlack = new HumanPlayer(Colour.BLACK, board);

	private void setup() {
		board.resetBoard();
	}
	
	private boolean red_moves_too_far_up() {
		boolean testPassed = true;
		board.initializeBoard();
		if (testPassed) {
			testPassed = false;
			errors += String
					.format("red_moves_too_far_up failed: Red should not be able to move "
							+ "too far up, but did. \n");
		}
		return testPassed;
	}

	private boolean red_moves_to_a_space_occupied_by_black() {
		boolean testPassed = true;
		board.initializeBoard();
		if (testPassed) {
			testPassed = false;
			errors += String
					.format("red_moves_to_a_space_occupied_by_black failed: Red "
							+ "should not be able to move to a space occupied by a black piece. \n");
		}
		return testPassed;
	}

	private boolean red_moves_to_a_space_occupied_by_red() {
		boolean testPassed = true;
		board.initializeBoard();
		if (testPassed) {
			testPassed = false;
			errors += String
					.format("red_moves_to_a_space_occupied_by_red failed: Red should"
							+ " not be able to move to a space occupied by a friendly piece. \n");
		}
		return testPassed;
	}

	private boolean red_moves_up() {
		boolean testPassed = true;
		board.initializeBoard();
		if (testPassed) {
			testPassed = false;
			errors += String
					.format("red_moves_up failed: Red should be able to "
							+ "move up. \n");
		}
		return testPassed;
	}

	private boolean red_moves_down() {
		boolean testPassed = true;
		board.initializeBoard();
		if (testPassed) {
			testPassed = false;
			errors += String.format("red_moves_down failed: Red should not be"
					+ " able to move down.\n");
		}
		return testPassed;
	}

	private boolean red_jumps_a_black_piece_to_an_empty_space() {
		boolean testPassed = true;
		board.initializeBoard();
		if (testPassed) {
			testPassed = false;
			errors += String
					.format("red_jumps_a_black_piece_to_an_empty_space failed: Red"
							+ " should be able to make this jump on a black to an empty space. \n");
		}
		return testPassed;
	}

	private boolean red_jumps_a_black_piece_to_an_occupied_space() {
		boolean testPassed = true;
		board.initializeBoard();
		if (testPassed) {
			testPassed = false;
			errors += String
					.format("red_jumps_a_black_piece_to_an_occupied_space failed: Red"
							+ " should not be able to jump a black piece, to a spot that is"
							+ " already occupied by any piece. \n");
		}
		return testPassed;
	}

	private boolean red_jumps_a_friendly_piece() {
		boolean testPassed = true;
		board.initializeBoard();
		if (testPassed) {
			testPassed = false;
			errors += String
					.format("red_jumps_a_friendly_piece failed: Red should not"
							+ " be able to jump a friendly. \n");
		}
		return testPassed;
	}

	private boolean red_jumps_an_empty_space() {
		boolean testPassed = true;
		board.initializeBoard();
		if (testPassed) {
			testPassed = false;
			errors += String
					.format("red_jumps_an_empty_space failed: Red should not be"
							+ " able to jump \"nothing\".\n");
		}
		return testPassed;
	}

	private boolean red_jumps_too_far() {
		boolean testPassed = true;
		board.initializeBoard();
		if (testPassed) {
			testPassed = false;
			errors += String.format("red_jumps_too_far failed: Red should not"
					+ " be able to jump more than 2 rows. \n");
		}
		return testPassed;
	}

	private boolean red_attempts_moving_black_piece() {
		boolean testPassed = true;
		board.initializeBoard();
		if (testPassed) {
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
			System.out.println("All tests passed");
		} else {
			System.out.println(test.errors);
		}
	}

}
