package com.sms.service;

import java.util.List;

import com.sms.entity.FinalCheck;

public interface IFinalCheckManage {
	public void addFinalCheck(FinalCheck finalCheck);
	public void deleteFinalCheck(FinalCheck finalCheck);
	public void modifyFinalCheck(FinalCheck finalCheck);
	public List<FinalCheck> findFinalCheckByEId(Integer eId);
	public List<FinalCheck> findFinalChecksByResult(String result);
}
