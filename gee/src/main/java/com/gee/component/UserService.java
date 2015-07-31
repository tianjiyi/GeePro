package com.gee.component;




import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gee.entity.UserEntity;
import com.gee.manager.UserManager;

@Service
public class UserService implements IUserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Resource
	private UserManager userManager;
	
	@Override
	public UserEntity getUserInfo(Integer id) {
//		UserEntity user = new UserEntity();
//		user.setId(id);
//		user.setUserName("testUser");
//		user.setFirstName("Test");
//		user.setLastName("User");
		UserEntity user = userManager.getById(id);
		logger.debug("Retriving user: {}; At {}", user.getUserName(), new Date());
		return user;
	}
	
	public void saveUser(UserEntity user){
		userManager.save(user);
	}

}
