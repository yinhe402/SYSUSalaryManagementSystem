package com.sms.action;

import com.opensymphony.xwork2.Action;
import com.sms.other.ComputeSalarySingleton;

public class InitSalaryCompute {
	private Integer areaDifference;//地区差
	private Integer positionAllowance;//岗位津贴
	private Integer educationAllowance;///教护补贴
	private Integer specialPositionParas,specialLevelParas;//特殊津贴加权
	private Integer onlyChildAllowance;//独生子女
	private Integer otherPositionParas,otherLevelParas;//其它补贴加权
	private Integer phonePositionParam,phoneLevelParam;//电话补贴加权
	 
	public String initSalaryCompute(){
		 ComputeSalarySingleton computeSalarySingleton=ComputeSalarySingleton.getInstance();
		 computeSalarySingleton.setAreaDifference(areaDifference);
		 computeSalarySingleton.setPhoneLevelParam(phoneLevelParam);
		 computeSalarySingleton.setPhonePositionParam(phonePositionParam);
		 computeSalarySingleton.setPositionAllowance(positionAllowance);
		 computeSalarySingleton.setEducationAllowance(educationAllowance);
		 computeSalarySingleton.setSpecialLevelParas(specialLevelParas);
		 computeSalarySingleton.setSpecialPositionParas(specialPositionParas);
		 computeSalarySingleton.setOnlyChildAllowance(onlyChildAllowance);
		 computeSalarySingleton.setOtherLevelParas(otherLevelParas);
		 computeSalarySingleton.setOtherPositionParas(otherPositionParas);
		 
		 return Action.SUCCESS;
	 }
}
