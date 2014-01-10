package ge.edu.sangu.unisys.server.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SUBJECT")
public class Subject implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "SUBJECT_ID")
	private Integer subjectId;

	@Column(name = "SUBJECT_NAME")
	private String subjectName;

	@Column(name = "SILABUS")
	private Integer silabus;

	@Column(name = "CREDITS")
	private Integer credits;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "PREREQUISITS", joinColumns = { @JoinColumn(name = "SUBJECT_ID") }, inverseJoinColumns = { @JoinColumn(name = "PREREQUEST_ID") })
	private Set<Subject> prerequisites;

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Integer getSilabus() {
		return silabus;
	}

	public void setSilabus(Integer silabus) {
		this.silabus = silabus;
	}

	public Integer getCredits() {
		return credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	public Set<Subject> getPrerequisites() {
		return prerequisites;
	}

	public void setPrerequisites(Set<Subject> prerequisites) {
		this.prerequisites = prerequisites;
	}
}