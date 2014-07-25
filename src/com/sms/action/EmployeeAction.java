package com.sms.action;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.omg.CORBA.Request;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sms.entity.Employee;
import com.sms.security.Md5;
import com.sms.service.IEmployeeManage;
import com.sms.service.IUserManage;

public class EmployeeAction extends ActionSupport {

	private Employee employee;

	@Resource
	private IEmployeeManage employeeManage;

	public Employee getEmployee() {
		return employee;
	}
	

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setEmployeeManage(IEmployeeManage employeeManage) {
		this.employeeManage = employeeManage;
	}

	public IEmployeeManage getEmployeeManage() {
		return employeeManage;
	}

	public static boolean isValid(int value) {
		if (value >= 100000 && value <= 999999)
			return true;
		return false;
	}

	public String addEmployee() {
		System.out.println("-------employeeAction.addEmployee--------"
				+ employee.getId());
		if (isValid(employee.getId())) {
			employeeManage.addEmployee(employee);
			ActionContext.getContext().getSession()
					.put("addedEmployee", employee);
			return "success";
		}
		return "fail";
	}

	public String modifyEmployee() {
		System.out.println("-------employeeAction.modifyEmployee--------"
				+ employee.getId());
		if (isValid(employee.getId())
				&& employeeManage.findEmployeeById(employee.getId()) != null) {
			employeeManage.modifyEmployee(employee);
			return "success";
		}
		return "fail";
	}

	public String getEmployeeInfo() {
		System.out.println("-------employeeAction.getEmployeeInfo--------"
				+ employee.getId());
		if (employee.getId() == null)
			return "fail";
		if (isValid(employee.getId())
				&& employeeManage.findEmployeeById(employee.getId()) != null) {
			Integer eid = employee.getId();
			employee = employeeManage.findEmployeeById(eid);
			Map session = ActionContext.getContext().getSession();
			session.put("eInfo", employee);
			return "success";
		}
		return "fail";
	}

}
