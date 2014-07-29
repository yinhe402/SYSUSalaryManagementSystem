package com.sms.service;

import java.util.List;

import com.sms.entity.Salary;

public interface ISalaryManage {
	public void addSalary(Salary salary);
	public void modifySalary(Salary salary);
	public void deleteSalary(Salary salary);
	public Salary findSalaryById(Integer id);
	public List<Salary> findSalaryByEId(Integer eid);
	public Salary findLastSalaryByEId(Integer eid);
}
