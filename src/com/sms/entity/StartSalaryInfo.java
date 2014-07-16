package com.sms.entity;

import java.sql.Date;
import java.sql.Time;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="OtherInfo")
public class StartSalaryInfo {
	private String eid; //职工号
	private Date startSalaryDate;//起薪时间
	private Time operateDate;//业务处理时间	
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
	private Double positionSalary;//岗位工资
	private Double levelSalary;//薪级工资
	private String remarks;//备注
	
	@Id
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	
	public Date getStartSalaryDate() {
		return startSalaryDate;
	}
	public void setStartSalaryDate(Date startSalaryDate) {
		this.startSalaryDate = startSalaryDate;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Time getOperateDate() {
		return operateDate;
	}
	public void setOperateDate(Time operateDate) {
		this.operateDate = operateDate;
	}
	
	public Boolean getIsRaised() {
		return isRaised;
	}
	public void setIsRaised(Boolean isRaised) {
		this.isRaised = isRaised;
	}
	public Integer getChangeYears() {
		return changeYears;
	}
	public void setChangeYears(Integer changeYears) {
		this.changeYears = changeYears;
	}
	public Integer getBreakOffSeniority() {
		return breakOffSeniority;
	}
	public void setBreakOffSeniority(Integer breakOffSeniority) {
		this.breakOffSeniority = breakOffSeniority;
	}
	public Integer getWorkYears() {
		return workYears;
	}
	public void setWorkYears(Integer workYears) {
		this.workYears = workYears;
	}
	public Integer getSeniorityBeforeWork() {
		return seniorityBeforeWork;
	}
	public void setSeniorityBeforeWork(Integer seniorityBeforeWork) {
		this.seniorityBeforeWork = seniorityBeforeWork;
	}
	public Integer getLearnSeniority() {
		return learnSeniority;
	}
	public void setLearnSeniority(Integer learnSeniority) {
		this.learnSeniority = learnSeniority;
	}
	public Integer getHireYears() {
		return hireYears;
	}
	public void setHireYears(Integer hireYears) {
		this.hireYears = hireYears;
	}
	public String getSalarySeries() {
		return salarySeries;
	}
	public void setSalarySeries(String salarySeries) {
		this.salarySeries = salarySeries;
	}
	public Integer getPositionLevel() {
		return positionLevel;
	}
	public void setPositionLevel(Integer positionLevel) {
		this.positionLevel = positionLevel;
	}
	public Integer getSalaryLevel() {
		return salaryLevel;
	}
	public void setSalaryLevel(Integer salaryLevel) {
		this.salaryLevel = salaryLevel;
	}
	public Double getPositionSalary() {
		return positionSalary;
	}
	public void setPositionSalary(Double positionSalary) {
		this.positionSalary = positionSalary;
	}
	public Double getLevelSalary() {
		return levelSalary;
	}
	public void setLevelSalary(Double levelSalary) {
		this.levelSalary = levelSalary;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
