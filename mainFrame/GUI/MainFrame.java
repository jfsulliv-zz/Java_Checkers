package GUI;

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
 * 
 * 
 */
public class MainFrame extends JFrame implements ActionListener {

	private JFrame mainContainer = new JFrame("Frog Checkers");
	private PanelListener panelListener;
	private JPanel mainMenu;
	private static JButton btnSinglePlayer, btnMultiPlayer, btnScoreBoards,
	btnQuit;
	private ImagePanel background;
	private ImageIcon singlePlayerButton, rollOverSinglePlayerButton,
	multiPlayerButton, scoreBoardButton, rollOverScoreBoardButton,
	rollOverMultiPlayerButton, quitButton, rollOverQuitButton;

	public void start() {
		mainContainer(mainMenu());
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
	
	private JPanel mainMenu() {
		mainMenu = new JPanel();
		mainMenu.setLayout(null);
		
		background = new ImagePanel(new ImageIcon(
				"GUIImages\\newBackground.png").getImage());
		
		
		singlePlayerButton = new ImageIcon("GUIImages\\singlePlayerButton.png");
		rollOverSinglePlayerButton = new ImageIcon(
				"GUIImages\\rollOverSinlgePlayerButton.png");
		btnSinglePlayer = new JButton(singlePlayerButton);
		btnSinglePlayer.setOpaque(false);
		btnSinglePlayer.setContentAreaFilled(false);
		btnSinglePlayer.setBorderPainted(false);
		btnSinglePlayer.setFocusPainted(false);
		btnSinglePlayer.setBounds(320, 25, 275, 130);
		btnSinglePlayer.setRolloverIcon(rollOverSinglePlayerButton);
		btnSinglePlayer.addActionListener(this);
		mainMenu.add(btnSinglePlayer);
		
		multiPlayerButton = new ImageIcon("GUIImages\\multiPlayerButton.png");
		rollOverMultiPlayerButton = new ImageIcon(
				"GUIImages\\rollOverMultiPlayerButton.png");
		btnMultiPlayer = new JButton(multiPlayerButton);
		btnMultiPlayer.setOpaque(false);
		btnMultiPlayer.setContentAreaFilled(false);
		btnMultiPlayer.setBorderPainted(false);
		btnMultiPlayer.setFocusPainted(false);
		btnMultiPlayer.setBounds(320, 170, 275, 130);
		btnMultiPlayer.setRolloverIcon(rollOverMultiPlayerButton);
		btnMultiPlayer.addActionListener(this);
		mainMenu.add(btnMultiPlayer);

		scoreBoardButton = new ImageIcon("GUIImages\\scoreBoardButton.png");
		rollOverScoreBoardButton = new ImageIcon(
				"GUIImages\\rollOverScoreBoardButton.png");
		btnScoreBoards = new JButton(scoreBoardButton);
		btnScoreBoards.setOpaque(false);
		btnScoreBoards.setContentAreaFilled(false);
		btnScoreBoards.setBorderPainted(false);
		btnScoreBoards.setFocusPainted(false);
		btnScoreBoards.setBounds(13, 380, 225, 73);
		btnScoreBoards.setRolloverIcon(rollOverScoreBoardButton);
		btnScoreBoards.addActionListener(this);
		mainMenu.add(btnScoreBoards);

		quitButton = new ImageIcon("GUIImages\\quitButton.png");
		rollOverQuitButton = new ImageIcon("GUIImages\\rollOverQuitButton.png");
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

	public void SwitchFrames(PanelListener panelListener) {
		this.panelListener = panelListener;
	}

	@Override
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
