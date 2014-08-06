package com.sms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sms.dao.ILeaveSchoolPersonDao;
import com.sms.entity.LeaveSchoolPerson;

public class LeaveSchoolPersonDaoImp implements ILeaveSchoolPersonDao{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addLeaveSchoolPerson(LeaveSchoolPerson leaveSchoolPerson) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().save(leaveSchoolPerson);
	}

	@Override
	public void deleteLeaveSchoolPerson(LeaveSchoolPerson leaveSchoolPerson) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().delete(leaveSchoolPerson);
	}

	@Override
	public void modifyLeaveSchoolPerson(LeaveSchoolPerson leaveSchoolPerson) {
		// TODO Auto-generated method stub
		getSession().clear();
		getSession().update(leaveSchoolPerson);
	}

	@Override
	public LeaveSchoolPerson findLeaveSchoolPersonByEId(Integer eId) {
		// TODO Auto-generated method stub
		Query query = (Query)getSession().createQuery("from LeaveSchoolPerson where eId = ?");
		query.setString(0, eId.toString());	
		return (LeaveSchoolPerson)query.uniqueResult();
	}

	@Override
	public List<LeaveSchoolPerson> findLeaveSchoolPersonsList() {
		Query query = (Query)getSession().createQuery("from LeaveSchoolPerson");
		return (List<LeaveSchoolPerson>)query.list();
	}
}
