package test;

import userInterface.controller.ScoreDataHandler;
import main.Score;


public class TestScores {

	public static void main(String[] args) {
//		Score score = new Score(10, 11, 22);
		ScoreDataHandler control = new ScoreDataHandler();
//		
//		control.saveScore(score);
//		
//		int wins = score.getWins();
//		int losses = score.getLosses();
//		int gamesPlayed = score.getGamesPlayed();
//		
//		System.out.println("Before appending wins/losses and games played:");
//		System.out.println("  Wins: " + wins);
//		System.out.println("  Losses: " + losses);
//		System.out.println("  GamesPlayed: " + gamesPlayed);
//		
//		System.out.println("\nAfter appending wins/losses and games played:");
//		System.out.println("  Wins: " + score.appendWins());
//		System.out.println("  Losses: " + score.appendLosses());
//		System.out.println("  GamesPlayer: " + score.appendGamesPlayed());
//		
//		score.appendWins();
//		score.appendLosses();
//		score.appendGamesPlayed();
//		
//		control.saveScore(score);
//		
//		wins = score.getWins();
//		losses = score.getLosses();
//		gamesPlayed = score.getGamesPlayed();
//		System.out.println(wins);
//		System.out.println(losses);
//		System.out.println(gamesPlayed);
		System.out.println(control.loadScore().getWins());
		System.out.println(control.loadScore().getLosses());
		System.out.println(control.loadScore().getGamesPlayed());
	}
}
