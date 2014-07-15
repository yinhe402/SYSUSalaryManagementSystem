package com.sms.service.impl;

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
		employeeDao.addEmployee(employee);
		
		User user = new User();
		user.setId(employee.getId());
		user.setPassword(Md5.generatePassword(employee.getId().toString()));
		user.setUserType(0);
		userDao.AddUser(user);
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
		return (Employee)employeeDao.findEmployeeById(id);
	}

}
