package userInterface.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
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
    private int topLeftX = 285;
    private int topLeftY = 145;
    private static final int SQUARE_LENGTH = 44;
	
    /**
     * Mutator
     * 
     * Constructs the view for the game panel.
     */
	public GamePanel() {
		setLayout(null);
		// The background is set through an ImagePanel, defined in it's own class. The image can be found
		// in the indicated path. 
		ImagePanel background = new ImagePanel(new ImageIcon("GUIImages\\GamePanelBackground.jpg").getImage());
		// Set the button equal to an ImageIcon and also add a roll over image.
		quitButton = new ImageIcon("GUIImages\\gamePanelQuitButton.png"); 
		//quitButton = new ImageIcon(getClass().getResource("GUIImages\\gamePanelQuitButton.jpg"));
		rollOverQuitButton = new ImageIcon("GUIImages\\rollOverGamePanelQuitButton.png"); 
		btnQuit = new JButton(quitButton);
		// This next bit will make the default JButton invisible and will hide any of the 
		// default borders.
		btnQuit.setOpaque(false);
		btnQuit.setContentAreaFilled(false);
		btnQuit.setBorderPainted(false);
		btnQuit.setFocusPainted(false);
		// Set the button
		btnQuit.setBounds(385, 480, 145, 105);
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
}
