package com.sms.action;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.sms.entity.Employee;
import com.sms.security.Md5;
import com.sms.service.IEmployeeManage;

public class EmployeeAction extends ActionSupport {

	private Employee employee;

	@Resource
	private IEmployeeManage employeeManage;

	public static boolean isValid(int value) {
		if (value >= 100000 && value <= 999999)
			return true;
		return false;
	}
	
	public void setEmployeeManage(IEmployeeManage employeeManage) {
		this.employeeManage = employeeManage;
	}

	public IEmployeeManage getEmployeeManage() {
		return employeeManage;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String addUser() {
		System.out.println("-------userAction.addUser--------" + user.getId());
		if (isValid(user.getId()) && isPasswordValid(user.getPassword()))
		{
			user.setPassword(Md5.generatePassword(user.getPassword()));
			userManage.addUser(user);
			return "success";
		}
		System.out.println("密码长度不够");
		return "fail";
	}

	public String modifyUser() {
		System.out.println("-------userAction.modifyUser--------" + user.getId());
		if (isValid(user.getId()) && userManage.findUserById(user.getId()) != null && isPasswordValid(user.getPassword()))
		{			
			user.setPassword(Md5.generatePassword(user.getPassword()));
			userManage.modifyUser(user);
			return "success";
		}
		System.out.println("密码长度不够");
		return "fail";
	}

	public String deleteUser() {
		System.out.println("-------userAction.deleteUser--------" + user.getId());
		
		if (Md5.validatePassword(userManage.findUserById(user.getId()).getPassword(), user.getPassword()))
		{
			userManage.deleteUser(user);
			return "success";
		}
		System.out.println("密码错误");
		return "fail";
	}
	
}

