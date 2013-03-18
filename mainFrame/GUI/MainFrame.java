package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import GUIcontroller.FrameSwitcher;

/**
 * 
 * @author Daniel
 * 
 * 
 * 
 */
public class MainFrame extends JFrame {

	private PanelListener panelListener;
	private JFrame mainContainer = new JFrame("Frog Checkers");
	private JPanel gamePanel = new GamePanel();
	private JPanel scorePanel = new ScorePanel();
	private JPanel mainMenu = new MainMenu();
	

	public void start() {
		mainContainer(mainMenu);
		// mainContainer(gamePanel);
		// mainContainer(scorePanel);
	}
	
	private JFrame mainContainer(JPanel frame) {
		mainContainer.getContentPane().add(frame);
		mainContainer.pack();

		mainContainer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainContainer.setSize(925, 608);
		mainContainer.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		mainContainer.setLocation(dim.width / 2 - mainContainer.getSize().width
				/ 2, dim.height / 2 - mainContainer.getSize().height / 2);
		mainContainer.setResizable(false);

		return mainContainer;
	}

	public void switchTo(JPanel frame) {
		mainContainer.getContentPane().removeAll();
		mainContainer.invalidate();
		mainContainer(frame);
		mainContainer.validate();
		mainContainer.repaint();
	}

	public void SwitchFrames(PanelListener panelListener) {
		this.panelListener = panelListener;
	}

}
