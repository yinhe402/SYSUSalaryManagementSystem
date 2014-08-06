package com.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.sms.dao.ILeaveSchoolPersonDao;
import com.sms.entity.LeaveSchoolPerson;
import com.sms.service.ILeaveSchoolPersonManage;

public class LeaveSchoolPersonManageImp implements ILeaveSchoolPersonManage{
	@Resource
	private ILeaveSchoolPersonDao iLeaveSchoolPersonDao;

	@Override
	public void addLeaveSchoolPerson(LeaveSchoolPerson leaveSchoolPerson) {
		// TODO Auto-generated method stub
		iLeaveSchoolPersonDao.addLeaveSchoolPerson(leaveSchoolPerson);
	}

	@Override
	public void deleteLeaveSchoolPerson(LeaveSchoolPerson leaveSchoolPerson) {
		// TODO Auto-generated method stub
		iLeaveSchoolPersonDao.deleteLeaveSchoolPerson(leaveSchoolPerson);
	}

	@Override
	public void modifyLeaveSchoolPerson(LeaveSchoolPerson leaveSchoolPerson) {
		// TODO Auto-generated method stub
		iLeaveSchoolPersonDao.modifyLeaveSchoolPerson(leaveSchoolPerson);
	}

	@Override
	public LeaveSchoolPerson findLeaveSchoolPersonByEId(Integer eId) {
		// TODO Auto-generated method stub
		return iLeaveSchoolPersonDao.findLeaveSchoolPersonByEId(eId);
	}
	
	@Override
	public List<LeaveSchoolPerson> findLeaveSchoolPersonsList() {
		return iLeaveSchoolPersonDao.findLeaveSchoolPersonsList();
	}

}
