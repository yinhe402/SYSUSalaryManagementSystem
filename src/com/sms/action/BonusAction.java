package com.sms.action;
import java.io.*;
import java.util.*;

import javax.annotation.Resource;

import org.hibernate.Session;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sms.dao.IEmployeeDao;
import com.sms.dao.IFinalBonusDao;
import com.sms.dao.IOffInfoDao;
import com.sms.entity.Employee;
import com.sms.entity.FinalBonus;
import com.sms.entity.FinalCheck;
import com.sms.entity.OffInfo;
import com.sms.exception.ExcelException;
import com.sms.service.IEmployeeManage;
import com.sms.service.IFinalBonusManage;
import com.sms.service.IFinalCheckManage;
import com.sms.service.IOffInfoManage;
import com.sms.service.ISalaryManage;
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
	@Resource
	private IOffInfoManage offInfoManage;
	@Resource
	private ISalaryManage salaryManage;
	
	private File testResultFile;
	private File offInfoFile;
	public File getOffInfoFile() {
		return offInfoFile;
	}

	public void setOffInfoFile(File offInfoFile) {
		this.offInfoFile = offInfoFile;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<FinalBonus> getResult() {
		return result;
	}

	public void setResult(List<FinalBonus> result) {
		this.result = result;
	}

	private String type;
	private List<FinalBonus> result;
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
			FinalBonus finalBonus = new FinalBonus();
			List<OffInfo> offInfosThisYear = offInfoManage.findOffInfoThisYear(); 
			for (FinalCheck c : checks) {
				finalCheckManage.addFinalCheck(c);
				if (c.getCheckResult().equals("基本称职")||c.getCheckResult().equals("不称职")) {
					finalBonus.setBasis(0);
					finalBonus.setCutReason(" 考核结果为:"+c.getCheckResult());
					finalBonus.setDoubleSalaryType("不发");
					finalBonus.setEId(c.getEId());
					finalBonus.setMonths(0.0);
					finalBonus.setYear(c.getYear());
					finalBonusManage.addFinalBonus(finalBonus);
				}
				else {
					List<OffInfo> offInfos = offInfoManage.findOffInfoThisYearByEId(c.getEId());	
					System.out.println(offInfos.size());
						if(offInfos.isEmpty()) {
							finalBonus.setBasis(salaryManage.findLastSalaryByEId(c.getEId()).getTotleSalary());
							finalBonus.setCutReason("无");
							finalBonus.setDoubleSalaryType("全部双薪");
							finalBonus.setEId(c.getEId());
							finalBonus.setMonths(12.0);
							finalBonus.setYear(c.getYear());
							finalBonusManage.addFinalBonus(finalBonus);
						}
						else {
							Integer offDay = 0;
							for(OffInfo o:offInfos) {
								Date startDate = (o.getStartDate().getYear() < new Date().getYear())?new Date(new Date().getYear(),0,1):o.getStartDate();
								Date endDate = (o.getEndDate().getYear() > new Date().getYear())?new Date(new Date().getYear(),11,31):o.getEndDate();
								System.out.println(startDate);
								System.out.println(endDate);
								offDay += (int) ((endDate.getTime()-startDate.getTime())/1000 / 60 / 60 / 24); 
								
							}
							System.out.println(offDay);
							double offMonth = ((int)(offDay / 15))/2.0f;
							System.out.println(offMonth);
							if(offMonth < 0.5) {
								finalBonus.setBasis(0);
								finalBonus.setCutReason("全年请假");
								finalBonus.setDoubleSalaryType("不发");
								finalBonus.setEId(c.getEId());
								finalBonus.setMonths(0.0);
								finalBonus.setYear(c.getYear());
								finalBonusManage.addFinalBonus(finalBonus);
							} else	if (offMonth > 11.5) {
								finalBonus.setBasis(salaryManage.findLastSalaryByEId(c.getEId()).getTotleSalary());
								finalBonus.setCutReason("无");
								finalBonus.setDoubleSalaryType("全部双薪");
								finalBonus.setEId(c.getEId());
								finalBonus.setMonths(12.0);
								finalBonus.setYear(c.getYear());
								finalBonusManage.addFinalBonus(finalBonus);	
							}
							finalBonus.setBasis(salaryManage.findLastSalaryByEId(c.getEId()).getTotleSalary());
							finalBonus.setCutReason("请假或者出国累计达"+offMonth+"个月");
							finalBonus.setDoubleSalaryType("部分双薪");
							finalBonus.setEId(c.getEId());
							finalBonus.setMonths(12.0-offMonth);
							finalBonus.setYear(c.getYear());
							finalBonusManage.addFinalBonus(finalBonus);
						}
				}
			}
			
		}
		
		return "success";
	}
	
	public String getSalaryResult() {
		List<FinalBonus> noBonusList = finalBonusManage.findFinalBonusByDoubleBonusType("不发");
		List<FinalBonus> partBonusList = finalBonusManage.findFinalBonusByDoubleBonusType("部分双薪");
		List<FinalBonus> allBonusList = finalBonusManage.findFinalBonusByDoubleBonusType("全部双薪");
		System.out.print(type);
		result = finalBonusManage.findFinalBonusByDoubleBonusType(type);
		
		result = finalBonusManage.findFinalBonusByDoubleBonusType(type);
		System.out.println(result);
		Map session = ActionContext.getContext().getSession();
		session.put("result", result);
		session.put("type", type);
         return "success";
	}
	
	public String importOffInfoResult() throws FileNotFoundException, ExcelException {
		List<OffInfo> checks = new ArrayList<OffInfo>();
		InputStream in = new FileInputStream(offInfoFile);
		LinkedHashMap<String, String> fieldMap = new LinkedHashMap<String, String>();
		fieldMap.put("职工号", "eid");
		fieldMap.put("开始时间", "startDate");
		fieldMap.put("结束时间", "endDate");
		fieldMap.put("原因", "reason");
		String[] uniqueFields = {"职工号", "开始时间", "结束时间", "原因"};
		checks = ExcelUtil.excelToList(in, "Sheet1", OffInfo.class, fieldMap, uniqueFields);
		for(OffInfo o:checks) {
			offInfoManage.addOffInfo(o);
		}
		return "success";

	}
}
