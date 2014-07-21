package com.sms.service;

import java.util.List;

import com.sms.entity.Deduction;

public interface IDeductionManage {
	public void addDeduction(Deduction deduction);
	public void deleteDeduction(Deduction deduction);
	public void modifyDeduction(Deduction deduction);
	public List<Deduction>  findDeductionByEId(Integer eId);
}
