package test;

import userInterface.controller.ScoreDataHandler;
import main.Score;


public class TestScores {

	public static void main(String[] args) {
		ScoreDataHandler control = new ScoreDataHandler();
		
		System.out.println("The current data is stored in the file:");
		
		System.out.println("Wins: " + control.loadScore().getWins());
		System.out.println("Losses: " + control.loadScore().getLosses());
		System.out.println("Games played: " + control.loadScore().getGamesPlayed());
		
	}
}
