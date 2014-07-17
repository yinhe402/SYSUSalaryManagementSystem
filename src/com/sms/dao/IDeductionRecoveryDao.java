package com.sms.dao;

import java.util.List;

import com.sms.entity.DeductionRecovery;

public interface IDeductionRecoveryDao {
	public void addDeductionRecovery(DeductionRecovery deductionRecovery);
	public void deleteDeductionRecovery(DeductionRecovery deductionRecovery);
	public void modifyDeductionRecovery(DeductionRecovery deductionRecovery);
	public List<DeductionRecovery> findDeductionRecoveryByEId(Integer eId);
}
