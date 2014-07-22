package com.sms.service;

import com.sms.entity.Salary;

public interface ISalaryManage {
	public void addSalary(Salary salary);
	public void modifySalary(Salary salary);
	public void deleteSalary(Salary salary);
	public Salary findSalaryById(Integer id);
	public Salary findSalaryByEId(Integer eid);
}
