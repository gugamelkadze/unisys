package ge.edu.sangu.unisys.server.db;

import ge.edu.sangu.unisys.server.models.Group;
import ge.edu.sangu.unisys.server.models.Note;
import ge.edu.sangu.unisys.server.models.User;
import ge.edu.sangu.unisys.shared.exceptions.dbexceptions.DBConnectException;
import ge.edu.sangu.unisys.shared.exceptions.dbexceptions.InvalidUsernameOrPasswordException;
import ge.edu.sangu.unisys.shared.exceptions.dbexceptions.NoRightException;
import ge.edu.sangu.unisys.shared.exceptions.dbexceptions.NoteNotFoundException;
import ge.edu.sangu.unisys.shared.exceptions.dbexceptions.UserNotFoundException;

import java.util.List;

public interface Repository {

	/**
	 * Authenticate user
	 * 
	 * @param firstName
	 *            First name of user
	 * @param lastName
	 *            Last name of user
	 * @param password
	 *            Password
	 * @return User with this parameters
	 * @throws InvalidUsernameOrPasswordException
	 *             If authentication fails
	 */
	User authenticate(String firstName, String lastName, String password)
			throws InvalidUsernameOrPasswordException;

	/**
	 * 
	 * @param user
	 *            Group creator
	 * @param group
	 *            New group
	 * @throws NoRightException
	 *             Throws exception if user has no right to create group
	 * 
	 */
	void createGroup(User user, Group group) throws NoRightException;

	/**
	 * Creates new note(inserts into database)
	 * 
	 * @param note
	 *            Note to create(insert)
	 * @throws DBConnectException
	 */
	void createNote(Note note) throws DBConnectException;

	/**
	 * 
	 * @param userId
	 *            owner's Id
	 * @return list of notes with this userId
	 * @throws DBConnectException
	 *             throws exception if unable to connect to database
	 */
	List<Note> getNotes(Integer userId) throws DBConnectException;

	/**
	 * changes note with the new one
	 * 
	 * @param oldNote
	 *            note to be changed
	 * @param newNote
	 * @throws NoteNotFoundException
	 *             if oldNote not found in the database
	 */
	void changeNote(Note oldNote, Note newNote) throws NoteNotFoundException;

	/**
	 * deletes note from database if it exists
	 * 
	 * @param note
	 *            note to be deleted
	 * @throws NoteNotFoundException
	 *             if this note doesn't exists
	 */
	void deleteNote(Note note) throws NoteNotFoundException;

	/**
	 * 
	 * @param group
	 *            group in which user must be added
	 * @param user
	 *            user to be added
	 * @throws UserNotFoundException
	 *             if the user not found in the database
	 */
	void addUserToGroup(Group group, User user) throws UserNotFoundException;

}