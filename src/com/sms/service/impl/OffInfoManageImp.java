package com.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Primary;

import com.sms.dao.IOffInfoDao;
import com.sms.entity.AddOrCut;
import com.sms.entity.OffInfo;
import com.sms.service.IOffInfoManage;

public class OffInfoManageImp implements IOffInfoManage {

	@Resource
	private IOffInfoDao offInfoDao;

	@Override
	public void addOffInfo(OffInfo offInfo) {
		offInfoDao.addOffInfo(offInfo);
		
	}

	@Override
	public void deleteOffInfo(OffInfo offInfo) {
		offInfoDao.deleteOffInfo(offInfo);
		
	}

	@Override
	public void modifyOffInfo(OffInfo offInfo) {
		offInfoDao.modifyOffInfo(offInfo);
		
	}

	@Override
	public List<OffInfo> findOffInfoByEId(Integer eId) {
		return offInfoDao.findOffInfoByEId(eId);
	}

	@Override
	public List<OffInfo> findOffInfoThisYear() {
		
		return offInfoDao.findOffInfoThisYear();
	}

	@Override
	public List<OffInfo> findOffInfoThisYearByEId(Integer eId) {
		return offInfoDao.findOffInfoThisYearByEId(eId);
	}

}
