package ge.edu.sangu.unisys.exceptions.dbexceptions;

public class NoteNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	private static final String DEFAULT_MESSAGE = "required note not found in the database";

	public NoteNotFoundException() {
		this(DEFAULT_MESSAGE);
	}

	public NoteNotFoundException(String message) {
		super(message);
	}

}