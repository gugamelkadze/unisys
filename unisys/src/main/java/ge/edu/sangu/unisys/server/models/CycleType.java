package ge.edu.sangu.unisys.server.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CYCLE_TYPES")
public class CycleType implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CYCLE_TYPE_ID")
	private Integer cycleTypeID;

	@Column(name = "TYPE_NAME")
	private String typeName;

	

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}