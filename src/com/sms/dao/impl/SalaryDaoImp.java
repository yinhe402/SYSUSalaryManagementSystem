<<<<<<< HEAD
package com.sms.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sms.dao.ISalaryDao;
import com.sms.entity.Salary;

public class SalaryDaoImp implements ISalaryDao {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void AddSalary(Salary salary) {
		getSession().save(salary);
	}

	@Override
	public void modifySalary(Salary salary) {
		getSession().clear();
		getSession().update(salary);
	}

	@Override
	public void deleteSalary(Salary salary) {
		getSession().clear();
		getSession().delete(salary);

	}

	@Override
	public Salary findSalaryById(Integer id) {
		Query query = getSession().createQuery("from Salary as s where s.id = ?");
		query.setString(0,id.toString());
		Salary s = (Salary)query.uniqueResult();
		return s;
	}

}
=======
package com.sms.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sms.dao.ISalaryDao;
import com.sms.entity.Salary;

public class SalaryDaoImp implements ISalaryDao {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addSalary(Salary salary) {
		getSession().save(salary);
	}

	@Override
	public void modifySalary(Salary salary) {
		getSession().clear();
		getSession().update(salary);
	}

	@Override
	public void deleteSalary(Salary salary) {
		getSession().clear();
		getSession().delete(salary);

	}

	@Override
	public Salary findSalaryById(Integer id) {
		Query query = getSession().createQuery("from Salary as s where s.id = ?");
		query.setString(0,id.toString());
		Salary s = (Salary)query.uniqueResult();
		return s;
	}

}
>>>>>>> e9fbb8eeae8b7f08ccade04560041c279df191c3
