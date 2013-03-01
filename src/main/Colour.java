package main;

/**
 * Enumerated type for Colour, used by various other Checkers components
 * <p>
 * BLACK("B") = 0; RED("R") = 1;
 * 
 * @author James Sullivan
 * 
 */
public enum Colour {
	BLACK("B"), RED("R");
	private final String stringValue;

	/**
	 * Method to set the Colour instance using a given String value
	 * 
	 * @param stringValue
	 */
	Colour(String stringValue) {
		this.stringValue = stringValue;
	}

	/**
	 * Returns the Ordinal value of the Colour
	 * 
	 * @return Ordinal corresponding to a single enumeration
	 */
	public int getOrdinal() {
		return this.ordinal();
	}

	@Override
	public String toString() {
		return this.stringValue;
	}
}
