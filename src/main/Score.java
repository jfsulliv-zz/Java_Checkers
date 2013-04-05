package main;

import java.io.Serializable;

/**
 * <ul>Sets the scores and appends the values by one. 
 * <p>
 * @author Daniel
 *
 */
public class Score implements Serializable {

	private int wins;
	private int losses;
	private int gamesPlayed;
	
	/**
	 * <!--Mutator method.-->
	 * 	<style>
	 * 		#method{
	 * 			text-indent: 10.0px;
	 * 		}
	 * 	</style>
	 * 	<ul><li><b>Score</b></li></ul>
	 * 	<ul><div ID="method"><p>public Score(int wins, int losses, int gamesPlayed)</p></div></ul>
	 * 	<ul> 
	 * 		<p>
	 * 			Takes, as parameters, 3 integer values. These values will be set and later used for the serialization
	 * 			of the score data.
	 * 		</p>
	 * 	</ul>
	 * 	<ul>
	 * 		<p>
	 * 			PreCondition: Must enter all 3 parameters
	 * 			<br>PostCondition: Will set the values entered to the instance variables</br>
	 * 		</p>
	 * 	</ul>
	 * 
	 * 	<ul>
	 *  	@param The number of wins
	 * 		@param losses The number of losses
	 *  	@param gamesPlayer The number of games played
	 *  	@return Return the instance of the games view.
	 *  </ul>
	 * 
	 * 
	 */
	public Score(int wins, int losses, int gamesPlayed) {
		super();
		this.wins = wins;
		this.losses = losses;
		this.gamesPlayed = gamesPlayed;
	}
	public Score() {
		
	}
	/**
	 * <!--Accessor method-->
	 * <ul><li><b>Score</b></li></ul>
	 * <ul>Getter method for the amount of wins.
	 * <p>
	 * @return integer value for amount of wins
	 */
	public int getWins() {
		return wins;
	}
	/**
	 * <!--Accessor method-->
	 * <ul><li><b>Score</b></li></ul>
	 * <ul>Setter method for the amount of wins.
	 * <p>
	 * @param wins the amount of wins
	 */
	public void setWins(int wins) {
		this.wins = wins;
	}
	/**
	 * <!--Accessor method-->
	 * <ul><li><b>Score</b></li></ul>
	 * <ul>Getter method for the amount of losses.
	 * <p>
	 * @return integer value for the amount of losses
	 */
	public int getLosses() {
		return losses;
	}
	/**
	 * <!--Accessor method-->
	 * <ul><li><b>Score</b></li></ul>
	 * <ul>Setter method for the amount of losses.
	 * <p>
	 * @param losses the amount of losses
	 */
	public void setLosses(int losses) {
		this.losses = losses;
	}
	/**
	 * <!--Accessor method-->
	 * <ul><li><b>Score</b></li></ul>
	 * <ul>Getter method for the amount of games played.
	 * <p>
	 * @return integer value for the amount of games played
	 */
	public int getGamesPlayed() {
		return gamesPlayed;
	}
	/**
	 * <!--Accessor method-->
	 * <ul><li><b>Score</b></li></ul>
	 * <ul>Setter method for the amount of games played.
	 * <p>
	 * @param gamesPlayed the amount of games played
	 */
	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}
	/**
	 * <!--Accessor method-->
	 * <ul><li><b>Score</b></li></ul>
	 * <ul>Appends the value of wins by 1.
	 * <p>
	 * @return new integer value for the amount of wins.
	 */
	public int appendWins() {
		return wins = getWins() + 1;
	}
	/**
	 * <!--Accessor method-->
	 * <ul><li><b>Score</b></li></ul>
	 * <ul>Appends the value of losses by 1.
	 * <p>
	 * @return new integer value for the amount of losses.
	 */
	public int appendLosses() {
		return losses = getLosses() + 1;
	}
	/**
	 * <!--Accessor method-->
	 * <ul><li><b>Score</b></li></ul>
	 * <ul>Appends the value of games played by 1.
	 * <p>
	 * @return new integer value for the amount of games played.
	 */
	public int appendGamesPlayed() {
		return gamesPlayed = getGamesPlayed() + 1;
	}
	
	
}
