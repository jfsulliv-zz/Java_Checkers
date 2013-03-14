package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame {

	private PanelListener panelListener;
	private JFrame mainContainer = new JFrame("Checkers");
	private JPanel mainMenu = new JPanel();
	private JButton btnSinglePlayer, btnMultiPlayer, btnScoreBoard, btnQuit;
	public void start() {
		
	}
	
	private JFrame mainContainer(JPanel frame) {
		return mainContainer;
	}
	
	private JPanel mainMenu() {
		return mainMenu;
	}
	public void SwitchFrames(PanelListener panelListener) {
		this.panelListener = panelListener;
	}
}
