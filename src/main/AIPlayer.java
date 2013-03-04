package main;
import java.util.Random;

public class AIPlayer extends Player {
	Random generator = new Random();

	public AIPlayer(Colour aColour,Board board) {
		super(aColour,false, board);
	}

	public Location randomStart(){
		Location[] preferredLocs = new Location[12];
		int tempIndex1 = 0;
		Location[] otherLocs = new Location[12];
		int tempIndex2 = 0;
		for(int i = 0; i < myPieces.length; i++){
			Location tempLoc = myPieces[i].getLocation();
			if (board.emptyJumps(this,tempLoc) != null) {
				preferredLocs[tempIndex1] = tempLoc;
				tempIndex1++;
			} else if (board.emptyMoves(this,tempLoc) != null) {
				otherLocs[tempIndex2] = tempLoc;
				tempIndex2++;
			}
		}

		if(tempIndex1 > 0){
			int randomIndex = generator.nextInt(tempIndex1);
			System.out.println("Computer selects Piece at " + preferredLocs[randomIndex]);
			return preferredLocs[randomIndex];
		} else if (tempIndex2 > 0) {
			int randomIndex = generator.nextInt(tempIndex2);
			System.out.println("Computer selects Piece at " + otherLocs[randomIndex]);
			return otherLocs[randomIndex];
		}

		return null;
	}

	public Location randomEnd(Location start){
		Location[] allJumps = board.emptyJumps(this,start);
		Location[] allMoves = board.emptyMoves(this,start);
		
		if(allJumps != null){
			int randomIndex = generator.nextInt(allJumps.length);
			System.out.println("Computer moves to " + allJumps[randomIndex]);
			return allJumps[randomIndex];
		} else if (allMoves != null) {
			int randomIndex = generator.nextInt(allMoves.length);
			System.out.println("Computer moves to " + allMoves[randomIndex]);
			return allMoves[randomIndex];
		} else {
			return null;
		}
	}
}