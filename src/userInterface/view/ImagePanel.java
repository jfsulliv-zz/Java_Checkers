package userInterface.view;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

/**
 * 	<ul>
 * 		<p>ImagePanel sets the background for any JPanel</p>
 * 		@author Daniel
 * 	</ul>
 * 
 *
 */
public class ImagePanel extends JPanel {
	
	private Image image;
	
	/**
	 * <!--Mutator method.-->
	 * 	<style>
	 * 		#method{
	 * 			text-indent: 10.0px;
	 * 		}
	 * 	</style>
	 * 	<ul><li><b>ImagePanel</b></li></ul>
	 * 	<ul><div ID="method"><p>public ImagePanel(Image image)</p></div></ul>
	 * 	<ul> 
	 * 		<p>
	 * 			Takes the given image and sets the size to the images default size. 
	 * 		</p>
	 * 	</ul>
	 * 	<ul>
	 * 		<p>
	 * 			PreCondition: The image given must be in the proper path and the right extension.
	 * 			<br>PostCondition: Will return the image as the new background</br>
	 * 		</p>
	 * 	</ul>
	 * 
	 * 	<ul>
	 *  	@param image  The image to be shown as the background.
	 *  </ul>
	 * 
	 * 
	 */
	public ImagePanel(Image image) {
		this.image = image;
		Dimension size = new Dimension(image.getWidth(null), image.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(image,  0 , 0 ,  null);
	}
	
}
