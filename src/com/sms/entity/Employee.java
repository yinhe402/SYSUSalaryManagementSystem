package com.sms.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Employee {
	
	private Integer id;//职工号
	private String name;
	private String email;
	private Boolean gender;
	private Date birthday;
	private String uid;//身份证号
	private String department;
	private String jobType;
	private String source; //入校来源
	private Date reachSchoolDate;
	private String maxEducation;
	private Date maxEducationDate;
	private String maxDegree;
	private Date maxDegreeDate;
	private String hireWork; //聘任职务
	private Integer workLevel; //职务级别
	private Date startWorkDate; //任职时间
	private String hireTitle; //聘任职称
	private Integer titleLevel; // 职称级别
	private Date hireDate;
	private String hireJob; //聘任岗位
	private Integer jobLevel;
	
	/**
	 * 职工号 六位数字组成
	 * */
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@OneToOne(cascade=CascadeType.ALL)
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
	@Column(name="gender", length = 10, nullable=false)
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Column(name="jobType", length = 10, nullable=false)
	public String getJobType() {
		return jobType;
	}
	
	public void setJobType(String jobType) {
		this.jobType = jobType;
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
	
	@Column(name="max_degree_date")
	public String getHireWork() {
		return hireWork;
	}
	
	
	public void setHireWork(String hireWork) {
		this.hireWork = hireWork;
	}
	
	@Column(name="workLevel")
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
	
	@Column(name="start_work_date")
	public String getHireTitle() {
		return hireTitle;
	}
	public void setHireTitle(String hireTitle) {
		this.hireTitle = hireTitle;
	}
	public Integer getTitleLevel() {
		return titleLevel;
	}
	public void setTitleLevel(Integer titleLevel) {
		this.titleLevel = titleLevel;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getHireJob() {
		return hireJob;
	}
	public void setHireJob(String hireJob) {
		this.hireJob = hireJob;
	}
	public Integer getJobLevel() {
		return jobLevel;
	}
	public void setJobLevel(Integer jobLevel) {
		this.jobLevel = jobLevel;
	}
}
