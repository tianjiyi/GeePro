package com.gee.component;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gee.entity.SessionEntity;
import com.gee.exception.GeeAuthException;
import com.gee.manager.SessionManager;
import com.gee.manager.UserManager;

@Service
public class SessionService {

	@Resource
	private SessionManager sessionManager;
	@Resource
	private UserManager userManager;
	
	@Transactional
	public SessionEntity createNewSession(String username, String password){
		Integer userId = userManager.authenticateUser(username, password);
		SessionEntity session = new SessionEntity();
		if(userId != null){
			session.setSessionKey(UUID.randomUUID().toString());
			session.setStartTime(new Date());
			session.setUserId(userId);
			sessionManager.saveOrUpdate(session);
			return session;	
		}else{
			throw new GeeAuthException();
		}
	}

}
