package main;

/**
 * A Board Class containing an 8x8 grid on which checkers can be played.
 * <p>
 * Each square is a member of a 2-dimensional Piece array that can hold a single
 * instance of a 'Piece' class.
 * 
 * @param boardArray
 *            A 2-dimensional Piece array of size 8x8
 * @param BOARD_ROWS
 *            : 8
 * @param BOARD_COLUMNS
 *            : 8
 * 
 */
public class Board {
	public static final int BOARD_ROWS = 8;
	public static final int BOARD_COLUMNS = 8;
	private Piece[][] boardArray = new Piece[8][8];
	private Moves[] isLegal;
	private int turnComplete = 0;

	/**
	 * Initializes the game board by creating an integer array to store the
	 * information of every square on the board. Each square will contain a 0
	 * for empty space, a 1 if it holds a piece for player 1 or a 2 if it holds
	 * a piece for player 2.
	 * 
	 * @return boardArray A 2D array holding information of what is currently on
	 *         every square of the board.
	 * @author Dylan Dobbyn
	 */
	public void initializeBoard() {
		for (int row = 0; row <= BOARD_ROWS - 1; row++) {
			for (int column = 0; column <= BOARD_COLUMNS - 1; column++) {
				if (row <= 2) {
					if ((row == 1) && (column % 2 == 1)) {
						boardArray[row][column] = new Piece(Colour.BLACK);
					} else if ((row != 1) && (column % 2 == 0)) {
						boardArray[row][column] = new Piece(Colour.BLACK);
					}
				}
				if (row >= 5) {
					if ((row == 6) && (column % 2 == 0)) {
						boardArray[row][column] = new Piece(Colour.RED);
					} else if ((row != 6) && (column % 2 == 1)) {
						boardArray[row][column] = new Piece(Colour.RED);
					}
				}
			}
		}
	}
	
	/**
	 * Checks the board array to identify the Piece object occupying a given
	 * square.
	 * 
	 * @param square
	 *            the Location on the board to be checked.
	 * 
	 * @return boardArray[x][y] The Piece object held on that particular Board
	 *         coordinates- null if empty.
	 * 
	 * @author Dylan Dobbyn
	 */
	public Piece checkSquare(Location square) {
		int x = square.getX();
		int y = square.getY();
		return boardArray[y][x];
	}

	/*
	 * Private setter method to change the state of a position on the board.
	 * Only used within Board's public methods to ensure encapsulation.
	 */
	private void setSquare(Location square, Piece piece) {
		boardArray[square.getY()][square.getX()] = piece;
	}
	
	public int turnComplete(){
		return turnComplete;
	}
	
	public void resetTurn(){
		turnComplete = 0;
	}
	/**
	 * Moves a piece that is on one square of the board to another square of the
	 * board, positions given by Location objects. Will also remove any pieces
	 * if applicable.
	 * 
	 * @param player
	 *            the Player who owns the piece to be moved.
	 * @param start
	 *            A Location object containing the information of the starting
	 *            square.
	 * @param end
	 *            A Location object containing information on the square to move
	 *            the piece to.
	 * @author Dylan Dobbyn
	 */
	public void movePiece(Player player, Location start, Location end) {
		turnComplete = 0;
		Location middle;

		if (checkMove(player, start, end) == false) {return;}

		if (deltaX(start, end) == 2) {
			int tempY = (end.getY() + start.getY()) / 2;
			int tempX = (end.getX() + start.getX()) / 2;
			middle = new Location(tempX, tempY);

			if (checkJump(player, start, middle, end) == false) {return; } 
			else { 
				setSquare(middle,null);
				setSquare(end,checkSquare(start));
				setSquare(start,null);
				System.out.println("Piece at ("+end.toString()+") can continue to move.");
				turnComplete = 1;
			}
		} else {
			setSquare(end,checkSquare(start));
			setSquare(start,null);
			turnComplete = 2;
		}
	}

