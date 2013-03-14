package mainFrameLauncher;


import javax.swing.SwingUtilities;


import GUI.MainFrame;
import GUIcontroller.FrameSwitcher;


public class MainFrameLauncher {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				runGUI();
			}

		});
	}

	public static void runGUI() {
		MainFrame frame = new MainFrame();
		FrameSwitcher controller = new FrameSwitcher(frame);
		frame.start();
		frame.SwitchFrames(controller);
	}

}
