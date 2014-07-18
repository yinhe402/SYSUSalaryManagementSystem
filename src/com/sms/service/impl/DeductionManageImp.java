package com.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.sms.dao.IDeductionDao;
import com.sms.entity.Deduction;
import com.sms.service.IDeductionManage;

public class DeductionManageImp implements IDeductionManage{
	@Resource
	private IDeductionDao iDeductionDao;

	@Override
	public void addDeduction(Deduction deduction) {
		// TODO Auto-generated method stub
		iDeductionDao.addDeduction(deduction);
	}

	@Override
	public void deleteDeduction(Deduction deduction) {
		// TODO Auto-generated method stub
		iDeductionDao.deleteDeduction(deduction);
	}

	@Override
	public void modifyDeduction(Deduction deduction) {
		// TODO Auto-generated method stub
		iDeductionDao.modifyDeduction(deduction);
	}

	@Override
	public List<Deduction>  findDeductionByEId(Integer eId) {
		// TODO Auto-generated method stub
		return iDeductionDao.findDeductionByEId(eId);
	}

}