	/**
	 * 
	 * Accessor method that will check the legality of a jump move. Contains a
	 * series of checks which are relevant to a piece being jumped.
	 * 
	 * @PreCond: The user selects a start, end, and jumped (middle) position.
	 * @PostCond: Will return whether the jump is legal or not.
	 * 
	 * @param currentPlayer
	 *            the Player who performs the jump
	 * @param start
	 *            the Starting Location of the piece
	 * @param middle
	 *            the Middle Location of the piece to be jumped over
	 * @param end
	 *            the End Location
	 * 
	 * @return true if the move is valid.
	 */
	public boolean checkJump(Player currentPlayer, Location start,
			Location middle, Location end) {

		if (checkSquare(middle) == null) {
			System.out.println("No piece to jump over.");
			return false;
		} else if (checkSquare(middle).getColour() == currentPlayer
				.getColour()) {
			System.out.println("You cannot jump your own chip.");
			return false;
		}

		if (start.getX() + 1 == middle.getX()) {
			if (start.getX() + 2 != end.getX()) {
				System.out.println("You can only jump in a straight line.");
				return false;
			}
		} else if (start.getX() - 1 == middle.getX()) {
			if (start.getX() - 2 != end.getX()) {
				System.out.println("You can only jump in a straight line.");
				return false;
			}
		}
		return true;
	}

	/**
	 * Accessor method that will check the general case legality of a move.
	 * Ensures that all moves performed are legal.
	 * 
	 * @PreCond: The user will select a starting and ending location.
	 * @PostCond: The validity of the move will be returned.
	 * 
	 * @param currentPlayer
	 *            the Player owner of the moved Piece.
	 * @param start
	 *            the Starting Location.
	 * @param end
	 *            the Ending location.
	 * 
	 * @return true if the move is valid.
	 */
	public boolean checkMove(Player currentPlayer, Location start, Location end) {

		if (checkSquare(start) == null) {
			System.out.println("No piece on that starting position.");
			return false;
		} else if (checkSquare(end) != null) {
			System.out.println("The end position is already taken.");
			return false;
		} else if (deltaX(start, end) != 1 && deltaX(start, end) != 2) {
			System.out.println("You cannot move that far.");
			return false;
		} else if (checkSquare(start).getColour() != currentPlayer
				.getColour()) {
			System.out.println("That is not your piece.");
			return false;
		} else if (checkSquare(start).isKing() == false) {
			if (end.getY() >= start.getY()
					&& currentPlayer.getColour() == Colour.RED) {
				System.out.println("That piece can only move up.");
				return false;
			} else if (end.getY() <= start.getY()
					&& currentPlayer.getColour() == Colour.BLACK) {
				System.out.println("That piece can only move down.");
				return false;
			}
		}
		return true;
	}

	/**
	 * Mutator method that will store all the legal moves for the current piece
	 * in an array (Moves[])
	 * 
	 * @PreCond: The locations entered must be within bounds.
	 * @PostCond: Will return an array of legalJumps.
	 * 
	 * @return
	 */
	public Moves[] isLegalMove(Player player) {

		return isLegal;
	}

	/**
	 * Mutator method that will store all the legal jumps for the current piece
	 * in an array (Moves[])
	 * 
	 * @PreCond: The locations entered must be within bounds.
	 * @PostCond: Will return an array of legalJumps.
	 * 
	 * @return isLegal jump
	 */
	public Moves[] isLegalJump(Player player, Location end) {

		return isLegal;
	}

	/*
	 * Private Accessor method to determine the distance between two
	 * X-Locations. This is used across other methods in Board, and is simply a
	 * timesaver.
	 */
	private int deltaX(Location start, Location end) {
		return Math.abs((start.getX() - end.getX()));
	}
	
	/**
	 * Prints the array to the screen. Used instead of a toString() method to
	 * identify what information is being held in the board.
	 * 
	 * @author Dylan Dobbyn
	 */
	public void printArray() {
		for (int i = 0; i <= 7; i++) {
			for (int j = 0; j <= 7; j++) {
				if (j == 7) {
					if (boardArray[i][j] == null) {
						System.out.print(0 + "\n");
					} else {
						System.out.print((boardArray[i][j]).getColour() + "\n");
					}
				} else {
					if (boardArray[i][j] == null) {
						System.out.print(0 + " ");
					} else {
						System.out.print((boardArray[i][j]).getColour() + " ");
					}

				}
			}
		}
	}
}
