package com.sms.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/*
 * 职称变动信息表
 */
@Entity
@Table(name="workChange")
public class WorkChange {
	private Integer id;//主键
	private Integer eId;//职工号
	private String name;//姓名
	private String newHireWork; //聘任职称
	private Integer newWorkLevel; // 职称级别
	private Date workChangeDate;//职务变动时间
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
	 * 职工号，6位数字
	 */
	@Column(name="eId",length=6,nullable=false)
	public Integer getEId() {
		return eId;
	}
	public void setEId(Integer eId) {
		this.eId = eId;
	}
	
	/*
	 * 姓名
	 */
	@Column(name="name", nullable=false, length=50)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/*
	 * 聘任职务
	 */
	@Column(name="newHireWork")
	public String getNewHireWork() {
		return newHireWork;
	}
	public void setNewHireWork(String newHireWork) {
		this.newHireWork = newHireWork;
	}
	
	/*
	 * 职务级别
	 */
	@Column(name="newWorkLevel")
	public Integer getNewWorkLevel() {
		return newWorkLevel;
	}
	public void setNewWorkLevel(Integer newWorkLevel) {
		this.newWorkLevel = newWorkLevel;
	}
	
	/*
	 * 职务变动时间
	 */
	@Column(name="workChangeDate")
	public Date getWorkChangeDate() {
		return workChangeDate;
	}
	public void setWorkChangeDate(Date workChangeDate) {
		this.workChangeDate = workChangeDate;
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
