package com.sms.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/*
 * 扣减处理信息表
 */
@Entity
@Table(name="deduction")
public class Deduction {
	private Integer id;//主键
	private Integer eId;//职工号
	private Date deductionDate;//扣减生效时间
	private Integer checkerId;//审核员id
	private Date checkDate;//审核时间
	private Integer operatoeId;//操作员id
	private Date operateDate;//操作时间
	private Integer amount;//各工资项扣减金额
	private String deductionReason;//扣减原因	
	
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
	public Integer geteId() {
		return eId;
	}
	public void seteId(Integer eId) {
		this.eId = eId;
	}
	
	/*
	 * 扣减生效时间
	 */
	@Column(name="deductionDate")
	public Date getDeductionDate() {
		return deductionDate;
	}
	public void setDeductionDate(Date deductionDate) {
		this.deductionDate = deductionDate;
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
	@Column(name="operatoeId")
	public Integer getOperatoeId() {
		return operatoeId;
	}
	public void setOperatoeId(Integer operatoeId) {
		this.operatoeId = operatoeId;
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
	@Column(name="deductionReason")
	public String getDeductionReason() {
		return deductionReason;
	}
	public void setDeductionReason(String deductionReason) {
		this.deductionReason = deductionReason;
	}
}	
