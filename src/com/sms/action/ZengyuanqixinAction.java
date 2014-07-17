package com.sms.action;

import java.util.Date;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.sms.entity.Employee;
import com.sms.entity.StartSalaryInfo;
import com.sms.service.IEmployeeManage;
import com.sms.service.IStartSalaryInfoManage;
import com.sms.action.EmployeeAction;

public class ZengyuanqixinAction extends ActionSupport {
	private StartSalaryInfo startSalaryInfo;

	public StartSalaryInfo getStartSalaryInfo() {
		return startSalaryInfo;
	}

	public void setStartSalaryInfo(StartSalaryInfo startSalaryInfo) {
		this.startSalaryInfo = startSalaryInfo;
	}
	
	@Resource
	private IStartSalaryInfoManage startSalaryInfoManage;

	public IStartSalaryInfoManage getStartSalaryInfoManage() {
		return startSalaryInfoManage;
	}

	public void setStartSalaryInfoManage(
			IStartSalaryInfoManage startSalaryInfoManage) {
		this.startSalaryInfoManage = startSalaryInfoManage;
	}
	
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
	
	public String importStaff()
	{
		System.out.println("-------startSalaryInfoAction.importStaff--------" + employee.getId());
		if (isValid(employee.getId()))
		{
			employeeManage.addEmployee(employee);
			startSalaryInfo.setEid(employee.getId());
			startSalaryInfo.setOperateDate(new Date());
			startSalaryInfoManage.addStartSalaryInfo(startSalaryInfo);
			return "success";
		}
		return "fail";
	}
}
