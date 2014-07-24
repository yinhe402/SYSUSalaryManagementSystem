package com.sms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * 工资恢复信息表
 */
@Entity
@Table(name="specialSalaryRecovery")
public class SpecialSalaryRecovery {
	private Integer id;//主键
	private Integer eId;//职工号
	private Date recoveryDate;//恢复时间
	private Integer checkerId;//审核员id
	private Date checkDate;//审核时间
	private Integer operatorId;//操作员id
	private Date operateDate;//操作时间
	private String recoveryReason;//恢复原因
	
	SpecialSalaryRecovery(){
		recoveryDate=new Date();
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
	@Column(name="eId")
	public Integer getEId() {
		return eId;
	}
	public void setEId(Integer eId) {
		this.eId = eId;
	}
	
	/*
	 * 恢复时间
	 */
	@Column(name="recoveryDate")
	public Date getRecoveryDate() {
		return recoveryDate;
	}
	public void setRecoveryDate(Date recoveryDate) {
		this.recoveryDate = recoveryDate;
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
	 * 审核时间
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
	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
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
	 * 恢复原因
	 */
	@Column(name="recoveryReason")
	public String getRecoveryReason() {
		return recoveryReason;
	}
	public void setRecoveryReason(String recoveryReason) {
		this.recoveryReason = recoveryReason;
	}
}
