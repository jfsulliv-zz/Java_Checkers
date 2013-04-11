package userInterface;

import javax.swing.SwingUtilities;

import main.Game;


import userInterface.controller.FrameSwitcher;
import userInterface.controller.ModelController;
import userInterface.view.MainFrame;

/**
 * 	
 * 	<ul>
 * 		<p>MainFrameLauncher is a thread safe launcher for the application</p>
 * 		@author Daniel
 * 	</ul>
 *
 */
public class MainFrameLauncher {

	private ModelController modelController;
	private static FrameSwitcher controller;
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try{
					runGUI(); // Runs the GUI 
				}
				catch (Exception event) {
					event.printStackTrace();
				}
			}

		});

	}
	
	/**
	 * 	<!--Accessor-->
	 * 
	 * 	<style>
	 * 		#method {
	 * 			text-indent: 10.0px;
	 * 		}
	 * 	</style>
	 * 
	 * 	<ul><li><b>MainFrameLauncher</b></li></ul>
	 * 	<ul><div ID="method">public static void runGUI()</div></ul>
	 * 	<ul>
	 * 		<p>
	 * 			This method will create the connection between the model, view and controller.
	 * 		</p>
	 * 	</ul>
	 */
	public static void runGUI() {
		ModelController modelController = new ModelController(); // Create an instance of the modelController
		MainFrame frame = new MainFrame(); // Create an instance of the MainFrame
		controller = FrameSwitcher.getInstance(frame); // Create an instance of the FrameSwitcher
		frame.start(); // Start the frame
		frame.SwitchFrames(controller); // Set the controller
		controller.setCoordinates(modelController); // Set a handle on the modelController for the frameSwitcher
	}

}
