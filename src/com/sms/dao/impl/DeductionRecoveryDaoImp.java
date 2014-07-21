package com.sms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sms.dao.IDeductionRecoveryDao;
import com.sms.entity.DeductionRecovery;

public class DeductionRecoveryDaoImp implements IDeductionRecoveryDao{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addDeductionRecovery(DeductionRecovery deductionRecovery) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().save(deductionRecovery);
	}

	@Override
	public void deleteDeductionRecovery(DeductionRecovery deductionRecovery) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().delete(deductionRecovery);
	}

	@Override
	public void modifyDeductionRecovery(DeductionRecovery deductionRecovery) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().update(deductionRecovery);
	}

	@Override
	public List<DeductionRecovery> findDeductionRecoveryByEId(Integer eId) {
		// TODO Auto-generated method stub
		Query query = (Query)getSession().createQuery("from DeductionRecovery where eId = ?");
		query.setString(0, eId.toString());	
		return (List<DeductionRecovery>)query.list();
	}

}
