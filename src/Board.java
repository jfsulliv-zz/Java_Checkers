public class Board {
    public static final int BOARD_ROWS = 8;
    public static final int BOARD_COLUMNS = 8;
    private int[][] boardArray = new int[8][8];
    
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
    
    public void movePiece(int startX, int startY, int endX, int endY){
        if (boardArray[endX][endY] == 0){
            boardArray[endX][endY] = boardArray[startX][startY];
            boardArray[startX][startY] = 0;
        }
    }
      
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
                    
                    
            