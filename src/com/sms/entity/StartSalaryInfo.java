package com.sms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="start_salary_info")
public class StartSalaryInfo {
	private Integer eid; //职工号
	private Date startSalaryDate;//起薪时间
	private Date operateDate;//业务处理时间
	private Boolean isRaised;//基本工资是否上调10%
	private Integer changeYears;//套改年限
	private Integer breakOffSeniority;//中断工龄
	private Integer workYears;//截至2006年6月30日的实际工作年限
	private Integer seniorityBeforeWork;//工作前工龄
	private Integer learnSeniority;//大专以上不计工龄年限
	private Integer hireYears; //任职年限
	private String  salarySeries; //工资系列
	private Integer positionLevel;//工资岗位级别
	private Integer salaryLevel;//薪级
	private Integer positionSalary;//岗位工资
	private Integer levelSalary;//薪级工资
	private String remarks;//备注
	
	@Id
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	
	@Column
	public Date getStartSalaryDate() {
		return startSalaryDate;
	}
	public void setStartSalaryDate(Date startSalaryDate) {
		this.startSalaryDate = startSalaryDate;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	public Date getOperateDate() {
		return operateDate;
	}
	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}
	
	@Column
	public Boolean getIsRaised() {
		return isRaised;
	}
	public void setIsRaised(Boolean isRaised) {
		this.isRaised = isRaised;
	}
	
	@Column
	public Integer getChangeYears() {
		return changeYears;
	}
	public void setChangeYears(Integer changeYears) {
		this.changeYears = changeYears;
	}
	
	@Column
	public Integer getBreakOffSeniority() {
		return breakOffSeniority;
	}
	public void setBreakOffSeniority(Integer breakOffSeniority) {
		this.breakOffSeniority = breakOffSeniority;
	}
	
	@Column
	public Integer getWorkYears() {
		return workYears;
	}
	public void setWorkYears(Integer workYears) {
		this.workYears = workYears;
	}
	
	@Column
	public Integer getSeniorityBeforeWork() {
		return seniorityBeforeWork;
	}
	public void setSeniorityBeforeWork(Integer seniorityBeforeWork) {
		this.seniorityBeforeWork = seniorityBeforeWork;
	}
	
	@Column
	public Integer getLearnSeniority() {
		return learnSeniority;
	}
	public void setLearnSeniority(Integer learnSeniority) {
		this.learnSeniority = learnSeniority;
	}
	
	@Column
	public Integer getHireYears() {
		return hireYears;
	}
	public void setHireYears(Integer hireYears) {
		this.hireYears = hireYears;
	}
	
	@Column
	public String getSalarySeries() {
		return salarySeries;
	}
	public void setSalarySeries(String salarySeries) {
		this.salarySeries = salarySeries;
	}
	
	@Column
	public Integer getPositionLevel() {
		return positionLevel;
	}
	public void setPositionLevel(Integer positionLevel) {
		this.positionLevel = positionLevel;
	}
	
	@Column
	public Integer getSalaryLevel() {
		return salaryLevel;
	}
	public void setSalaryLevel(Integer salaryLevel) {
		this.salaryLevel = salaryLevel;
	}
	
	@Column
	public Integer getPositionSalary() {
		return positionSalary;
	}
	public void setPositionSalary(Integer positionSalary) {
		this.positionSalary = positionSalary;
	}
	
	@Column
	public Integer getLevelSalary() {
		return levelSalary;
	}
	public void setLevelSalary(Integer levelSalary) {
		this.levelSalary = levelSalary;
	}
	
	@Column
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
