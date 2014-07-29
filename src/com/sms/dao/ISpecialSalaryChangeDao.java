package com.sms.dao;

import java.util.List;

import com.sms.entity.SpecialSalaryChange;

public interface ISpecialSalaryChangeDao {
	public void addSpecialSalaryChange(SpecialSalaryChange specialSalaryChange);
	public void deleteSpecialSalaryChange(SpecialSalaryChange specialSalaryChange);
	public void modifySpecialSalaryChange(SpecialSalaryChange specialSalaryChange);
	public List<SpecialSalaryChange> findSpecialSalaryChangeByEId(Integer eId);
	public List<SpecialSalaryChange> findAllSpecialSalaryChange();
}
