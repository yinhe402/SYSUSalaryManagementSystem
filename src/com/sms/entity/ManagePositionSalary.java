package com.sms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * 管理人员薪级工资表
 */
@Entity
@Table(name = "manPosiSal_table")
public class ManagePositionSalary {
	private int id;//主键
	private String position;//岗位
	private Integer level;//级数
	private Integer salaryStandard;//工资标准
	private Integer startPayLevel;//起点薪级
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	/*
	 * 岗位,假设岗位汉字长度不超过5,不可为空,可重复
	 */
	@Column(name="position", length = 10, nullable=false,unique=false)
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	/*
	 * 级数,假设级数数字长度不超过5,不可为空,不可重复
	 */
	@Column(name="level", length = 5, nullable=false,unique=true)
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	
	/*
	 * 假设工资数字长度不超过10,不可为空,可重复
	 */
	@Column(name="salaryStandard", length = 10, nullable=false,unique=false)
	public Integer getSalaryStandard() {
		return salaryStandard;
	}
	public void setSalaryStandard(Integer salaryStandard) {
		this.salaryStandard = salaryStandard;
	}
	
	/*
	 * 假设起点薪级数字长度不超过5,不可为空,可重复
	 */
	@Column(name="startPayLevel", length = 5, nullable=false,unique=false)
	public Integer getStartPayLevel() {
		return startPayLevel;
	}
	
	public void setStartPayLevel(Integer startPayLevel) {
		this.startPayLevel = startPayLevel;
	}
	
}
