package ge.edu.sangu.unisys.db;

import ge.edu.sangu.unisys.exceptions.dbexceptions.DBConnectException;
import ge.edu.sangu.unisys.exceptions.dbexceptions.InvalidUsernameOrPasswordException;
import ge.edu.sangu.unisys.exceptions.dbexceptions.NoRightException;
import ge.edu.sangu.unisys.exceptions.dbexceptions.NoteNotFoundException;
import ge.edu.sangu.unisys.exceptions.dbexceptions.UserNotFoundException;
import ge.edu.sangu.unisys.models.Group;
import ge.edu.sangu.unisys.models.Note;
import ge.edu.sangu.unisys.models.Right;
import ge.edu.sangu.unisys.models.User;
import ge.edu.sangu.unisys.models.UserType;
import ge.edu.sangu.unisys.utils.UtilitClass;

import java.util.List;

import org.apache.log4j.Logger;

class DataBaseManager implements Repository {

	private static SqlManager sqlManager;

	private static MongoManager mongoManager;

	private Logger LOG = Logger.getLogger(DataBaseManager.class);

	private UtilitClass utilitObject = new UtilitClass();

	public DataBaseManager() {
		try {
			sqlManager = SqlManager.INSTANCE;
		} catch (Exception ex) {
			LOG.error(ex.getMessage(), ex);

			sqlManager = null;

			// TODO send message to competent person
		}

		try {
			mongoManager = MongoManager.getInstance();
		} catch (DBConnectException ex) {
			LOG.error(ex.getMessage(), ex);

			mongoManager = null;

			// TODO send message to competent person
		}
	}

	@Override
	public User authenticate(String firstName, String lastName, String password)
			throws InvalidUsernameOrPasswordException {

		User user;
		try {
			user = sqlManager.getUserByUsernamePassword(firstName, lastName,
					password);
		} catch (Exception ex) {
			LOG.error(ex.getMessage(), ex);
			if (ex instanceof InvalidUsernameOrPasswordException) {
				throw ex;
			}

			user = null;
		}

		return user;
	}

	@Override
	public void createNote(Note note) throws DBConnectException {

		try {
			utilitObject.checkForNull(mongoManager);
		} catch (NullPointerException ex) {
			LOG.error(ex.getMessage(), ex);

			throw new DBConnectException();
		}

		mongoManager.createNote(note);
	}

	@Override
	public void createGroup(User user, Group group) throws NoRightException {

		if (hasRight(user.getUserType(), new Right("Create group"))) {
			group.setGroupCreator(user);

			sqlManager.createGroup(group);
		}

		else {

			throw new NoRightException("User has no rights to create group");
		}
	}

	private Boolean hasRight(UserType type, Right right) {

		return type.getRights().contains(right);

	}

	@Override
	public List<Note> getNotes(Integer userId) throws DBConnectException {
		try {
			utilitObject.checkForNull(mongoManager);
		} catch (NullPointerException ex) {
			LOG.error(ex.getMessage(), ex);

			throw new DBConnectException();
		}

		return mongoManager.getNotes(userId);

	}

	@Override
	public void changeNote(Note oldNote, Note newNote)
			throws NoteNotFoundException {
		try {
			mongoManager.changeNote(oldNote, newNote);
		} catch (NoteNotFoundException ex) {
			LOG.error(ex.getMessage(), ex);

			throw ex;
		}

	}

	@Override
	public void deleteNote(Note note) throws NoteNotFoundException {
		try {
			mongoManager.deleteNote(note);
		} catch (NoteNotFoundException ex) {
			LOG.error(ex.getMessage(), ex);

			throw ex;
		}

	}

	@Override
	public void addUserToGroup(Group group, User user)
			throws UserNotFoundException {
		try {
			sqlManager.addUserToGroup(group, user);
		} catch (Exception ex) {
			LOG.error(ex.getMessage(), ex);

			if (ex instanceof UserNotFoundException) {
				throw ex;
			}
		}

	}

}