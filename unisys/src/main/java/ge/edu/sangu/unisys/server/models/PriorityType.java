package ge.edu.sangu.unisys.server.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRIORITY_TYPES")
public class PriorityType implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "RIGHT_ID")
	private Integer rightID;

	@Column(name = "RIGHT_NAME")
	private String rightName;

	public String getRightName() {
		return rightName;
	}

	public void setRightName(String rightName) {
		this.rightName = rightName;
	}

}