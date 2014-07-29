package com.sms.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.sms.entity.Employee;
import com.sms.entity.Salary;
import com.sms.entity.SpecialSalaryChange;
import com.sms.entity.SpecialSalaryRecovery;
import com.sms.service.IEmployeeManage;
import com.sms.service.ISalaryManage;
import com.sms.service.ISpecialSalaryChangeManage;
import com.sms.service.ISpecialSalaryRecoveryManage;

public class SpecialSalaryAction {
	private SpecialSalaryChange specialSalaryChange;
	private SpecialSalaryRecovery specialSalaryRecovery;
	private List<String[]> infoChange = new ArrayList<String[]>();
	private List<String[]> infoRecovery = new ArrayList<String[]>();
	private boolean flagChange=true;
	private boolean flagRecovery=true;
	
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
			String[] strings = {employee.getId().toString(),employee.getName(),employee.getDepartment(),changeList.get(i).getAmount().toString(),
					changeList.get(i).getReason(),changeList.get(i).getChangeDate().toString()}; 
			System.out.println(strings);
			infoChange.add(strings);
		}
		
	}
	
	public void initRecovery(){	
		List<SpecialSalaryRecovery> recoveryList = iSpecialSalaryRecoveryManage.findAllSpecialSalaryRecovery();
		for(int i=0;i<recoveryList.size();i++){		
			Employee employee = iEmployeeManage.findEmployeeById(recoveryList.get(i).getEId());
			String[] strings = {employee.getId().toString(),employee.getName(),employee.getDepartment(),
					recoveryList.get(i).getRecoveryReason(),recoveryList.get(i).getRecoveryDate().toString()}; 
			System.out.println(strings);
			infoRecovery.add(strings);
		}
	}
	
	public String specialSalaryChange(){
		System.out.println(specialSalaryChange.getEId());
		if(flagChange){
			initChange();
			flagChange=false;
		}
		
		iSpecialSalaryChangeManage.addSpecialSalaryChange(specialSalaryChange);
		Salary salary = iSalaryManage.findLastSalaryByEId(specialSalaryChange.getEId());
		//System.out.println(salary.getTotleSalary());
		//System.out.println(specialSalaryChange.getAmount());

		Employee employee = iEmployeeManage.findEmployeeById(specialSalaryChange.getEId());

		salary.setTotleSalary(salary.getTotleSalary()+specialSalaryChange.getAmount());
		iSalaryManage.modifySalary(salary);
		String[] strings = {employee.getId().toString(),employee.getName(),employee.getDepartment(),specialSalaryChange.getAmount().toString(),
				specialSalaryChange.getReason(),specialSalaryChange.getChangeDate().toString()}; 
		System.out.println(strings);
		infoChange.add(strings);	
		
		ActionContext.getContext().getSession().put("infoChange", infoChange);
		
		return Action.SUCCESS;
	}
	
	public String specialSalaryRecovery(){	
		if(flagRecovery){
			initRecovery();
			flagRecovery=false;
		}
		//System.out.println(specialSalaryRecovery.getEId());
		iSpecialSalaryRecoveryManage.addSpecialSalaryRecovery(specialSalaryRecovery);
//<<<<<<< HEAD
//
//		Salary salary = iSalaryManage.findLastSalaryByEId(specialSalaryRecovery.getEId());
//		Employee employee = iEmployeeManage.findEmployeeById(specialSalaryChange.getEId());
//=======
		Salary salary = iSalaryManage.findSalaryByEId(specialSalaryRecovery.getEId()).get(0);
		Employee employee = iEmployeeManage.findEmployeeById(specialSalaryRecovery.getEId());

		salary.setTotleSalary();
		iSalaryManage.modifySalary(salary);
		String[] strings = {employee.getId().toString(),employee.getName(),employee.getDepartment(),specialSalaryRecovery.getRecoveryReason().toString(),specialSalaryRecovery.getRecoveryDate().toString()}; 
		infoRecovery.add(strings);
		System.out.println(strings);
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
}
