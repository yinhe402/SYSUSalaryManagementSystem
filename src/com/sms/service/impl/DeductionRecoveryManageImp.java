package com.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.sms.dao.IDeductionRecoveryDao;
import com.sms.entity.DeductionRecovery;
import com.sms.service.IDeductionRecoveryManage;

public class DeductionRecoveryManageImp implements IDeductionRecoveryManage{
	@Resource
	private IDeductionRecoveryDao iDeductionRecoveryDao;

	@Override
	public void addDeductionRecovery(DeductionRecovery deductionRecovery) {
		// TODO Auto-generated method stub
		iDeductionRecoveryDao.addDeductionRecovery(deductionRecovery);
	}

	@Override
	public void deleteDeductionRecovery(DeductionRecovery deductionRecovery) {
		// TODO Auto-generated method stub
		iDeductionRecoveryDao.deleteDeductionRecovery(deductionRecovery);
	}

	@Override
	public void modifyDeductionRecovery(DeductionRecovery deductionRecovery) {
		// TODO Auto-generated method stub
		iDeductionRecoveryDao.modifyDeductionRecovery(deductionRecovery);
	}

	@Override
	public List<DeductionRecovery> findDeductionRecoveryByEId(Integer eId) {
		// TODO Auto-generated method stub
		return iDeductionRecoveryDao.findDeductionRecoveryByEId(eId);
	}

}
