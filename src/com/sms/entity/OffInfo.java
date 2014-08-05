package com.sms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class OffInfo {
	
	private Integer id; 
	
	private Integer eid; //职工号
	private Date startDate; //开始时间
	private Date endDate; //结束时间
	private String reason; //原因
	
	public OffInfo() {
		this.eid = 000000;
	}
	
	public OffInfo(Integer eid, Date sDate, Date eDate, String reason) {
		this.eid = eid;
		this.startDate = sDate;
		this.endDate = eDate;
		this.reason = reason;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="eid", nullable=false)
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	@Column(name="start_date", nullable=false)
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	@Column(name="end_date", nullable=false)
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Column(name="reason")
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	

}
