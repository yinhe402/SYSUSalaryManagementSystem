package com.sms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sms.dao.IExperiencesDao;
import com.sms.entity.Employee;
import com.sms.entity.Experiences;

public class ExperiencesDaoImp implements IExperiencesDao {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addExperiences(Experiences experiences) {
		getSession().save(experiences);
	}
	
	@Override
	public void modifyExperiences(Experiences experiences) {
		getSession().clear();
		getSession().update(experiences);
	}
	
	@Override
	public void deleteExperiences(Experiences experiences) {
		getSession().clear();
		getSession().delete(experiences);
	}
	
	@Override
	public List<Experiences> findManageExperiencesListByEid(Integer eid) {		
		Query query = (Query)getSession().createQuery("from Experiences as e where (e.eid = ? AND e.type = 1)");
		query.setInteger(0, eid);
		return (List<Experiences>)query.list();
	}
	
	@Override
	public List<Experiences> findProfExperiencesListByEid(Integer eid) {		
		Query query = (Query)getSession().createQuery("from Experiences as e where (e.eid = ? AND e.type = 2)");
		query.setInteger(0, eid);
		return (List<Experiences>)query.list();
	}
	
	@Override
	public List<Experiences> findWorkerExperiencesListByEid(Integer eid) {		
		Query query = (Query)getSession().createQuery("from Experiences as e where (e.eid = ? AND e.type = 3)");
		query.setInteger(0, eid);
		return (List<Experiences>)query.list();
	}
	
	@Override
	public List<Experiences> findEduExperiencesListByEid(Integer eid) {		
		Query query = (Query)getSession().createQuery("from Experiences as e where (e.eid = ? AND e.type = 0)");
		query.setInteger(0, eid);
		return (List<Experiences>)query.list();
	}
}
