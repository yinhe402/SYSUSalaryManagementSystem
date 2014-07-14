package com.sms.dao.impl;

import org.hibernate.*;

import com.sms.dao.IEmployeeDao;
import com.sms.entity.Employee;
import com.sms.entity.User;

public class EmployeeDaoImp implements IEmployeeDao {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Employee findEmployeeById(Integer id) {
		getSession().clear();
		Query query = getSession().createQuery("from Employee as e where e.id = ?");
		query.setString(0, id.toString());	
		Employee employee = (Employee)query.uniqueResult();
		return employee;
	}

	@Override
	public void addEmployee(Employee employee) {
		getSession().save(employee);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		getSession().clear();
		getSession().delete(employee);
	}

	@Override
	public void modifyEmployee(Employee employee) {
		getSession().update(employee);
		
	}

}
