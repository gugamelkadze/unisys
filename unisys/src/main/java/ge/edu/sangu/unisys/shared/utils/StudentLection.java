package ge.edu.sangu.unisys.shared.utils;

import ge.edu.sangu.unisys.server.models.Lection;
import ge.edu.sangu.unisys.server.models.User;

import java.io.Serializable;
import java.util.Date;

public class StudentLection implements Serializable {

	private static final long serialVersionUID = 1L;

	private User student;

	private Lection lection;

	private Date lectionDate;

	// getters and setters

	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
	}

	public Lection getLection() {
		return lection;
	}

	public void setLection(Lection lection) {
		this.lection = lection;
	}

	public Date getLectionDate() {
		return lectionDate;
	}

	public void setLectionDate(Date lectionDate) {
		this.lectionDate = lectionDate;
	}

}