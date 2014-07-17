package com.sms.service;

import java.util.List;

import com.sms.entity.WorkChange;

public interface IWorkChangeManage {
	public void addWorkChange(WorkChange workChange);
	public void deleteWorkChange(WorkChange workChange);
	public void modifyWorkChange(WorkChange workChange);
	public List<WorkChange> findWorkChangeByEId(Integer eId);
}
