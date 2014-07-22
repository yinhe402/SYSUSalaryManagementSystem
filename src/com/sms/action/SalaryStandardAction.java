package com.sms.action;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.RequestContext;
import org.apache.struts2.ServletActionContext;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sms.entity.ManagePaylevelSalary;
import com.sms.entity.ManagePositionSalary;
import com.sms.entity.ProfessionalPositionSalary;
import com.sms.service.IManageSalaryManage;
import com.sms.service.IProfSalaryManage;
import com.sms.service.IWorkerSalaryManage;

public class SalaryStandardAction extends ActionSupport {
	
	private ManagePositionSalary managePositionSalary;

	public ManagePositionSalary getManagePositionSalary() {
		return managePositionSalary;
	}

	public void setManagePositionSalary(ManagePositionSalary managePositionSalary) {
		this.managePositionSalary = managePositionSalary;
	}
	
	private ProfessionalPositionSalary professionalPositionSalary;
	private ManagePaylevelSalary managePaylevelSalary;

	public ManagePaylevelSalary getManagePaylevelSalary() {
		return managePaylevelSalary;
	}

	public void setManagePaylevelSalary(ManagePaylevelSalary managePaylevelSalary) {
		this.managePaylevelSalary = managePaylevelSalary;
	}
	
	public IWorkerSalaryManage getWorkerSalaryManage() {
		return workerSalaryManage;
	}

	public void setWorkerSalaryManage(IWorkerSalaryManage workerSalaryManage) {
		this.workerSalaryManage = workerSalaryManage;
	}

	public IProfSalaryManage getProfSalaryManage() {
		return profSalaryManage;
	}

	public void setProfSalaryManage(IProfSalaryManage profSalaryManage) {
		this.profSalaryManage = profSalaryManage;
	}

	@Resource
	private IManageSalaryManage manageSalaryManage;

	@Resource
	private IWorkerSalaryManage workerSalaryManage;
	
	@Resource 
	private IProfSalaryManage profSalaryManage;

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
		Map session = ActionContext.getContext().getSession();
		session.put("managepositionsalary", lst1);
		session.put("managepaylevelsalary", lst2);
		return "success";
	}
	
	public String modifyPosSalaryStandard()
	{
		System.out.println("-------salaryStandardAction.modifyPosSalaryStandard--------");
		ManagePositionSalary tmpManagePositionSalary = new ManagePositionSalary();
		tmpManagePositionSalary = manageSalaryManage.findManPosSalByLevel(managePositionSalary.getLevel());
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
		tmpManagePaylevelSalary = manageSalaryManage.findManPaySalByPayLevel(managePaylevelSalary.getPayLevel());
		tmpManagePaylevelSalary.setPayLevel(managePaylevelSalary.getPayLevel());
		tmpManagePaylevelSalary.setSalaryStandard(managePaylevelSalary.getSalaryStandard());
		manageSalaryManage.modifyManPaySal(tmpManagePaylevelSalary);
		return "success";
	}
	
	public String getAllManagePositionSalary()  {
		System.out.println("GetAllSalary");
		ActionContext.getContext().getSession().put("manList",manageSalaryManage.findAllPositionSalary());
		ActionContext.getContext().getSession().put("proList",profSalaryManage.findAllPositionSalary());
		ActionContext.getContext().getSession().put("workerList", workerSalaryManage.findAllPositionSalary());
		ActionContext.getContext().getSession().put("manPayLevelList",manageSalaryManage.findAllPayLevelSalary());
		ActionContext.getContext().getSession().put("proPayLevelList",profSalaryManage.findAllPayLevelSalary());
		ActionContext.getContext().getSession().put("workerPayLevelList", workerSalaryManage.findAllPayLevelSalary());
		System.out.println("Add All");
		return "success";
	}
	
	public String getChangeInfo() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String position = request.getParameter("position");
		System.out.print(position);
		String level = request.getParameter("level");
		System.out.print(level);
		String salaryStandard = request.getParameter("salaryStandard");
		System.out.print(salaryStandard);
		String startPayLevel = request.getParameter("startPayLevel");
		System.out.print(startPayLevel);
		return "success";
		
	}
}
