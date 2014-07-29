package com.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.sms.dao.ISpecialSalaryChangeDao;
import com.sms.entity.SpecialSalaryChange;
import com.sms.service.ISpecialSalaryChangeManage;

public class SpecialSalaryChangeManageImp implements ISpecialSalaryChangeManage{
	@Resource
	private ISpecialSalaryChangeDao iSpecialSalaryChangeDao;

	@Override
	public void addSpecialSalaryChange(SpecialSalaryChange SpecialSalaryChange) {
		// TODO Auto-generated method stub
		iSpecialSalaryChangeDao.addSpecialSalaryChange(SpecialSalaryChange);
	}

	@Override
	public void deleteSpecialSalaryChange(SpecialSalaryChange SpecialSalaryChange) {
		// TODO Auto-generated method stub
		iSpecialSalaryChangeDao.deleteSpecialSalaryChange(SpecialSalaryChange);
	}

	@Override
	public void modifySpecialSalaryChange(SpecialSalaryChange SpecialSalaryChange) {
		// TODO Auto-generated method stub
		iSpecialSalaryChangeDao.modifySpecialSalaryChange(SpecialSalaryChange);
	}

	@Override
	public List<SpecialSalaryChange>  findSpecialSalaryChangeByEId(Integer eId) {
		// TODO Auto-generated method stub
		return iSpecialSalaryChangeDao.findSpecialSalaryChangeByEId(eId);
	}

	@Override
	public List<SpecialSalaryChange> findAllSpecialSalaryChange() {
		// TODO Auto-generated method stub
		return iSpecialSalaryChangeDao.findAllSpecialSalaryChange();
	}

}
