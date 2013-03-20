package mainFrameLauncher;


import javax.swing.SwingUtilities;

import controller.FrameSwitcher;


import GUI.MainFrame;


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
		MainFrame frame = new MainFrame(); // Create an instance of the MainFrame
		FrameSwitcher controller = new FrameSwitcher(frame); // Create an instance of the FrameSwitcher
		frame.start(); // Start the frame
		frame.SwitchFrames(controller); // Set the controller
	}

}
