package userInterface.GUI;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class ImagePanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5882571991300339926L;
	private Image image;
	
	public ImagePanel(String image) {
		this(new ImageIcon(image).getImage());
	}
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
