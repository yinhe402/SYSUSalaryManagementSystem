package com.sms.service;

import java.util.List;

import com.sms.entity.Employee;

public interface IEmployeeManage {
	public void addEmployee(Employee employee);
	public void modifyEmployee(Employee employee);
	public void deleteEmployee(Employee employee);
	public Employee findEmployeeById(Integer id);
	public List<Employee> findEmployeesByName(String name);
	public List<Employee> findEmployeesByDepartment(String department);
}
