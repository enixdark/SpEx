package com.demo.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.model.Data;
import com.demo.model.Task;
import com.demo.service.TaskService;
import com.demo.service.UserService;
import com.demo.validation.TaskValidator;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;

import javax.validation.Valid;

/**
 * Created by cqshinn on 31/03/2016.
 */
@Controller
public class TaskController {
	private final static Logger logger = LoggerFactory.getLogger(TaskController.class);
	
    @Autowired
    private TaskService taskService;
    
    @Autowired
	private ConversionService conversionService;
	//Autowiring the ConversionService we declared in the context file above.
	 
    @InitBinder("task")
    protected void initBinder(WebDataBinder binder){
    	if(binder.getConversionService() == null)
    		binder.setConversionService(conversionService);
    	binder.addValidators(new TaskValidator());
    }

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
    
    @RequestMapping(path = "/tasks/new", method = RequestMethod.GET)
    public String newTaskForm(Model model){
    	model.addAllAttributes(new HashMap(){
    		{
    			put("task", new Task());
    			put("priorities", Arrays.asList(0,1,2,3,4,5,6,7,8,9,10));
    			put("users",Data.users);
    			put("assignees",Data.users);
    		}
    	});
    	return "tasks/new";
    }
    
    @RequestMapping(path = "/tasks/new", method = RequestMethod.POST)
    public String createTaskForm(@ModelAttribute("task") @Valid Task task,BindingResult result, Model model){
    	if(result.hasErrors()){
        	return "tasks/new";
    	}
    	else{
    		taskService.createTask(task.getName(), task.getPriority(), task.getUser().getId(), task.getAssignee().getId());
    		return "redirect:/tasks";
    	}
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

