package userInterface.controller;

import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.event.EventListenerList;

import userInterface.GUI.GamePanel;
import userInterface.GUI.MainFrame;
import userInterface.GUI.MainMenu;
import userInterface.GUI.PanelListener;
import userInterface.GUI.ScorePanel;


public class FrameSwitcher implements PanelListener {

	private JPanel mainMenu = new MainMenu();
	private JPanel gamePanel = new GamePanel();
	private JPanel scorePanel = new ScorePanel();

	public EventListenerList actionListenerList = new EventListenerList();

	public FrameSwitcher() {

	}

	public FrameSwitcher(MainFrame frame) {

	}

	public JPanel gamePanel() {
		System.out.println("GamePanel Event: Recieved");
		return gamePanel;
	}

	public JPanel mainMenu() {
		System.out.println("MainMenu Event: Recieved");
		return mainMenu;
	}

	public JPanel scoreBoard() {
		System.out.println("ScoreBoard Event: Recieved");
		return scorePanel;
	}

	public void addActionListener(ActionListener actionListener) {
		actionListenerList.add(ActionListener.class, actionListener);
	}

	public void removeActionListener(ActionListener actionListener) {
		actionListenerList.remove(ActionListener.class, actionListener);
	}

}
