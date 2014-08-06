package com.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.sms.dao.IEmployeeDao;
import com.sms.dao.IUserDao;
import com.sms.entity.Employee;
import com.sms.entity.User;
import com.sms.security.Md5;
import com.sms.service.IEmployeeManage;

public class EmployeeManageImp implements IEmployeeManage {
	@Resource
	IEmployeeDao employeeDao;
	@Resource
	IUserDao userDao;

	@Override
	public void addEmployee(Employee employee) {
		if (findEmployeeById(employee.getId()) != null)
			modifyEmployee(employee);
		else {
			employeeDao.addEmployee(employee);

			User user = new User();
			user.setId(employee.getId());
			user.setPassword(Md5.generatePassword(employee.getId().toString()));
			user.setUserType(0);
			if (userDao.findUserById(user.getId()) != null)
				userDao.modifyUser(user);
			else {
				userDao.AddUser(user);
			}
		}
	}

	@Override
	public void modifyEmployee(Employee employee) {
		employeeDao.modifyEmployee(employee);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		employeeDao.modifyEmployee(employee);
	}

	@Override
	public Employee findEmployeeById(Integer id) {
		return (Employee) employeeDao.findEmployeeById(id);
	}

	@Override
	public List<Employee> findEmployeesByName(String name) {
		return (List<Employee>) employeeDao.findEmployeesByName(name);
	}

	@Override
	public List<Employee> findEmployeesByDepartment(String department) {
		return (List<Employee>) employeeDao
				.findEmployeesByDepartment(department);
	}
}
