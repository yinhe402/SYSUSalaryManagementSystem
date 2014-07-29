package com.sms.dao;

import java.util.List;

import com.sms.entity.Employee;

public interface IEmployeeDao {
	public void addEmployee(Employee employee);
	public void deleteEmployee(Employee employee);
	public void modifyEmployee(Employee employee);
	public Employee findEmployeeById(Integer id);
	public List<Employee> findEmployeesByName(String name);
	public List<Employee> findEmployeesByDepartment(String department);
}
