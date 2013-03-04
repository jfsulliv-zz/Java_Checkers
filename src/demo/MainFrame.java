package demo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
/**
 * This method is a mutator. It sets the JPanel.
 */
	private void panel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exits the game once the window is closed.
		setSize(920, 650); // Sets the size of the frame. 
		mainMenu = new JPanel();
		setContentPane(mainMenu);
		mainMenu.setLayout(null);

		/*
		 * Adjusts the JPanel so it is located in the center of users screen.
		 */
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); 
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height/ 2 - this.getSize().height / 2);

		setVisible(true);
	}

	/**
	 * This method is a mutator. It creates our Single-Player Button, creates its location, and add's it to our Main Menu.
	 * Pre-Conditions: JPanel has to exist.
	 * Post-Conditions: There will be a button created.
	 */
	private void singlePlayerButton() {
		btnSinglePlayer = new JButton("SinglePlayer");
		btnSinglePlayer.setBounds(365, 210, 170, 55);
		mainMenu.add(btnSinglePlayer);
      
      	btnSinglePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				singlePlayerMultiPlayerMenu();
				
				backToMainMenu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						new NewMainFrame();
					}

				});

				exit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);

					}
				});

				statistics.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new StatisticsPanel();
						
					}
				});
				mainMenu.revalidate();
				mainMenu.repaint();

			}
		});

		
		/*
		 * Enables clicking and opens new frame.
		 */
		
		btnSinglePlayer.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    
		    		panel();
		         
		    }
		});
	}
	/**
	 * This method is a mutator. It creates our Multi-Player Button, creates its location, and add's it to our Main Menu.
	 * Pre-Conditions: JPanel has to exist.
	 * Post-Conditions: There will be a button created.
	 */
	private void multiPlayerButton() {
		btnMultiPlayer = new JButton("MultiPlayer");
		btnMultiPlayer.setBounds(365, 300, 170, 55);
		mainMenu.add(btnMultiPlayer);
		
		/*
		 * Enables clicking and opens new frame.
		 */
		
		btnMultiPlayer.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        
		    	panel();
		        
		    }
		});
	}
	/**
	 * This method is a mutator. It creates our Scoreboard Button, creates its location, and add's it to our Main Menu.
	 * Pre-Conditions: JPanel has to exist.
	 * Post-Conditions: There will be a button created.
	 */
	private void scoreBoards() {
		btnScoreBoards = new JButton("Scoreboards");
		btnScoreBoards.setBounds(365, 411, 170, 55);
		mainMenu.add(btnScoreBoards);
		
		/*
		 * Enables clicking and opens new frame.
		 */
	}
	/**
	 * This method is a mutator.It creates our Quit Button, creates its location, and add's it to our Main Menu.
	 *	Pre-Conditions: JPanel has to exist.
	 * Post-Conditions: There will be a button created.
	 */
	private void quit() {

		btnQuit = new JButton("Quit");
		btnQuit.setBounds(365, 500, 170, 55);
		mainMenu.add(btnQuit);
      
      		btnQuit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		});
		/*
		 * Enables clicking and quits the frame.
		 */
	}
}
