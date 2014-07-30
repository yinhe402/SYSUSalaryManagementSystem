package com.sms.service;

import java.util.List;

import com.sms.entity.FinalBonus;

public interface IFinalBonusManage {
	public void addFinalBonus(FinalBonus finalBonus);
	public void deleteFinalBonus(FinalBonus finalBonus);
	public void modifyFinalBonus(FinalBonus finalBonus);
	public List<FinalBonus> findFinalBonusByEId(Integer eId);
	public List<FinalBonus> findFinalBonusByDoubleBonusType(String doubleBonusType);
}
