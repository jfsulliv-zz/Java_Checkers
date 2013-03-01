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
	public void movePiece(Player player, Location start, Location end) {
		Location middle;
		
		if(checkMove(player,start,end) == false){ return; }
		
		if(deltaX(start,end) == 2){
			int tempY = (end.getY() + start.getY()) / 2;
			int tempX = (end.getX() + start.getX()) / 2;
			middle = new Location(tempY,tempX);
			
			if(checkJump(player,start,middle,end) == false) { return; }
			
			else { 
				boardArray[middle.getY()][middle.getX()] = null; 
			}
		}
		boardArray[end.getY()][end.getX()] = boardArray[start.getY()][start.getX()];
		boardArray[start.getX()][start.getY()] = null;
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
	public boolean checkJump(Player currentPlayer, Location start, Location middle, Location end) {

		if(boardArray[middle.getY()][middle.getX()] == null){
			System.out.println("No piece to jump over.");
			return false;
		} else if(boardArray[middle.getY()][middle.getX()].getColour() == currentPlayer.getColour()){
			System.out.println("You cannot jump your own chip.");
			return false;
		}
		
		if(start.getX() + 1 == middle.getX()){
			if (start.getX() + 2 != end.getX()){
				System.out.println("You can only jump in a straight line.");
				return false;
			}
		} else if (start.getX() - 1 == middle.getX()) {
			if (start.getX() - 2 != end.getX()){
				System.out.println("You can only jump in a straight line.");
				return false;
			}
		}
		return true;
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

		if (boardArray[start.getY()][start.getX()] == null){
			System.out.println("No piece on that starting position.");
			return false;
		} else if (boardArray[end.getY()][end.getX()] != null){
			System.out.println("The end position is already taken.");
			return false;
		} else if (deltaX(start,end) != 1 && deltaX(start,end) != 2){
			System.out.println("You cannot move that far.");
			return false;
		} else if (boardArray[start.getY()][start.getX()].getColour() != currentPlayer.getColour()) {
			System.out.println("That is not your piece.");
			return false;
		} else if(boardArray[start.getY()][start.getX()].isKing() == false) {
			if (end.getY() >= start.getY() && currentPlayer.getColour() == Colour.RED) {
				System.out.println("That piece can only move up.");
				return false;
			} else if (end.getY() <= start.getY() && currentPlayer.getColour() == Colour.BLACK) {
				System.out.println("That piece can only move down.");
				return false;
			}
		} return true;
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
	 * Private Accessor method to determine the distance between two X-Locations.
	 * This is used across other methods in Board, and is simply a timesaver.
	 */
	private int deltaX(Location start, Location end){
		return Math.abs((start.getX() - end.getX()));
	}
}
