package userInterface.view;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import main.*;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import userInterface.controller.FrameSwitcher;

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
	private int upperBound = 158;
	private int leftBound = 292;
	private String panelName;
	private ImageIcon blueFrogs = new ImageIcon("GUIImages/Other/BlueFrog.png"); 
	private ImageIcon greenFrogs = new ImageIcon("GUIImages/Other/GreenFrog.png"); 
	private ImageIcon blueKing = new ImageIcon("GUIImages/Other/BlueFrogKing.png"); 
	private ImageIcon greenKing = new ImageIcon("GUIImages/Other/GreenFrogKing.png"); 
	private Colour colour;
    private FrameSwitcher frameSwitcher;
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
	public ImagePanel(Image image, String panelName) {
		this.image = image;
		this.panelName = panelName;
		Dimension size = new Dimension(image.getWidth(null), image.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}

	public void paintComponent(Graphics g) {		
		g.drawImage(image,  0 , 0 ,  null);
		
		if (panelName != "GamePanel"){
            return;
            }
        frameSwitcher = frameSwitcher.getInstance();
        frameSwitcher.updateGUI();
        String[][] boardArray = frameSwitcher.stringBoard();
        for(int row = 0; row <= 7; row++){
            for (int column = 0; column <=7; column++){
				
                if(boardArray[column][row] == null){
                    continue;
                }
                if(boardArray[column][row] == "Black King"){
                    greenKing.paintIcon(this, g, row*44+leftBound, column*44+upperBound);
                } else if(boardArray[column][row] == "Black") {
                    greenFrogs.paintIcon(this, g, row*44+leftBound, column*44+upperBound);
                }

                else if(boardArray[column][row] == "Red King") {
                    blueKing.paintIcon(this, g, row*44+leftBound, column*44+upperBound);
                } else if (boardArray[column][row] == "Red")  {
                    blueFrogs.paintIcon(this, g, row*44+leftBound, column*44+upperBound);
                }

            }
        }
        
	}

}
	
