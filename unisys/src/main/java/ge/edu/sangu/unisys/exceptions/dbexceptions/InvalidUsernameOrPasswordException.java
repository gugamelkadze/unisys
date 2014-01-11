package ge.edu.sangu.unisys.exceptions.dbexceptions;

import java.security.InvalidParameterException;

/**
 * This exception will be used when user authentication fails
 * 
 * @author davit
 */
public class InvalidUsernameOrPasswordException extends
		InvalidParameterException {
	private static final long serialVersionUID = 1L;

	public InvalidUsernameOrPasswordException() {
		super();
	}

	public InvalidUsernameOrPasswordException(String message) {
		super(message);
	}
}