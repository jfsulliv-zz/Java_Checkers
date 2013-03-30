package userInterface.view;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

/**
 * 
 * @author Daniel
 * 
 * ImagePanel will allow us to create a background image for any panel.
 *
 */
public class ImagePanel extends JPanel {
	
	private Image image;
	
	/**
	 * Mutator
	 * 
	 * @param image
	 * 
	 * A constructor that manipulates the image.
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
	/**
	 * Mutator
	 * 
	 * Draws the image specified.
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(image,  0 , 0 ,  null);
	}
	
}
