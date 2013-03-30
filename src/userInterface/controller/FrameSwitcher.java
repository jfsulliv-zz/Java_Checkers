package userInterface.controller;

import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.event.EventListenerList;

import main.Game;
import main.GameLauncher;
import userInterface.GUI.GamePanel;
import userInterface.GUI.IModel;
import userInterface.GUI.MainFrame;
import userInterface.GUI.MainMenu;
import userInterface.GUI.PanelListener;
import userInterface.GUI.ScorePanel;

/**
 * 
 * @author Daniel
 *
 * The FrameSwitcher is a listener that listens to actions called from the MainFrame. 
 */
public class FrameSwitcher implements PanelListener {

	private JPanel mainMenu = new MainMenu(); // Create an instance of the MainMenu
	private JPanel gamePanel = new GamePanel(); // Create an instance of the GamePanel
	private JPanel scorePanel = new ScorePanel(); // Create an instance of the ScorePanel
	private IModel modelController; // Create a handle on the ModelController
	private int gameMode;

	/**
	 * Creates a handle on the MainFrame.
	 * @param frame
	 */
	public FrameSwitcher(MainFrame frame, Game game) {

	}

	/**
	 * Accessor method.
	 * 
	 * @PreCond: There must be a gamePanel to return.
	 * @PostCond: Will return the gamePanel.
	 * 
	 * When this method is called, within the MainFrame class, it will display the GamePanel
	 * 
	 */
	public JPanel gamePanel(int gameMode) {
		System.out.println("GamePanel Event: Recieved");
		this.gameMode = gameMode; // Store the given game mode in an instance variable.
		if (modelController != null) {
			modelController.gameInstance();
		}
		return gamePanel;
	}

	/**
	 * Accessor method
	 * 
	 * @PreCond: There must be a mainMenu to return.
	 * @PostCond: Will return the mainMenu.
	 * 
	 * When this method is called, within the MainFrame class, it will display the MainMenu
	 */
	public JPanel mainMenu() {
		System.out.println("MainMenu Event: Recieved");
		return mainMenu;
	}

	/**
	 * Accessor method
	 * 
	 * @PreCond: There must be a scoreBoard to return.
	 * @PostCond: Will return a scoreBoard.
	 * 
	 * When this method is called, within the MainFrame class, it will display the ScorePanel
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
	
	public int getGameMode() {
		System.out.println("The game mode chosen was " + gameMode + " player.");
		return gameMode;
	}

}
