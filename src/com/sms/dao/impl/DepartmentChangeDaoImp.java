package com.sms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sms.dao.IDepartmentChangeDao;
import com.sms.entity.DepartmentChange;

public class DepartmentChangeDaoImp implements IDepartmentChangeDao{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addDepartmentChange(DepartmentChange departmentChange) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().save(departmentChange);
	}

	@Override
	public void deleteDepartmentChange(DepartmentChange departmentChange) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().delete(departmentChange);
	}

	@Override
	public void modifyDepartmentChange(DepartmentChange departmentChange) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().update(departmentChange);
	}

	@Override
	public List<DepartmentChange> findDepartmentChangeByEId(Integer eId) {
		// TODO Auto-generated method stub
		Query query = (Query)getSession().createQuery("from DepartmentChange where eId = ?");
		query.setString(0, eId.toString());	
		return (List<DepartmentChange>)query.list();
	}

}
