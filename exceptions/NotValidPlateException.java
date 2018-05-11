package exceptions;

public class NotValidPlateException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotValidPlateException(String string){
		super(string);
	}
}
