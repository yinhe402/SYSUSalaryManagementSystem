package com.sms.dao;

import java.util.List;

import com.sms.entity.DepartmentChange;

public interface IDepartmentChangeDao {
	public void addDepartmentChange(DepartmentChange departmentChange);
	public void deleteDepartmentChange(DepartmentChange departmentChange);
	public void modifyDepartmentChange(DepartmentChange departmentChange);
	public List<DepartmentChange> findDepartmentChangeByEId(Integer eId);
}
