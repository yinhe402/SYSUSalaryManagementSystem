package com.sms.dao;

import java.util.List;

import com.sms.entity.Deduction;

public interface IDeductionDao {
	public void addDeduction(Deduction deduction);
	public void deleteDeduction(Deduction deduction);
	public void modifyDeduction(Deduction deduction);
	public List<Deduction> findDeductionByEId(Integer eId);
}
