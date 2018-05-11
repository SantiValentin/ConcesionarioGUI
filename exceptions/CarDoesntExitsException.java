package exceptions;

public class CarDoesntExitsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CarDoesntExitsException(String string) {
		super(string);
	}
}
