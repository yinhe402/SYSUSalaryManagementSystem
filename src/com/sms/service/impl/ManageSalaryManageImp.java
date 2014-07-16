package com.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.sms.dao.IManageSalaryDao;
import com.sms.entity.ManagePaylevelSalary;
import com.sms.entity.ManagePositionSalary;
import com.sms.entity.ManageSalaryChange;
import com.sms.service.IManageSalaryManage;

public class ManageSalaryManageImp implements IManageSalaryManage{
	private ManagePositionSalary managePositionSalary;
	private ManagePaylevelSalary managePaylevelSalary;
	private ManageSalaryChange manageSalaryChange;
	
	@Resource
	private IManageSalaryDao ImanageSalaryDao;
	
	public ManagePositionSalary getManagePositionSalary() {
		return managePositionSalary;
	}

	public void setManagePositionSalary(ManagePositionSalary managePositionSalary) {
		this.managePositionSalary = managePositionSalary;
	}

	public ManageSalaryChange getManageSalaryChange() {
		return manageSalaryChange;
	}

	public void setManageSalaryChange(ManageSalaryChange manageSalaryChange) {
		this.manageSalaryChange = manageSalaryChange;
	}

	public ManagePaylevelSalary getManagePaylevelSalary() {
		return managePaylevelSalary;
	}

	public void setManagePaylevelSalary(ManagePaylevelSalary managePaylevelSalary) {
		this.managePaylevelSalary = managePaylevelSalary;
	}

	public IManageSalaryDao getManageSalaryDao() {
		return ImanageSalaryDao;
	}

	public void setManageSalaryDao(IManageSalaryDao manageSalaryDao) {
		this.ImanageSalaryDao = manageSalaryDao;
	}
	
	@Override
	public void addManPaySal(ManagePaylevelSalary manPaylevelSalary) {
		// TODO Auto-generated method stub
		ImanageSalaryDao.addManPaySal(manPaylevelSalary);
	}
	
	@Override
	public void modifyManPaySal(ManagePaylevelSalary manPaylevelSalary) {
		// TODO Auto-generated method stub
		setManPaySalByPayLevel(manPaylevelSalary.getPayLevel());
		getManagePaylevelSalary().setSalaryStandard(manPaylevelSalary.getSalaryStandard());
		ImanageSalaryDao.modifyManPaySal(getManagePaylevelSalary());
	}

	@Override
	public void deleteManPaySal() {
		// TODO Auto-generated method stub
		ImanageSalaryDao.deleteManPaySal(getManagePaylevelSalary());
	}

	@Override
	public void setManPaySalByPayLevel(Integer payLevel) {
		// TODO Auto-generated method stub
		this.managePaylevelSalary=ImanageSalaryDao.findManPaySalByPayLevel(payLevel);
	}

	@Override
	public void addManPosSal(ManagePositionSalary managePositionSalary) {
		// TODO Auto-generated method stub
		ImanageSalaryDao.addManPosSal(managePositionSalary);
	}

	@Override
	public void modifyManPosSal(ManagePositionSalary managePositionSalary) {
		// TODO Auto-generated method stub
		setManPosSalByLevel(managePositionSalary.getLevel());
		getManagePositionSalary().setSalaryStandard(managePositionSalary.getSalaryStandard());
		getManagePositionSalary().setPosition(managePositionSalary.getPosition());
		ImanageSalaryDao.modifyManPosSal(getManagePositionSalary());
	}

	@Override
	public void deleteManPosSal() {
		// TODO Auto-generated method stub
		ImanageSalaryDao.deleteManPosSal(getManagePositionSalary());
	}

	@Override
	public void setManPosSalByLevel(Integer level) {
		// TODO Auto-generated method stub
		this.managePositionSalary=ImanageSalaryDao.findManPosSalByLevel(level);
	}

	@Override
	public void addManSalCha(ManageSalaryChange manageSalaryChange) {
		// TODO Auto-generated method stub
		ImanageSalaryDao.addManSalCha(manageSalaryChange);
	}

	@Override
	public void modifyManSalCha(ManageSalaryChange manageSalaryChange) {
		// TODO Auto-generated method stub
		setManSalChaByLevel(manageSalaryChange.getPositionLevel(), manageSalaryChange.getUpperBoundOfChangeYear(), manageSalaryChange.getUpperBoundOfChangeYear());
		getManageSalaryChange().setPayLevel(manageSalaryChange.getPayLevel());
		ImanageSalaryDao.modifyManSalCha(manageSalaryChange);
	}

	@Override
	public void deleteManSalCha() {
		// TODO Auto-generated method stub
		ImanageSalaryDao.deleteManSalCha(manageSalaryChange);
	}

	@Override
	public void setManSalChaByLevel(Integer level,Integer off,Integer cha) {
		// TODO Auto-generated method stub
		this.manageSalaryChange=ImanageSalaryDao.findManSalChaByLevel(level,off,cha);
	}

	@Override
	public Integer getSalary() {
		// TODO Auto-generated method stub
		return managePaylevelSalary.getSalaryStandard()+managePositionSalary.getSalaryStandard();
	}

	@Override
	public void setAllManage(Integer level,Integer off,Integer cha) {
		//System.out.println(level);
		// TODO Auto-generated method stub
		setManSalChaByLevel(level,off,cha);
		System.out.println(getManageSalaryChange().getPayLevel());
		setManPaySalByPayLevel(getManageSalaryChange().getPayLevel());
		setManPosSalByLevel(level);
	}

	@Override
	public List<ManagePaylevelSalary> findAllPayLevelSalary() {
		// TODO Auto-generated method stub
		return ImanageSalaryDao.findAllPayLevelSalary();
	}

	@Override
	public List<ManagePositionSalary> findAllPositionSalary() {
		// TODO Auto-generated method stub
		return ImanageSalaryDao.findAllPositionSalary();
	}
}
