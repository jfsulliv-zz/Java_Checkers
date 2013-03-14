package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * 
 * @author Daniel
 * 
 * This class is a container class that upon launch will always open the main menu.
 *
 */
public class MainFrame {

	private PanelListener panelListener;
	private JFrame mainContainer = new JFrame("Checkers");
	private JPanel mainMenu = new JPanel();
	private JButton btnSinglePlayer, btnMultiPlayer, btnScoreBoard, btnQuit;

	public void start() {
		mainContainer(mainMenu());
	}

	private JFrame mainContainer(JPanel frame) {
		mainContainer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainContainer.setSize(1170, 650);
		mainContainer.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		mainContainer.setLocation(dim.width / 2 - mainContainer.getSize().width
				/ 2, dim.height / 2 - mainContainer.getSize().height / 2);
		mainContainer.setResizable(false);

		mainContainer.add(frame);

		return mainContainer;
	}

	private JPanel mainMenu() {
		mainMenu.setLayout(null);
		ImagePanel background = new ImagePanel(new ImageIcon("GUIImages\\MainMenuBackground.png").getImage());
		
		ImageIcon singlePlayerButton = new ImageIcon("GUIImages\\singlePlayerButton.png");
		btnSinglePlayer = new JButton(singlePlayerButton);
		btnSinglePlayer.setOpaque(false);
		btnSinglePlayer.setContentAreaFilled(false);
		btnSinglePlayer.setBorderPainted(false);
		btnSinglePlayer.setBounds(410, 25, 298, 105);
		mainMenu.add(btnSinglePlayer);
		
		ImageIcon multiPlayerButton = new ImageIcon("GUIImages\\multiPlayerButton.png");
		btnMultiPlayer = new JButton(multiPlayerButton);
		btnMultiPlayer.setOpaque(false);
		btnMultiPlayer.setContentAreaFilled(false);
		btnMultiPlayer.setBorderPainted(false);
		btnMultiPlayer.setBounds(420, 170, 298, 105);
		mainMenu.add(btnMultiPlayer);

		ImageIcon scoreBoardButton = new ImageIcon("GUIImages\\scoreBoardButton.png");
		btnScoreBoard = new JButton(scoreBoardButton);
		btnScoreBoard.setOpaque(false);
		btnScoreBoard.setContentAreaFilled(false);
		btnScoreBoard.setBorderPainted(false);
		btnScoreBoard.setBounds(17, 460, 180, 58);
		mainMenu.add(btnScoreBoard);

		ImageIcon quitButton = new ImageIcon("GUIImages\\quitButton.png");
		btnQuit = new JButton(quitButton);
		btnQuit.setOpaque(false);
		btnQuit.setContentAreaFilled(false);
		btnQuit.setBorderPainted(false);
		btnQuit.setBounds(50, 530, 95, 58);
		mainMenu.add(btnQuit);
		
		
		mainMenu.add(background);

		return mainMenu;
	}

	public void SwitchFrames(PanelListener panelListener) {
		this.panelListener = panelListener;
	}

}
