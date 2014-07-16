package com.sms.action;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
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
		List<ManagePositionSalary> lst1 = manageSalaryManage.findAllPositionSalary();
		List<ManagePaylevelSalary> lst2 = manageSalaryManage.findAllPayLevelSalary();
		System.out.println(lst1.isEmpty());
		System.out.println(lst1.get(0).getId());
		System.out.println(lst1.get(0).getPosition());
		System.out.println(lst1.get(0).getLevel());
		Map session = ActionContext.getContext().getSession();
		session.put("managepositionsalary", lst1);
		session.put("managepaylevelsalary", lst2);
		return "success";
	}
	
	public String modifyPosSalaryStandard()
	{
		System.out.println("-------salaryStandardAction.modifyPosSalaryStandard--------");
		ManagePositionSalary tmpManagePositionSalary = new ManagePositionSalary();
		tmpManagePositionSalary.setId(managePositionSalary.getId());
		tmpManagePositionSalary.setPosition(managePositionSalary.getPosition());
		tmpManagePositionSalary.setLevel(managePositionSalary.getLevel());
		tmpManagePositionSalary.setSalaryStandard(managePositionSalary.getSalaryStandard());
		tmpManagePositionSalary.setStartPayLevel(managePositionSalary.getStartPayLevel());
		System.out.println(tmpManagePositionSalary.getStartPayLevel());
		manageSalaryManage.modifyManPosSal(tmpManagePositionSalary);
		return "success";
	}
	
	public String modifyLevSalaryStandard()
	{
		System.out.println("-------salaryStandardAction.modifyLevSalaryStandard--------");
		ManagePaylevelSalary tmpManagePaylevelSalary = new ManagePaylevelSalary();
		tmpManagePaylevelSalary.setId(managePaylevelSalary.getId());
		tmpManagePaylevelSalary.setPayLevel(managePaylevelSalary.getPayLevel());
		tmpManagePaylevelSalary.setSalaryStandard(managePaylevelSalary.getSalaryStandard());
		manageSalaryManage.modifyManPaySal(tmpManagePaylevelSalary);
		return "success";
	}
}
