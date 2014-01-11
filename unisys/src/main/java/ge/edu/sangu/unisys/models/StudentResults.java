package ge.edu.sangu.unisys.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "STUDENT_RESULTS")
public class StudentResults implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "RESULT_ID")
	private Integer resultId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STUDENT_ID")
	private User student;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LECTION_ID")
	private Lection lection;

	@Transient
	private Scores scores;

	public Integer getResultId() {
		return resultId;
	}

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

	public Scores getScores() {
		return scores;
	}

	public void setScores(Scores scores) {
		this.scores = scores;
	}
}