package com.sms.dao;

import com.sms.entity.StartSalaryInfo;

public interface IStartSalaryInfoDao {
	public void AddStartSalaryInfo(StartSalaryInfo startSalaryInfo);
	public void modifyStartSalaryInfo(StartSalaryInfo startSalaryInfo);
	public void deleteStartSalaryInfo(StartSalaryInfo startSalaryInfo);
	public StartSalaryInfo findStartSalaryInfoById(Integer id);
}
