package com.sms.dao;

import java.util.List;

import com.sms.entity.TitleChange;

public interface ITitleChangeDao {
	public void addTitleChange(TitleChange titleChange);
	public void deleteTitleChange(TitleChange titleChange);
	public void modifyTitleChange(TitleChange titleChange);
	public List<TitleChange> findTitleChangeByEId(Integer eId);
}
