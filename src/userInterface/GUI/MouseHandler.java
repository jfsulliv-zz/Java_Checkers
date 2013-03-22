package userInterface.GUI;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.JPanel;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import main.Location;

public class MouseHandler implements MouseListener, MouseMotionListener{
    private int squareLength;
    private int leftBound;
    private int rightBound;
    private int upperBound;
    private int lowerBound;
    private Location topLeft;
    private Component component;
    private int clickNumber = 0;
    private int xCoord;
    private int yCoord;
    private int xBoardCoord;
    private int yBoardCoord;
    private boolean inBound;
    private Cursor cursorShape;
    
    public MouseHandler(Component aComponent, Location topLeft, int squareLength){
        this.topLeft = topLeft;
        this.squareLength = squareLength;
        this.component = aComponent;
        leftBound = topLeft.getX();
        upperBound = topLeft.getY();
        rightBound = 8*squareLength + leftBound;
        lowerBound = 8*squareLength + upperBound;
        
        component.addMouseListener(this);
        component.addMouseMotionListener(this);
        cursorShape = component.getCursor();
        
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
        
        if (e.getX() > leftBound && e.getX() < rightBound && e.getY() > upperBound && e.getY() < lowerBound){
            component.setCursor(cursorShape.getPredefinedCursor(cursorShape.HAND_CURSOR));
            inBound = true;
            
        }
        else{
            component.setCursor(cursorShape.getPredefinedCursor(cursorShape.DEFAULT_CURSOR));
            inBound = false;
        }
    
    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e) {
        xBoardCoord = 0;
        yBoardCoord = 0;
        if (inBound){
            xBoardCoord = (int)Math.floor((e.getX() - leftBound) / squareLength);
            yBoardCoord = (int)Math.floor((e.getY() - upperBound) / squareLength);
            xCoord = e.getX();
            yCoord = e.getY(); 
            clickNumber++;
            }
        if (clickNumber == 2){
            clickNumber = 0;
            }
        System.out.println("xBoardCoord: " +xBoardCoord +" yBoardCoord: " +yBoardCoord);
        System.out.println(e.getX() +" " +e.getY());
                 
        }
    public Location getLocation(){return new Location(xBoardCoord, yBoardCoord);} 
    
    public int getClickNumber(){return clickNumber;}
    
    // public void highLightSquare(Graphics canvas, Location boardCoord){
        // if (clickNumber == 1){
            // canvas.setColor(Color.BLUE);
            // canvas.drawRect(boardCoord.getX() * squareLength + leftBound, 
                // boardCoord.getY() * squareLength + upperBound, squareLength, squareLenght);
            // }
        // else{
            
            // }
        // repaint();
        // }
           

    }           
            