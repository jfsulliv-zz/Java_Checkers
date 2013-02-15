package model;


public class Board {
	public static final int BOARD_ROWS = 8;
    public static final int BOARD_COLUMNS = 8;
    private Piece[][] boardArray = new Piece[8][8];
    
    /**
        *Initializes the game board by creating an integer array to store the information of every square
        *on the board. Each square will contain a 0 for empty space, a 1 if it holds a piece for
        *player 1 or a 2 if it holds a piece for player 2. 
        *@return boardArray A 2D array holding information of what is currently on every 
        *square of the board. 
        *@author Dylan Dobbyn
        */
    public void initializeBoard(){
        for (int row = 0; row <= BOARD_ROWS - 1; row++){
            for (int column = 0; column <= BOARD_COLUMNS - 1; column++){
                if (row <=2) {
                    if ((row == 1) && (column % 2 == 1)) {
                        boardArray[column][row] = new Piece(Colour.BLACK);
                    }
                    else if ((row != 1) && (column % 2 == 0)) {
                        boardArray[column][row] = new Piece(Colour.BLACK);
                    }
                }
                if (row >= 5){
                    if ((row == 6) && (column % 2 == 0)){
                        boardArray[column][row] = new Piece(Colour.RED);
                    }
                    else if ((row != 6) && (column % 2 == 1)){
                        boardArray[column][row] = new Piece(Colour.RED);
                    }
                }
            }
        }
    }
    /**
   	 * Mutator method that will create a new move and determine if the move was
   	 * a jump, if it was it will remove any piece that was jumped over. This
   	 * method is not meant to handle any rules, except that whatever piece is
   	 * jumped is removed from the board. Also, this method will not actively
   	 * figure out what piece is being played.
   	 * 
   	 * @PreCond: The start and end Locations must be within bounds.
   	 * @PostCond: If a piece is jumped, it is removed from the board.
   	 * 
   	 * @param starting
   	 *            location
   	 * @param ending
   	 *            location
   	 */
    public void movePiece(Location start, Location end){
        if (boardArray[end.getX()][end.getY()] == null){
        	if (start.getX() - end.getX() == 2 || start.getX() - end.getX() == -2) {
    			int jumpX = (start.getX() + end.getX()) / 2;
    			int jumpY = (start.getY() + end.getY()) / 2;
    			boardArray[jumpX][jumpY] = null;
    		}
        	
            boardArray[end.getX()][end.getY()] = boardArray[start.getX()][start.getY()];
            boardArray[start.getX()][start.getY()] = null;
            
            
        }
       
    }
    /**
        *Checks the board array to identify if there is a piece sitting
        *on a certain square of the board.
        *@param square The Location object containing the board coordinates of the 
        *square to be checked. 
        *@return boardArray[x][y] The integer belonging to the x and y coordinates 
        *of the board given. 
        *@author Dylan Dobbyn
        */
    public Piece checkSquare(Location square){
        int x = square.getX();
        int y = square.getY();
        return boardArray[x][y];
    }
     
    /**
        *Prints the array to the screen. Used instead of a toString()
        *method to identify what information is being held in the board. 
        *@author Dylan Dobbyn
        */
    public void printArray(){
        for (int i = 0; i <= 7; i++){
            for (int j = 0; j<=7; j++){
                if (j == 7){
                	if (boardArray[j][i] == null){
                		System.out.print(0 + "\n");
                	} else {
                    System.out.print((boardArray[j][i]).colour.toString() +"\n");
                	}
                }
                else{
                	if (boardArray[j][i] == null){
                		System.out.print(0 + " ");
                	} else {
                		System.out.print((boardArray[j][i]).colour.toString() +" ");
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
    /*
	public boolean checkJump(Player currentPlayer, Location start,Location middle, Location end) {
		boolean canJump = false;

		int x1 = start.getX();
		int y1 = start.getY();
		int x2 = middle.getX();
		int y2 = middle.getY();
		int x3 = end.getX();
		int y3 = end.getY();

		System.out.println(start.toString());
		System.out.println(middle.toString());
		System.out.println(end.toString());

		if(boardArray[x1][y1] == null) {
			System.out.println("There was no piece here to begin with.");
			return false;
		}
		if (boardArray[x3][y3] != null) {
			System.out.println("This location already contains a chip");
			canJump = false;
		} else if (currentPlayer.playerColour == Colour.BLACK) {
			if ((boardArray[x1][y1]).colour == Colour.BLACK && x3 <= x1) {
				System.out.println("BLACK: This piece can only move down.");
				canJump = false;
			} else if (boardArray[x2][y2].colour != Colour.RED) {
				System.out.println("BLACK: No red chip to jump over.");
				canJump = false;
			} else {
				canJump = true;
			}

		} else {
			if (boardArray[x1][y1].colour == Colour.RED && x3 > x1) {
				System.out.println("RED: This piece can only move up.");
				canJump = false;
			} else if (boardArray[x2][y2].colour != Colour.BLACK) {
				System.out.println("RED: No black chip to jump over.");
				canJump = false;
			} else {
				canJump = true;
			}
		}
		return canJump;
	}
	*/
}
