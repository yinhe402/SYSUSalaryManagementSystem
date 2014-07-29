package com.sms.service;

import java.util.List;

import com.sms.entity.OffInfo;

public interface IOffInfoManage {
	public void addOffInfo(OffInfo offInfo);
	public void deleteOffInfo(OffInfo offInfo);
	public void modifyOffInfo(OffInfo offInfo);
	public List<OffInfo> findOffInfoByEId(Integer eId);
	public List<OffInfo> findOffInfoThisYear();
	public List<OffInfo> findOffInfoThisYearByEId(Integer eId);
}
