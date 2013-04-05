package userInterface.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import main.Score;

/**
 * <ul> This class deals with the file "score.dat" and will handle any exceptions.
 * <p>
 * @author Daniel
 *
 */
public class ScoreDataHandler {

	private static final String fileName = "score.dat";
	
	/**
	 * <!--Mutator method.-->
	 * 	<style>
	 * 		#method{
	 * 			text-indent: 10.0px;
	 * 		}
	 * 	</style>
	 * 	<ul><li><b>ScoreDataHandler</b></li></ul>
	 * 	<ul><div ID="method"><p>public void saveScore(Score score)</p></div></ul>
	 * 	<ul> 
	 * 		<p>
	 * 			Saves the data that will come through this class, namely the amount of wins, losses and games played.
	 * 		</p>
	 * 	</ul>
	 * 	<ul>
	 * 		<p>
	 * 			PreCondition: The file must exist.
	 * 			<br>PostCondition: Will save the file, and serialize it.</br>
	 * 		</p>
	 * 	</ul>
	 * 
	 * 	<ul>
	 *  	@param score The scores to save.
	 *  </ul>
	 * 
	 * 
	 */
	public void saveScore(Score score) {
		ObjectOutputStream out = null;
		
        try {
            out = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(score);
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ioe) {
                	ioe.printStackTrace();
                }
            }
        }
	}
	/**
	 * <!--Mutator method.-->
	 * 	<style>
	 * 		#method{
	 * 			text-indent: 10.0px;
	 * 		}
	 * 	</style>
	 * 	<ul><li><b>ScoreDataHandler</b></li></ul>
	 * 	<ul><div ID="method"><p>public Score loadScore()</p></div></ul>
	 * 	<ul> 
	 * 		<p>
	 * 			Loads the data that is already in the file, namely the amount of wins, losses and games played.
	 * 		</p>
	 * 	</ul>
	 * 	<ul>
	 * 		<p>
	 * 			PreCondition: The file must exist.
	 * 			<br>PostCondition: Will save the file, and deserialize it.</br>
	 * 		</p>
	 * 	</ul>
	 * 
	 * 	<ul>
	 *  	@return the scores that are in the file. 
	 *  </ul>
	 * 
	 * 
	 */
	public Score loadScore() {
		ObjectInputStream in = null;
        Score score = null;
        try {
            in = new ObjectInputStream(new FileInputStream(fileName));
            score = (Score)in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ioe) {
                	ioe.printStackTrace();
                }
            }
        }
        return score;
    }
}
