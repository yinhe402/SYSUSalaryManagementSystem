package com.sms.action;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.sms.entity.Employee;
import com.sms.entity.Salary;
import com.sms.entity.StartSalaryInfo;
import com.sms.exception.ExcelException;
import com.sms.other.ComputeSalarySingleton;
import com.sms.other.SalaryExport;
import com.sms.service.IEmployeeManage;
import com.sms.service.ISalaryManage;
import com.sms.service.IStartSalaryInfoManage;
import com.sms.util.ExcelUtil;

//工资自动生成
public class AutoSalary {
	private List<SalaryExport> newSalaryList; 
	private ComputeSalarySingleton computeSalarySingleton=ComputeSalarySingleton.getInstance();
	
	@Resource
	private ISalaryManage iSalaryManage;
	
	@Resource
	private IEmployeeManage iEmployeeManage;
	
	@Resource
	private IStartSalaryInfoManage iStartSalaryInfoManage;
	
	public String computeSalary(){
		newSalaryList=new ArrayList<SalaryExport>();
		//System.out.println("heh");
		List<StartSalaryInfo> list = iStartSalaryInfoManage.getAllStartSalaryInfo();
		
		for(int i=0;i<list.size();i++){
			StartSalaryInfo startSalaryInfo=list.get(i);
			//System.out.println(startSalaryInfo.getPositionLevel());
			//System.out.println(startSalaryInfo.getLevelSalary());
			Salary salary =new Salary(startSalaryInfo.getEid(),startSalaryInfo.getPositionSalary(),startSalaryInfo.getLevelSalary());
			computeSalarySingleton.setSalary(salary);
			iSalaryManage.addSalary(salary);
			
			Employee employee=iEmployeeManage.findEmployeeById(startSalaryInfo.getEid());
			SalaryExport salaryExport=new SalaryExport(startSalaryInfo.getEid(), employee.getName(), employee.getDepartment(), salary.getPositionSalary(), salary.getLevelSalary(), salary.getTotleSalary(), salary.getTime());
			newSalaryList.add(salaryExport);
		}
		
		ActionContext.getContext().getSession().put("newSalaryList", newSalaryList);
		return Action.SUCCESS;
	}
	
	public String exportSalary() throws ExcelException{
		LinkedHashMap fieldMap = new LinkedHashMap<String, String>();
		
		fieldMap.put("eid", "职工号");
		fieldMap.put("name", "姓名");
		fieldMap.put("department", "单位");
		fieldMap.put("positionSalary", "岗位工资");
		fieldMap.put("levleSalary", "级别工资");
		fieldMap.put("salary", "月薪");
		fieldMap.put("date", "发放日期");
		 
		String sheetName="Sheet1";
		HttpServletResponse response = ServletActionContext.getResponse();

		ExcelUtil.listToExcel(newSalaryList, fieldMap, sheetName, response);
		
		return Action.SUCCESS;
	}

	public List<SalaryExport> getNewSalaryList() {
		return newSalaryList;
	}

	public void setNewSalaryList(List<SalaryExport> newSalaryList) {
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
