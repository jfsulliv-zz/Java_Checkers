package test;
import main.*;

public class TestAll {
	
	public static void main(String[] args) {
		try {
		TestBlackPlayer test1 = new TestBlackPlayer();
		TestRedPlayer test2 = new TestRedPlayer();
		test1.run();
		test2.run();
		} catch (OutOfBoundsException oobe) {
			System.out.println("There seems to be an error in some of the generated Locations.");
		}
	}
}
