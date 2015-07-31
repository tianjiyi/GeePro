package com.gee.manager;

import java.util.List;

import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gee.entity.UserEntity;
import com.gee.exception.GeeUserException;

@Repository
public class UserManager extends BaseManager<UserEntity> {

	@Transactional
	public void save(UserEntity user) {
		saveOrUpdate(user);
	}

	@Transactional
	public UserEntity getById(Integer userId) {
		UserEntity user = new UserEntity();
		user.setId(userId);
		Example userExample = Example.create(user);
		List<UserEntity> users = this.qbe(userExample);
		if (users.size() == 0) {
			throw new GeeUserException("No user found");
		}
		return users.get(0);
	}
	
	@Transactional
	public List<UserEntity> qbe(Example userExample) {
		List<UserEntity> users = getSession().createCriteria(UserEntity.class).add(userExample).list();
		return users;
	}
	
	@SuppressWarnings("unchecked")
	public Integer authenticateUser(String username, String password){
		
		List<UserEntity> users = getSession().createCriteria(UserEntity.class)
												.add(Restrictions.eq("userName", username))
												.add(Restrictions.eq("password", password)).list();

		if(users.size() == 1){
			return users.get(0).getId();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<UserEntity> findAllUsers() {
		return getSession().createCriteria(UserEntity.class).list();
	}

}
