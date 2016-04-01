package com.demo.web.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.User;
import com.demo.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	static final String FILE_ROOT_DIR = "/tmp/servlet-uploads";
	@Autowired
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
	
	@RequestMapping(path = "/{userId}/profileForm", method = RequestMethod.GET)
	public String uploadProfileImage(@PathVariable("userId") @Valid Long userId,Model model){
		model.addAttribute("user",userService.findById(userId));
		return "users/upload";
	}
	
	@RequestMapping(path = "/{userId}/profileForm", method = RequestMethod.POST)
	public String postUploadProfileImage(@PathVariable("userId") @Valid Long userId, 
			@RequestParam("profileImage") MultipartFile file) throws IOException{
		User user = userService.findById(userId);
		String rootDir = String.format("%s/%d", FILE_ROOT_DIR , userId);
		if(!file.isEmpty()){
			File fileDir = new File(rootDir);
			if(!fileDir.exists()){
				fileDir.mkdirs();
			}
		}
		FileCopyUtils.copy(file.getBytes(), new File(String.format("%s/%s", FILE_ROOT_DIR, file.getOriginalFilename())));
		File profileImageFile = userService.addProfileImage(userId,file.getOriginalFilename());
		return "redirect:/users/"+userId;
	}
}
