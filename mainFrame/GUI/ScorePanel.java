package GUI;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ScorePanel extends JPanel {

	public ScorePanel() {
		setLayout(null);
		ImagePanel background = new ImagePanel(new ImageIcon("GUIImages\\ScoreBoardView.png").getImage());

		add(background);
	}
}
