package com.sms.action;

import java.util.ArrayList;

import javax.annotation.Resource;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.sms.entity.ManagePaylevelSalary;
import com.sms.entity.ManagePositionSalary;
import com.sms.service.IManageSalaryManage;

public class SalaryStandardAction extends ActionSupport {
	
	private ManagePositionSalary managePositionSalary;

	public ManagePositionSalary getManagePositionSalary() {
		return managePositionSalary;
	}

	public void setManagePositionSalary(ManagePositionSalary managePositionSalary) {
		this.managePositionSalary = managePositionSalary;
	}
	
	private ManagePaylevelSalary managePaylevelSalary;

	public ManagePaylevelSalary getManagePaylevelSalary() {
		return managePaylevelSalary;
	}

	public void setManagePaylevelSalary(ManagePaylevelSalary managePaylevelSalary) {
		this.managePaylevelSalary = managePaylevelSalary;
	}
	
	@Resource
	private IManageSalaryManage manageSalaryManage;

	public IManageSalaryManage getManageSalaryManage() {
		return manageSalaryManage;
	}

	public void setManageSalaryManage(IManageSalaryManage manageSalaryManage) {
		this.manageSalaryManage = manageSalaryManage;
	}
	
	public String checkSalaryStandard()
	{
		System.out.println("-------salaryStandardAction.checkSalaryStandard--------");
		List<ManagePositionSalary> lst1;
		return "success";
	}
	
	public String modifySalaryStandard()
	{
		return "success";
	}
}
