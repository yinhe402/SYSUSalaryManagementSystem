package com.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.sms.dao.ISpecialSalaryRecoveryDao;
import com.sms.entity.SpecialSalaryRecovery;
import com.sms.service.ISpecialSalaryRecoveryManage;

public class SpecialSalaryRecoveryManageImp implements ISpecialSalaryRecoveryManage{
	@Resource
	private ISpecialSalaryRecoveryDao iSpecialSalaryRecoveryDao;

	@Override
	public void addSpecialSalaryRecovery(SpecialSalaryRecovery SpecialSalaryRecovery) {
		// TODO Auto-generated method stub
		iSpecialSalaryRecoveryDao.addSpecialSalaryRecovery(SpecialSalaryRecovery);
	}

	@Override
	public void deleteSpecialSalaryRecovery(SpecialSalaryRecovery SpecialSalaryRecovery) {
		// TODO Auto-generated method stub
		iSpecialSalaryRecoveryDao.deleteSpecialSalaryRecovery(SpecialSalaryRecovery);
	}

	@Override
	public void modifySpecialSalaryRecovery(SpecialSalaryRecovery SpecialSalaryRecovery) {
		// TODO Auto-generated method stub
		iSpecialSalaryRecoveryDao.modifySpecialSalaryRecovery(SpecialSalaryRecovery);
	}

	@Override
	public List<SpecialSalaryRecovery>  findSpecialSalaryRecoveryByEId(Integer eId) {
		// TODO Auto-generated method stub
		return iSpecialSalaryRecoveryDao.findSpecialSalaryRecoveryByEId(eId);
	}

	@Override
	public List<SpecialSalaryRecovery> findAllSpecialSalaryRecovery() {
		// TODO Auto-generated method stub
		return iSpecialSalaryRecoveryDao.findAllSpecialSalaryRecovery();
	}

}
