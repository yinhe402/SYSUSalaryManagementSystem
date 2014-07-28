package com.sms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * 单位变动信息表
 */
@Entity
@Table(name="departmentChange")
public class DepartmentChange {
	private Integer id;//主键
	private Integer eId;//职工号
	private String name;//姓名
	private String oldDepartment;//原单位
	private String newDepartment;//新单位
	private Date depChangeDate;//单位变动时间
	private String according;//变更依据
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
	 * 职工号。6位数字
	 */
	@Column(name="eId",length=6,nullable=false)
	public Integer getEId() {
		return eId;
	}
	public void setEId(Integer eId) {
		this.eId = eId;
	}
	
	/*
	 * 姓名。
	 */
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/*
	 * 原单位
	 */
	@Column(name="oldDepartment")
	public String getOldDepartment() {
		return oldDepartment;
	}
	public void setOldDepartment(String oldDepartment) {
		this.oldDepartment = oldDepartment;
	}
	
	/*
	 * 新单位
	 */
	@Column(name="newDepartment")
	public String getNewDepartment() {
		return newDepartment;
	}
	public void setNewDepartment(String newDepartment) {
		this.newDepartment = newDepartment;
	}
	
	/*
	 * 单位变动时间
	 */
	@Column(name="depChangeDate")
	public Date getDepChangeDate() {
		return depChangeDate;
	}
	public void setDepChangeDate(Date depChangeDate) {
		this.depChangeDate = depChangeDate;
	}
	
	/*
	 * 变更依据
	 */
	@Column(name="according")
	public String getAccording() {
		return according;
	}
	public void setAccording(String according) {
		this.according = according;
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
