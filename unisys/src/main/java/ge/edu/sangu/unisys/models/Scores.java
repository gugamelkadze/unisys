package ge.edu.sangu.unisys.models;

import ge.edu.sangu.unisys.utils.Exam;

import java.io.Serializable;
import java.util.Map;

public class Scores implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * the fields of this class will be saved in the mongodb
	 */

	private Integer studentResultId; // the ID of STUDENT_RESULTS table

	private Map<Exam, Integer> results; // exam - score

	public Map<Exam, Integer> getResults() {
		return results;
	}

	public void setResults(Map<Exam, Integer> results) {
		this.results = results;
	}

	public Integer getStudentResultId() {
		return studentResultId;
	}

	public void setStudentResultId(Integer studentResultId) {
		this.studentResultId = studentResultId;
	}

}