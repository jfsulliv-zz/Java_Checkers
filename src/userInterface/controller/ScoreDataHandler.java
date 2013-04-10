package userInterface.controller;

import java.io.File;
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

	private ScoreDataHandler controller;
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
        	System.out.println("saveScore: Unable to write to file.");
        	e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException IOE) {
                	System.out.println("saveScore: Unable to close file.");
                	IOE.printStackTrace();
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
        	File file = new File(fileName); 
        	resetFile(); // This checks if the files exist or if the length of the file is approriate.
            in = new ObjectInputStream(new FileInputStream(file));
            score = (Score)in.readObject();
        } catch (IOException e) {
        	System.out.println("loadScore: Unable to read file.");
            e.printStackTrace();
        } catch(Exception e) {
        	System.out.println("loadScore: Something went wrong.");
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ioe) {
                	System.out.println("loadScore: Unable to close file.");
                	ioe.printStackTrace();
                }
            }
        }
        return score;
    }
	
	private void resetFile() {
		Score score = null;
		File file = new File(fileName);
    	if(!file.exists() || file.length() == 0) {
    		try {
    			System.out.println(fileName + " was not found. Creating new file...");
    			file.createNewFile();
    		} catch (IOException ioe) {
    			System.out.println("Error occured...");
    			System.out.println("Was not able to create a new file.");
    		} finally {
    			System.out.println("Writing new data...");
    			score = new Score(0, 0, 0);
    			controller = new ScoreDataHandler();
        		controller.saveScore(score);
        		System.out.println("New data finished writing...");
    		}
    	}
	}
}
