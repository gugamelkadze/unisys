package ge.edu.sangu.unisys.exceptions.dbexceptions;

import ge.edu.sangu.unisys.models.User;

public class UserNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;

	private static final String DEFAULT_MESSAGE = "user not found";

	private User user;

	public UserNotFoundException() {
		this(DEFAULT_MESSAGE);
	}

	public UserNotFoundException(String message) {
		super(message);
	}

	public UserNotFoundException(User user) {
		this(user, DEFAULT_MESSAGE);
	}

	public UserNotFoundException(User user, String message) {
		super(message);

		this.user = user;

	}

	public User getUser() {
		return user;
	}

}