package com.gee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gee.component.UserService;
import com.gee.entity.UserEntity;

@RestController
@RequestMapping("/data")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/user")
	public UserEntity getUserDetail	(@RequestParam(value="id")Integer id){
		UserEntity user = userService.getUserInfo(id);
		return user;
	}

}
