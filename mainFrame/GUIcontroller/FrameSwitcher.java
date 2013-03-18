package GUIcontroller;

import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.event.EventListenerList;

import GUI.GamePanel;
import GUI.MainFrame;
import GUI.MainMenu;
import GUI.PanelListener;
import GUI.ScorePanel;

public class FrameSwitcher implements PanelListener {

	private JPanel mainMenu = new MainMenu();
	private JPanel gamePanel = new GamePanel();
	private JPanel scorePanel = new ScorePanel();

	public EventListenerList actionListenerList = new EventListenerList();

	public FrameSwitcher() {
		
	}
	public FrameSwitcher(MainFrame frame) {

	}

	public void gamePanel() {
		System.out.println("GamePanel Event: Recieved");

	}

	public void mainMenu() {
		System.out.println("MainMenu Event: Recieved");
	}

	public void scoreBoard() {
		System.out.println("ScoreBoard Event: Recieved");
	}

	public void addActionListener(ActionListener actionListener) {
		actionListenerList.add(ActionListener.class, actionListener);
	}

	public void removeActionListener(ActionListener actionListener) {
		actionListenerList.remove(ActionListener.class, actionListener);
	}

}
