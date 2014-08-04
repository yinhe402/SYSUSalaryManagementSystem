package com.sms.dao;

import java.util.List;

import com.sms.entity.Experiences;

public interface IExperiencesDao {
	public void addExperiences(Experiences experiences);
	public void modifyExperiences(Experiences experiences);
	public void deleteExperiences(Experiences experiences);
	
	public List<Experiences> findManageExperiencesListByEid(Integer eid);
	public List<Experiences> findProfExperiencesListByEid(Integer eid);
	public List<Experiences> findWorkerExperiencesListByEid(Integer eid);
	public List<Experiences> findEduExperiencesListByEid(Integer eid);
}
