package ge.edu.sangu.unisys.db;

import ge.edu.sangu.unisys.exceptions.dbexceptions.DBConnectException;
import ge.edu.sangu.unisys.exceptions.dbexceptions.NoteNotFoundException;
import ge.edu.sangu.unisys.models.Note;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;

class MongoManager {

	private static MongoManager instance;

	private MongoClient client;

	private DB db;

	private static final String HOST = "";

	private static final String DB_NAME = "mydb";

	private static final Logger LOG = Logger.getLogger(MongoManager.class);

	private MongoManager() throws UnknownHostException {
		try {
			client = new MongoClient(HOST);

			db = client.getDB(DB_NAME);
		} catch (UnknownHostException ex) {
			LOG.error(ex.getMessage(), ex);

			throw ex;

		}
	}

	public static synchronized MongoManager getInstance()
			throws DBConnectException {
		if (instance == null) {
			try {
				instance = new MongoManager();
			} catch (UnknownHostException ex) {
				LOG.error(ex.getMessage(), ex);

				// TODO send message to competent person

				throw new DBConnectException();
			}
		}

		return instance;
	}

	private DBObject parseObject(Object object) {

		String jsonText = new Gson().toJson(object);

		return (DBObject) (JSON.parse(jsonText));
	}

	private void insertObject(String collectionName, Object object) {
		DBCollection collection = db.getCollection(collectionName);

		collection.insert(parseObject(object));

	}

	public void createNote(Note note) {

		try {
			insertObject("Note", note);
		} catch (MongoException ex) {
			LOG.error(ex.getMessage(), ex);
		}

	}

	private List<String> getDBObjects(String collectionName, BasicDBObject query) {
		DBCollection collection = db.getCollection(collectionName);
		DBCursor cursor = collection.find(query);

		List<String> jsonObjects = new ArrayList<String>();

		while (cursor.hasNext()) {
			jsonObjects.add(cursor.next().toString());

		}

		cursor.close();

		return jsonObjects;
	}

	public List<Note> getNotes(Integer userId) {
		List<String> DBObjects = getDBObjects("Note", new BasicDBObject(
				"UserID", userId));
		List<Note> notes = new ArrayList<Note>();

		for (String json : DBObjects) {
			Note note = new Gson().fromJson(json, Note.class);
			notes.add(note);
		}

		return notes;
	}

	private void changeObject(String collectionName, Object oldObject,
			Object newObject) throws Exception {
		DBCollection dbc = db.getCollection(collectionName);

		WriteResult wr = dbc.update(parseObject(oldObject),
				parseObject(newObject));

		if (wr.getError() != null) {
			throw new Exception(wr.getError());
		}
	}

	public void changeNote(Note oldNote, Note newNote)
			throws NoteNotFoundException {
		try {
			changeObject("Note", oldNote, newNote);
		} catch (Exception ex) {
			LOG.error(ex.getMessage(), ex);

			throw new NoteNotFoundException();
		}
	}

	private void deleteObject(String collectionName, Object object)
			throws Exception {

		DBCollection dbc = db.getCollection(collectionName);

		try {
			dbc.remove(parseObject(object));
		} catch (MongoException ex) {
			LOG.error(ex.getMessage(), ex);

			throw ex;
		}
	}

	public void deleteNote(Note note) throws NoteNotFoundException {
		try {
			deleteObject("Note", note);
		} catch (Exception ex) {
			LOG.error(ex.getMessage(), ex);

			throw new NoteNotFoundException();
		}
	}

}