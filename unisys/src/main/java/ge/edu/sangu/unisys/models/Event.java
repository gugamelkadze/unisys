package ge.edu.sangu.unisys.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EVENTS")
public class Event implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "EVENT_ID")
	private Integer eventID;

	@Column(name = "EVENT_NAME")
	private String eventName;

	@Column(name = "EVENT_DATE")
	private Date eventDate;

	@Column(name = "GROUP_ID")
	private Group group;

	@ManyToOne
	@JoinColumn(name = "EVENT_PRIORITY_TYPE_ID")
	private PriorityType eventPriorityType;

	@ManyToOne
	@JoinColumn(name = "EVENT_CYCLE_TYPE_ID")
	private CycleType eventCycleType;

	@Column(name = "EVENT_FIRST_DATETIME")
	private Date eventFirstDateTime;

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public PriorityType getEventPriorityType() {
		return eventPriorityType;
	}

	public void setEventPriorityType(PriorityType eventPriorityType) {
		this.eventPriorityType = eventPriorityType;
	}

	public CycleType getEventCycleType() {
		return eventCycleType;
	}

	public void setEventCycleType(CycleType eventCycleType) {
		this.eventCycleType = eventCycleType;
	}

	public Date getEventFirstDateTime() {
		return eventFirstDateTime;
	}

	public void setEventFirstDateTime(Date eventFirstDateTime) {
		this.eventFirstDateTime = eventFirstDateTime;
	}

	public Integer getEventId() {
		return this.eventID;
	}

}