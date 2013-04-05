package userInterface.view;

import main.*;

/**
 * 	<ul>
 * 		<p> This interface is defined for use by ModelController class. </p>
 * 		@author Daniel
 * 	</ul>
 *
 */
public interface IModel {

	/**
	 * 	<!--Accessor Method-->
	 * 	<style>
	 * 		#method {
	 * 			text-indent: 10.0px;
	 * 		}
	 * 	</style>
	 * 	<ul>
	 * 		<li><b>IModel</b></li>
	 * 	</ul>
	 * 	<ul><div ID="method"><p>public void gameInstance(int mode)</p></div></ul>
	 * 	<ul>
	 * 		<p> 
	 * 			This will create a handle on the model data. Specifically it will get the
	 * 			game mode; single player or multi player. Also it will speak the HumanPlayer 
	 * 			class by constantly sending locations to be checked for validity. 
	 * 		</p>
	 * 		<p>
	 *  		PreCondition: A mode must be passed in. 
	 *  		<br>PostCondition: A mode will chosen and the game will begin.<br>
	 * 		</p>
	 * 	</ul>
	 * 	<ul>
	 * 		@param mode The mode of the game, determined by which button is clicked.
	 * 	</ul>
	 */
	public void gameInstance(int mode);
	
	/**
	 * 	<!--Accessor Method-->
	 * 	<style>
	 * 		#method {
	 * 			text-indent: 10.0px;
	 * 		}
	 * 	</style>
	 * 	<ul>
	 * 		<li><b>IModel</b></li>
	 * 	</ul>
	 * 	<ul><div ID="method"><p>public void scoreBoardInstance</p></div></ul>
	 * 	<ul>
	 * 		<p> 
	 * 			This will create a handle on the model data. Specifically it will gather the
	 * 			data stored containing the wins and losses for the user. If no file exists,
	 * 			a file will be created that contains zero wins and zero losses. 
	 * 		</p>
	 * 	</ul>
	 */
	public void scoreBoardInstance();
	
	public void setStartLocation(Player currentPlayer, Location aLoc);
	public void setEndLocation(Player currentPlayer, Location aLoc);
	public void makeMove(Player currentPlayer);
	public boolean validSelectionMade();
	
}
