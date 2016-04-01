package com.demo.web.controllers;

import java.util.Date;
import java.util.Locale;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.User;
import com.demo.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired(required=false)
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String listAllUsers(Locale locale, Model model){
		model.addAttribute("users",userService.findAllUsers());
		return "user/list";
	}
	
	@RequestMapping(path = "/new", method = RequestMethod.GET)
	public String newUserForm(Model model){
		User user = new User();
		user.setBirthday(new Date());
		model.addAttribute("user",user);
		return "user/new";
	}
	
	@RequestMapping(path = "/new", method = RequestMethod.POST)
	public String saveNewUser(@ModelAttribute("user") User user, Model model){
		userService.createNewUser(user);
		return "redirect:/user";
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ModelAndView viewUser(@PathVariable("id") Long id){
		return new ModelAndView("/user/view").addObject("user", userService.findById(id));
	}
	
	@RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
	public String editUser(@PathVariable("id") Long id, Model model){
		model.addAttribute("user",userService.findById(id));
		return "user/edit";
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public String updateUser(@PathVariable("id") Long id,@ModelAttribute("user") User user, Model model){
		userService.updateUser(user);
		model.addAttribute("user", userService.findById(id));
		return "redirect:/user/"+id;
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable("id") Long id, Model model){
		User exist = userService.findById(id);
		if(exist != null){
			userService.deleteUser(id);
		}
		return "redirect:/user";
	}
}
