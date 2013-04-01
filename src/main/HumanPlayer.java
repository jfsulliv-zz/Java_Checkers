package main;
import java.util.Scanner;

import userInterface.view.MouseHandler;

/**
 * A human Player Subclass. Contains methods to take user input and turn it into a Location.
 * @author james
 *
 */
public class HumanPlayer extends Player {
	private Scanner scanner = new Scanner(System.in);
	MouseHandler handler;

	/**
	 * Constructor method to call the Player super's constructor given some parameters.
	 * @param aColour The Colour of the HumanPlayer to be made.
	 * @param board The instance of the Board.
	 */
	public HumanPlayer(Colour aColour,Board board) {
		super(aColour,board);
	}

	/**
	 * Accessor Method to determine, validate and return  a starting piece Location.
	 * 
	 * @return Location of a selected Piece that can be moved.
	 */
	public Location selectStart(){
		Location start = null;
		boolean validUserInput = false;
		
		while(!validUserInput){
			System.out.print("Please select the Piece to move: ");
			start = takeInput();
			Piece tempPiece = board.checkSquare(start);
			
			if(tempPiece == null) {
				System.out.println("There is no piece there.");
			} else if(tempPiece.getColour() != this.playerColour) {
				System.out.println("That is not your piece to move.");
			} else if(tempPiece.emptyMoves(this).length == 0 
					&& tempPiece.emptyJumps(this).length == 0) {
				System.out.println("That piece has no available moves.");
			} else {
				validUserInput = true;
			}
		}
		
		return start;			
	}
	
	/** 
	 * Accessor Method to determine, validate and return an end location for the Player to move.
	 * 
	 * @param Start Location
	 * @return End Location
	 */
	public Location selectEnd(Location start) {
		Location end = null;
		boolean validUserInput = false;
		boolean silentMovementChecks = false; // Error messages on the movements checked will be given.
		
		while(!validUserInput){
			System.out.print("Enter a location to move to: ");
			end = takeInput();
			Move move = new Move(this,start,end,silentMovementChecks);
			
			if (move.isValid() == false){
				System.out.print("Invalid Location. ");
				if(board.turnComplete() == 0){
					start = selectStart();	// The player will have the opportunity to reselect the Start position
				}							// if they have not made any movements on their turn yet.
			} else {
				validUserInput = true;
			}
		}
		
		return end;
	}
	
	/*
	 * Private method to take String input and check for validity.
	 * If the string is valid, it will be returned as a new Location object.
	 * 
	 * Correct format: "int,int"
	 */
	private Location takeInput(){
		Location loc = null;
		int tempX = 0;
		int tempY = 0;
		boolean validUserInput = false;
		
		while(!validUserInput){
			try {
				// The user must enter in the form "x,y", or the program will not allow them to continue.
				String in = scanner.nextLine();
				tempX = Integer.parseInt(in.substring(0,in.indexOf(",")));
				tempY = Integer.parseInt(in.substring(in.indexOf(",") + 1));
				loc = new Location(tempX, tempY);
				
				if(loc.inBounds()) {
					validUserInput = true;
				} else {
					System.out.print("Invalid coordinates given- try again. ");
				}
				
			} catch(IndexOutOfBoundsException iobe) {
				System.out.print("Invalid entry- try again. ");
			} catch(NumberFormatException nfe) {
				System.out.print("Invalid entry- try again. ");
			} catch(OutOfBoundsException oobe) {
				System.out.print("Invalid coordinates were given- try again.");
			}
		}
		
		return loc;
	}
}