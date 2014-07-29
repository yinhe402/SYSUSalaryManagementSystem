package com.sms.service.impl;

import java.util.List;

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
	public Salary findSalaryById(Integer id)
	{
		return salaryDao.findSalaryById(id);
	}

	@Override
	public List<Salary> findSalaryByEId(Integer eid) {
		return salaryDao.findSalaryByEId(eid);
	}

	@Override
	public Salary findLastSalaryByEId(Integer eid) {
		return salaryDao.findLastSalaryById(eid);
	}
}
