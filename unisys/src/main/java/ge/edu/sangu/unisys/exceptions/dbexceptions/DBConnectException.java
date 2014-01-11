package ge.edu.sangu.unisys.exceptions.dbexceptions;

public class DBConnectException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String DEFAULT_MESSAGE = "Can not connect to database";

	public DBConnectException() {
		this(DEFAULT_MESSAGE);
	}

	public DBConnectException(String message) {
		super(message);
	}

}