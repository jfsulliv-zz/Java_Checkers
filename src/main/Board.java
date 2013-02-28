package main;

/**
 * A Board Class containing an 8x8 grid on which checkers can be played. <p>
 * Each square is a member of a 2-dimensional Piece array that can hold a single
 * instance of a 'Piece' class.
 * @param boardArray A 2-dimensional Piece array of size 8x8
 * @param BOARD_ROWS : 8
 * @param BOARD_COLUMNS : 8
 *
 */
public class Board {
	public static final int BOARD_ROWS = 8;
	public static final int BOARD_COLUMNS = 8;
	private Piece[][] boardArray = new Piece[8][8];
	private Moves[] isLegal;

	/**
     *Initializes the game board by creating an integer array to store the information of every square
     *on the board. Each square will contain a 0 for empty space, a 1 if it holds a piece for
     *player 1 or a 2 if it holds a piece for player 2. 
     *@return boardArray A 2D array holding information of what is currently on every 
     *square of the board. 
     *@author Dylan Dobbyn
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
     *Moves a piece that is on one square of the board to another square 
     *of the board, positions given by Location objects.
     *@param start A Location object containing the information of the starting square.
     *@param end A Location object containing information on the square to move the piece to. 
     *@author Dylan Dobbyn
     */
	public void movePiece(Location start, Location end) {
		if (boardArray[end.getX()][end.getY()] == null) {
			if (start.getX() - end.getX() == 2
					|| start.getX() - end.getX() == -2) {
				int jumpX = (start.getX() + end.getX()) / 2;
				int jumpY = (start.getY() + end.getY()) / 2;
				boardArray[jumpX][jumpY] = null;
			}

			boardArray[end.getX()][end.getY()] = boardArray[start.getX()][start.getY()];
			boardArray[start.getX()][start.getY()] = null;

		}

	}

	/**
	 * Checks the board array to identify if there is a piece sitting on a
	 * certain square of the board.
	 * 
	 * @param square
	 *            The Location object containing the board coordinates of the
	 *            square to be checked.
	 * @return boardArray[x][y] The integer belonging to the x and y coordinates
	 *         of the board given.
	 * @author Dylan Dobbyn
	 */
	public Piece checkSquare(Location square) {
		int x = square.getX();
		int y = square.getY();
		return boardArray[y][x];
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
					if (boardArray[i][j] == null){
						System.out.print(0 + "\n");
					} else {
						System.out.print((boardArray[i][j]).getColour() +"\n");
					}
				} else {
					if (boardArray[i][j] == null){
						System.out.print(0 + " ");
					} else {
						 System.out.print((boardArray[i][j]).getColour() +" ");
					}

				}
			}
		}
	}

	/**
	 * 
	 * Accessor method that will check if the desired new location is a legal
	 * location.
	 * 
	 * @PreCond: The user must first choose a piece to jump and where to jump
	 *           to.
	 * @PostCond: Will return whether the jump is legal or not.
	 * 
	 * @param player
	 *            , starting location, piece being jumped location, and ending
	 *            location.
	 * 
	 * @return true or false
	 */
	public boolean checkJump(Player currentPlayer, Location start,
			Location middle, Location end) {
		boolean canJump = false;

		if (boardArray[start.getX()][start.getY()] == null) {
			System.out.println("There was no piece here to begin with.");
			return false;
		}
		if (boardArray[end.getX()][end.getY()] != null) {
			System.out.println("This location already contains a chip");
			canJump = false;
		} else if (currentPlayer.getColour() == Colour.BLACK) {
			if ((boardArray[start.getX()][start.getY()]).getColour() == Colour.BLACK
					&& end.getX() <= start.getX()) {
				System.out.println("BLACK: This piece can only move down.");
				canJump = false;
			} else if (boardArray[middle.getX()][middle.getY()].getColour() != Colour.RED) {
				System.out.println("BLACK: No red chip to jump over.");
				canJump = false;
			} else {
				canJump = true;
			}

		} else {
			if (boardArray[start.getX()][start.getY()].getColour() == Colour.RED
					&& end.getX() > start.getX()) {
				System.out.println("RED: This piece can only move up.");
				canJump = false;
			} else if (boardArray[middle.getX()][middle.getY()].getColour() != Colour.BLACK) {
				System.out.println("RED: No black chip to jump over.");
				canJump = false;
			} else {
				canJump = true;
			}
		}
		return canJump;
	}

	/**
	 * Accessor method that will check if the desired new location is a legal
	 * location.
	 * 
	 * @PreCond: The user must first choose a piece to move and where to move it
	 *           to.
	 * @PostCond: Will return whether the move is legal or not.
	 * 
	 * @return true or false.
	 */
	public boolean checkMove(Player currentPlayer, Location start, Location end) {
		boolean canMove = false;

		if (boardArray[start.getX()][start.getY()] == null) {
			System.out.println("There was no piece here initially.");
			return false;
		}
		if (boardArray[end.getX()][end.getY()] != null) {
			System.out.println("This location already contains a chip");
			return false;
		}
		if (currentPlayer.getColour() == Colour.BLACK) {
			if ((boardArray[start.getX()][start.getY()]).getColour() == Colour.BLACK
					&& end.getX() <= start.getX()) {
				System.out.println("BLACK: This piece can only move down.");
				return false;
			} else {
				canMove = true;
			}
		} else {
			if (boardArray[start.getX()][start.getY()].getColour() == Colour.RED
					&& end.getX() > start.getX()) {
				System.out.println("RED: This piece can only move up.");
				return false;
			} else {
				canMove = true;
			}
		}

		return canMove;
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

}
