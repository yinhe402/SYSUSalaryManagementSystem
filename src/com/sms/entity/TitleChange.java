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
@Table(name="titleChange")
public class TitleChange {
	private Integer id;//主键
	private Integer eId;//职工号
	private String name;//姓名
	private String newHireTitle; //新聘任职称
	private Integer newTitleLevel; //新职称级别
	private Date titleChangeDate;//职务变动时间
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
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/*
	 * 新聘任职称
	 */
	@Column(name="newHireTitle")
	public String getNewHireTitle() {
		return newHireTitle;
	}
	public void setNewHireTitle(String newHireTitle) {
		this.newHireTitle = newHireTitle;
	}
	
	/*
	 * 新聘任级别
	 */
	@Column(name="newTitleLevel")
	public Integer getNewTitleLevel() {
		return newTitleLevel;
	}
	public void setNewTitleLevel(Integer newTitleLevel) {
		this.newTitleLevel = newTitleLevel;
	}
	
	/*
	 * 职称变动时间
	 */
	@Column(name="titleChangeDate")
	public Date getTitleChangeDate() {
		return titleChangeDate;
	}
	public void setTitleChangeDate(Date titleChangeDate) {
		this.titleChangeDate = titleChangeDate;
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
