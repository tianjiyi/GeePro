package com.gee.component;




import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.gee.entity.UserEntity;

@Component
public class UserService implements IUserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	@Override
	public UserEntity getUserInfo(Integer id) {
		UserEntity user = new UserEntity();
		user.setId(id);
		user.setUserName("testUser");
		user.setFirstName("Test");
		user.setLastName("User");
		logger.debug("Retriving user: {}; At {}", user.getUserName(), new Date());
		return user;
	}

}
