package com.demo.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.model.Task;
import com.demo.service.TaskService;

import java.util.Locale;

/**
 * Created by cqshinn on 31/03/2016.
 */
@Controller
public class HomeController {
	private final static Logger logger = LoggerFactory.getLogger(HomeController.class);
	
    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Locale locale, Model model){
        logger.info(String.format("Welcome to Taskify! Locale is {}.", locale));
        model.addAttribute("totalTasks", taskService.findAllTasksCount());
        model.addAttribute("totalOpenTasks", taskService.findAllOpenTasksCount());
        return "home";
    }
    
    //user for http://uri/tasks?status=Open
    @RequestMapping(path = "/tasks", method = RequestMethod.GET)
    public String list(/*@RequestParam(name = "status", required = false, defaultValue = "404") 
    	String status, */Model model){
    	model.addAttribute("tasks", taskService.findAllTasks());
    	return "tasks/list";
    }
    
//    @RequestMapping(path = "/tasks/new.json", method = RequestMethod.POST,
//    		consumes = "application/json", produces = "application/json")
//    @ResponseBody
//    public CreateTaskResponse createNewTaskJson(@ResponseBody CreateTaskRequest createRequest)
//    {
//    	Task task = new Task();
//    	task.setName(createRequest.getTaskName());
//    	return new CreateTaskResponse(taskService.createTask(task));
//    }


}

