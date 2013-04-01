package userInterface.controller;

import javax.swing.JPanel;

import userInterface.view.GamePanel;
import userInterface.view.IModel;
import userInterface.view.MainFrame;
import userInterface.view.MainMenu;
import userInterface.view.PanelListener;
import userInterface.view.ScorePanel;

/**
 *	<ul>
 *		<p>FrameSwitcher will listen to events coming from the MainFrame.</p>
 *		@author Daniel
 *	</ul>
 * 
 */
public class FrameSwitcher implements PanelListener {

	private JPanel mainMenu = new MainMenu(); // Create an instance of the MainMenu
	private JPanel gamePanel = new GamePanel(); // Create an instance of the GamePanel
	private JPanel scorePanel = new ScorePanel(); // Create an instance of the ScorePanel
	private IModel modelController; // Create a handle on the ModelController
	private int gameMode;

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
	public FrameSwitcher(MainFrame frame) {

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
		System.out.println("GamePanel Event: Recieved");
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
	public JPanel mainMenu() {
		System.out.println("MainMenu Event: Recieved");
		return mainMenu;
	}

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
		System.out.println("ScoreBoard Event: Recieved");
		if (modelController != null) {
			modelController.scoreBoardInstance();
		}
		return scorePanel;
	}

	public void setCoordinates(IModel modelController) {
		this.modelController = modelController;
	}
	
}
