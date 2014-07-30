package com.sms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sms.dao.IFinalCheckDao;
import com.sms.entity.FinalCheck;

public class FinalCheckDaoImp implements IFinalCheckDao{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addFinalCheck(FinalCheck finalCheck) {
		getSession().clear();
		getSession().save(finalCheck);
	}

	@Override
	public void deleteFinalCheck(FinalCheck finalCheck) {
		getSession().clear();
		getSession().delete(finalCheck);
	}

	@Override
	public void modifyFinalCheck(FinalCheck finalCheck) {
		getSession().clear();
		getSession().update(finalCheck);
	}

	@Override
	public List<FinalCheck> findFinalCheckByEId(Integer eId) {
		Query query = (Query)getSession().createQuery("from FinalCheck where eId = ?");
		query.setString(0, eId.toString());	
		return (List<FinalCheck>)query.list();
	}

	@Override
	public List<FinalCheck> findFinalChecksByResult(String result) {
		Query query = (Query) getSession().createCriteria("from FinalCheck where checkResult = ?");
		query.setString(0, result);
		return (List<FinalCheck>)query.list();
	}

}
