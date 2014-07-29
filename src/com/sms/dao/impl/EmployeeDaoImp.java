package com.sms.dao.impl;

import java.util.List;

import org.hibernate.*;

import com.sms.dao.IEmployeeDao;
import com.sms.entity.Employee;

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
		Query query = (Query)getSession().createQuery("from Employee as e where e.id = ?");
		query.setString(0, id.toString());	
		return (Employee)query.uniqueResult();
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
		getSession().clear();
		getSession().update(employee);
		
	}
	
	@Override
	public List<Employee> findEmployeesByName(String name) {
		Query query = (Query)getSession().createQuery("from Employee as e where e.name = ?");
		query.setString(0, name);	
		return (List<Employee>)query.list();
	}
	
	@Override
	public List<Employee> findEmployeesByDepartment(String department) {
		Query query = (Query)getSession().createQuery("from Employee as e where e.department = ?");
		query.setString(0, department);	
		return (List<Employee>)query.list();
	}
}
