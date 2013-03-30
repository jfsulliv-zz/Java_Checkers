package userInterface.view;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * 
 * @author Daniel
 *
 * Constructs the Score Panel.
 */
public class ScorePanel extends JPanel {

	/**
	 * Mutator
	 * 
	 * Constructs the view for the score Boards.
	 */
	public ScorePanel() {
		setLayout(null);
		ImagePanel background = new ImagePanel(new ImageIcon("GUIImages/Other/ScoreBoardView.png").getImage());

		add(background);
	}
}
