package com.sms.service;

import java.util.List;

import com.sms.entity.SpecialSalaryRecovery;

public interface ISpecialSalaryRecoveryManage {
	public void addSpecialSalaryRecovery(SpecialSalaryRecovery specialSalaryRecovery);
	public void deleteSpecialSalaryRecovery(SpecialSalaryRecovery specialSalaryRecovery);
	public void modifySpecialSalaryRecovery(SpecialSalaryRecovery specialSalaryRecovery);
	public List<SpecialSalaryRecovery> findSpecialSalaryRecoveryByEId(Integer eId);
	public List<SpecialSalaryRecovery> findAllSpecialSalaryRecovery();
}
