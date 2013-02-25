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
                        boardArray[row][column] = new Piece(Colour.BLACK);
                    }
                    else if ((row != 1) && (column % 2 == 0)) {
                        boardArray[row][column] = new Piece(Colour.BLACK);
                    }
                }
                if (row >= 5){
                    if ((row == 6) && (column % 2 == 0)){
                        boardArray[row][column] = new Piece(Colour.RED);
                    }
                    else if ((row != 6) && (column % 2 == 1)){
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
    public void movePiece(Location start, Location end){
        if (boardArray[end.getY()][end.getX()] == null){
            boardArray[end.getY()][end.getX()] = boardArray[start.getY()][start.getX()];
            boardArray[start.getY()][start.getX()] = null;
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
        return boardArray[y][x];
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
                	if (boardArray[i][j] == null){
                		System.out.print(0 + "\n");
                	} else {
                    System.out.print((boardArray[i][j]).getColour() +"\n");
                	}
                }
                else{
                	if (boardArray[i][j] == null){
                		System.out.print(0 + " ");
                	} else {
                		System.out.print((boardArray[i][j]).getColour() +" ");
                	}
                    
                }
            }
        }
    }
}
