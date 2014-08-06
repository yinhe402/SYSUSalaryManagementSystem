package com.sms.action;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.sms.entity.Employee;
import com.sms.entity.Salary;
import com.sms.entity.SpecialSalaryChange;
import com.sms.entity.SpecialSalaryRecovery;
import com.sms.exception.ExcelException;
import com.sms.other.SpecialChangeExport;
import com.sms.other.SpecialRecoveryExport;
import com.sms.service.IEmployeeManage;
import com.sms.service.ISalaryManage;
import com.sms.service.ISpecialSalaryChangeManage;
import com.sms.service.ISpecialSalaryRecoveryManage;
import com.sms.util.ExcelUtil;

public class SpecialSalaryAction {
	private SpecialSalaryChange specialSalaryChange;
	private SpecialSalaryRecovery specialSalaryRecovery;
	private List<SpecialChangeExport> infoChange = new ArrayList<SpecialChangeExport>();
	private List<SpecialRecoveryExport> infoRecovery = new ArrayList<SpecialRecoveryExport>();
	//private boolean flagChange=true;
	//private boolean flagRecovery=true;
	
	@Resource
	private ISpecialSalaryChangeManage iSpecialSalaryChangeManage;
	
	@Resource
	private ISpecialSalaryRecoveryManage iSpecialSalaryRecoveryManage;
	
	@Resource
	private IEmployeeManage iEmployeeManage;
	
	@Resource
	private ISalaryManage iSalaryManage;
	
	public void initChange(){
		List<SpecialSalaryChange> changeList = iSpecialSalaryChangeManage.findAllSpecialSalaryChange();
		for(int i=0;i<changeList.size();i++){		
			Employee employee = iEmployeeManage.findEmployeeById(changeList.get(i).getEId());
			SpecialChangeExport sce = new SpecialChangeExport(employee.getId(),employee.getName(),employee.getDepartment(),changeList.get(i).getAmount(),
					changeList.get(i).getReason(),changeList.get(i).getChangeDate()); 
			infoChange.add(sce);
		}
	}
	
	public void initRecovery(){	
		List<SpecialSalaryRecovery> recoveryList = iSpecialSalaryRecoveryManage.findAllSpecialSalaryRecovery();
		for(int i=0;i<recoveryList.size();i++){		
			Employee employee = iEmployeeManage.findEmployeeById(recoveryList.get(i).getEId());
			SpecialRecoveryExport sre = new SpecialRecoveryExport(employee.getId(),employee.getName(),employee.getDepartment(),
					recoveryList.get(i).getRecoveryReason(),recoveryList.get(i).getRecoveryDate()); 
			infoRecovery.add(sre);
		}
	}
	
	public String specialSalaryChange(){
		//System.out.println(specialSalaryChange.getEId());
		initChange();
		
		iSpecialSalaryChangeManage.addSpecialSalaryChange(specialSalaryChange);
		Salary salary = iSalaryManage.findLastSalaryByEId(specialSalaryChange.getEId());
		//System.out.println(salary.getTotleSalary());
		//System.out.println(specialSalaryChange.getAmount());

		if(salary==null){
			return "fail";
		}
		Employee employee = iEmployeeManage.findEmployeeById(specialSalaryChange.getEId());
		if(employee==null){
			return "fail";
		}
		salary.setTotleSalary(salary.getTotleSalary()+specialSalaryChange.getAmount());
		iSalaryManage.modifySalary(salary);
		SpecialChangeExport sce = new SpecialChangeExport(employee.getId(),employee.getName(),employee.getDepartment(),specialSalaryChange.getAmount(),
				specialSalaryChange.getReason(),specialSalaryChange.getChangeDate()); 
		infoChange.add(sce);	
		
		ActionContext.getContext().getSession().put("infoChange", infoChange);
		
		return Action.SUCCESS;
	}
	
