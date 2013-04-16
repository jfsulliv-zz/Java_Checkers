package userInterface.controller;

import javax.swing.JPanel;

import userInterface.view.GamePanel;
import userInterface.view.IModel;
import userInterface.view.MainFrame;
import userInterface.view.PanelListener;
import userInterface.view.ScorePanel;
import main.*;

/**
 *	<ul>
 *		<p>FrameSwitcher will listen to events coming from the MainFrame.</p>
 *		@author Daniel
 *	</ul>
 * 
 */
public class FrameSwitcher implements PanelListener {

	private JPanel gamePanel = new GamePanel(); // Create an instance of the GamePanel
	private JPanel scorePanel = new ScorePanel(); // Create an instance of the ScorePanel
	private IModel modelController; // Create a handle on the ModelController
	private int gameMode;
	private MainFrame frame;
	private static FrameSwitcher instance;
    private boolean highlight;
    private Location highlightSquare;
    private String[][] stringBoard = new String[8][8];
	
	/**
	 * <ul>
	 * 	Creates a handle on the MainFrame.
	 * </ul>
	 * <ul>
	 * 	@param frame Takes an instance of MainFrame, to be called in the launcher. This will allow
	 * 				us to create a handle on the MainFrame, such that this class becomes a 
	 * 				listener.
	 * </ul>
	 */
	private FrameSwitcher(MainFrame frame) {
		this.frame = frame;
	}

	/**
	 * <!--Accessor method.-->
	 * 	<style>
	 * 		#method{
	 * 			text-indent: 10.0px;
	 * 		}
	 * 	</style>
	 * 	<ul><li><b>FrameSwitcher</b></li></ul>
	 * 	<ul><div ID="method"><p>public JPanel gamePanel(int gameMode)</p></div></ul>
	 * 	<ul> 
	 * 		<p>
	 * 			Sets the mode of the game, whether it's single player or multi player.
	 * 			This method is also responsible for showing the appropriate panel depending on
	 * 			what button has been clicked.
	 * 		</p>
	 * 	</ul>
	 * 	<ul>
	 * 		<p>
	 * 			PreCondition: There must be a gamePanel to return.
	 * 			<br>PostCondition: Will return the gamePanel.</br>
	 * 		</p>
	 * 	</ul>
	 * 
	 * 	<ul>
	 *  	@param gameMode  The mode of the game, determined by which button is clicked.
	 *  	@return Return the instance of the games view.
	 *  </ul>
	 * 
	 * 
	 */
	public JPanel gamePanel(int gameMode) {
		this.gameMode = gameMode; // Store the given game mode in an instance variable.
		if (modelController != null) {
			modelController.gameInstance(gameMode);
		}
		return gamePanel;
	}

	/**
	 * <!--Accessor method.-->
	 * 	<style>
	 * 		#method {
	 * 			text-indent: 10.0px;
	 * 		}
	 * 	</style>
	 * 	<ul><li><b>FrameSwitcher</b></li></ul>
	 * 	<ul><div ID="method"><p>public JPanel mainMenu()</p></div></ul>
	 * 	<ul> 
	 * 		<p>
	 * 			This is the main menu of the GUI. This is not yet implemented.
	 * 		</p>
	 * 	</ul>
	 * 	<ul>
	 * 		<p>
	 * 			PreCondition: There must be a main menu to return.
	 * 			<br>PostCondition: Will return the main menu.</br>
	 * 		</p>
	 * 	</ul>
	 * 
	 * 	<ul>
	 *  	@return Return the instance of the menus view.
	 *  </ul>
	 * 
	 * 
	 */

	/**
	 * <!--Accessor method.-->
	 * 	<style>
	 * 		#method {
	 * 			text-indent: 10.0px;
	 * 		}
	 * 	</style>
	 * 	<ul><li><b>FrameSwitcher</b></li></ul>
	 * 	<ul><div ID="method"><p>public JPanel scoreBoard()</p></div></ul>
	 * 	<ul> 
	 * 		<p>
	 * 			This is the score board of the GUI. This is not yet implemented.
	 * 		</p>
	 * 	</ul>
	 * 	<ul>
	 * 		<p>
	 * 			PreCondition: There must be a score board to return.
	 * 			<br>PostCondition: Will return the score board.</br>
	 * 		</p>
	 * 	</ul>
	 * 
	 * 	<ul>
	 *  @return Return the instance of the score boards view.
	 *  </ul>
	 * 
	 * 
	 */
	public JPanel scoreBoard() {
		if (modelController != null) {
			modelController.scoreBoardInstance();
		}
		return scorePanel;
	}
    /** 
        *Takes a piece array from board and simplifies it to a String array
        *to be held in the FrameSwitcher. Then updates the GamePanel with new 
        *frogs.
        *Pre-conditions: The Game, Board and GamePanel must all be initialized already.
        *Post-conditions: The GUI will be redrawn with the new board configuration.
        *@author Dylan Dobbyn
        */
    public void updateGUI(){
        Piece[][] boardArray = Game.getInstance().getBoard().getArray();
        if (boardArray == null){
            Board firstBoard = new Board();
            firstBoard.initializeBoard();
            boardArray = firstBoard.getArray();
            }
        for(int row = 0; row <= 7; row++){
			for (int column = 0; column <=7; column++){
				
				if(boardArray[column][row] == null){
					stringBoard[column][row] = null;
				} 
				else if(boardArray[column][row].getColour() == Colour.BLACK) {
					if(boardArray[column][row].isKing()) {
						stringBoard[column][row] = "Black King";
					} else {
						stringBoard[column][row] = "Black";
					}

				} 
				else {
					if(boardArray[column][row].isKing()) {
                        stringBoard[column][row] = "Red King";
					} else {
						stringBoard[column][row] = "Red";
					}
				}
			}
		}
        gamePanel.updateUI();
    }
    public void updateGUI(Location square){
        highlightSquare = square;
        highlight = true;
        gamePanel.updateUI();
        }
        
    public void updateGUI(Player player, int errorCode){
    
    
    }       
    public void setHighlight(boolean set){
        highlight = set;
        }
    public Location highlightSquare(){
        return highlightSquare;
        }
    public boolean highlight(){
        return highlight;
        }
	public static FrameSwitcher getInstance(MainFrame frame){
		if (instance == null){
			instance = new FrameSwitcher(frame);
		}
		return instance;
	}
    public static FrameSwitcher getInstance(){
        while(instance == null){
            pause(1);
            }
        return instance;
        }
    public String[][] stringBoard(){
        return stringBoard;
        }


	public void setCoordinates(IModel modelController) {
		this.modelController = modelController;
	}
    /**
        *Used to pause the thread to allow the MainFrame to initialize the 
        *FrameSwitcher before the ImagePanel needs it.
        *Pre-conditions: none.
        *Post-conditions: The thread has been paused for a number of seconds.
        *@param timeToWaitInSeconds:int The number of seconds to pause the thread for.
        *@author Daniel Contreras
        */
	private static void pause(int timeToWaitInSeconds) {
		int timeToMilli = 1000 * timeToWaitInSeconds;
		long t0, t1;
        t0 =  System.currentTimeMillis();
        do{
            t1 = System.currentTimeMillis();
        }
        while (t1 - t0 < timeToMilli);
	}
	public IModel getModelController() { return modelController; }
	
}
