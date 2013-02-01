import javax.swing.SwingUtilities;

/**
 * The application for testing MainFrame.
 * 
 */

public class MainFrameTest {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() { 
				/**
				 * This method is an accessor. 
				 */
				new MainFrame(); //Command that calls the MainFrame.
				
			}
		
		});
		
	}

}
