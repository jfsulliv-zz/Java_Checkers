package userInterface.view;

import javax.swing.JPanel;

/**
 * 
 * @author Daniel
 *
 * PanelListener is defined as an interface for use by the FrameSwitcher.
 */
public interface PanelListener {

	public JPanel gamePanel(int number);
	
	public JPanel mainMenu();
	
	public JPanel scoreBoard();
	
	public int getGameMode();
}
