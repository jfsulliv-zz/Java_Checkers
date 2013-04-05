package userInterface.view;

import javax.swing.JPanel;

/**
 * 	<ul>
 * 		<p>PanelListener is defined as an interface for use by the FrameSwitcher.</p>
 * 		@author Daniel
 * 	</ul>
 *
 */
public interface PanelListener {

	/**
	 * <!--Accessor method.-->
	 * 	<style>
	 * 		#method{
	 * 			text-indent: 10.0px;
	 * 		}
	 * 	</style>
	 * 	<ul><li><b>PanelListener</b></li></ul>
	 * 	<ul><div ID="method"><p>public JPanel gamePanel(int gameMode)</p></div></ul>
	 * 	<ul> 
	 * 		<p>
	 * 			Sets the mode of the game, whether it's single player or multi player.
	 * 			This method is also responsible for showing the appropriate panel depending on
	 * 			what button has been clicked.
	 * 		</p>
	 * 	</ul>
	 * 	<ul>
	 * 		<p>
	 * 			PreCondition: There must be a gamePanel to return.
	 * 			<br>PostCondition: Will return the gamePanel.</br>
	 * 		</p>
	 * 	</ul>
	 * 
	 * 	<ul>
	 *  	@param gameMode  The mode of the game, determined by which button is clicked.
	 *  	@return Return the instance of the games view.
	 *  </ul>
	 * 
	 * 
	 */
	public JPanel gamePanel(int number);
	
	/**
	 * <!--Accessor method.-->
	 * 	<style>
	 * 		#method {
	 * 			text-indent: 10.0px;
	 * 		}
	 * 	</style>
	 * 	<ul><li><b>PanelListener</b></li></ul>
	 * 	<ul><div ID="method"><p>public JPanel mainMenu()</p></div></ul>
	 * 	<ul> 
	 * 		<p>
	 * 			This is the main menu of the GUI. This is not yet implemented.
	 * 		</p>
	 * 	</ul>
	 * 	<ul>
	 * 		<p>
	 * 			PreCondition: There must be a main menu to return.
	 * 			<br>PostCondition: Will return the main menu.</br>
	 * 		</p>
	 * 	</ul>
	 * 
	 * 	<ul>
	 *  	@return Return the instance of the menus view.
	 *  </ul>
	 * 
	 * 
	 */
	public JPanel mainMenu();
	
	/**
	 * <!--Accessor method.-->
	 * 	<style>
	 * 		#method {
	 * 			text-indent: 10.0px;
	 * 		}
	 * 	</style>
	 * 	<ul><li><b>PanelListener</b></li></ul>
	 * 	<ul><div ID="method"><p>public JPanel scoreBoard()</p></div></ul>
	 * 	<ul> 
	 * 		<p>
	 * 			This is the score board of the GUI. This is not yet implemented.
	 * 		</p>
	 * 	</ul>
	 * 	<ul>
	 * 		<p>
	 * 			PreCondition: There must be a score board to return.
	 * 			<br>PostCondition: Will return the score board.</br>
	 * 		</p>
	 * 	</ul>
	 * 
	 * 	<ul>
	 *  	@return Return the instance of the score boards view.
	 *  </ul>
	 * 
	 * 
	 */
	public JPanel scoreBoard();
	
}
