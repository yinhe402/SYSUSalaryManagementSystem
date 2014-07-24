package com.sms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/*
 * 工资变动信息表
 */
@Entity
@Table(name="specialSalaryChange")
public class SpecialSalaryChange {
	private Integer id;//主键
	private Integer eId;//职工号
	private Date changeDate;//扣减生效时间
	private Integer checkerId;//审核员id
	private Date checkDate;//审核时间
	private Integer operatorId;//操作员id
	private Date operateDate;//操作时间
	private Integer amount;//工资金额增减，负数为减少
	private String reason;//扣减原因	
	
	SpecialSalaryChange(){
		changeDate=new Date();
	}
	
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
	@Column(name="eId",length=6)
	public Integer getEId() {
		return eId;
	}
	public void setEId(Integer eId) {
		this.eId = eId;
	}
	
	/*
	 * 扣减生效时间
	 */
	@Column(name="changeDate")
	public Date getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}
	
	/*
	 * 审核员id
	 */
	@Column(name="checkerId")
	public Integer getCheckerId() {
		return checkerId;
	}
	public void setCheckerId(Integer checkerId) {
		this.checkerId = checkerId;
	}
	
	/*
	 *审核时间
	 */
	@Column(name="checkDate")
	public Date getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}
	
	/*
	 * 操作员id
	 */
	@Column(name="operatorId")
	public Integer getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(Integer operatoeId) {
		this.operatorId = operatoeId;
	}
	
	/*
	 * 操作时间
	 */
	@Column(name="operateDate")
	public Date getOperateDate() {
		return operateDate;
	}
	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}
	
	/*
	 * 扣减金额
	 */
	@Column(name="amount")
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	/*
	 *扣减原因
	 */
	@Column(name="reason")
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
}	
