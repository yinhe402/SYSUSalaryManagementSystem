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
	private int id;//涓婚敭
	private String positon;//宀椾綅
	private Integer level;//绾ф暟
	private Integer salaryStandard;//宸ヨ祫鏍囧噯
	private Integer startPayLevel;//璧风偣钖骇
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	/*
	 * 宀椾綅,鍋囪宀椾綅姹夊瓧闀垮害涓嶈秴杩?,涓嶅彲涓虹┖,鍙噸澶?
	 */
	@Column(name="position", length = 10, nullable=false,unique=false)
	public String getPositon() {
		return positon;
	}
	public void setPositon(String positon) {
		this.positon = positon;
	}
	
	/*
	 * 绾ф暟,鍋囪绾ф暟鏁板瓧闀垮害涓嶈秴杩?,涓嶅彲涓虹┖,涓嶅彲閲嶅
	 */
	@Column(name="level", length = 5, nullable=false,unique=true)
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	
	/*
	 * 鍋囪宸ヨ祫鏁板瓧闀垮害涓嶈秴杩?0,涓嶅彲涓虹┖,鍙噸澶?
	 */
	@Column(name="salaryStandard", length = 10, nullable=false,unique=false)
	public Integer getSalaryStandard() {
		return salaryStandard;
	}
	public void setSalaryStandard(Integer salaryStandard) {
		this.salaryStandard = salaryStandard;
	}
	
	/*
	 * 鍋囪璧风偣钖骇鏁板瓧闀垮害涓嶈秴杩?,涓嶅彲涓虹┖,鍙噸澶?
	 */
	@Column(name="startPayLevel", length = 5, nullable=false,unique=false)
	public Integer getPaylevel() {
		return startPayLevel;
	}
	public void setPaylevel(Integer startPayLevel) {
		this.startPayLevel = startPayLevel;
	}
}
