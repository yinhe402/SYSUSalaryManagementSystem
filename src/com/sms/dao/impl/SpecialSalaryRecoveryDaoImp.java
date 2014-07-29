package com.sms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sms.dao.ISpecialSalaryRecoveryDao;
import com.sms.entity.SpecialSalaryRecovery;

public class SpecialSalaryRecoveryDaoImp implements ISpecialSalaryRecoveryDao{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addSpecialSalaryRecovery(SpecialSalaryRecovery specialSalaryRecovery) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().save(specialSalaryRecovery);
	}

	@Override
	public void deleteSpecialSalaryRecovery(SpecialSalaryRecovery specialSalaryRecovery) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().delete(specialSalaryRecovery);
	}

	@Override
	public void modifySpecialSalaryRecovery(SpecialSalaryRecovery specialSalaryRecovery) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().update(specialSalaryRecovery);
	}

	@Override
	public List<SpecialSalaryRecovery> findSpecialSalaryRecoveryByEId(Integer eId) {
		// TODO Auto-generated method stub
		Query query = (Query)getSession().createQuery("from SpecialSalaryRecovery where eId = ?");
		query.setString(0, eId.toString());	
		return (List<SpecialSalaryRecovery>)query.list();
	}

	@Override
	public List<SpecialSalaryRecovery> findAllSpecialSalaryRecovery() {
		// TODO Auto-generated method stub
		Query query = (Query)getSession().createQuery("from SpecialSalaryRecovery");	
		return (List<SpecialSalaryRecovery>)query.list();
	}

}
