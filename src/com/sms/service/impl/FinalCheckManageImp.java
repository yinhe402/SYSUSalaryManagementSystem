package com.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.sms.dao.IFinalCheckDao;
import com.sms.entity.FinalCheck;
import com.sms.service.IFinalCheckManage;

public class FinalCheckManageImp implements IFinalCheckManage{
	@Resource
	private IFinalCheckDao iFinalCheckDao;

	@Override
	public void addFinalCheck(FinalCheck finalCheck) {
		// TODO Auto-generated method stub
		iFinalCheckDao.addFinalCheck(finalCheck);
	}

	@Override
	public void deleteFinalCheck(FinalCheck finalCheck) {
		// TODO Auto-generated method stub
		iFinalCheckDao.deleteFinalCheck(finalCheck);
	}

	@Override
	public void modifyFinalCheck(FinalCheck finalCheck) {
		// TODO Auto-generated method stub
		iFinalCheckDao.modifyFinalCheck(finalCheck);
	}

	@Override
	public List<FinalCheck> findFinalCheckByEId(Integer eId) {
		// TODO Auto-generated method stub
		return iFinalCheckDao.findFinalCheckByEId(eId);
	}

}
