package com.demo.model;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;;

public class User {
	private static AtomicLong count = new AtomicLong(0);
	private long id;
	private String name;
	private Date birthday;
	public User(){
		this(count.incrementAndGet(),null,null);
	}
	
	public User(String name, Date birthday){
		this(count.incrementAndGet(),name,birthday);
	}
	
	public User(User user){
		
	}
	
	public User(long id, String name, Date birthday){
		this.id = id;
		this.name = name;
		this.birthday = birthday;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
