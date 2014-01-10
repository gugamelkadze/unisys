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
@Table(name = "USER_TYPES")
public class UserType implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "TYPE_ID")
	private Integer userTypeId;

	@Column(name = "TYPE_NAME")
	private String typeName;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "USER_TYPES_RIGHTS", joinColumns = { @JoinColumn(name = "USER_TYPE_ID") }, inverseJoinColumns = { @JoinColumn(name = "RIGHT_ID") })
	private Set<Right> rights;

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Set<Right> getRights() {
		return rights;
	}

	public void setRights(Set<Right> rights) {
		this.rights = rights;
	}

	public Integer getUserTypeId() {
		return this.userTypeId;
	}
}