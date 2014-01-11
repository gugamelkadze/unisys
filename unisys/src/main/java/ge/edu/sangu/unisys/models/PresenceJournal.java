package ge.edu.sangu.unisys.models;

import ge.edu.sangu.unisys.utils.PresenceStatus;
import ge.edu.sangu.unisys.utils.StudentLection;

import java.io.Serializable;
import java.util.Map;

public class PresenceJournal implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * the fields of this class will be saved in the mongodb
	 */

	private Integer studentResultId; // the ID of STUDENT_RESULTS table

	private Map<StudentLection, PresenceStatus> presenceResults; // defines
																	// student's
																	// presence
																	// on each
																	// lection

	// getters and setters

	public Integer getStudentResultId() {
		return studentResultId;
	}

	public void setStudentResultId(Integer studentResultId) {
		this.studentResultId = studentResultId;
	}

	public Map<StudentLection, PresenceStatus> getPresenceResults() {
		return presenceResults;
	}

	public void setPresenceResults(
			Map<StudentLection, PresenceStatus> presenceResults) {
		this.presenceResults = presenceResults;
	}

}