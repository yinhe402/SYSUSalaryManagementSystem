package com.sms.service;

import java.util.List;

import com.sms.entity.SpecialSalaryChange;

public interface ISpecialSalaryChangeManage {
	public void addSpecialSalaryChange(SpecialSalaryChange specialSalaryChange);
	public void deleteSpecialSalaryChange(SpecialSalaryChange specialSalaryChange);
	public void modifySpecialSalaryChange(SpecialSalaryChange specialSalaryChange);
	public List<SpecialSalaryChange>  findSpecialSalaryChangeByEId(Integer eId);
	public List<SpecialSalaryChange> findAllSpecialSalaryChange();
}
