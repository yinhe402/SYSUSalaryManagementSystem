package com.sms.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="employee")
public class Employee {
	
	private Integer id;//职工号
	private String name;//姓名
	private String email;//邮箱
	private Boolean gender;//性别
	private Date birthday;//出生日期
	private String uid;//身份证号
	private String department;//单位
	private String jobType;//岗位性质
	private String type;//人员身份

	private String source; //进校来源
	private Date reachSchoolDate;//入校报到时间
	private String maxEducation;//最高学历
	private Date maxEducationDate;//最高学历获得时间
	private String maxDegree;//最高学位
	private Date maxDegreeDate;//最高学位获得时间
	private String hireWork; //聘任职务
	private Integer workLevel; //职务级别
	private Date startWorkDate; //任职时间
	private String hireTitle; //聘任职称
	private Integer titleLevel; // 职称级别
	private Date hireDate;//聘任时间
	private String hireJob; //（拟）聘任岗位
	private Integer jobLevel;//聘岗级别
	
	/**
	 * 职工号 六位数字组成
	 * */
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="name", length=20, nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="email", length=40)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="gender", nullable=false)
	public Boolean getGender() {
		return gender;
	}
	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	
	@Column(name="birthday", nullable=false)
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Column(name="uid", length = 20, nullable=false)
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	@Column(name="department", length = 10, nullable=false)
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Column(name="job_type", length = 10, nullable=false)
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	
	@Column(name="type", length = 10)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name="source", length = 10)
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
	@Column(name="reach_school_date")
	public Date getReachSchoolDate() {
		return reachSchoolDate;
	}
	public void setReachSchoolDate(Date reachSchoolDate) {
		this.reachSchoolDate = reachSchoolDate;
	}
	
	@Column(name="max_education", length=20, nullable=false)
	public String getMaxEducation() {
		return maxEducation;
	}
	
	public void setMaxEducation(String maxEducation) {
		this.maxEducation = maxEducation;
	}
	@Column(name="max_education_date", nullable=false)
	public Date getMaxEducationDate() {
		return maxEducationDate;
	}
	
	public void setMaxEducationDate(Date maxEducationDate) {
		this.maxEducationDate = maxEducationDate;
	}
	
	@Column(name="max_degree", length=20, nullable=false)
	public String getMaxDegree() {
		return maxDegree;
	}
	public void setMaxDegree(String maxDegree) {
		this.maxDegree = maxDegree;
	}
	
	@Column(name="max_degree_date", nullable=false)
	public Date getMaxDegreeDate() {
		return maxDegreeDate;
	}
	public void setMaxDegreeDate(Date maxDegreeDate) {
		this.maxDegreeDate = maxDegreeDate;
	}
	
	@Column(name="hire_work")
	public String getHireWork() {
		return hireWork;
	}
	
	
	public void setHireWork(String hireWork) {
		this.hireWork = hireWork;
	}
	
	@Column(name="work_level")
	public Integer getWorkLevel() {
		return workLevel;
	}
	public void setWorkLevel(Integer workLevel) {
		this.workLevel = workLevel;
	}
	
	
	@Column(name="start_work_date")
	public Date getStartWorkDate() {
		return startWorkDate;
	}
	public void setStartWorkDate(Date startWorkDate) {
		this.startWorkDate = startWorkDate;
	}
	
	@Column(name="hire_title", length=30)
	public String getHireTitle() {
		return hireTitle;
	}
	public void setHireTitle(String hireTitle) {
		this.hireTitle = hireTitle;
	}
	
	@Column(name="title_level")
	public Integer getTitleLevel() {
		return titleLevel;
	}
	public void setTitleLevel(Integer titleLevel) {
		this.titleLevel = titleLevel;
	}
	
	@Column(name="hire_date")
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	
	@Column(name="hire_job", length=20)
	public String getHireJob() {
		return hireJob;
	}
	public void setHireJob(String hireJob) {
		this.hireJob = hireJob;
	}
	
	@Column(name="job_level")
	public Integer getJobLevel() {
		return jobLevel;
	}
	public void setJobLevel(Integer jobLevel) {
		this.jobLevel = jobLevel;
	}
}
