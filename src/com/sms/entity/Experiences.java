package com.sms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="experiences")
public class Experiences {
	private Integer exId;//主键，自增
	private Integer eid;//职工号
	private Integer type;//经历类型，1为管理，2为专技，3为工人，0为教育
	private Integer exYear;//经历开始时间
	private String exRank;//经历级别
	
	public Experiences() {
		type = 0;
	}
	
	public Experiences(Integer eid, Integer type, Integer exYear, String exRank) {
		this.eid = eid;
		this.type = type;
		this.exYear = exYear;
		this.exRank = exRank;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="exId")
	public Integer getExId() {
		return exId;
	}

	public void setExId(Integer exId) {
		this.exId = exId;
	}

	@Column(name="eid")	
	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	@Column(name="type")
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name="exYear")
	public Integer getExYear() {
		return exYear;
	}

	public void setExYear(Integer exYear) {
		this.exYear = exYear;
	}

	@Column(name="exRank")
	public String getExRank() {
		return exRank;
	}

	public void setExRank(String exRank) {
		this.exRank = exRank;
	}
}
