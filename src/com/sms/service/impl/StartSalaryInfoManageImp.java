package com.sms.service.impl;

import javax.annotation.Resource;

import com.sms.dao.IStartSalaryInfoDao;
import com.sms.entity.StartSalaryInfo;
import com.sms.service.IStartSalaryInfoManage;

public class StartSalaryInfoManageImp implements IStartSalaryInfoManage {
	
	@Resource
	private IStartSalaryInfoDao startSalaryInfoDao;

	public IStartSalaryInfoDao getStartSalaryInfoDao() {
		return startSalaryInfoDao;
	}

	public void setStartSalaryInfoDao(IStartSalaryInfoDao startSalaryInfoDao) {
		this.startSalaryInfoDao = startSalaryInfoDao;
	}
	
	@Override
	public void addStartSalaryInfo(StartSalaryInfo startSalaryInfo)
	{
		startSalaryInfoDao.addStartSalaryInfo(startSalaryInfo);
	}
	
	@Override
	public void modifyStartSalaryInfo(StartSalaryInfo startSalaryInfo)
	{
		startSalaryInfoDao.modifyStartSalaryInfo(startSalaryInfo);
	}
	
	@Override
	public void deleteStartSalaryInfo(StartSalaryInfo startSalaryInfo)
	{
		startSalaryInfoDao.deleteStartSalaryInfo(startSalaryInfo);
	}
	
	@Override
	public StartSalaryInfo findStartSalaryInfoById(Integer id)
	{
		return startSalaryInfoDao.findStartSalaryInfoById(id);
	}
}
