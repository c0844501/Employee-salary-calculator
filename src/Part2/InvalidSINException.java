package Part2;
//Exception handling class

public class InvalidSINException extends Exception {

	
	private static final long serialVersionUID = 1L;

	public InvalidSINException() {
		super("ERROR: Invalid Social Insurance Number");
	}

	public InvalidSINException(String str) {
		super(str);
	}

}
