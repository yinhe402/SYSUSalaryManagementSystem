package com.sms.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.context.annotation.Primary;
@Entity
@Table(name="employee")
public class Employee {
	
	private Integer id;//职工号
	private String name;//姓名
	private String email;//邮箱
	private String gender;//性别
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
		System.out.println(id);
		this.id = id;
	}
	
	/**
	 * 姓名 
	 * */
	@Column(name="name", length=20, nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println(name);
		this.name = name;
	}
	
	/**
	 * 邮箱
	 * */
	@Column(name="email", length=40)
	public String getEmail() {
		
		return email;
	}
	public void setEmail(String email) {
		System.out.println(email);
		this.email = email;
	}
	
	/**
	 * 性别
	 * */
	@Column(name="gender", nullable=false)
	public String getGender() {	
		return gender;
	}
	public void setGender(String gender) {
		System.out.println(gender);
		this.gender = gender;
	}
	
	/**
	 * 出生日期
	 * */
	@Column(name="birthday", nullable=false)
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		System.out.println(birthday);
		this.birthday = birthday;
	}
	
	/**
	 * 身份证号
	 * */
	@Column(name="uid", length = 20, nullable=false)
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		System.out.println(uid);
		this.uid = uid;
	}
	
	/**
	 * 单位
	 * */
	@Column(name="department", length = 10, nullable=false)
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		System.out.println(department);
		
		this.department = department;
	}
	
	/**
	 * 岗位性质
	 * */
	@Column(name="job_type", length = 10, nullable=false)
	public String getJobType() {
		
		return jobType;
	}
	public void setJobType(String jobType) {
		System.out.println(jobType);
		this.jobType = jobType;
	}
	
	/**
	 * 人员身份
	 * */
	@Column(name="type", length = 10)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		System.out.println(type);
		this.type = type;
	}
	
	/**
	 * 入校来源
	 * */
	@Column(name="source", length = 10)
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		System.out.println(source);
		this.source = source;
	}
	
	/**
	 * 进校时间
	 * */
	@Column(name="reach_school_date")
	public Date getReachSchoolDate() {
		return reachSchoolDate;
	}
	public void setReachSchoolDate(Date reachSchoolDate) {
		System.out.println(reachSchoolDate);
		this.reachSchoolDate = reachSchoolDate;
	}
	
	/**
	 * 最高学历
	 * */
	@Column(name="max_education", length=20, nullable=false)
	public String getMaxEducation() {
		return maxEducation;
	}
	
	public void setMaxEducation(String maxEducation) {
		System.out.println(maxEducation);
		this.maxEducation = maxEducation;
	}
	
	/**
	 * 最高学历获得时间
	 * */
	@Column(name="max_education_date", nullable=false)
	public Date getMaxEducationDate() {
		return maxEducationDate;
	}
	
	public void setMaxEducationDate(Date maxEducationDate) {
		System.out.println(maxEducationDate);
		this.maxEducationDate = maxEducationDate;
	}
	
	/**
	 * 最高学位
	 * */
	@Column(name="max_degree", length=20, nullable=false)
	public String getMaxDegree() {
		return maxDegree;
	}
	public void setMaxDegree(String maxDegree) {
		System.out.println(maxDegree);
		this.maxDegree = maxDegree;
	}
	
	/**
	 * 最高学位获得时间
	 * */
	@Column(name="max_degree_date", nullable=false)
	public Date getMaxDegreeDate() {
		return maxDegreeDate;
	}
	public void setMaxDegreeDate(Date maxDegreeDate) {
		System.out.println(maxDegreeDate);
		this.maxDegreeDate = maxDegreeDate;
	}
	
	/**
	 * 聘任职务
	 * */
	@Column(name="hire_work")
	public String getHireWork() {
		return hireWork;
	}
	
	
	public void setHireWork(String hireWork) {
		System.out.println(hireWork);
		this.hireWork = hireWork;
	}
	
	/**
	 * 聘任级别
	 * */
	@Column(name="work_level")
	public Integer getWorkLevel() {
		return workLevel;
	}
	public void setWorkLevel(Integer workLevel) {
		System.out.println("职务级别："+workLevel);
		this.workLevel = workLevel;
	}
	
	/**
	 * 任职时间
	 * */
	@Column(name="start_work_date")
	public Date getStartWorkDate() {
		return startWorkDate;
	}
	public void setStartWorkDate(Date startWorkDate) {
		System.out.println(startWorkDate);
		this.startWorkDate = startWorkDate;
	}
	
	/**
	 * 聘任职称
	 * */
	@Column(name="hire_title", length=30)
	public String getHireTitle() {
		return hireTitle;
	}
	public void setHireTitle(String hireTitle) {
		this.hireTitle = hireTitle;
		System.out.println(hireTitle);
	}
	
	/**
	 * 职称级别
	 * */
	@Column(name="title_level")
	public Integer getTitleLevel() {
		return titleLevel;
	}
	public void setTitleLevel(Integer titleLevel) {
		this.titleLevel = titleLevel;
		System.out.println("职称级别："+titleLevel);
	}
	
	/**
	 * 聘任时间
	 * */
	@Column(name="hire_date")
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
		System.out.println(hireDate);
	}
	
	/**
	 * 聘任岗位 
	 * */
	@Column(name="hire_job", length=20)
	public String getHireJob() {
		return hireJob;
	}
	public void setHireJob(String hireJob) {
		this.hireJob = hireJob;
		System.out.println(hireJob);
	}
	
	/**
	 * 岗位级别
	 * */
	@Column(name="job_level")
	public Integer getJobLevel() {
		return jobLevel;
	}
	public void setJobLevel(Integer jobLevel) {
		this.jobLevel = jobLevel;
		System.out.println("岗位级别"+jobLevel);
	}
}
