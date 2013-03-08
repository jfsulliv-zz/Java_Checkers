package test;

import main.Board;
import main.HumanPlayer;

public class TestBlackPlayer {

	private String errors = " ";
	private Board board = new Board();
	private HumanPlayer player1, player2;

	private boolean black_moves_too_far_down() {
		boolean testPassed = true;
		board.initializeBoard();
		if (testPassed) {
			testPassed = false;
			errors += String
					.format("black_moves_too_far_down failed: Black should not"
							+ " be able to move too far down. \n");
		}
		return testPassed;
	}

	private boolean black_moves_to_a_space_occupied_by_black() {
		boolean testPassed = true;
		board.initializeBoard();
		if (testPassed) {
			testPassed = false;
			errors += String
					.format("black_moves_to_a_space_occupied_by_black failed: "
							+ "Black should not be able to move a space occupied by a friendly. \n");
		}
		return testPassed;
	}

	private boolean black_moves_to_a_space_occupied_by_red() {
		boolean testPassed = true;
		board.initializeBoard();
		if (testPassed) {
			testPassed = false;
			errors += String
					.format("black_moves_to_a_space_occupied_by_red failed: Black"
							+ " should not be able to move to a space occupied by a red. \n");
		}
		return testPassed;
	}

	private boolean black_moves_up() {
		boolean testPassed = true;
		board.initializeBoard();
		if (testPassed) {
			testPassed = false;
			errors += String.format("black_moves_up failed: Black should not"
					+ " be able to move up. \n");
		}
		return testPassed;
	}

	private boolean black_moves_down() {
		boolean testPassed = true;
		board.initializeBoard();
		if (testPassed) {
			testPassed = false;
			errors += String.format("black_moves_down failed: Black should be"
					+ " able to move down. \n");
		}
		return testPassed;
	}

	private boolean black_jumps_a_red_piece_to_an_empty_space() {
		boolean testPassed = true;
		board.initializeBoard();
		if (testPassed) {
			testPassed = false;
			errors += String
					.format("black_jumps_a_red_piece_to_an_empty_space failed: "
							+ " Black should have been able to jump a red piece to a space"
							+ " that is not occupied by any piece. \n");
		}
		return testPassed;
	}

	private boolean black_jumps_a_red_piece_to_an_occupied_space() {
		boolean testPassed = true;
		board.initializeBoard();
		if (testPassed) {
			testPassed = false;
			errors += String
					.format("black_jumps_a_red_piece_to_an_occupied_space failed: "
							+ "Black should not be able to jump a red piece to a space"
							+ " that is occupied by any colour. \n");
		}
		return testPassed;
	}

	private boolean black_jumps_a_friendly_piece() {
		boolean testPassed = true;
		board.initializeBoard();
		if (testPassed) {
			testPassed = false;
			errors += String
					.format("black_jumps_a_friendly_piece failed: Black should "
							+ "not be able to jump a friendly piece. \n");
		}
		return testPassed;
	}

	private boolean black_jumps_an_empty_space() {
		boolean testPassed = true;
		board.initializeBoard();
		if (testPassed) {
			testPassed = false;
			errors += String
					.format("black_jumps_an_empty_space failed: Black should not be able"
							+ " to jump \"nothing\". \n");
		}
		return testPassed;
	}

	private boolean black_jumps_too_far() {
		boolean testPassed = true;
		board.initializeBoard();
		if (testPassed) {
			testPassed = false;
			errors += String.format("black_jumps_too_far failed: Black"
					+ " should not be able to jump greater than 2 rows. \n");
		}
		return testPassed;
	}

	private boolean black_attempts_moving_black_piece() {
		boolean testPassed = true;
		board.initializeBoard();
		if (testPassed) {
			testPassed = false;
			errors += String
					.format("black_attempts_moving_black_piece failed: "
							+ "Black should not be able to move a red piece. \n");
		}
		return testPassed;
	}

	public static void main(String[] args) {
		boolean testsPassed = true;
		TestBlackPlayer test = new TestBlackPlayer();
		
		testsPassed &= test.black_moves_too_far_down();
		testsPassed &= test.black_moves_to_a_space_occupied_by_black();
		testsPassed &= test.black_moves_to_a_space_occupied_by_red();
		testsPassed &= test.black_moves_up();
		testsPassed &= test.black_moves_down();
		testsPassed &= test.black_jumps_a_red_piece_to_an_empty_space();
		testsPassed &= test.black_jumps_a_red_piece_to_an_occupied_space();
		testsPassed &= test.black_jumps_a_friendly_piece();
		testsPassed &= test.black_jumps_an_empty_space();
		testsPassed &= test.black_jumps_too_far();
		testsPassed &= test.black_attempts_moving_black_piece();
		
		if (testsPassed) {
			System.out.println("All tests passed");
		} else {
			System.out.println(test.errors);
		}
	}

}
