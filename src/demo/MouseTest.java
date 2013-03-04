package demo;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import javax.swing.JApplet;
import java.awt.*;

public class MouseTest extends JApplet implements MouseListener, MouseMotionListener {
    public static final int SQUARE_LENGTH = 60;
    public static final int RIGHT_BOUND = 687;
    public static final int LEFT_BOUND = 238;
    public static final int UPPER_BOUND = 85;
    public static final int LOWER_BOUND = 565;
    
    private Cursor cursorShape = this.getCursor();
    private boolean inBound;
    private int xCoord;
    private int yCoord;
    
    public MouseTest(){
        addMouseListener(this);
        addMouseMotionListener(this);
        }
    public void mousePressed(MouseEvent e) {
       
    }

    public void mouseReleased(MouseEvent e) {
       
    }

    public void mouseEntered(MouseEvent e) {
        
        
    }
    public void mouseDragged(MouseEvent e) {
       
    }
    public void mouseMoved(MouseEvent e) {
        
        if (e.getX() > LEFT_BOUND && e.getX() < RIGHT_BOUND && e.getY() > UPPER_BOUND && e.getY() < LOWER_BOUND){
            this.setCursor(cursorShape.getPredefinedCursor(cursorShape.HAND_CURSOR));
            inBound = true;
            
        }
        else{
            this.setCursor(cursorShape.getPredefinedCursor(cursorShape.DEFAULT_CURSOR));
            inBound = false;
        }
    
    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e) {
        xCoord = 0;
        yCoord = 0;
        if (inBound){
            xCoord = (int)Math.floor((e.getX() - LEFT_BOUND) / SQUARE_LENGTH) + 1;
            yCoord = (int)Math.floor((e.getY() - UPPER_BOUND) / SQUARE_LENGTH) + 1;
            }
        System.out.println("xCoord: " +xCoord +" yCoord: " +yCoord);
        System.out.println(e.getX() +" " +e.getY());
                 
    }
    public void paint(Graphics canvas) {
        int ySquareCoord = 85;
        int xSquareCoord = 223;
        for (int i = 1; i <= 8; i++){
            xSquareCoord = 223;
            for (int j = 1; j <= 7; j++){
                canvas.drawRect(xSquareCoord, ySquareCoord, SQUARE_LENGTH, SQUARE_LENGTH);
                xSquareCoord = xSquareCoord + SQUARE_LENGTH;
            }
            canvas.drawRect(xSquareCoord, ySquareCoord, SQUARE_LENGTH, SQUARE_LENGTH);
            ySquareCoord = ySquareCoord + SQUARE_LENGTH;
        }
     }       

}
