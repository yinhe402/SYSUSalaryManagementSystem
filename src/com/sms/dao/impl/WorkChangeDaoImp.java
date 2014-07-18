package com.sms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sms.dao.IWorkChangeDao;
import com.sms.entity.WorkChange;

public class WorkChangeDaoImp implements IWorkChangeDao{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addWorkChange(WorkChange workChange) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().save(workChange);
	}

	@Override
	public void deleteWorkChange(WorkChange workChange) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().delete(workChange);
	}

	@Override
	public void modifyWorkChange(WorkChange workChange) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().update(workChange);
	}

	@Override
	public List<WorkChange> findWorkChangeByEId(Integer eId) {
		// TODO Auto-generated method stub
		Query query = (Query)getSession().createQuery("from WorkChange where eId = ?");
		query.setString(0, eId.toString());	
		return (List<WorkChange>)query.list();
	}

}
