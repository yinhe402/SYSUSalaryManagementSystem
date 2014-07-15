package com.sms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * 专业技术人员薪级工资表
 */
@Entity
@Table(name = "profPaylSal_table")
public class ProfessionalPaylevelSalary {
	private int id;//主键
	private Integer payLevel;//薪级
	private Integer salaryStandard;//工资标准
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	/*
	 * 假设薪级数字长度不超过5,不可为空,不可重复
	 */
	@Column(name="payLevel", length = 5, nullable=false,unique=true)
	public Integer getPayLevel() {
		return payLevel;
	}

	public void setPayLevel(Integer payLevel) {
		this.payLevel = payLevel;
	}
	
	/*
	 * 假设工资标准数字长度不超过10,不可为空,可重复
	 */
	@Column(name="salaryStandard", length = 10, nullable=false,unique=false)
	public Integer getSalaryStandard() {
		return salaryStandard;
	}
	
	public void setSalaryStandard(Integer salaryStandard) {
		this.salaryStandard = salaryStandard;
	}
	
}
