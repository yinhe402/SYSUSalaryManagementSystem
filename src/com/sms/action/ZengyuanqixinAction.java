package com.sms.action;

import java.util.Date;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.sms.entity.Employee;
import com.sms.entity.StartSalaryInfo;
import com.sms.service.IEmployeeManage;
import com.sms.service.IManageSalaryManage;
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
	
	@Resource
	private IManageSalaryManage manageSalaryManage;	
	
	public IManageSalaryManage getManageSalaryManage() {
		return manageSalaryManage;
	}

	public void setManageSalaryManage(IManageSalaryManage manageSalaryManage) {
		this.manageSalaryManage = manageSalaryManage;
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
			
			//自动套用确定工作前年龄
			if (employee.getMaxDegree() == "博士")
				startSalaryInfo.setSeniorityBeforeWork(5);
			else if (employee.getMaxDegree() == "硕士")
				startSalaryInfo.setSeniorityBeforeWork(2);			
			startSalaryInfo.setChangeYears(startSalaryInfo.getWorkYears()+startSalaryInfo.getSeniorityBeforeWork()+startSalaryInfo.getLearnSeniority());
			
			startSalaryInfo.setHireYears(2006-employee.getStartWorkDate().getYear()+1-startSalaryInfo.getBreakOffSeniority());
			
			if (startSalaryInfo.getSalarySeries() == "管理")
			{
				startSalaryInfo.setPositionSalary(new Double(manageSalaryManage.findManPosSalByLevel(startSalaryInfo.getPositionLevel()).getSalaryStandard()));
				Integer 
			}
			else if (startSalaryInfo.getSalarySeries() == "专技")
			{
				
			}
			else if (startSalaryInfo.getSalarySeries() == "技工")
			{
				
			}
			else if (startSalaryInfo.getSalarySeries() == "普工")
			{
				
			}
			else 
			{
				System.out.println("工资系列有误，请您检查");
				return "fail";
			}
			
			
			startSalaryInfoManage.addStartSalaryInfo(startSalaryInfo);
			return "success";
		}
		return "fail";
	}
}
