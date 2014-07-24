package com.sms.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.sms.entity.Salary;
import com.sms.entity.StartSalaryInfo;
import com.sms.other.ComputeSalarySingleton;
import com.sms.service.ISalaryManage;
import com.sms.service.IStartSalaryInfoManage;

//工资自动生成
public class AutoSalary {
	private List<Salary> newSalaryList; 
	private ComputeSalarySingleton computeSalarySingleton=ComputeSalarySingleton.getInstance();
	
	@Resource
	private ISalaryManage iSalaryManage;
	
	@Resource
	private IStartSalaryInfoManage iStartSalaryInfoManage;
	
	public String computeSalary(){
		newSalaryList=new ArrayList<Salary>();
		//System.out.println("heh");
		List<StartSalaryInfo> list = iStartSalaryInfoManage.getAllStartSalaryInfo();
		
		for(int i=0;i<list.size();i++){
			StartSalaryInfo startSalaryInfo=list.get(i);
			//System.out.println(startSalaryInfo.getPositionLevel());
			//System.out.println(startSalaryInfo.getLevelSalary());
			Salary salary =new Salary(startSalaryInfo.getEid(),startSalaryInfo.getPositionSalary(),startSalaryInfo.getLevelSalary());
			computeSalarySingleton.setSalary(salary);
			iSalaryManage.addSalary(salary);
			newSalaryList.add(salary);
		}
		
		ActionContext.getContext().getSession().put("newSalaryList", newSalaryList);
		return Action.SUCCESS;
	}

	public List<Salary> getNewSalaryList() {
		return newSalaryList;
	}

	public void setNewSalaryList(List<Salary> newSalaryList) {
		this.newSalaryList = newSalaryList;
	}

	public ISalaryManage getISalaryManage() {
		return iSalaryManage;
	}

	public void setISalaryManage(ISalaryManage iSalaryManage) {
		this.iSalaryManage = iSalaryManage;
	}

	public IStartSalaryInfoManage getIStartSalaryInfoManage() {
		return iStartSalaryInfoManage;
	}

	public void setIStartSalaryInfoManage(
			IStartSalaryInfoManage iStartSalaryInfoManage) {
		this.iStartSalaryInfoManage = iStartSalaryInfoManage;
	}
	
	
}
