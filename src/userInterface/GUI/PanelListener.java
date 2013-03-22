package userInterface.GUI;

import javax.swing.JPanel;

/**
 * 
 * @author Daniel
 *
 * PanelListener is defined as an interface for use by the FrameSwitcher.
 */
public interface PanelListener {

	public JPanel gamePanel();
	
	public JPanel mainMenu();
	
	public JPanel scoreBoard();
}
