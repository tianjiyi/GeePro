package com.gee.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gee.component.SessionService;
import com.gee.entity.SessionEntity;
import com.gee.entity.UserEntity;

@RestController
@RequestMapping("/session")
public class SessionController {
	
	@Resource
	private SessionService sessionService;
	
	@RequestMapping
	public SessionEntity getMetaData(){
		SessionEntity session = new SessionEntity();
		return session;
	}
	
	@RequestMapping(value = "/requestLoginSession", method = RequestMethod.POST)
	public @ResponseBody SessionEntity requestNewLoginSession(@RequestBody UserEntity requestedUser){
		return sessionService.createNewSession(requestedUser.getUserName(), requestedUser.getPassword());
	}

}
