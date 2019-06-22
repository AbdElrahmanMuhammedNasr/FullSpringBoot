package com.example.demo.Entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Task {
	
	@Id
	@GeneratedValue
	private long id;
	@NotEmpty
	private String date;
	@NotEmpty
	private String startTime;
	@NotEmpty
	private String stopTime;
	@NotEmpty
	private String deecription;
	@ManyToOne
	@JoinColumn(name="USER_EMAIL")
	private User user;
	
	
	
	public Task() {
 	}

	public Task(String date, String startTime, String stopTime, String deecription) {
  		this.date = date;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.deecription = deecription;
	}

	public Task(String date, String startTime, String stopTime, String deecription, User user) {
 		this.date = date;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.deecription = deecription;
		this.user = user;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getStopTime() {
		return stopTime;
	}
	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}
	public String getDeecription() {
		return deecription;
	}
	public void setDeecription(String deecription) {
		this.deecription = deecription;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
