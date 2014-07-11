package com.sms.service.impl;

import javax.annotation.Resource;

import com.sms.dao.IEmployeeDao;
import com.sms.entity.Employee;
import com.sms.service.IEmployeeManage;

public class EmployeeManageImp implements IEmployeeManage {
	@Resource
	IEmployeeDao employeeDao;

	@Override
	public void addEmployee(Employee employee) {
			employeeDao.addEmployee(employee);
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
