package com.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.sms.dao.IDepartmentChangeDao;
import com.sms.entity.DepartmentChange;
import com.sms.service.IDepartmentChangeManage;

public class DepartmentChangeManageImp implements IDepartmentChangeManage{
	@Resource
	private IDepartmentChangeDao iDepartmentChangeDao;

	@Override
	public void addDepartmentChange(DepartmentChange departmentChange) {
		// TODO Auto-generated method stub
		iDepartmentChangeDao.addDepartmentChange(departmentChange);
	}

	@Override
	public void deleteDepartmentChange(DepartmentChange departmentChange) {
		// TODO Auto-generated method stub
		iDepartmentChangeDao.deleteDepartmentChange(departmentChange);
	}

	@Override
	public void modifyDepartmentChange(DepartmentChange departmentChange) {
		// TODO Auto-generated method stub
		iDepartmentChangeDao.modifyDepartmentChange(departmentChange);
	}

	@Override
	public List<DepartmentChange> findDepartmentChangeByEId(Integer eId) {
		// TODO Auto-generated method stub
		return iDepartmentChangeDao.findDepartmentChangeByEId(eId);
	}

}
