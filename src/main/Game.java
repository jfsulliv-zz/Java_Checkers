package main;
import java.util.Scanner;
/*
 * Skeleton of the main Game logic- NOT complete!
 * ToDo: Check to see if there are available moves, end turn if not.
 * Author: James
 */
public class Game {
	static Game instance;
	Player blackPlayer;
	Player redPlayer;
	Board board = new Board();
	Scanner scanner = new Scanner(System.in);
	
	public static Game getInstance(){
		if(instance == null){
			instance = new Game();
		}
		return instance;
	}
	
	public void initialize(){
		System.out.println("Welcome to Checkers!\n RED will play first.");
		System.out.println("Enter locations when prompted in the form \"x,\"y.");
		System.out.println("The board is arranged with 0,0 at the Top-Left, 7,7 at the Bottom-Right.");
		
		blackPlayer = new Player(Colour.BLACK);
		redPlayer = new Player(Colour.RED);
		board.initializeBoard();
	}
	
	public void turn(Player aPlayer){
		board.resetTurn();
		if(aPlayer.piecesLeft() == 0){
			gameOver(aPlayer);
		}
		
		System.out.println("Turn: "+aPlayer.toString());
		
		board.printArray();
		
		while(board.turnComplete() != 2){
			System.out.println(aPlayer.toString()+", select the piece you wish to move.");
			
			Location start = takeInput();
			System.out.println("Now select the location to move to.");
			Location end = takeInput();
			board.movePiece(aPlayer,start,end);
			
			if(board.turnComplete() == 1){
				start = end;
				board.printArray();
				while(board.turnComplete() != 2){
					System.out.println("Select the next location to move to.");
					end = takeInput();
					board.movePiece(aPlayer, start, end);
				}
			}
		}
		board.printArray();
	}
	
	public Location takeInput(){
		boolean valid = false;
		int tempX = 0;
		int tempY = 0;
		while(valid == false){
			try {
				String in = scanner.nextLine();
				tempX = Integer.parseInt(in.substring(0,in.indexOf(",")));
				tempY = Integer.parseInt(in.substring(in.indexOf(",") + 1));
				valid = true;
			} catch(IndexOutOfBoundsException e) {
				System.out.print("Invalid entry- try again.");
			} catch(NumberFormatException e) {
				System.out.print("Invalid entry- try again.");
			}
		}
		Location loc = new Location(tempX, tempY);
		return loc;
	}
	
	public void gameOver(Player aPlayer){
		System.out.println(aPlayer.toString()+" no longer has any pieces to move! They lose.");
		System.exit(0);
	}
}
