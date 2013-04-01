package userInterface.view;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * 	<ul>
 * 		<p>Creates the view for the score panel. This panel will show the users scores.</p>
 * 		@author Daniel
 * 	</ul>
 *
 */
public class ScorePanel extends JPanel {

	 /**
     *<!--Mutator-->
     *	<ul>
     *		<li><strong>ScorePanel</strong></li>
     *	</ul>
     *	<style> 
     *		div {
     *			text-indent: 10.0px;
     *		}
     *	</style>
     *	<ul>
     * 		<div><p>public ScorePanel()</p></div>
     * 		<p>
     * 			Creates the view for the score panel and displays the users current scores. 
     * 		</p>
     *	</ul>
     */
	public ScorePanel() {
		setLayout(null);
		ImagePanel background = new ImagePanel(new ImageIcon("GUIImages/Other/ScoreBoardView.png").getImage());

		add(background);
	}
}
