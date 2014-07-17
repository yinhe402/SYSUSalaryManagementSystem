package com.sms.service;

import java.util.List;

import com.sms.entity.AddOrCut;

public interface IAddOrCutManage {
	public void addAddOrCut(AddOrCut addOrCut);
	public void deleteAddOrCut(AddOrCut addOrCut);
	public void modifyAddOrCut(AddOrCut addOrCut);
	public List<AddOrCut> findAddOrCutByEId(Integer eId);
}
