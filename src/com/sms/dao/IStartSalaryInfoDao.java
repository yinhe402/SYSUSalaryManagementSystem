package com.sms.dao;

import java.util.List;

import com.sms.entity.StartSalaryInfo;

public interface IStartSalaryInfoDao {
	public void addStartSalaryInfo(StartSalaryInfo startSalaryInfo);
	public void modifyStartSalaryInfo(StartSalaryInfo startSalaryInfo);
	public void deleteStartSalaryInfo(StartSalaryInfo startSalaryInfo);
	public StartSalaryInfo findStartSalaryInfoByEId(Integer eid);
	public List<StartSalaryInfo> getAllStartSalaryInfo();
}
