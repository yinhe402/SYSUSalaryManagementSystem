package com.sms.service;

import com.sms.entity.StartSalaryInfo;

public interface IStartSalaryInfoManage {
	public void addStartSalaryInfo(StartSalaryInfo startSalaryInfo);
	public void modifyStartSalaryInfo(StartSalaryInfo startSalaryInfo);
	public void deleteStartSalaryInfo(StartSalaryInfo startSalaryInfo);
	public StartSalaryInfo findStartSalaryInfoById(Integer id);
}
