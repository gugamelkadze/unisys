package ge.edu.sangu.unisys.models;

import ge.edu.sangu.unisys.utils.Status;

import java.io.Serializable;
import java.util.Date;

public class Note implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * fields of this class will be saved in the mongodb
	 */

	private Integer userID; // ID of user_ the owner of this note

	private String noteName;

	private Date firstDate;

	private Date lastDate;

	private CycleType cycleType;

	private Status noteStatus;

	private String description; // note description

	// getters and setters

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getNoteName() {
		return noteName;
	}

	public void setNoteName(String noteName) {
		this.noteName = noteName;
	}

	public Date getFirstDate() {
		return firstDate;
	}

	public void setFirstDate(Date firstDate) {
		this.firstDate = firstDate;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public Status getNoteStatus() {
		return noteStatus;
	}

	public void setNoteStatus(Status noteStatus) {
		this.noteStatus = noteStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CycleType getCycleType() {
		return cycleType;
	}

	public void setCycleType(CycleType cycleType) {
		this.cycleType = cycleType;
	}

}