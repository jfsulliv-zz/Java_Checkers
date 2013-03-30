package userInterface;

import javax.swing.SwingUtilities;

import main.Game;

import userInterface.controller.FrameSwitcher;
import userInterface.controller.ModelController;
import userInterface.view.GamePanel;
import userInterface.view.IModel;
import userInterface.view.MainFrame;

public class MainFrameLauncher {

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

	public static void runGUI() {
		
		ModelController modelController = new ModelController(); // Create an instance of the modelController
		MainFrame frame = new MainFrame(); // Create an instance of the MainFrame
		FrameSwitcher controller = new FrameSwitcher(frame); // Create an instance of the FrameSwitcher
		frame.start(); // Start the frame
		
		frame.SwitchFrames(controller); // Set the controller
		controller.setCoordinates(modelController); // Set a handle on the modelController for the frameSwitcher
	}

}
