import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

	
	private JButton btnSinglePlayer, btnMultiPlayer, btnScoreBoards, btnQuit;
	private JPanel mainMenu;

	public MainFrame() {
		super("Checkers");
		panel();
		singlePlayerButton();
		multiPlayerButton();
		scoreBoards();
		quit();

	}

	private void panel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(920, 650);
		mainMenu = new JPanel();
		mainMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainMenu);
		mainMenu.setLayout(null);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height/ 2 - this.getSize().height / 2);

		setVisible(true);
	}

	private void singlePlayerButton() {
		btnSinglePlayer = new JButton("SinglePlayer");
		btnSinglePlayer.setBounds(365, 210, 170, 55);
		mainMenu.add(btnSinglePlayer);

	}

	private void multiPlayerButton() {
		btnMultiPlayer = new JButton("MultiPlayer");
		btnMultiPlayer.setBounds(365, 300, 170, 55);
		mainMenu.add(btnMultiPlayer);

	}

	private void scoreBoards() {
		btnScoreBoards = new JButton("Scoreboards");
		btnScoreBoards.setBounds(365, 411, 170, 55);
		mainMenu.add(btnScoreBoards);

	}

	private void quit() {

		btnQuit = new JButton("Quit");
		btnQuit.setBounds(365, 500, 170, 55);
		mainMenu.add(btnQuit);
	}
}
