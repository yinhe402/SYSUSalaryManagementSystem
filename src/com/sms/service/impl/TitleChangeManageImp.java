package com.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.sms.dao.ITitleChangeDao;
import com.sms.entity.TitleChange;
import com.sms.service.ITitleChangeManage;

public class TitleChangeManageImp implements ITitleChangeManage{
	@Resource
	private ITitleChangeDao iTitleChangeDao;

	@Override
	public void addTitleChange(TitleChange TitleChange) {
		// TODO Auto-generated method stub
		iTitleChangeDao.addTitleChange(TitleChange);
	}

	@Override
	public void deleteTitleChange(TitleChange TitleChange) {
		// TODO Auto-generated method stub
		iTitleChangeDao.deleteTitleChange(TitleChange);
	}

	@Override
	public void modifyTitleChange(TitleChange TitleChange) {
		// TODO Auto-generated method stub
		iTitleChangeDao.modifyTitleChange(TitleChange);
	}

	@Override
	public List<TitleChange> findTitleChangeByEId(Integer eId) {
		// TODO Auto-generated method stub
		return iTitleChangeDao.findTitleChangeByEId(eId);
	}

}
