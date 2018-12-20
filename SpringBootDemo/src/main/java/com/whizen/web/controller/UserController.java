package com.whizen.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whizen.entity.User;
import com.whizen.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private UserService userService;
	@GetMapping(value ="/get/{id}")
	public User get(@PathVariable Integer id) {
		return this.userService.get(id);
	}
	@GetMapping(value = "/insert")
	public Object insert(User user) {
		int count = this.userService.insert(user);
		if (count>0) {
			return "seccess";
		}
		else {
			return "fail";
		}
	}
	@GetMapping(value = "/list")
	public List<User> list() {
		// TODO Auto-generated method stub
		return this.userService.list();
	}
	
	@GetMapping(value = "/delete")
	public Object delete(Integer id) {
		// TODO Auto-generated method stub
		int count = this.userService.delete(id);
		if (count>0) {
			return "seccess";
		}
		else {
			return "fail";
		}
	}
	@GetMapping(value = "/update")
	public Object update(User user) {
		// TODO Auto-generated method stub
		int count = this.userService.update(user);
		if (count>0) {
			return "seccess"; 
		}
		else {
			return "fail";
		}
	}
	

}
