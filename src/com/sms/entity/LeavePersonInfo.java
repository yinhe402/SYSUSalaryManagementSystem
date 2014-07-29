package com.sms.entity;

import java.util.Date;

public class LeavePersonInfo {
	private String name;
	private String gender;
	private Integer eId;
	private String department;
	private Date leaveDate;
	private String reason;
	private String state;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer geteId() {
		return eId;
	}
	public void seteId(Integer eId) {
		this.eId = eId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Date getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public LeavePersonInfo(){
		name = null;
		gender = null;
		eId = null;
		department = null;
		leaveDate = null;
		reason = null;
		state = null;
	}
	
	public LeavePersonInfo(String s1, String s2, Integer i1, String s3, Date d1, String s4, String s5) {
		name = s1;
		gender = s2;
		eId = i1;
		department = s3;
		leaveDate = d1;
		reason = s4;
		state = s5;
	}
}
