package com.sms.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sms.entity.Employee;
import com.sms.entity.ExperienceInfo;
import com.sms.entity.StartSalaryInfo;
import com.sms.service.IEmployeeManage;
import com.sms.service.IManageSalaryManage;
import com.sms.service.IProfSalaryManage;
import com.sms.service.IStartSalaryInfoManage;
import com.sms.service.IWorkerSalaryManage;
import com.sms.service.LevelSalaryChange;

public class NewEmployeeAction extends ActionSupport {
	
	private StartSalaryInfo startSalaryInfo;
	
	public StartSalaryInfo getStartSalaryInfo() {
		return startSalaryInfo;
	}

	public void setStartSalaryInfo(StartSalaryInfo startSalaryInfo) {
		this.startSalaryInfo = startSalaryInfo;
	}
	
	//参加工作时间
	private String startWorkYear;

	public String getStartWorkYear() {
		return startWorkYear;
	}

	public void setStartWorkYear(String startWorkYear) {
		this.startWorkYear = startWorkYear;
	}
	
	//考核不成功的次数
	private int failTime;	
	
	public int getFailTime() {
		return failTime;
	}

	public void setFailTime(int failTime) {
		this.failTime = failTime;
	}


	private int i;
	private int j;
	private int k;
	private int l;
	private int m;
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}

	public int getL() {
		return l;
	}

	public void setL(int l) {
		this.l = l;
	}
	
	public int getM() {
		return m;
	}
	
	public void setM(int m) {
		this.m = m;
	}

	@Resource
	private IStartSalaryInfoManage startSalaryInfoManage;

	public IStartSalaryInfoManage getStartSalaryInfoManage() {
		return startSalaryInfoManage;
	}

	public void setStartSalaryInfoManage(
			IStartSalaryInfoManage startSalaryInfoManage) {
		this.startSalaryInfoManage = startSalaryInfoManage;
	}

	private Employee employee;

	@Resource
	private IEmployeeManage employeeManage;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setEmployeeManage(IEmployeeManage employeeManage) {
		this.employeeManage = employeeManage;
	}

	public IEmployeeManage getEmployeeManage() {
		return employeeManage;
	}

	@Resource
	private IManageSalaryManage manageSalaryManage;

	public IManageSalaryManage getManageSalaryManage() {
		return manageSalaryManage;
	}

	public void setManageSalaryManage(IManageSalaryManage manageSalaryManage) {
		this.manageSalaryManage = manageSalaryManage;
	}
	
	@Resource
	private IProfSalaryManage profSalaryManage;	

	public IProfSalaryManage getProfSalaryManage() {
		return profSalaryManage;
	}

	public void setProfSalaryManage(IProfSalaryManage profSalaryManage) {
		this.profSalaryManage = profSalaryManage;
	}
	
	@Resource
	private IWorkerSalaryManage workerSalaryManage;	

	public IWorkerSalaryManage getWorkerSalaryManage() {
		return workerSalaryManage;
	}

	public void setWorkerSalaryManage(IWorkerSalaryManage workerSalaryManage) {
		this.workerSalaryManage = workerSalaryManage;
	}

	public static boolean isValid(int value) {
		if (value >= 100000 && value <= 999999)
			return true;
		return false;
	}

	public String importStaff() {
		System.out.println("-------startSalaryInfoAction.importStaff--------" + startSalaryInfo.getEid());
		if (isValid(startSalaryInfo.getEid())) {
			HttpServletRequest request = ServletActionContext.getRequest();
			startSalaryInfo.setOperateDate(new Date());
			
			Date attendWorkDate = LevelSalaryChange.strToDate(startWorkYear);
			
			ArrayList<Date> array1 = new ArrayList<Date>(), array2 = new ArrayList<Date>();
			ArrayList<ExperienceInfo> manageList = new ArrayList<ExperienceInfo>(), techList = new ArrayList<ExperienceInfo>(), eduList = new ArrayList<ExperienceInfo>(), worList = new ArrayList<ExperienceInfo>();
			
			System.out.println(manageSalaryManage.getPayLevel(6, 2, 15));
			
			System.out.println("管理i:"+i);
			System.out.println("专技j:"+j);
			System.out.println("教育k:"+k);
			System.out.println("中断l:"+l);
			System.out.println("工人m:"+m);
			
			for (int count = 0; count < i; count++) {
				System.out.println(request.getParameter("manExperience"+count));
				System.out.println(request.getParameter("manWorkDate"+count));
				manageList.add(new ExperienceInfo(request.getParameter("manExperience"+count), Integer.parseInt(request.getParameter("manWorkDate"+count))));
			}
			
			for (int count = 0; count < j; count++) {
				System.out.println(request.getParameter("proExperience"+count));
				System.out.println(request.getParameter("proWorkDate"+count));
				techList.add(new ExperienceInfo(request.getParameter("proExperience"+count), Integer.parseInt(request.getParameter("proWorkDate"+count))));
			}
			
			for (int count = 0; count < k; count++) {
				System.out.println(request.getParameter("eduExperience"+count));
				System.out.println(request.getParameter("eduWorkDate"+count));
				eduList.add(new ExperienceInfo(request.getParameter("eduExperience"+count), Integer.parseInt(request.getParameter("eduWorkDate"+count))));
			}
			
			for (int count = 0; count < m; count++) {
				System.out.println(request.getParameter("workerExperience"+count));
				System.out.println(request.getParameter("workerWorkDate"+count));
				worList.add(new ExperienceInfo(request.getParameter("workerExperience"+count), Integer.parseInt(request.getParameter("workerWorkDate"+count))));
			}
			
			for (int count = 0; count < l; count++) {
				System.out.println(request.getParameter("breakStartDate"+count));
				System.out.println(request.getParameter("breakEndDate"+count));
				array1.add(LevelSalaryChange.strToDate(request.getParameter("breakStartDate"+count)));
				array2.add(LevelSalaryChange.strToDate(request.getParameter("breakEndDate"+count)));
			}
			
			startSalaryInfo.setBreakOffSeniority(LevelSalaryChange.getBreakUpYears(array1, array2, l));//获取中断工龄

			startSalaryInfo.setWorkYears(LevelSalaryChange.getRealWorkTime(attendWorkDate, array1, array2, l));//获取实际工作年限
			
			startSalaryInfo.setSeniorityBeforeWork(LevelSalaryChange.getBeforeWorkTime(eduList));//获取工作前工龄
			
			startSalaryInfo.setLearnSeniority(LevelSalaryChange.getStudyInSchoolTime(eduList));//获取大专以上不计工龄年限
			
			startSalaryInfo.setChangeYears(LevelSalaryChange.getSalaryChangeYears(attendWorkDate, array1, array2, l, eduList, failTime));//获取套改年限
			System.out.println("套改年限：  "+startSalaryInfo.getChangeYears());
			
			startSalaryInfo.setHireYears(LevelSalaryChange.getOfficeTime(manageList, techList, eduList, attendWorkDate, array1, array2, l, failTime, worList));//获取任职年限
			
			startSalaryInfo.setSalaryLevel(LevelSalaryChange.getSalaryLevel(manageList, techList, eduList, attendWorkDate, array1, array2, l, failTime, worList));//获取薪级
			
			if (startSalaryInfo.getSalarySeries() == "管理") {
				startSalaryInfo.setPositionSalary(manageSalaryManage.findManPosSalByLevel(startSalaryInfo.getPositionLevel()).getSalaryStandard());
				startSalaryInfo.setLevelSalary(manageSalaryManage.findManPaySalByPayLevel(startSalaryInfo.getSalaryLevel()).getSalaryStandard());
			} else if (startSalaryInfo.getSalarySeries() == "专技") {
				startSalaryInfo.setPositionSalary(profSalaryManage.findProfPosSalByLevel(startSalaryInfo.getPositionLevel()).getSalaryStandard());
				startSalaryInfo.setLevelSalary(profSalaryManage.findProfPaySalByPayLevel(startSalaryInfo.getSalaryLevel()).getSalaryStandard());
			} else if (startSalaryInfo.getSalarySeries() == "工人") {
				startSalaryInfo.setPositionSalary(workerSalaryManage.findWorkerPosSalByLevel(startSalaryInfo.getPositionLevel()).getSalaryStandard());
				startSalaryInfo.setLevelSalary(workerSalaryManage.findWorkerPaySalByPayLevel(startSalaryInfo.getSalaryLevel()).getSalaryStandard());
			}
			
			startSalaryInfoManage.addStartSalaryInfo(startSalaryInfo);
			
			Map session = ActionContext.getContext().getSession();
			session.put("ssInfo", startSalaryInfo);
			session.put("mList", manageList);
			session.put("tList", techList);
			session.put("wList", worList);
			session.put("eList", eduList);
			session.put("fTime", failTime);
			
			return "success";
		}
		return "fail";
	}
}
