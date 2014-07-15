package com.sms.service;

import com.sms.entity.WorkerPaylevelSalary;
import com.sms.entity.WorkerPositionSalary;
import com.sms.entity.WorkerSalaryChange;

public interface IWorkerSalaryManageDao {
	public void addWorkerPaySal(WorkerPaylevelSalary workerPaylevelSalary);//增加工人薪级工资映射
	public void modifyWorkerPaySal(WorkerPaylevelSalary workerPaylevelSalary);//修改工人薪级工资映射
	public void deleteWorkerPaySal();//删除工人薪级工资映射
	public void setWorkerPaySalByPayLevel(Integer payLevel);//根据薪级设置工人薪级工资映射记录
	
	public void addWorkerPosSal(WorkerPositionSalary workerPositionSalary);//增加工人职务映射
	public void modifyWorkerPosSal(WorkerPositionSalary workerPositionSalary);//修改工人职务映射
	public void deleteWorkerPosSal();//删除工人职务映射
	public void setWorkerPosSalByLevel(Integer level);//根据级别设置工人职务工资映射记录
	
	public void addWorkerSalCha(WorkerSalaryChange workerSalaryChange);//增加工人套改工资映射
	public void modifyWorkerSalCha(WorkerSalaryChange workerSalaryChange);//修改工人套改工资映射
	public void deleteWorkerSalCha();//删除工人套改工资映射
	public void setWorkerSalChaByLevel(Integer level,Integer off,Integer cha);//根据级别和相应工作年限设置套改工资映射记录
	
	public void setAllManage(Integer level,Integer off,Integer cha);//设置所有私有成员
	
	public Integer getSalary();//获得工人工资
}
