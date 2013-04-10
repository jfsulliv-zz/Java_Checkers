package userInterface.view;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import userInterface.controller.ScoreDataHandler;

/**
 * 	<ul>
 * 		<p>Creates the view for the score panel. This panel will show the users scores.</p>
 * 		@author Daniel
 * 	</ul>
 *
 */
public class ScorePanel extends JPanel {

	private ScoreDataHandler controller = new ScoreDataHandler();
	private JLabel wins, losses, gamesPlayed;
	
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
		ImagePanel background = new ImagePanel(new ImageIcon("GUIImages/Other/ScoreBoard.png").getImage(),"ScoreBoard");

		wins = new JLabel(controller.getWin());
		wins.setFont(new Font("Serif", Font.PLAIN, 45));
		wins.setBounds(500, 195, 50, 50);
		
		losses = new JLabel(controller.getLoss());
		losses.setFont(new Font("Serif", Font.PLAIN, 45));
		losses.setBounds(500, 290, 50, 50);
		
		gamesPlayed = new JLabel(controller.getGamesPlayed());
		gamesPlayed.setFont(new Font("Serif", Font.PLAIN, 45));
		gamesPlayed.setBounds(500, 400, 50, 50);
		
		add(wins);
		add(losses);
		add(gamesPlayed);
		add(background);
	}
}
