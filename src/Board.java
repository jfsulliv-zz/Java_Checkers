/**
    *Used to create and initialize a checkerboard to play checkers.
    *@author Dylan Dobbyn.
    */
public class Board {
    public static final int BOARD_ROWS = 8;
    public static final int BOARD_COLUMNS = 8;
    private int[][] boardArray = new int[8][8];
    
    /**
        *Initializes the game board by creating an integer array to store the information of every square
        *on the board. Each square will contain a 0 for empty space, a 1 if it holds a piece for
        *player 1 or a 2 if it holds a piece for player 2. 
        *@return boardArray A 2D array holding information of what is currently on every 
        *square of the board. 
        *@author Dylan Dobbyn
        */
    public int[][] intializeBoard(){
       for (int row = 0; row <= BOARD_ROWS - 1; row++){
           for (int column = 0; column <= BOARD_COLUMNS - 1; column++){
               if (row <=2) {
                   if ((row == 1) && (column % 2 == 1)) {
                        boardArray[row][column] = 1;
                   }
                   else if ((row != 1) && (column % 2 == 0)) {
                       boardArray[row][column] = 1;
                   }
               }
               if (row >= 5){
                   if ((row == 6) && (column % 2 == 0)){
                       boardArray[row][column] = 2;
                   }
                   else if ((row != 6) && (column % 2 == 1)){
                       boardArray[row][column] = 2;
                   }
               }
            }
        }
    return boardArray;
    }
    /**
        *Moves a piece that is on one square of the board to another square 
        *of the board, positions given by Location objects.
        *@param start A Location object containing the information of the starting square.
        *@param end A Location object containing information on the square to move the piece to. 
        *@author Dylan Dobbyn
        */
    public void movePiece(Location start, Location end){
        if (boardArray[end.getX()][end.getY()] == 0){
            boardArray[end.getX()][end.getY()] = boardArray[start.getX()][start.getY()];
            boardArray[start.getX()][start.getY()] = 0;
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
    public int checkSquare(Location square){
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
                    System.out.print(boardArray[i][j] +"\n");
                }
                else{
                    System.out.print(boardArray[i][j] +" ");
                }
            }
        }
    }
    
}
                    
                    
            