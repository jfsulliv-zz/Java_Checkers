package userInterface.controller;

import main.GameLauncher;
import userInterface.view.IModel;

/**
 * 	<ul>
 * 		<p>Creates a handle on the model of the data.</p>
 * 		@author Daniel
 * 	</ul>
 * 
 *
 */
public class ModelController implements IModel {
	
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
	public void gameInstance(int mode) {
		Thread gameLauncher = new Thread(new GameLauncher(mode));
		System.out.println("GameInstance event: Recieved");
		gameLauncher.start();
	}

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
	public void scoreBoardInstance() {
		System.out.println("ScoreBoardInstance event: Recieved");
	}

}
