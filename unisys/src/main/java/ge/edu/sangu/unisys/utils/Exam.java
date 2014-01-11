package ge.edu.sangu.unisys.utils;

import java.io.Serializable;
import java.util.Date;

public class Exam implements Serializable {

	private static final long serialVersionUID = 1L;

	private ExamType type;

	private Date firstDate; // exam date

	private Date secondDate; // repeated exam date

	// getters and setters

	public ExamType getType() {
		return type;
	}

	public void setType(ExamType type) {
		this.type = type;
	}

	public Date getFirstDate() {
		return firstDate;
	}

	public void setFirstDate(Date firstDate) {
		this.firstDate = firstDate;
	}

	public Date getSecondDate() {
		return secondDate;
	}

	public void setSecondDate(Date secondDate) {
		this.secondDate = secondDate;
	}

}