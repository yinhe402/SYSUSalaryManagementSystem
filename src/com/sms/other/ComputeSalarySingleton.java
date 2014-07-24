package com.sms.other;

import com.sms.entity.Salary;

//工资计算公式
public class ComputeSalarySingleton {
	private static ComputeSalarySingleton computeSalarySingleton = null;
	
	private Integer positionSalary;//岗位工资
	private Integer levelSalary;//薪级工资
	
	private Integer areaDifference;//地区差
	private Integer positionAllowance;//岗位津贴
	private Integer educationAllowance;///教护补贴
	private Integer specialPositionParas,specialLevelParas;//特殊津贴加权
	private Integer onlyChildAllowance;//独生子女
	private Integer otherPositionParas,otherLevelParas;//其它补贴加权
	private Integer phonePositionParam,phoneLevelParam;//电话补贴加权
	//private Integer monthAddAllowance;//月增资额
	//private Integer supplementSalary;//补发工资
	 
	 private ComputeSalarySingleton(){
	 }
	 
	 synchronized public static ComputeSalarySingleton getInstance(){
		 if(computeSalarySingleton==null){
			 computeSalarySingleton=new ComputeSalarySingleton();
		 }
		 return computeSalarySingleton;
	 }
	
	 public void computeSalary(Salary salary){
		 positionSalary=salary.getPositionSalary();
		 levelSalary=salary.getLevelSalary();
		 
		 salary.setAreaDifference(areaDifference);
		 salary.setPositionAllowance(positionAllowance);
		 salary.setEducationAllowance(educationAllowance);
		 salary.setSpecialAllowance(specialPositionParas*positionSalary+specialLevelParas*levelSalary);
		 salary.setOnlyChildAllowance(onlyChildAllowance);
		 salary.setOtherAllowance(otherPositionParas*positionSalary+otherLevelParas*levelSalary);
		 salary.setPhoneAllowance(phonePositionParam*positionSalary+phoneLevelParam*levelSalary);
		 salary.setTotleSalary();
	 }

	public Integer getPositionSalary() {
		return positionSalary;
	}

	public void setPositionSalary(Integer positionSalary) {
		this.positionSalary = positionSalary;
	}

	public Integer getLevelSalary() {
		return levelSalary;
	}

	public void setLevelSalary(Integer levelSalary) {
		this.levelSalary = levelSalary;
	}

	public Integer getAreaDifference() {
		return areaDifference;
	}

	public void setAreaDifference(Integer areaDifference) {
		this.areaDifference = areaDifference;
	}

	public Integer getPositionAllowance() {
		return positionAllowance;
	}

	public void setPositionAllowance(Integer positionAllowance) {
		this.positionAllowance = positionAllowance;
	}

	public Integer getEducationAllowance() {
		return educationAllowance;
	}

	public void setEducationAllowance(Integer educationAllowance) {
		this.educationAllowance = educationAllowance;
	}

	public Integer getSpecialPositionParas() {
		return specialPositionParas;
	}

	public void setSpecialPositionParas(Integer specialPositionParas) {
		this.specialPositionParas = specialPositionParas;
	}

	public Integer getSpecialLevelParas() {
		return specialLevelParas;
	}

	public void setSpecialLevelParas(Integer specialLevelParas) {
		this.specialLevelParas = specialLevelParas;
	}

	public Integer getOnlyChildAllowance() {
		return onlyChildAllowance;
	}

	public void setOnlyChildAllowance(Integer onlyChildAllowance) {
		this.onlyChildAllowance = onlyChildAllowance;
	}

	public Integer getOtherPositionParas() {
		return otherPositionParas;
	}

	public void setOtherPositionParas(Integer otherPositionParas) {
		this.otherPositionParas = otherPositionParas;
	}

	public Integer getOtherLevelParas() {
		return otherLevelParas;
	}

	public void setOtherLevelParas(Integer otherLevelParas) {
		this.otherLevelParas = otherLevelParas;
	}

	public Integer getPhonePositionParam() {
		return phonePositionParam;
	}

	public void setPhonePositionParam(Integer phonePositionParam) {
		this.phonePositionParam = phonePositionParam;
	}

	public Integer getPhoneLevelParam() {
		return phoneLevelParam;
	}

	public void setPhoneLevelParam(Integer phoneLevelParam) {
		this.phoneLevelParam = phoneLevelParam;
	}
}
