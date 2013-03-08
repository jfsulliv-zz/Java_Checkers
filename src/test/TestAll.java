package test;
import main.*;

public class TestAll {

	private String errors = " ";
	private Board board = new Board();
	private HumanPlayer player1, player2;
	private AIPlayer AIPlayer;
	
	// Red test cases (Human) 
	private boolean red_moves_too_far_up() {
		return false;
	}
	private boolean red_moves_to_a_space_occupied_by_black() {
		return false;
	}
	private boolean red_moves_to_a_space_occupied_by_red() {
		return false;
	}
	private boolean red_moves_up() {
		return false;
	}
	private boolean red_moves_down() {
		return false;
	}
	private boolean red_jumps_a_black_piece_to_an_empty_space() {
		return false;
	}
	private boolean red_jumps_a_black_piece_to_an_occupied_space() {
		return false;
	}
	private boolean red_jumps_a_friendly_piece() {
		return false;
	}
	private boolean red_jumps_an_empty_space() {
		return false;
	}
	private boolean red_jumps_too_far() {
		return false;
	}
	
	// Black test cases (Human)
	private boolean black_moves_too_far_down() {
		return false;
	}
	private boolean black_moves_to_a_space_occupied_by_black() {
		return false;
	}
	private boolean black_moves_to_a_space_occupied_by_red() {
		return false;
	}
	private boolean black_moves_up() {
		return false;
	}
	private boolean black_moves_down() {
		return false;
	}
	private boolean black_jumps_a_red_piece_to_an_empty_space() {
		return false;
	}
	private boolean black_jumps_a_red_piece_to_an_occupied_space() {
		return false;
	}
	private boolean black_jumps_a_friendly_piece() {
		return false;
	}
	private boolean black_jumps_an_empty_space() {
		return false;
	}
	private boolean black_jumps_too_far() {
		return false;
	}
	
	// All other test cases
	private boolean user_attempts_to_move_wrong_piece() {
		return false;
	}
	
	public static void main(String[] args) {
		boolean testsPassed = true;
		TestAll test = new TestAll();
		
		testsPassed &= test.red_moves_too_far_up();
		
		if (testsPassed) {
			System.out.println("All tests passed");
		} else {
			System.out.println(test.errors);
		}
	}

}
