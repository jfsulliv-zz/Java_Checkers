package userInterface.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import userInterface.controller.ModelController;
import main.Game;
import main.GameLauncher;
import main.Location;

/**
 * 
 * @author Daniel
 * 
 * Creates a GamePanel with a board that returns locations, for now in the terminal.
 *
 */
public class GamePanel extends JPanel implements ActionListener {

	private JButton btnQuit;
	private ImageIcon quitButton, rollOverQuitButton;
    private MouseHandler mouseHandler; 
    private int topLeftX = 292;
    private int topLeftY = 158;
    private static final int SQUARE_LENGTH = 44;
    private ModelController modelController;
    private GameLauncher gameMode;
	
    /**
     * Mutator
     * 
     * Constructs the view for the game panel.
     */
	public GamePanel() {
		setLayout(null);
		// The background is set through an ImagePanel, defined in it's own class. The image can be found
		// in the indicated path. 
		ImagePanel background = new ImagePanel(new ImageIcon("GUIImages\\Other\\FormalBackground.png").getImage());
		// Set the button equal to an ImageIcon and also add a roll over image.
		quitButton = new ImageIcon("GUIImages\\Buttons\\gamePanelQuitButton.png"); 
		//quitButton = new ImageIcon(getClass().getResource("GUIImages\\gamePanelQuitButton.jpg"));
		rollOverQuitButton = new ImageIcon("GUIImages\\Buttons\\rollOverGamePanelQuitButton.png"); 
		btnQuit = new JButton(quitButton);
		// This next bit will make the default JButton invisible and will hide any of the 
		// default borders.
		btnQuit.setOpaque(false);
		btnQuit.setContentAreaFilled(false);
		btnQuit.setBorderPainted(false);
		btnQuit.setFocusPainted(false);
		// Set the button
		btnQuit.setBounds(435, 520, 71, 46);
		btnQuit.setRolloverIcon(rollOverQuitButton);
		btnQuit.addActionListener(this);
		// The mouseHandler will set the board to return location values in the terminal.
        mouseHandler = new MouseHandler(this, topLeftX, topLeftY, SQUARE_LENGTH); 
		add(btnQuit);
		add(background);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton)e.getSource();
		// Exit the game if quit is clicked
		if(source == btnQuit) {
			System.exit(0);
		}
	}

	public void gameMode(ModelController modelController) {
		this.modelController = modelController;
		
	}
	
}
