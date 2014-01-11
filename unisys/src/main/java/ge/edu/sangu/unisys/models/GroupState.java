package ge.edu.sangu.unisys.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author irakli
 * 
 */

@Entity
@Table(name = "GROUP_STATES")
public class GroupState implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "STATE_ID")
	private Integer stateId;

	@Column(name = "STATE_NAME")
	private String stateName;

	// getters and setters

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

}