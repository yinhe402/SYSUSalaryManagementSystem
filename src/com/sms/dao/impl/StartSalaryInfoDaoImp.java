package com.sms.dao.impl;

import org.hibernate.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sms.dao.IStartSalaryInfoDao;
import com.sms.entity.StartSalaryInfo;

public class StartSalaryInfoDaoImp implements IStartSalaryInfoDao {
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addStartSalaryInfo(StartSalaryInfo startSalaryInfo) {
		getSession().save(startSalaryInfo);
	}

	@Override
	public void modifyStartSalaryInfo(StartSalaryInfo startSalaryInfo) {
		getSession().clear();
		getSession().update(startSalaryInfo);
	}

	@Override
	public void deleteStartSalaryInfo(StartSalaryInfo startSalaryInfo) {
		getSession().clear();
		getSession().update(startSalaryInfo);
	}

	@Override
	public StartSalaryInfo findStartSalaryInfoById(Integer id) {
		Query query = (Query)getSession().createQuery("from StartSalaryInfo as s where s.eid = ?");
		query.setString(0, id.toString());
		return (StartSalaryInfo)query.uniqueResult();
	}

}
