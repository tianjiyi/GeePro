package com.gee.manager;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public abstract class BaseManager<E> {
	
	@Autowired
    private SessionFactory sessionFactory;
	

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
	

    public void persist(E entity) {
        getSession().persist(entity);
    }
    
    public void saveOrUpdate(E entity){
    	getSession().saveOrUpdate(entity);
    }
	

    public void delete(E entity) {
        getSession().delete(entity);
    }

}
