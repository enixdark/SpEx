package com.demo.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.demo.model.Data;
import com.demo.model.Task;

//public interface TaskService {
//	int createTask(String name, int priority, int createUserById, int assigneeId);
//	Task findTaskById(int id);
//	List<Task> findTaskByAssignee(int id);
//	List<Task> findAllTasks();
//	int findAllTasksCount();
//	List<Task> findAllOpenTasks();
//	int findAllOpenTasksCount();
//	
//	List<Task> findTaskByAssignee(String name);
//	List<Task> findOpenTaskByAssignee(int id);
//	List<Task> findOpenTaskByAssignee(String name);
//	
//	void completeTask(int id,String comment, int user);
//	
//}
@Component("taskService")
public class TaskService {
	static UserService userService = new UserService();
	
	public int createTask(String name, int priority, long createUserById, long assigneeId){
		new Task(name,priority,"Test",userService.findById(createUserById), userService.findById(assigneeId));
		return 1;
	}
	
	public Task findTaskById(int id){
		return Data.tasks.stream().filter(t -> t.getId() == id).findFirst().get();
	}
	public List<Task> findTaskByAssignee(int id){
		return Data.tasks.stream().filter(t -> t.getAssignee().getId() == id)
				.collect(Collectors.toList());
	}
	public List<Task> findAllTasks(){
		return Data.tasks;
	}
	public int findAllTasksCount(){
		return Data.tasks.size();
	}
	public List<Task> findAllOpenTasks(){
		return Data.tasks.stream().filter(t -> t.getPriority() > 0)
				.collect(Collectors.toList()); 
	}
	public long findAllOpenTasksCount(){
		return Data.tasks.stream().filter(t -> t.getPriority() > 0)
				.count(); 
	}
	
	public List<Task> findTaskByAssignee(String name){
		return Data.tasks.stream().filter(t -> t.getAssignee().getName().equals(name))
				.collect(Collectors.toList());
	}
	public List<Task> findOpenTaskByAssignee(long id){
		return Data.tasks.stream().filter(t -> t.getAssignee().getId() == id && t.getPriority() > 0)
				.collect(Collectors.toList());
	}
	public List<Task> findOpenTaskByAssignee(String name){
		return Data.tasks.stream().filter(t -> t.getAssignee().getName().equals(name) && t.getPriority() > 0)
				.collect(Collectors.toList());
	}
	
	public void completeTask(int id,String comment, int user){
		
	}
	
}
