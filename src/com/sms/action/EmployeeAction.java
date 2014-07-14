package com.sms.action;

import javax.annotation.Resource;

import org.omg.CORBA.Request;

import com.opensymphony.xwork2.ActionSupport;
import com.sms.entity.Employee;
import com.sms.security.Md5;
import com.sms.service.IEmployeeManage;
import com.sms.service.IUserManage;

public class EmployeeAction extends ActionSupport {

	private Employee employee;

	@Resource
	private IEmployeeManage employeeManage;
	
	@Resource
	private IUserManage userManage;

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

	public String addEmployee() {
		System.out.println("-------employeeAction.addEmployee--------" + employee.getId());
		if (isValid(employee.getId())) {
			employeeManage.addEmployee(employee);				
			return "success";
		}
		return "fail";
	}

	public String modifyEmployee() {
		System.out.println("-------employeeAction.modifyEmployee--------" + employee.getId());
		if (isValid(employee.getId()) && employeeManage.findEmployeeById(employee.getId()) != null) {
			employeeManage.modifyEmployee(employee);
			return "success";
		}
		return "fail";
	}

}
