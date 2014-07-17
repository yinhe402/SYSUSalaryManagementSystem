package com.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.sms.dao.IWorkChangeDao;
import com.sms.entity.WorkChange;
import com.sms.service.IWorkChangeManage;

public class WorkChangeManageImp implements IWorkChangeManage{
	@Resource
	private IWorkChangeDao iWorkChangeDao;

	@Override
	public void addWorkChange(WorkChange workChange) {
		// TODO Auto-generated method stub
		iWorkChangeDao.addWorkChange(workChange);
	}

	@Override
	public void deleteWorkChange(WorkChange workChange) {
		// TODO Auto-generated method stub
		iWorkChangeDao.deleteWorkChange(workChange);
	}

	@Override
	public void modifyWorkChange(WorkChange workChange) {
		// TODO Auto-generated method stub
		iWorkChangeDao.modifyWorkChange(workChange);
	}

	@Override
	public List<WorkChange> findWorkChangeByEId(Integer eId) {
		// TODO Auto-generated method stub
		return iWorkChangeDao.findWorkChangeByEId(eId);
	}

}
