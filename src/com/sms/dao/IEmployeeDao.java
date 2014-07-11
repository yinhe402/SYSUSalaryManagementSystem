package com.sms.dao;

import com.sms.entity.Employee;

public interface IEmployeeDao {
	public void addEmployee(Employee employee);
	public void deleteEmployee(Employee employee);
	public void modifyEmployee(Employee employee);
	public Employee findEmployeeById(Integer id);
}
