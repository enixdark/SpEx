package com.demo.web.controllers;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.demo.model.Task;

@RestController
public class TaskRestController {
//	@RequestMapping(path = "/api/task/new.json", method = RequestMethod.POST,
//			consumes = "application/json", produces = "application/json")
//	public CreateTaskResponse createNewTaskJson(@RequestBody CreateTaskRequest createRequest)
//	{
//		Task task = new Task();
//		task.setName(createRequest.getTaskName());
//		return new CreateTaskResponse(taskService.createTask(task));
//	} 
	
	//use async request with callable
//	@RequestMapping(path = "/api/task/new.json", method = RequestMethod.POST,
//			consumes = "application/json", produces = "application/json")
//	public Callable<CreateTaskResponse> createNewTaskJson(@RequestBody CreateTaskRequest createRequest)
//	{
//		return new Callable<CreateTaskResponse>() {
//			Task task = new Task();
//			task.setName(createRequest.getTaskName());
//			return new CreateTaskResponse(taskService.createTask(task));
//		};
//		
//	}

	//use async request with deffer
//	@RequestMapping(path = "/api/task/new.json", method = RequestMethod.POST,
//			consumes = "application/json", produces = "application/json")
//	public DeferredResult<CreateTaskResponse> createNewTaskJson(@RequestBody CreateTaskRequest createRequest)
//	{
//		DeferredResult<CreateTaskResponse> def = new DeferredResult<>();
//		CompletableFuture.runAsync(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				Task task = new Task();
//				task.setName(createRequest.getTaskName());
//				return new CreateTaskResponse(taskService.createTask(task));
//			}
//		});	
//	}
}
