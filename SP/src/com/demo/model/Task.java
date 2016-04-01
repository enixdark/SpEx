package com.demo.model;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Task {
	private static AtomicLong count = new AtomicLong(0);
	private long id;
	private String name;
	private int priority;
	private String comment;
	private User user;
	private User assignee;
	private String status;
	public Task(){
		this.setId(count.incrementAndGet());
	}
	
	public Task(String name, int priority, String comment, User user, User assignee){
		this.setId(count.incrementAndGet());
		this.name = name;
		this.priority = priority;
		this.comment = comment;
		this.user = user;
		this.assignee = assignee;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User getAssignee() {
		return assignee;
	}
	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}

	public long getId() {
		return id;
	}

	private void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
