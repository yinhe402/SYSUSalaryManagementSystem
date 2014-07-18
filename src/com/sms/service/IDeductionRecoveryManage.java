package com.sms.service;

import java.util.List;

import com.sms.entity.DeductionRecovery;

public interface IDeductionRecoveryManage {
	public void addDeductionRecovery(DeductionRecovery deductionRecovery);
	public void deleteDeductionRecovery(DeductionRecovery deductionRecovery);
	public void modifyDeductionRecovery(DeductionRecovery deductionRecovery);
	public List<DeductionRecovery> findDeductionRecoveryByEId(Integer eId);
}
