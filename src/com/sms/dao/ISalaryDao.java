package com.sms.dao;

import com.sms.entity.Salary;

public interface ISalaryDao {
	public void addSalary(Salary salary);
	public void modifySalary(Salary salary);
	public void deleteSalary(Salary salary);
	public Salary findSalaryById(Integer id);
}
