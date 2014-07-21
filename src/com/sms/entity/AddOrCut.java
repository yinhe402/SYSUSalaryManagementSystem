package com.sms.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/*
 * 补发补扣信息表
 */
@Entity
@Table(name="addOrCut")
public class AddOrCut {
	private Integer id;//主键
	private Integer eId;//职工号
	private boolean choice;//true:补发,false:补扣
	private Integer amount;//补发补扣金额
	private String addOrCutReason;//补发补扣原因
	private Date addOrCutDate;//补发补扣时间
	
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
	 * 补发补扣
	 */
	@Column(name="choice")
	public boolean isChoice() {
		return choice;
	}
	public void setChoice(boolean choice) {
		this.choice = choice;
	}
	
	/*
	 * 补发补扣金额
	 */
	@Column(name="amount")
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	/*
	 * 补发补扣原因
	 */
	@Column(name="addOrCutReason")
	public String getAddOrCutReason() {
		return addOrCutReason;
	}
	public void setAddOrCutReason(String addOrCutReason) {
		this.addOrCutReason = addOrCutReason;
	}
	
	/*
	 * 补发补扣时间
	 */
	@Column(name="addOrCutDate")
	public Date getAddOrCutDate() {
		return addOrCutDate;
	}
	public void setAddOrCutDate(Date addOrCutDate) {
		this.addOrCutDate = addOrCutDate;
	}
}
