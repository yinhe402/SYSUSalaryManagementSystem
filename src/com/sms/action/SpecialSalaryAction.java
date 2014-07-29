package com.sms.action;

import javax.annotation.Resource;

import com.opensymphony.xwork2.Action;
import com.sms.entity.Salary;
import com.sms.entity.SpecialSalaryChange;
import com.sms.entity.SpecialSalaryRecovery;
import com.sms.service.ISalaryManage;
import com.sms.service.ISpecialSalaryChangeManage;
import com.sms.service.ISpecialSalaryRecoveryManage;

public class SpecialSalaryAction {
	private SpecialSalaryChange specialSalaryChange;
	private SpecialSalaryRecovery specialSalaryRecovery;
	
	@Resource
	private ISpecialSalaryChangeManage iSpecialSalaryChangeManage;
	
	@Resource
	private ISpecialSalaryRecoveryManage iSpecialSalaryRecoveryManage;
	
	@Resource
	private ISalaryManage iSalaryManage;
	
	public String specialSalaryChange(){
		//System.out.println(specialSalaryChange.getEId());
		iSpecialSalaryChangeManage.addSpecialSalaryChange(specialSalaryChange);
		Salary salary = iSalaryManage.findLastSalaryByEId(specialSalaryChange.getEId());
		//System.out.println(salary.getTotleSalary());
		//System.out.println(specialSalaryChange.getAmount());
		salary.setTotleSalary(salary.getTotleSalary()+specialSalaryChange.getAmount());
		iSalaryManage.modifySalary(salary);
		
		return Action.SUCCESS;
	}
	
	public String specialSalaryRecovery(){
		//System.out.println(specialSalaryRecovery.getEId());
		iSpecialSalaryRecoveryManage.addSpecialSalaryRecovery(specialSalaryRecovery);
		Salary salary = iSalaryManage.findLastSalaryByEId(specialSalaryRecovery.getEId());
		salary.setTotleSalary();
		iSalaryManage.modifySalary(salary);
		
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
