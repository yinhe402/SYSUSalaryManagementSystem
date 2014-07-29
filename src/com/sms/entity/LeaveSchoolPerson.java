package com.sms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * 离校人员信息表
 */
@Entity
@Table(name="leaveSchoolPerson")
public class LeaveSchoolPerson {
	private Integer id;//主键
	private Integer eId;//职工号
	private Date leaveSchoolDate;//离校时间
	private String leaveReason;//离校原因
	private String salaryState;//工资状态 在职,停职,取消工资关系
	private Date stopDate;//停发时间
	private String note;//备注
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	/*
	 * 职工号  6位数字
	 */
	@Column(name="eId",length=6,nullable=false)
	public Integer getEId() {
		return eId;
	}
	public void setEId(Integer eId) {
		this.eId = eId;
	}
	
	/*
	 * 离校时间
	 */
	@Column(name="leaveSchoolDate",nullable=false)
	public Date getLeaveSchoolDate() {
		return leaveSchoolDate;
	}
	public void setLeaveSchoolDate(Date leaveSchoolDate) {
		this.leaveSchoolDate = leaveSchoolDate;
	}
	
	/*
	 * 离校原因
	 */
	@Column(name="leaveReason")
	public String getLeaveReason() {
		return leaveReason;
	}
	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}
	
	/*
	 * 工资状态
	 */
	@Column(name="salaryState")
	public String getSalaryState() {
		return salaryState;
	}
	public void setSalaryState(String salaryState) {
		this.salaryState = salaryState;
	}
	
	@Column(name="stopDate",nullable=false)
	public Date getStopDate() {
		return stopDate;
	}
	public void setStopDate(Date stopDate) {
		this.stopDate = stopDate;
	}
	
	/*
	 * 备注
	 */
	@Column(name="note")
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}
