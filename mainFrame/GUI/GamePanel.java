package GUI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

	private JButton btnQuit;
	private ImageIcon quitButton, rollOverQuitButton;
	
	public GamePanel() {
		setLayout(null);
		ImagePanel background = new ImagePanel(new ImageIcon("GUIImages\\GamePanelBackground.jpg").getImage());
		
		quitButton = new ImageIcon("GUIImages\\gamePanelQuitButton.png");
		rollOverQuitButton = new ImageIcon("GUIImages\\rollOverGamePanelQuitButton.png");
		btnQuit = new JButton(quitButton);
		btnQuit.setOpaque(false);
		btnQuit.setContentAreaFilled(false);
		btnQuit.setBorderPainted(false);
		btnQuit.setFocusPainted(false);
		btnQuit.setBounds(385, 480, 145, 105);
		btnQuit.setRolloverIcon(rollOverQuitButton);
		
		add(btnQuit);
		add(background);
		
	}
}
