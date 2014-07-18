package com.sms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * 年终一次性奖金信息表
 */
@Entity
@Table(name="finalBonus")
public class FinalBonus {
	private Integer id;//主键
	private Integer eId;//职工号
	private Integer year;//年份
	private Integer doubleSalaryType;//发放双薪类型  0:不发  1,2,3:部分发  4:全额发放
	private Integer months;//实际发放月数
	private String cutReason;//部分双薪原因
	
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
	 * 年份
	 */
	@Column(name="year")
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	
	/*
	 * 发放双薪类型
	 */
	@Column(name="doubleSalaryType")
	public Integer getDoubleSalaryType() {
		return doubleSalaryType;
	}
	public void setDoubleSalaryType(Integer doubleSalaryType) {
		this.doubleSalaryType = doubleSalaryType;
	}
	
	/*
	 * 实际发放月数
	 */
	@Column(name="months")
	public Integer getMonths() {
		return months;
	}
	public void setMonths(Integer months) {
		this.months = months;
	}
	
	/*
	 * 部分双薪原因
	 */
	@Column(name="cutReason")
	public String getCutReason() {
		return cutReason;
	}
	public void setCutReason(String cutReason) {
		this.cutReason = cutReason;
	}
}
