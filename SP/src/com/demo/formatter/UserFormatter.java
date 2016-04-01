package com.demo.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.demo.model.Task;
import com.demo.model.User;
import com.demo.service.TaskService;
import com.demo.service.UserService;

@Component("userFormatter")
public class UserFormatter implements Formatter<User> {
	
	@Autowired
    private UserService userService;
	
	@Override
	public String print(User user, Locale locale) {
		// TODO Auto-generated method stub
		return user.getName();
	}

	@Override
	public User parse(String user, Locale locale) throws ParseException {
		// TODO Auto-generated method stub
		return userService.findById(Long.parseLong(user));
	}

}
