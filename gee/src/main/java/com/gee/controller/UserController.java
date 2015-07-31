package com.gee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gee.component.UserService;
import com.gee.entity.UserEntity;

@RestController
@RequestMapping("/user")
public class UserController {
	
	public static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping
	public UserEntity getUserMetaData(){
		UserEntity user = new UserEntity();
		return user;
	}
	
	@RequestMapping("/getById/{id}")
	public UserEntity getUserDetail	(@PathVariable(value="id")Integer id){
		UserEntity user = userService.getUserInfo(id);
		return user;
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String createuser(@RequestBody UserEntity user){
		logger.info("Start create user");
		userService.saveUser(user);
		return "SUCCESS";
	}

}
