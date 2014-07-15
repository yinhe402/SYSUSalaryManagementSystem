package com.sms.service;

import com.sms.entity.ManagePaylevelSalary;
import com.sms.entity.ManagePositionSalary;
import com.sms.entity.ManageSalaryChange;

public interface IManageSalaryManage {
	public void addManPaySal(ManagePaylevelSalary manPaylevelSalary);//增加管理人员薪级工资映射
	public void modifyManPaySal(ManagePaylevelSalary manPaylevelSalary);//修改管理人员薪级工资映射
	public void deleteManPaySal();//删除管理人员薪级工资映射
	public void setManPaySalByPayLevel(Integer payLevel);//根据薪级设置管理人员薪级工资映射记录
	
	public void addManPosSal(ManagePositionSalary managePositionSalary);//增加管理人员职务映射
	public void modifyManPosSal(ManagePositionSalary managePositionSalary);//修改管理人员职务映射
	public void deleteManPosSal();//删除管理人员职务映射
	public void setManPosSalByLevel(Integer level);//根据级别设置管理人员职务工资映射记录
	
	public void addManSalCha(ManageSalaryChange manageSalaryChange);//增加管理人员套改工资映射
	public void modifyManSalCha(ManageSalaryChange manageSalaryChange);//修改管理人员套改工资映射
	public void deleteManSalCha();//删除管理人员套改工资映射
	public void setManSalChaByLevel(Integer level,Integer off,Integer cha);//根据级别和相应工作年限设置套改工资映射记录
	
	public void setAllManage(Integer level,Integer off,Integer cha);//设置所有私有成员
	
	public Integer getSalary();//获得管理人员工资
}
