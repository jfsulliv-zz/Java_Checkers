package demo;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JApplet;
import java.awt.*;

public class MouseTest extends JApplet implements MouseListener, MouseMotionListener {
    public static final int SQUARE_LENGTH = 60;
    public static final int RIGHT_BOUND = 703;
    public static final int LEFT_BOUND = 223;
    public static final int UPPER_BOUND = 85;
    public static final int LOWER_BOUND = 565;
    private int clickNumber = 0;
    
    private Cursor cursorShape = this.getCursor();
    private boolean inBound;
    private int xCoord;
    private int yCoord;
    private int xBoardCoord;
    private int yBoardCoord;
    
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
        xBoardCoord = 0;
        yBoardCoord = 0;
        if (inBound){
            xBoardCoord = (int)Math.floor((e.getX() - LEFT_BOUND) / SQUARE_LENGTH) + 1;
            yBoardCoord = (int)Math.floor((e.getY() - UPPER_BOUND) / SQUARE_LENGTH) + 1;
            xCoord = e.getX();
            yCoord = e.getY(); 
            clickNumber++;
            }
        if (clickNumber == 2){
            clickNumber = 0;
            }
        repaint();
        System.out.println("xBoardCoord: " +xBoardCoord +" yBoardCoord: " +yBoardCoord);
        System.out.println(e.getX() +" " +e.getY());
                 
    }

    public void paint(Graphics canvas) {
        int ySquareCoord = 85;
        int xSquareCoord = 223;
        for (int i = 1; i <= 8; i++){
            xSquareCoord = 223;
            for (int j = 1; j <= 8; j++){
                if (clickNumber == 1){
                    canvas.setColor(Color.BLUE);
                    canvas.fillRect((xBoardCoord - 1) * SQUARE_LENGTH + LEFT_BOUND, (yBoardCoord - 1) * SQUARE_LENGTH + UPPER_BOUND,
                    SQUARE_LENGTH, SQUARE_LENGTH);
                    canvas.setColor(Color.BLACK);
                    canvas.drawRect((xBoardCoord - 1) * SQUARE_LENGTH + LEFT_BOUND, (yBoardCoord - 1) * SQUARE_LENGTH + UPPER_BOUND,
                    SQUARE_LENGTH, SQUARE_LENGTH);
                    }
                else{
                    canvas.setColor(Color.WHITE);
                    canvas.fillRect(xSquareCoord, ySquareCoord, SQUARE_LENGTH, SQUARE_LENGTH);
                    canvas.setColor(Color.BLACK);
                    canvas.drawRect(xSquareCoord, ySquareCoord, SQUARE_LENGTH, SQUARE_LENGTH);
                    }
                xSquareCoord = xSquareCoord + SQUARE_LENGTH;
            }
            ySquareCoord = ySquareCoord + SQUARE_LENGTH;
            }
        }       

    }