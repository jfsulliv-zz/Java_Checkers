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
						boardArray[row][column] = new Piece(Colour.BLACK, new Location(column,row));
					} else if ((row != 1) && (column % 2 == 0)) {
						boardArray[row][column] = new Piece(Colour.BLACK, new Location(column,row));
					}
				}
				if (row >= 5) {
					if ((row == 6) && (column % 2 == 0)) {
						boardArray[row][column] = new Piece(Colour.RED, new Location(column,row));
					} else if ((row != 6) && (column % 2 == 1)) {
						boardArray[row][column] = new Piece(Colour.RED, new Location(column,row));
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
		if(!inBounds(square)){ return null; }
		int x = square.getX(); int y = square.getY();
		return boardArray[y][x];
	}

	public Piece[] getPieces(Colour aColour) {
		Piece[] tempPiece = new Piece[12];
		int tempIndex = 0;
		for(int i = 0; i < BOARD_ROWS; i++) {
			for(int j = 0; j < BOARD_COLUMNS; j++){
				if(boardArray[i][j] != null && boardArray[i][j].getColour() == aColour) {
					tempPiece[tempIndex] = boardArray[i][j];
					tempIndex++;
				}
			}
		}
		if (tempIndex == 0) { return null; }

		Piece[] myPieces = new Piece[tempIndex];
		for(int index = 0; index < tempIndex; index++){
			myPieces[index] = tempPiece[index];
		}
		return myPieces;
	}
	/*
	 * Private setter method to change the state of a position on the board.
	 * Only used within Board's public methods to ensure encapsulation.
	 */
	private void setSquare(Location square, Piece piece) {
		if(!inBounds(square)) { return; }
		boardArray[square.getY()][square.getX()] = piece;
		if(piece != null){
			piece.setLocation(square);
		}
	}
	
	public int turnComplete(){
		return turnComplete;
	}
	
	public void resetTurn(){
		turnComplete = 0;
	}
	
	public void endTurn(){
		turnComplete = 2;
	}

	private boolean inBounds(Location square){
		if (square.getX() >= 0 && square.getX() < BOARD_ROWS && square.getY() >= 0 && square.getY() < BOARD_COLUMNS ){
			return true;
		} return false;
	}

	private boolean isJump(Location start, Location end){
		if (deltaX(start,end) == 2 && deltaY(start,end) == 2){
			return true;
		} return false;
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
		boolean isJump = isJump(start,end);
		boolean silent = false;

		if (inBounds(end) == false) {
			return; 
		} else if (checkMove(player, start, end, isJump, silent) == false) {
			return;
		}

		if (isJump == true) {
			int tempY = (end.getY() + start.getY()) / 2;
			int tempX = (end.getX() + start.getX()) / 2;
			Location middle = new Location(tempX, tempY);
			setSquare(middle,null);
			setSquare(end,checkSquare(start));
			setSquare(start,null);
			turnComplete = 1;
		} else {
			setSquare(end,checkSquare(start));
			setSquare(start,null);
			turnComplete = 2;
		}
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
	public boolean checkMove(Player currentPlayer, Location start, Location end, Boolean isJump , Boolean silent) {
		int maxDistance;
		if (isJump(start,end)) {
			maxDistance = 2;
		} else {
			maxDistance = 1;
		}

		if (checkSquare(start) == null) {
			if(!silent) {System.out.println("No piece on that starting position."); }
			return false;
		} else if (checkSquare(end) != null) {
			if(!silent) { System.out.println("The end position is already taken."); }
			return false;
		} else if (checkSquare(start).getColour() != currentPlayer.getColour()) {
			if(!silent) {System.out.println("That is not your piece.");}
			return false;
		} else if (deltaX(start, end) != maxDistance || deltaY(start, end) != maxDistance) {
			if(!silent) {System.out.println("You cannot move that far."); }
			return false;
		} else if (checkSquare(start).isKing() == false) {
			if (end.getY() >= start.getY() && currentPlayer.getColour() == Colour.RED) {
				if(!silent) { System.out.println("That piece can only move up."); }
				return false;
			} else if (end.getY() <= start.getY() && currentPlayer.getColour() == Colour.BLACK) {
				if(!silent) { System.out.println("That piece can only move down."); }
				return false;
			} 
		} 

		if(isJump == false) { return true;} 
		else { return checkJump(currentPlayer,start,end, silent); }

	}

	private boolean checkJump(Player currentPlayer, Location start, Location end, Boolean silent) {
		int tempY = (end.getY() + start.getY()) / 2;
		int tempX = (end.getX() + start.getX()) / 2;
		Location middle = new Location(tempX, tempY);

		if (checkSquare(middle) == null) {
			if(!silent) { System.out.println("No piece to jump over."); }
			return false;
		} else if (checkSquare(middle).getColour() == currentPlayer.getColour()) {
			if(!silent) { System.out.println("You cannot jump your own chip."); }
			return false;
		} else if (start.getX() + 1 == middle.getX()) {
			if (start.getX() + 2 != end.getX()) {
				if(!silent) { System.out.println("You can only jump in a straight line."); }
				return false;
			}
		} else if (start.getX() - 1 == middle.getX()) {
			if (start.getX() - 2 != end.getX()) {
				if(!silent) { System.out.println("You can only jump in a straight line."); }
				return false;
			}
		}
		return true;
	}

	/*
	 * Private Accessor method to determine the distance between two
	 * X-Locations. This is used across other methods in Board, and is simply a
	 * timesaver.
	 */
	private int deltaX(Location start, Location end) {
		return Math.abs((start.getX() - end.getX()));
	}
	private int deltaY(Location start, Location end) {
		return Math.abs((start.getY() - end.getY()));
	}

	
	/**
	 * Prints the array to the screen. Used instead of a toString() method to
	 * identify what information is being held in the board.
	 * 
	 * @author Dylan Dobbyn
	 */
	public void printArray() {
		for (int i = -1; i <= 7; i++) {
			for (int j = -1; j <= 7; j++) {

				if ( i == -1 && j == -1 ) {
					System.out.print("    ");
				} else if ( i == -1 ) {
					if (j == 7) {
						System.out.print(j + "\n\n");
					} else {
						System.out.print(j + " ");
					}
				} else if (j == -1 ) {
					System.out.print(i + "   ");
				} 

				else if (j == 7) {
					if (boardArray[i][j] == null) {
						System.out.print("_" + "\n");
					} else {
						System.out.print((boardArray[i][j]) + "\n");
					}
				} else {
					if (boardArray[i][j] == null) {
						System.out.print("_" + " ");
					} else {
						System.out.print((boardArray[i][j]) + " ");
					}

				}
			}
		}
		System.out.print("\n");
	}

	public Location[] emptyMoves(Player player, Location start){
		boolean isJump = false;
		boolean silent = true;
		int numMoves = 0;
		Location[] maxMoves = new Location[4];

		for(int x = -1; x <= 1; x += 2) {
			for(int y = -1; y <= 1; y += 2){
				int tempX = start.getX() + x;
				int tempY = start.getY() + y;
				Location tempLoc = new Location(tempX,tempY);
				if(inBounds(tempLoc) && checkMove(player,start,tempLoc,isJump, silent)) { 
					maxMoves[numMoves] = tempLoc;
					numMoves++;
				}
 			}
		}

		if(numMoves == 0){ return null; }

		Location[] legalMoves = new Location[numMoves];
		for(int index = 0; index < numMoves; index++) {
			legalMoves[index] = maxMoves[index];
		}
		return legalMoves;
	}

	public Location[] emptyJumps(Player player, Location start){
		boolean isJump = true;
		boolean silent = true;
		int numMoves = 0;
		Location[] maxJumps = new Location[4];

		for(int x = -2; x <= 2; x += 4){
			for(int y = -2; y <= 2; y += 4){
				int tempX = start.getX() + x;
				int tempY = start.getY() + y;
				Location tempLoc = new Location(tempX,tempY);
				if (inBounds(tempLoc) && checkMove(player,start,tempLoc,isJump, silent)){
					maxJumps[numMoves] = tempLoc;
					numMoves++;
				}			
			}
		}

		if( numMoves == 0) { return null; }

		Location[] legalJumps = new Location[numMoves];
		for(int index = 0; index < numMoves; index++){
			legalJumps[index] = maxJumps[index];
		}		
		return legalJumps;
	}
}
