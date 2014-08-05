package com.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.sms.dao.IExperiencesDao;
import com.sms.entity.Experiences;
import com.sms.service.IExperiencesManage;

public class ExperiencesManageImp implements IExperiencesManage {
	@Resource
	IExperiencesDao experiencesDao;
	
	@Override
	public void addExperiences(Experiences experiences) {
		experiencesDao.addExperiences(experiences);
	}
	
	@Override
	public void modifyExperiences(Experiences experiences) {
		experiencesDao.modifyExperiences(experiences);
	}
	
	@Override
	public void deleteExperiences(Experiences experiences) {
		experiencesDao.deleteExperiences(experiences);
	}
	
	@Override
	public List<Experiences> findManageExperiencesListByEid(Integer eid) {
		return experiencesDao.findManageExperiencesListByEid(eid);
	}
	
	@Override
	public List<Experiences> findProfExperiencesListByEid(Integer eid) {
		return experiencesDao.findProfExperiencesListByEid(eid);
	}
	
	@Override
	public List<Experiences> findWorkerExperiencesListByEid(Integer eid) {
		return experiencesDao.findWorkerExperiencesListByEid(eid);
	}
	
	@Override
	public List<Experiences> findEduExperiencesListByEid(Integer eid) {
		return experiencesDao.findEduExperiencesListByEid(eid);
	}
}
