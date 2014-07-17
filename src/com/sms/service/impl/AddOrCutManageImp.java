package com.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.sms.dao.IAddOrCutDao;
import com.sms.entity.AddOrCut;
import com.sms.service.IAddOrCutManage;

public class AddOrCutManageImp implements IAddOrCutManage{
	@Resource
	private IAddOrCutDao iAddOrCutDao;

	@Override
	public void addAddOrCut(AddOrCut addOrCut) {
		// TODO Auto-generated method stub
		iAddOrCutDao.addAddOrCut(addOrCut);
	}

	@Override
	public void deleteAddOrCut(AddOrCut addOrCut) {
		// TODO Auto-generated method stub
		iAddOrCutDao.deleteAddOrCut(addOrCut);
	}

	@Override
	public void modifyAddOrCut(AddOrCut addOrCut) {
		// TODO Auto-generated method stub
		iAddOrCutDao.modifyAddOrCut(addOrCut);
	}

	@Override
	public List<AddOrCut>  findAddOrCutByEId(Integer eId) {
		// TODO Auto-generated method stub
		return iAddOrCutDao.findAddOrCutByEId(eId);
	}

}
