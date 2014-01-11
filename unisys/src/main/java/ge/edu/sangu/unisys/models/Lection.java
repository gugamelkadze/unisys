package ge.edu.sangu.unisys.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author davit
 * 
 */
@Entity
@Table(name = "LECTION")
public class Lection implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "LECTION_ID")
	private Integer lectionId;

	@ManyToOne
	@JoinColumn(name = "SUBJECT_ID")
	private Subject subject;

	@ManyToOne
	@JoinColumn(name = "LECTION_LECTOR")
	private User lectionLector;

	@ManyToOne
	@JoinColumn(name = "SEMINAR_LECTOR")
	private User seminarLector;

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public User getLectionLector() {
		return lectionLector;
	}

	public void setLectionLector(User lectionLector) {
		this.lectionLector = lectionLector;
	}

	public User getSeminarLector() {
		return seminarLector;
	}

	public void setSeminarLector(User seminarLector) {
		this.seminarLector = seminarLector;
	}
}