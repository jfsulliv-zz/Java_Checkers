package GUI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenu extends JPanel {
	
	private JPanel mainMenu = new JPanel();
	private JButton btnSinglePlayer, btnMultiPlayer, btnScoreBoard, btnQuit;
	private ImageIcon singlePlayerButton, rollOverSinglePlayerButton, multiPlayerButton, 
					  scoreBoardButton, rollOverScoreBoardButton, 
					  rollOverMultiPlayerButton, quitButton, rollOverQuitButton;
	
	public JPanel mainMenuPanel() {
		mainMenu.setLayout(null);
		ImagePanel background = new ImagePanel(new ImageIcon("GUIImages\\newBackground.png").getImage());
		
		singlePlayerButton = new ImageIcon("GUIImages\\singlePlayerButton.png");
		rollOverSinglePlayerButton = new ImageIcon("GUIImages\\rollOverSinlgePlayerButton.png");
		btnSinglePlayer = new JButton(singlePlayerButton);
		btnSinglePlayer.setOpaque(false);
		btnSinglePlayer.setContentAreaFilled(false);
		btnSinglePlayer.setBorderPainted(false);
		btnSinglePlayer.setFocusPainted(false);
		btnSinglePlayer.setBounds(320, 25, 275, 130);
		btnSinglePlayer.setRolloverIcon(rollOverSinglePlayerButton);
		mainMenu.add(btnSinglePlayer);
		
		multiPlayerButton = new ImageIcon("GUIImages\\multiPlayerButton.png");
		rollOverMultiPlayerButton = new ImageIcon("GUIImages\\rollOverMultiPlayerButton.png");
		btnMultiPlayer = new JButton(multiPlayerButton);
		btnMultiPlayer.setOpaque(false);
		btnMultiPlayer.setContentAreaFilled(false);
		btnMultiPlayer.setBorderPainted(false);
		btnMultiPlayer.setFocusPainted(false);
		btnMultiPlayer.setBounds(320, 170, 275, 130);
		btnMultiPlayer.setRolloverIcon(rollOverMultiPlayerButton);
		mainMenu.add(btnMultiPlayer);

		scoreBoardButton = new ImageIcon("GUIImages\\scoreBoardButton.png");
		rollOverScoreBoardButton = new ImageIcon("GUIImages\\rollOverScoreBoardButton.png");
		btnScoreBoard = new JButton(scoreBoardButton);
		btnScoreBoard.setOpaque(false);
		btnScoreBoard.setContentAreaFilled(false);
		btnScoreBoard.setBorderPainted(false);
		btnScoreBoard.setFocusPainted(false);
		btnScoreBoard.setBounds(13, 380, 225, 73);
		btnScoreBoard.setRolloverIcon(rollOverScoreBoardButton);
		mainMenu.add(btnScoreBoard);

		quitButton = new ImageIcon("GUIImages\\quitButton.png");
		rollOverQuitButton = new ImageIcon("GUIImages\\rollOverQuitButton.png");
		btnQuit = new JButton(quitButton);
		btnQuit.setOpaque(false);
		btnQuit.setContentAreaFilled(false);
		btnQuit.setBorderPainted(false);
		btnQuit.setFocusPainted(false);
		btnQuit.setBounds(45, 460, 120, 85);
		btnQuit.setRolloverIcon(rollOverQuitButton);
		mainMenu.add(btnQuit);
		
		mainMenu.add(background);

		return mainMenu;
	}
}

