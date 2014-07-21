package com.sms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sms.dao.IDeductionDao;
import com.sms.entity.Deduction;

public class DeductionDaoImp implements IDeductionDao{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addDeduction(Deduction deduction) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().save(deduction);
	}

	@Override
	public void deleteDeduction(Deduction deduction) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().delete(deduction);
	}

	@Override
	public void modifyDeduction(Deduction deduction) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().update(deduction);
	}

	@Override
	public List<Deduction> findDeductionByEId(Integer eId) {
		// TODO Auto-generated method stub
		Query query = (Query)getSession().createQuery("from Deduction where eId = ?");
		query.setString(0, eId.toString());	
		return (List<Deduction>)query.list();
	}

}
