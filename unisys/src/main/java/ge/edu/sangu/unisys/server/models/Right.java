package ge.edu.sangu.unisys.server.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 
 * @author irakli
 * 
 */

@Entity
@Table(name = "RIGHTS")
public class Right implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "RIGHT_ID")
	private Integer rightId;

	@Column(name = "RIGHT_NAME")
	private String rightName;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "rights")
	private Set<UserType> userTypes;

	public Right() {
	}

	public Right(String name) {
		this.rightName = name;
	}

	public int getRightId() {
		return rightId;
	}

	public void setRightId(int rightId) {
		this.rightId = rightId;
	}

	public String getRightName() {
		return rightName;
	}

	public void setRightName(String rightName) {
		this.rightName = rightName;
	}

	public Set<UserType> getUserTypes() {
		return userTypes;
	}

	public void setUserTypes(Set<UserType> userTypes) {
		this.userTypes = userTypes;
	}

}