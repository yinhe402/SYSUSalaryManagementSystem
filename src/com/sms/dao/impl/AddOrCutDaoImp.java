package com.sms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sms.dao.IAddOrCutDao;
import com.sms.entity.AddOrCut;

public class AddOrCutDaoImp implements IAddOrCutDao{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addAddOrCut(AddOrCut addOrCut) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().save(addOrCut);
	}

	@Override
	public void deleteAddOrCut(AddOrCut addOrCut) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().delete(addOrCut);
	}

	@Override
	public void modifyAddOrCut(AddOrCut addOrCut) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().update(addOrCut);
	}

	@Override
	public List<AddOrCut> findAddOrCutByEId(Integer eId) {
		// TODO Auto-generated method stub
		Query query = (Query)getSession().createQuery("from AddOrCut where eId = ?");
		query.setString(0, eId.toString());	
		return ( List<AddOrCut>)query.list();
	}

}
