package userInterface.view;

import main.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import main.Board;
import main.Location;
import main.OutOfBoundsException;

/**
 * MouseHandler class to take input fromt the gui. Uses mouse listeners to
 * identify the board piece selected.
 * 
 * @author Dylan
 */

public class MouseHandler implements MouseListener, MouseMotionListener {
	private Game game;
	private int squareLength;
	private int leftBound;
	private int rightBound;
	private int upperBound;
	private int lowerBound;
	private Location topLeft;
	private Location start;
	private Location end;
	private Component component;
	private int clickNumber = 0;
	private int xCoord;
	private int yCoord;
	private int xBoardCoord;
	private int yBoardCoord;
	private boolean inBound;
	private Cursor cursorShape;
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
			int squareLength) {
		this.game = Game.getInstance();
		this.topLeft = topLeft;
		this.squareLength = squareLength;
		this.component = aComponent;
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
		}
		
		// If the Player is jumping a second piece, it can only select an end-point
		if(game.currentPlayer().isContinueMove() == true){
			clickNumber = 1;
		}
		
		if (clickNumber == 0) {
			try {
				start = new Location(0, 0);
				end = new Location(0, 0);
			} catch (OutOfBoundsException e1) {
				e1.printStackTrace();
			}

		}
		
		if (inBound) {
			xBoardCoord = (int) Math.floor((e.getX() - leftBound)
					/ squareLength);
			yBoardCoord = (int) Math.floor((e.getY() - upperBound)
					/ squareLength);
			xCoord = e.getX();
			yCoord = e.getY();
			clickNumber++;
		}
		
		if (clickNumber == 1) {
			try {
				
				start = new Location(xBoardCoord, yBoardCoord);
				game.currentPlayer().setStart(start);
				if(game.currentPlayer().validStartSelected() == false){
					clickNumber = 0;
					return;
				}
				
			} catch (OutOfBoundsException e1) {
				e1.printStackTrace();
			}
		} else if (clickNumber == 2) {
			try {
				
				end = new Location(xBoardCoord, yBoardCoord);
				game.currentPlayer().setEnd(end);
				if(game.currentPlayer().validEndSelected() == false){
					clickNumber = 0;
					start = null;
					return;
				}
				
				if(start.isSameLocation(end)) {
					game.currentPlayer().resetLocations();
					start = null;
					end = null;
					clickNumber = 0;
					return;
				} else {
					System.out.println(start.toString() + "    " + end.toString());
					game.currentPlayer().makeCurrentMove();
				}
				
			} catch (OutOfBoundsException e1) {
				e1.printStackTrace();
			}
			clickNumber = 0;
		}
		xBoardCoord = 0;
		yBoardCoord = 0;

	}

	public Location getStart() {
		return start;
	}
	public void getStart(Location start) {
		this.start = start;
	}

	public Location getEnd() {
		return end;
	}

	public int getClickNumber() {
		return clickNumber;
	}

	public void setClickNumber(int number) {
		clickNumber = number;
	}
}
