package com.sms.service.impl;

import javax.annotation.Resource;

import com.sms.dao.ISalaryDao;
import com.sms.entity.Salary;
import com.sms.service.ISalaryManage;

public class SalaryManageImp implements ISalaryManage{
	
	@Resource
	private ISalaryDao salaryDao;

	public ISalaryDao getSalaryDao() {
		return salaryDao;
	}

	public void setSalaryDao(ISalaryDao salaryDao) {
		this.salaryDao = salaryDao;
	}
	
	@Override
	public void addSalary(Salary salary)
	{
		salaryDao.addSalary(salary);
	}
	
	@Override
	public void modifySalary(Salary salary)
	{
		salaryDao.modifySalary(salary);
	}
	
	@Override
	public void deleteSalary(Salary salary)
	{
		salaryDao.deleteSalary(salary);
	}
	
	@Override
	public Salary findSalaryById(Integer eid)
	{
		return salaryDao.findSalaryById(eid);
	}
}
