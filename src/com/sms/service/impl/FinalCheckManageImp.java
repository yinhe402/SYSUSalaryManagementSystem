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
		List<FinalCheck> checks = iFinalCheckDao.findFinalCheckByEId(finalCheck.getEId());
		for (FinalCheck f:checks) {
			if(f.getYear() == finalCheck.getYear()) {
				f.setCheckResult(finalCheck.getCheckResult());
				iFinalCheckDao.modifyFinalCheck(f);
				return;
			}
		}
			
		iFinalCheckDao.addFinalCheck(finalCheck);
	}

	@Override
	public void deleteFinalCheck(FinalCheck finalCheck) {
		iFinalCheckDao.deleteFinalCheck(finalCheck);
	}

	@Override
	public void modifyFinalCheck(FinalCheck finalCheck) {
		iFinalCheckDao.modifyFinalCheck(finalCheck);
	}

	@Override
	public List<FinalCheck> findFinalCheckByEId(Integer eId) {
		return iFinalCheckDao.findFinalCheckByEId(eId);
	}

	@Override
	public List<FinalCheck> findFinalChecksByResult(String result) {
		return iFinalCheckDao.findFinalChecksByResult(result);
	}

}
