package userInterface.controller;

import main.*;
import userInterface.view.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import main.Location;
import main.OutOfBoundsException;

/**
 * MouseHandler class to take input fromt the gui. Uses mouse listeners to
 * identify the board piece selected.
 * 
 * @author Dylan
 */

public class MouseHandler implements MouseListener, MouseMotionListener {
	private Component component;
	private IModel modelController;
    private FrameSwitcher frameSwitcher;
	private Cursor cursorShape;
	
	private int squareLength, leftBound, rightBound, upperBound, lowerBound;
	private int clickNumber = 0;
	private boolean inBound;
	
	private Game game;
	private Player player;
	
	private Location start, end;
	private int xBoardCoord, yBoardCoord;
	
	/**
	 * Constructor used to add the mouse handler to the panel with the proper
	 * bounds.
	 * 
	 * @param aComponent
	 *            A component to add mouseHandler to.
	 * @param topLeft
	 *            The top left coordinate of the board.
	 * @param squareLength
	 *            The length of a single square on the board.
	 * @author Dylan
	 */
	public MouseHandler(Component aComponent, int topLeftX, int topLeftY,
			int squareLength, IModel modelController) {
		this.game = Game.getInstance();
		this.squareLength = squareLength;
		this.component = aComponent;
		this.modelController = modelController;
		leftBound = topLeftX;
		upperBound = topLeftY;
		rightBound = 8 * squareLength + leftBound;
		lowerBound = 8 * squareLength + upperBound;

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

	/**
	 * MouseMoved listens for mouse movement and changes the cursor when it
	 * moves within bounds of the board.
	 * 
	 * @param e
	 *            The mouse event listened for.
	 */
	public void mouseMoved(MouseEvent e) {

		if (e.getX() > leftBound && e.getX() < rightBound
				&& e.getY() > upperBound && e.getY() < lowerBound) {
			component.setCursor(cursorShape.getPredefinedCursor(cursorShape.HAND_CURSOR));
			inBound = true;

		} else {
			component.setCursor(cursorShape.getPredefinedCursor(cursorShape.DEFAULT_CURSOR));
			inBound = false;
		}

	}

	public void mouseExited(MouseEvent e) {

	}

	/**
	 * Listens for mouse clicks on the screen. Sets the start and end locations
	 * for moving pieces and resets them when the turn is over.
	 * 
	 * @param e
	 *            The mouse event listened for.
	 * @author Dylan
	 */
	public void mouseClicked(MouseEvent e) {
		// If the Player is not a Human player or is a null, any mouse events are ignored
		if(game.currentPlayer().isHuman() == false || game.currentPlayer() == null) {
			return;
		} else {
			player = game.currentPlayer();
		}
		
		// If the Player is jumping a second piece, it can only select an end-point
		if(game.currentPlayer().isContinueMove() == true){
			clickNumber = 1;
		}
		this.frameSwitcher = FrameSwitcher.getInstance();
		if (inBound) {
			xBoardCoord = (int) Math.floor((e.getX() - leftBound)
					/ squareLength);
			yBoardCoord = (int) Math.floor((e.getY() - upperBound)
					/ squareLength);
			clickNumber++;
		}
		
		
		if (clickNumber == 1) {
			try {
				
				start = new Location(xBoardCoord, yBoardCoord);
				modelController.setStartLocation(player,start);
				
				if(!modelController.validSelectionMade()) {
					clickNumber = 0;
					start = null;
					return;
                }
                frameSwitcher.updateGUI(start);
				
			} catch (OutOfBoundsException e1) {
				e1.printStackTrace();
			}
		} else if (clickNumber == 2) {
			try {
                frameSwitcher.setHighlight(false);
                frameSwitcher.updateGUI();
				end = new Location(xBoardCoord, yBoardCoord);
				modelController.setEndLocation(player, end);
				
				if(!modelController.validSelectionMade()){
					clickNumber = 0;
					start = null;
					end = null;
					return;
				} else {
					System.out.println(start.toString() + "    " + end.toString());
					modelController.makeMove(player);
                    if (game.currentPlayer().isContinueMove()==true){
                        frameSwitcher.updateGUI(end);
                        }
				}
				
			} catch (OutOfBoundsException e1) {
				e1.printStackTrace();
			}
			clickNumber = 0;
		}
		xBoardCoord = 0;
		yBoardCoord = 0;

	}
}
