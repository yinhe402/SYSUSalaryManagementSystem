package com.sms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;

/*
 * 管理人员薪级工资套改表
 */
@Entity
@Table(name = "manSalCha_table")
public class ManageSalaryChange {
	private int id;//主键
	private Integer positionLevel;//岗位级别
	private Integer lowBoundOfOfficeYear;//任职年限下界
	private Integer upperBoundOfOfficeYear;//任职年限上界
	private Integer lowBoundOfChangeYear;//套改年限下界
	private Integer upperBoundOfChangeYear;//套改年限上界
	private Integer payLevel;//薪级

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	/*
	 * 岗位级别,假设岗位级别数字长度不超过5,不可为空,可重复
	 */
	@Column(name="positionLevel", length = 5, nullable=false,unique=false)
	public Integer getPositionLevel() {
		return positionLevel;
	}
	public void setPositionLevel(Integer positionLevel) {
		this.positionLevel = positionLevel;
	}
	
	/*
	 * 任职年限下界,假设任职年限下界数字长度不超过5,不可为空,可重复
	 */
	@Column(name="lowBoundOfOfficeYear", length = 5, nullable=false,unique=false)
	public Integer getLowBoundOfOfficeYear() {
		return lowBoundOfOfficeYear;
	}
	public void setLowBoundOfOfficeYear(Integer lowBoundOfOfficeYear) {
		this.lowBoundOfOfficeYear = lowBoundOfOfficeYear;
	}
	
	/*
	 * 任职年限上界,假设任职年限上界数字长度不超过5,不可为空,可重复
	 */
	@Column(name="upperBoundOfOfficeYear", length = 5, nullable=false,unique=false)
	public Integer getUpperBoundOfOfficeYear() {
		return upperBoundOfOfficeYear;
	}
	public void setUpperBoundOfOfficeYear(Integer upperBoundOfOfficeYear) {
		this.upperBoundOfOfficeYear = upperBoundOfOfficeYear;
	}
	
	/*
	 * 套改年限下界,假设套改年限下界数字长度不超过5,不可为空,可重复
	 */
	@Column(name="lowBoundOfChangeYear", length = 5, nullable=false,unique=false)
	public Integer getLowBoundOfChangeYear() {
		return lowBoundOfChangeYear;
	}
	public void setLowBoundOfChangeYear(Integer lowBoundOfChangeYear) {
		this.lowBoundOfChangeYear = lowBoundOfChangeYear;
	}
	
	/*
	 * 套改年限上界,假设套改年限上界数字长度不超过5,不可为空,可重复
	 */
	@Column(name="upperBoundOfChangeYear", length = 5, nullable=false,unique=false)
	public Integer getUpperBoundOfChangeYear() {
		return upperBoundOfChangeYear;
	}
	public void setUpperBoundOfChangeYear(Integer upperBoundOfChangeYear) {
		this.upperBoundOfChangeYear = upperBoundOfChangeYear;
	}
	
	/*
	 * 薪级,假设薪级数字长度不超过5,不可为空,可重复
	 */
	@Column(name="payLevel", length = 5, nullable=false,unique=false)
	public Integer getPayLevel() {
		return payLevel;
	}
	public void setPayLevel(Integer payLevel) {
		this.payLevel = payLevel;
	}
}
