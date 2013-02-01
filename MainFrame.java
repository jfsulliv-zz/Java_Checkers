 import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private JButton btnSinglePlayer, btnMultiPlayer, btnScoreBoards, btnQuit;
	private JPanel mainMenu;

	/**
	 * The constructor method of the class. This constructor calls the private methods of the
	 * class, therefore returning the main JPanel frame that it has to draw.
	 */
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
