package com.sms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sms.dao.ITitleChangeDao;
import com.sms.entity.TitleChange;

public class TitleChangeDaoImp implements ITitleChangeDao{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addTitleChange(TitleChange titleChange) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().save(titleChange);
	}

	@Override
	public void deleteTitleChange(TitleChange titleChange) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().delete(titleChange);
	}

	@Override
	public void modifyTitleChange(TitleChange titleChange) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().update(titleChange);
	}

	@Override
	public List<TitleChange> findTitleChangeByEId(Integer eId) {
		// TODO Auto-generated method stub
		Query query = (Query)getSession().createQuery("from TitleChange where eId = ?");
		query.setString(0, eId.toString());	
		return (List<TitleChange>)query.list();
	}

}
