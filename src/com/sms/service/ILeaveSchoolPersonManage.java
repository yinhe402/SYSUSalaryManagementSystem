package com.sms.service;

import java.util.List;

import com.sms.entity.LeaveSchoolPerson;

public interface ILeaveSchoolPersonManage {
	public void addLeaveSchoolPerson(LeaveSchoolPerson leaveSchoolPerson);
	public void deleteLeaveSchoolPerson(LeaveSchoolPerson leaveSchoolPerson);
	public void modifyLeaveSchoolPerson(LeaveSchoolPerson leaveSchoolPerson);
	public LeaveSchoolPerson findLeaveSchoolPersonByEId(Integer eId);
	public List<LeaveSchoolPerson> findLeaveSchoolPersonsList();
}
