package userInterface.GUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author Daniel
 * 
 * MainFrame is a container class. The container is comprised of a JFrame that will contain JPanels.
 * The JPanels are switched according to what is happening in the FrameSwitcher.
 */
public class MainFrame extends JFrame implements ActionListener {

	private JFrame mainContainer = new JFrame("Frog Checkers");
	private PanelListener panelListener; // Create a handle on the FrameSwitcher
	private JPanel mainMenu;
	private static JButton btnSinglePlayer, btnMultiPlayer, btnScoreBoards,
	btnQuit;
	private ImagePanel background;
	private ImageIcon singlePlayerButton, rollOverSinglePlayerButton,
	multiPlayerButton, scoreBoardButton, rollOverScoreBoardButton,
	rollOverMultiPlayerButton, quitButton, rollOverQuitButton;

	/**
	 * Accessor 
	 * 
	 * This method will start the GUI, initiating the main menu first.
	 */
	public void start() {
		mainContainer(mainMenu());
	}

	/**
	 * Mutator
	 * 
	 * @param frame
	 * @return mainConainer
	 * 
	 * This method will create the container, mainContainer, and it takes a parameter 
	 * of JPanel. This parameter will be responsible for changing frames.
	 * 
	 */
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
	
	/**
	 * Mutator
	 * 
	 * @return mainMenu
	 * 
	 * Construct the main menu of the GUI.
	 */
	private JPanel mainMenu() {
		mainMenu = new JPanel();
		mainMenu.setLayout(null);
		
		background = new ImagePanel(new ImageIcon(
				"GUIImages\\Other\\newBackground.png").getImage());
		
		
		singlePlayerButton = new ImageIcon("GUIImages\\Buttons\\singlePlayerButton.png");
		rollOverSinglePlayerButton = new ImageIcon(
				"GUIImages\\Buttons\\rollOverSinlgePlayerButton.png");
		btnSinglePlayer = new JButton(singlePlayerButton);
		btnSinglePlayer.setOpaque(false);
		btnSinglePlayer.setContentAreaFilled(false);
		btnSinglePlayer.setBorderPainted(false);
		btnSinglePlayer.setFocusPainted(false);
		btnSinglePlayer.setBounds(320, 25, 275, 130);
		btnSinglePlayer.setRolloverIcon(rollOverSinglePlayerButton);
		btnSinglePlayer.addActionListener(this);
		mainMenu.add(btnSinglePlayer);
		
		multiPlayerButton = new ImageIcon("GUIImages\\Buttons\\multiPlayerButton.png");
		rollOverMultiPlayerButton = new ImageIcon(
				"GUIImages\\Buttons\\rollOverMultiPlayerButton.png");
		btnMultiPlayer = new JButton(multiPlayerButton);
		btnMultiPlayer.setOpaque(false);
		btnMultiPlayer.setContentAreaFilled(false);
		btnMultiPlayer.setBorderPainted(false);
		btnMultiPlayer.setFocusPainted(false);
		btnMultiPlayer.setBounds(320, 170, 275, 130);
		btnMultiPlayer.setRolloverIcon(rollOverMultiPlayerButton);
		btnMultiPlayer.addActionListener(this);
		mainMenu.add(btnMultiPlayer);

		scoreBoardButton = new ImageIcon("GUIImages\\Buttons\\scoreBoardButton.png");
		rollOverScoreBoardButton = new ImageIcon(
				"GUIImages\\Buttons\\rollOverScoreBoardButton.png");
		btnScoreBoards = new JButton(scoreBoardButton);
		btnScoreBoards.setOpaque(false);
		btnScoreBoards.setContentAreaFilled(false);
		btnScoreBoards.setBorderPainted(false);
		btnScoreBoards.setFocusPainted(false);
		btnScoreBoards.setBounds(13, 380, 225, 73);
		btnScoreBoards.setRolloverIcon(rollOverScoreBoardButton);
		btnScoreBoards.addActionListener(this);
		mainMenu.add(btnScoreBoards);

		quitButton = new ImageIcon("GUIImages\\Buttons\\quitButton.png");
		rollOverQuitButton = new ImageIcon("GUIImages\\Buttons\\rollOverQuitButton.png");
		btnQuit = new JButton(quitButton);
		btnQuit.setOpaque(false);
		btnQuit.setContentAreaFilled(false);
		btnQuit.setBorderPainted(false);
		btnQuit.setFocusPainted(false);
		btnQuit.setBounds(45, 460, 120, 85);
		btnQuit.setRolloverIcon(rollOverQuitButton);
		btnQuit.addActionListener(this);
		mainMenu.add(btnQuit);
		
		mainMenu.add(background);
		
		return mainMenu;
	}

	/**
	 * 
	 * @param panelListener
	 * 
	 * This creates a handle on the listener, PanelListener. Whenever an event happens, the
	 * instance variable paneListener is no longer null which will be useful in the 
	 * actionPerformed method.
	 */
	public void SwitchFrames(PanelListener panelListener) {
		this.panelListener = panelListener;
	}

	/**
	 * Mutator
	 * 
	 * actionPerformed will take you to the appropriate screens depending on what is 
	 * clicked by the user. Before changing the frames we must first check
	 * if panelListener is null.
	 */
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton)e.getSource();
		
		if (source == btnSinglePlayer) {
			if (panelListener != null) { 
				mainContainer.getContentPane().removeAll();
				mainContainer.invalidate();
				mainContainer(panelListener.gamePanel());
				mainContainer.validate();
				mainContainer.repaint();
			}
		} else if (source == btnMultiPlayer) {
			if (panelListener != null) {
				mainContainer.getContentPane().removeAll();
				mainContainer.invalidate();
				mainContainer(panelListener.gamePanel());
				mainContainer.validate();
				mainContainer.repaint();
			}
		} else if (source == btnScoreBoards) {
			if (panelListener != null) {
				mainContainer.getContentPane().removeAll();
				mainContainer.invalidate();
				mainContainer(panelListener.scoreBoard());
				mainContainer.validate();
				mainContainer.repaint();
			}
		} else {
			System.exit(0);
		}
	}

}
