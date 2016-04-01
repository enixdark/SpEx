package com.demo.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;

public class Data {
	public static List<User> users = Lists.newArrayList();
	public static List<Task> tasks = Lists.newArrayList();
	
	static{
		users.addAll(Arrays.asList(
				new User("Quan",new Date()),
				new User("Quyn",new Date()),
				new User("Hugo",new Date()),
				new User("Test",new Date())
		));
		
		tasks.addAll(Arrays.asList(
			new Task("Test 1",0, "Test", users.get(0), users.get(0)),
			new Task("Test 2",10, "Hello World", users.get(1), users.get(0)),
			new Task("Test 3",2, "Test 3", users.get(1), users.get(2)),
			new Task("Test 4",3, "Test", users.get(2), users.get(1)),
			new Task("Test 5",4, "Test 1", users.get(0), users.get(0)),
			new Task("Test 6",0, "Test 1", users.get(2), users.get(3)),
			new Task("Test 7",10, "Test 1", users.get(3), users.get(3)),
			new Task("Test 8",0, "Test 1", users.get(1), users.get(3)),
			new Task("Test 9",0, "Test 1", users.get(0), users.get(1))
		));
		
	}
}
