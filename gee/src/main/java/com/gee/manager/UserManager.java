package com.gee.manager;

import java.util.List;

import com.gee.entity.UserEntity;

public class UserManager extends BaseManager<UserEntity> {
	
	public void save(UserEntity user){
		persist(user);
	}
	
	@SuppressWarnings("unchecked")
	public List<UserEntity> findAllUsers(){
		return 	getSession().createCriteria(UserEntity.class).list();
	}

}
