package main;

/**
 * Custom exception for cases involving out-of-bound locations.
 * @author james
 *
 */
public class OutOfBoundsException extends Exception {
	public OutOfBoundsException(){
		super();
	}
	
	public OutOfBoundsException(String error){
		super(error);
	}
}