	public String specialSalaryRecovery(){	
		initRecovery();

		//System.out.println(specialSalaryRecovery.getEId());
		iSpecialSalaryRecoveryManage.addSpecialSalaryRecovery(specialSalaryRecovery);


		Salary salary = iSalaryManage.findLastSalaryByEId(specialSalaryRecovery.getEId());

		if(salary==null){
			return "fail";
		}
		Employee employee = iEmployeeManage.findEmployeeById(specialSalaryRecovery.getEId());
		if(employee==null){
			return "fail";
		}
		salary.setTotleSalary();
		iSalaryManage.modifySalary(salary);
		SpecialRecoveryExport sre = new SpecialRecoveryExport(employee.getId(),employee.getName(),employee.getDepartment(),
				specialSalaryRecovery.getRecoveryReason(),specialSalaryRecovery.getRecoveryDate()); 
		infoRecovery.add(sre);
		ActionContext.getContext().getSession().put("infoRecovery", infoRecovery);
		
		return Action.SUCCESS;
	}

	public SpecialSalaryChange getSpecialSalaryChange() {
		return specialSalaryChange;
	}

	public void setSpecialSalaryChange(SpecialSalaryChange specialSalaryChange) {
		this.specialSalaryChange = specialSalaryChange;
	}

	public SpecialSalaryRecovery getSpecialSalaryRecovery() {
		return specialSalaryRecovery;
	}

	public void setSpecialSalaryRecovery(SpecialSalaryRecovery specialSalaryRecovery) {
		this.specialSalaryRecovery = specialSalaryRecovery;
	}

	public ISpecialSalaryChangeManage getiSpecialSalaryChangeManage() {
		return iSpecialSalaryChangeManage;
	}

	public void setiSpecialSalaryChangeManage(
			ISpecialSalaryChangeManage iSpecialSalaryChangeManage) {
		this.iSpecialSalaryChangeManage = iSpecialSalaryChangeManage;
	}

	public ISpecialSalaryRecoveryManage getiSpecialSalaryRecoveryManage() {
		return iSpecialSalaryRecoveryManage;
	}

	public void setiSpecialSalaryRecoveryManage(
			ISpecialSalaryRecoveryManage iSpecialSalaryRecoveryManage) {
		this.iSpecialSalaryRecoveryManage = iSpecialSalaryRecoveryManage;
	}

	public ISalaryManage getiSalaryManage() {
		return iSalaryManage;
	}

	public void setiSalaryManage(ISalaryManage iSalaryManage) {
		this.iSalaryManage = iSalaryManage;
	}
	
	public String exportChange() throws IOException, ExcelException {
		//System.out.println("satrt export");
		LinkedHashMap fieldMap = new LinkedHashMap<String, String>();
		fieldMap.put("eid", "职工号");
		fieldMap.put("name", "姓名");
		fieldMap.put("department", "单位");
		fieldMap.put("amount", "变动金额");
		fieldMap.put("reason", "变动原因");
		fieldMap.put("date", "变动日期");
		 
		String sheetName="Sheet1";
		HttpServletResponse response = ServletActionContext.getResponse();
		//System.out.println(infoChange.size());
		//System.out.println(flagChange);
		initChange();
		ExcelUtil.listToExcel(infoChange, fieldMap, sheetName, response);
		
		return "ok";
	}
	
	public String exportRecovery() throws IOException, ExcelException {
		//System.out.println("satrt export");
		LinkedHashMap fieldMap = new LinkedHashMap<String, String>();
		fieldMap.put("eid", "职工号");
		fieldMap.put("name", "姓名");
		fieldMap.put("department", "单位");
		fieldMap.put("reason", "恢复原因");
		fieldMap.put("date", "恢复日期");
		String sheetName="Sheet2";
		HttpServletResponse response = ServletActionContext.getResponse();
		initRecovery();
		ExcelUtil.listToExcel(infoRecovery, fieldMap, sheetName, response);
		
		return "ok";
	}
	
}
