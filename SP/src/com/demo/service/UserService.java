package com.demo.service;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Component;

import com.demo.model.Data;
import com.demo.model.User;

//public interface UserService {
//	List<User> findAllUsers();
//	void createNewUser(User user);
//	User findById(Long id);
//	void updateUser(User user);
//	boolean deleteUser(Long id); 
//}
@Component("userService")
public class UserService {
	public List<User> findAllUsers(){
		return Data.users;
	}
	public void createNewUser(User user){
		Data.users.add(user);
	}
	public User findById(Long id){
		return Data.users.stream().filter(u -> u.getId() == id).findFirst().get();
	}
	public void updateUser(User user){
		User us = Data.users.stream().filter(u -> u.getId() == user.getId()).findFirst().get();
		us.setName(user.getName());
		us.setBirthday(user.getBirthday());
	}
	
	public boolean deleteUser(Long id){
		User us = Data.users.stream().filter(u -> u.getId() == id).findFirst().get();
		return Data.users.remove(us);
	}
	public File addProfileImage(Long userId, String originalFilename) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
