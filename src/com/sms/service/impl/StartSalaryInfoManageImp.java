package com.sms.service.impl;

import java.util.List;

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
	public StartSalaryInfo findStartSalaryInfoByEId(Integer eid)
	{
		return startSalaryInfoDao.findStartSalaryInfoByEId(eid);
	}

	@Override
	public List<StartSalaryInfo> getAllStartSalaryInfo() {
		// TODO Auto-generated method stub
		return  startSalaryInfoDao.getAllStartSalaryInfo();
	}
}
