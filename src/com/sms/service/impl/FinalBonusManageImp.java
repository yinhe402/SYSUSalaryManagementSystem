package com.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.sms.dao.IFinalBonusDao;
import com.sms.entity.FinalBonus;
import com.sms.service.IFinalBonusManage;

public class FinalBonusManageImp implements IFinalBonusManage{
	@Resource
	private IFinalBonusDao iFinalBonusDao;

	@Override
	public void addFinalBonus(FinalBonus finalBonus) {
		
		iFinalBonusDao.addFinalBonus(finalBonus);
	}

	@Override
	public void deleteFinalBonus(FinalBonus finalBonus) {
		
		iFinalBonusDao.deleteFinalBonus(finalBonus);
	}

	@Override
	public void modifyFinalBonus(FinalBonus finalBonus) {
		
		iFinalBonusDao.modifyFinalBonus(finalBonus);
	}

	@Override
	public List<FinalBonus> findFinalBonusByEId(Integer eId) {
		
		return iFinalBonusDao.findFinalBonusByEId(eId);
	}

	@Override
	public List<FinalBonus> findFinalBonusByDoubleBonusType(
			String doubleBonusType) {
		
		return iFinalBonusDao.findFinalBonusByDoubleBonusType(doubleBonusType);
	}

}
