package mainFrameLauncher;


import javax.swing.SwingUtilities;


import GUI.MainFrame;
import GUIcontroller.FrameSwitcher;


public class MainFrameLauncher {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				runGUI(); // Runs the GUI
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
