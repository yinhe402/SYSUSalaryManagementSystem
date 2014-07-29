package com.sms.dao;

import java.util.List;

import com.sms.entity.Salary;

public interface ISalaryDao {
	public void addSalary(Salary salary);
	public void modifySalary(Salary salary);
	public void deleteSalary(Salary salary);
	public Salary findSalaryById(Integer id);
	public List<Salary> findSalaryByEId(Integer eid);
	public Salary findLastSalaryById(Integer eid);
}
