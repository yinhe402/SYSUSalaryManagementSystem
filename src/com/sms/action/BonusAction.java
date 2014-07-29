package com.sms.action;

<<<<<<< HEAD
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.sms.dao.IEmployeeDao;
import com.sms.dao.IFinalBonusDao;
import com.sms.entity.Employee;
import com.sms.entity.FinalCheck;
import com.sms.exception.ExcelException;
import com.sms.service.IEmployeeManage;
import com.sms.service.IFinalBonusManage;
import com.sms.service.IFinalCheckManage;
import com.sms.util.ExcelUtil;

public class BonusAction extends ActionSupport {
	@Resource
	private IFinalBonusManage finalBonusManage;
	public IFinalBonusManage getFinalBonusManage() {
		return finalBonusManage;
	}

	public void setFinalBonusManage(IFinalBonusManage finalBonusManage) {
		this.finalBonusManage = finalBonusManage;
	}

	public IFinalCheckManage getFinalCheckManage() {
		return finalCheckManage;
	}

	public void setFinalCheckManage(IFinalCheckManage finalCheckManage) {
		this.finalCheckManage = finalCheckManage;
	}

	public File getTestResultFile() {
		return testResultFile;
	}

	public void setTestResultFile(File testResultFile) {
		this.testResultFile = testResultFile;
	}

	@Resource
	private IFinalCheckManage finalCheckManage;
	@Resource
	private IEmployeeManage employeeManage;
	
	private File testResultFile;
	
	public String importTestResult() throws FileNotFoundException, ExcelException {
		if (null != testResultFile) {
			List<FinalCheck> checks = new ArrayList<FinalCheck>();
			InputStream in = new FileInputStream(testResultFile);
			LinkedHashMap<String, String> fieldMap = new LinkedHashMap<String, String>();
			fieldMap.put("职工号", "eId");
			fieldMap.put("年份", "year");
			fieldMap.put("考核结果", "checkResult");
			String[] uniqueFields = {"职工号", "年份"};
			checks = ExcelUtil.excelToList(in, "Sheet1", FinalCheck.class, fieldMap, uniqueFields);
			for (FinalCheck c : checks) {
				finalCheckManage.addFinalCheck(c);
			}
			
		}
		
		return "success";
	}
	
	public String getSalaryResult() {
		return null;
	}
=======
import com.opensymphony.xwork2.ActionSupport;

public class BonusAction extends ActionSupport {

>>>>>>> 59aab23f38f4fe332996db6350fc09af5feb7b9e
}
