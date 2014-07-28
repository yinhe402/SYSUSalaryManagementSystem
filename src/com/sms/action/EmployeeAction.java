package com.sms.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.omg.CORBA.Request;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sms.entity.Employee;
import com.sms.exception.ExcelException;
import com.sms.security.Md5;
import com.sms.service.IEmployeeManage;
import com.sms.service.IUserManage;
import com.sms.util.ExcelUtil;

public class EmployeeAction extends ActionSupport {

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
	
	private File employeeFile;

	public File getEmployeeFile() {
		return employeeFile;
	}

	public void setEmployeeFile(File employeeFile) {
		this.employeeFile = employeeFile;
	}

	public static boolean isValid(int value) {
		if (value >= 100000 && value <= 999999)
			return true;
		return false;
	}

	public String addEmployee() {
		System.out.println("-------employeeAction.addEmployee--------"
				+ employee.getId());
		if (isValid(employee.getId())) {
			employeeManage.addEmployee(employee);
			ActionContext.getContext().getSession()
					.put("addedEmployee", employee);
			return "success";
		}
		return "fail";
	}

	public String modifyEmployee() {
		System.out.println("-------employeeAction.modifyEmployee--------"
				+ employee.getId());
		if (isValid(employee.getId())
				&& employeeManage.findEmployeeById(employee.getId()) != null) {
			employeeManage.modifyEmployee(employee);
			return "success";
		}
		return "fail";
	}

	public String getEmployeeInfo() {
		System.out.println("-------employeeAction.getEmployeeInfo--------"
				+ employee.getId());
		if (employee.getId() == null)
			return "fail";
		if (isValid(employee.getId())
				&& employeeManage.findEmployeeById(employee.getId()) != null) {
			Integer eid = employee.getId();
			employee = employeeManage.findEmployeeById(eid);
			Map session = ActionContext.getContext().getSession();
			session.put("eInfo", employee);
			return "success";
		}
		return "fail";
	}
	
	public String importEmployeeInfo() throws FileNotFoundException, ExcelException {
		if (employeeFile != null) {
			String filePath = employeeFile.getAbsolutePath();
			List<Employee> employeeList = new ArrayList<Employee>();
			InputStream in = new FileInputStream(employeeFile);
			LinkedHashMap fieldMap = new LinkedHashMap<String, String>();
			fieldMap.put("职工号", "id");
			fieldMap.put("姓名", "name");
			fieldMap.put("邮箱", "email");
			fieldMap.put("性别", "gender");
			fieldMap.put("出生日期", "birthday");
			fieldMap.put("身份证号", "uid");
			fieldMap.put("单位", "department");
			fieldMap.put("岗位性质", "jobType");
			fieldMap.put("人员身份", "type");
			fieldMap.put("进校来源", "source");
			fieldMap.put("入校报到时间", "reachSchoolDate");
			fieldMap.put("最高学历", "maxEducation");
			fieldMap.put("最高学历获得时间", "maxEducationDate");
			fieldMap.put("最高学位", "maxDegree");
			fieldMap.put("最高学位获得时间", "maxDegreeDate");
			fieldMap.put("聘任职务", "hireWork");
			fieldMap.put("职务级别", "workLevel");
			fieldMap.put("任职时间", "startWorkDate");
			fieldMap.put("聘任职称", "hireTitle");
			fieldMap.put("职称级别", "titleLevel");
			fieldMap.put("聘任时间", "hireDate");
			fieldMap.put("（拟）聘任岗位", "hireJob");
			fieldMap.put("聘岗级别", "jobLevel");
			String[] uniqueFields = {"职工号"};
			Employee employee = new Employee();
			
			employeeList = ExcelUtil.excelToList(in, "Sheet1", Employee.class, fieldMap, uniqueFields);
			
			for (Employee e : employeeList) {
				
				System.out.println(e.getHireTitle());
				System.out.println(e.getType());
				
				employeeManage.addEmployee(e);
			}
		}
		return "success";
	}

}
