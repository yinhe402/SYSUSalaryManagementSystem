package com.sms.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sms.dao.IUserDao;
import com.sms.entity.User;

public class UserDaoImp implements IUserDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void AddUser(User user) {
		getSession().save(user);
	}

	@Override
	public void modifyUser(User user) {
		getSession().clear();
		getSession().update(user);
	}

	@Override
	public void deleteUser(User user) {
		getSession().clear();
		getSession().delete(user);
	}

	@Override
	public User findUserById(Integer  id) {
		Query query = getSession().createQuery("from User as u where u.id = ?");
		query.setString(0,id.toString());
		User u = (User)query.uniqueResult();
		return u;
	}

}
