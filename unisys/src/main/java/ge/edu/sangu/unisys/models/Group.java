package ge.edu.sangu.unisys.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author irakli
 * 
 */

@Entity
@Table(name = "GROUPS")
public class Group implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "GROUP_ID")
	private Integer groupId;

	@Column(name = "CREATOR_ID")
	private User groupCreator;

	@Column(name = "GROUP_NAME")
	private String groupName;

	@ManyToOne
	@JoinColumn(name = "GROUP_PARENT_ID")
	private Group parentGroup;

	@ManyToOne
	@JoinColumn(name = "GROUP_STATE_ID")
	private GroupState groupState;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "groups")
	private Set<User> users;

	// getters and setters

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Group getParentGroup() {
		return parentGroup;
	}

	public void setParentGroup(Group parentGroup) {
		this.parentGroup = parentGroup;
	}

	public GroupState getGroupState() {
		return groupState;
	}

	public void setGroupState(GroupState groupState) {
		this.groupState = groupState;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public User getGroupCreator() {
		return groupCreator;
	}

	public void setGroupCreator(User groupCreator) {
		this.groupCreator = groupCreator;
	}

}