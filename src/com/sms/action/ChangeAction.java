package com.sms.action;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.omg.CORBA.Current;

import com.sms.entity.DepartmentChange;
import com.sms.entity.ExperienceInfo;
import com.sms.entity.Experiences;
import com.sms.entity.OffInfo;
import com.sms.exception.ExcelException;
import com.sms.service.IDepartmentChangeManage;
import com.sms.service.IEmployeeManage;
import com.sms.service.IExperiencesManage;
import com.sms.service.IManageSalaryManage;
import com.sms.service.IOffInfoManage;
import com.sms.service.IProfSalaryManage;
import com.sms.service.IStartSalaryInfoManage;
import com.sms.service.IWorkerSalaryManage;
import com.sms.service.impl.EmployeeManageImp;
import com.sms.util.ExcelUtil;

import java.util.Date;

public class ChangeAction {

	private DepartmentChange departmentChange;

	public DepartmentChange getDepartmentChange() {
		return departmentChange;
	}

	public void setDepartmentChange(DepartmentChange departmentChange) {
		this.departmentChange = departmentChange;
	}

	@Resource
	private IDepartmentChangeManage departmentChangeManage;

	public IDepartmentChangeManage getDepartmentChangeManage() {
		return departmentChangeManage;
	}

	public void setDepartmentChangeManage(
			IDepartmentChangeManage departmentChangeManage) {
		this.departmentChangeManage = departmentChangeManage;
	}

	@Resource
	private IEmployeeManage employeeManage;

	public IEmployeeManage getEmployeeManage() {
		return employeeManage;
	}

	public void setEmployeeManage(IEmployeeManage employeeManage) {
		this.employeeManage = employeeManage;
	}

	// 职工号是否有效
	public static boolean isValid(int value) {
		if (value >= 100000 && value <= 999999)
			return true;
		return false;
	}

	public String SchoolInnerChange() {
		System.out.println("-------changeAction.SchoolInnerChange--------"
				+ departmentChange.getEId());
		if (!isValid(departmentChange.getEId()))
			return "fail";
		if (employeeManage.findEmployeeById(departmentChange.getEId()) == null)
			return "fail";
		if (employeeManage.findEmployeeById(departmentChange.getEId())
				.getName().equals(departmentChange.getName())
				&& employeeManage.findEmployeeById(departmentChange.getEId())
						.getDepartment()
						.equals(departmentChange.getOldDepartment())) {
			employeeManage.findEmployeeById(departmentChange.getEId())
					.setDepartment(departmentChange.getNewDepartment());
			departmentChangeManage.addDepartmentChange(departmentChange);
			return "success";
		}
		return "fail";
	}

	public String InfoExport() {
		System.out.println("-------changeAction.InfoExport--------"
				+ departmentChange.getEId());
		/*
		 * if (SchoolInnerChange().equals("success")true) {
		 * List<DepartmentChange> lst = new ArrayList<DepartmentChange>();
		 * DepartmentChange newDepartmentChange = new DepartmentChange();
		 * 
		 * newDepartmentChange.setId(departmentChange.getId());
		 * newDepartmentChange.setEId(departmentChange.getEId());
		 * newDepartmentChange.setName(departmentChange.getName());
		 * newDepartmentChange
		 * .setOldDepartment(departmentChange.getOldDepartment());
		 * newDepartmentChange
		 * .setNewDepartment(departmentChange.getNewDepartment());
		 * newDepartmentChange.setAccording(departmentChange.getAccording());
		 * newDepartmentChange.setDepChangeDate(new Date());
		 * newDepartmentChange.setNote(departmentChange.getNote());
		 * lst.add(newDepartmentChange);
		 * System.out.println(lst.get(0).getAccording());
		 * 
		 * LinkedHashMap fieldMap = new LinkedHashMap<String, String>();
		 * fieldMap.put("eId", "职工号"); fieldMap.put("name", "姓名");
		 * fieldMap.put("oldDepartment", "原工作单位"); fieldMap.put("newDepartment",
		 * "新工作单位"); fieldMap.put("according", "变更依据"); fieldMap.put("note",
		 * "备注");
		 * 
		 * String fileName = "InnerChangeStartSalary"; HttpServletResponse
		 * response = null; response = ServletActionContext.getResponse();
		 * response.reset();
		 * response.setContentType("application/vnd.ms-excel"); //改成输出excel文件
		 * response
		 * .setHeader("Content-disposition","attachment; filename="+fileName
		 * +".xls" );
		 * 
		 * try { OutputStream output = response.getOutputStream();
		 * ExcelUtil.listToExcel(lst, fieldMap, "内部调动起薪表", output); } catch
		 * (Exception e) { e.printStackTrace(); }
		 * 
		 * return null; }
		 */
		/* return "fail"; */
		if (SchoolInnerChange().equals("success")) {
			List<DepartmentChange> lst = new ArrayList<DepartmentChange>();
			departmentChange.setDepChangeDate(new Date());
			lst.add(departmentChange);
			String[] tableHeader = { "职工号", "姓名", "原工作单位", "新工作单位", "变更依据",
					"备注" };
			short cellNumber = (short) tableHeader.length;
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFCell cell = null;
			HSSFRow row = null;
			HSSFCellStyle style_header = workbook.createCellStyle();
			style_header.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			HSSFCellStyle style_data = workbook.createCellStyle();
			style_data.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			HSSFFont font = workbook.createFont();
			HSSFSheet sheet = workbook.createSheet("InnerChangeStartSalary");
			HSSFHeader header = sheet.getHeader();
			try {
				if (lst.size() < 1) {
					header.setCenter("查无资料");
				} else {
					header.setCenter("InnerChangeStartSalary");
					row = sheet.createRow(0);
					row.setHeight((short) 400);
					for (int k = 0; k < cellNumber; k++) {
						cell = row.createCell(k);
						cell.setCellValue(tableHeader[k]);
						sheet.setColumnWidth(k, 8000);
						font.setColor(HSSFFont.COLOR_NORMAL);
						font.setFontHeight((short) 350);
						style_data.setFont(font);
						cell.setCellStyle(style_data);
					}
					DepartmentChange newDepartmentChange = new DepartmentChange();
					for (int i = 0; i < lst.size(); i++) {
						newDepartmentChange = lst.get(i);
						row = sheet.createRow((short) (i + 1));
						row.setHeight((short) 400);

						cell = row.createCell(0);
						cell.setCellValue(newDepartmentChange.getEId());
						cell.setCellStyle(style_header);

						cell = row.createCell(1);
						cell.setCellValue(newDepartmentChange.getName());
						cell.setCellStyle(style_header);

						cell = row.createCell(2);
						cell.setCellValue(newDepartmentChange
								.getOldDepartment());
						cell.setCellStyle(style_header);

						cell = row.createCell(3);
						cell.setCellValue(newDepartmentChange
								.getNewDepartment());
						cell.setCellStyle(style_header);

						cell = row.createCell(4);
						cell.setCellValue(newDepartmentChange.getAccording());
						cell.setCellStyle(style_header);

						cell = row.createCell(5);
						cell.setCellValue(newDepartmentChange.getNote());
						cell.setCellStyle(style_header);
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			HttpServletResponse response = null;// 创建一个HttpServletResponse对象
			OutputStream out = null;// 创建一个输出流对象
			try {
				response = ServletActionContext.getResponse();// 初始化HttpServletResponse对象
				out = response.getOutputStream();//
				response.setHeader("Content-disposition",
						"attachment; filename=" + "InnerChangeStartSalary.xls");// filename是下载的xls的名，建议最好用英文
				response.setContentType("application/msexcel;charset=UTF-8");// 设置类型
				response.setHeader("Pragma", "No-cache");// 设置头
				response.setHeader("Cache-Control", "no-cache");// 设置头
				response.setDateHeader("Expires", 0);// 设置日期头
				workbook.write(out);
				out.flush();
				workbook.write(out);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (out != null) {
						out.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return null;
		}
		return "fail";
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

	@Resource
	private IExperiencesManage experiencesManage;

	public IExperiencesManage getExperiencesManage() {
		return experiencesManage;
	}

	public void setExperiencesManage(IExperiencesManage experiencesManage) {
		this.experiencesManage = experiencesManage;
	}

	@Resource
	private IOffInfoManage offInfoManage;

	public IOffInfoManage getOffInfoManage() {
		return offInfoManage;
	}

	public void setOffInfoManage(IOffInfoManage offInfoManage) {
		this.offInfoManage = offInfoManage;
	}

	// 字符串到日期格式转化函数，输入字符串，返回日期
	public Date strToDate(String str) {
		String[] divideStr = str.split("-");
		if (divideStr.length == 3) {
			int year = Integer.parseInt(divideStr[0].trim());
			int month = Integer.parseInt(divideStr[1].trim());
			int day = Integer.parseInt(divideStr[2].trim());
			Calendar calendar = Calendar.getInstance();
			calendar.set(year, month - 1, day);
			return calendar.getTime();
		}
		return null;
	}

	// 获取两个日期之间的时间差（四舍五入，精确到月），输入两个日期，输出中断工龄
	public int dateDif(Date d1, Date d2) {
		int yearDif = d2.getYear() - d1.getYear();
		int monthDif = d2.getMonth() - d1.getMonth();
		int dayDif = d2.getDay() - d1.getDay();

		if (monthDif < 0) {
			yearDif = yearDif - 1;
			monthDif = 12 + monthDif;
		}
		if (dayDif < 0) {
			monthDif = monthDif - 1;
			dayDif = 30 + dayDif;
		}

		System.out.println("起始时间:" + d1);
		System.out.println("恢复时间:" + d2);
		System.out.println("中断时间" + yearDif + "年" + monthDif + "月");
		if ((monthDif == 6 && dayDif > 0) || monthDif > 6) {
			return yearDif + 1;
		} else {
			return yearDif;
		}
	}

	// 获取管理系列任职时间
	public int getManageOfficeTime(int mLevel, int manageMinYear,
			ArrayList<ExperienceInfo> techList) {
		int minTechYear = 2006;
		int techLength = techList.size();

		if (mLevel == 7) {
			for (int i = 0; i < techLength; i++) {
				if (techList.get(i).getGanhuoLevel() >= 10
						&& techList.get(i).getGanhuoLevel() <= 13) {
					if (techList.get(i).getTime() < minTechYear) {
						minTechYear = techList.get(i).getTime();
					}
				}
			}
			minTechYear = minTechYear + 5;
		} else if (mLevel == 6) {
			for (int i = 0; i < techLength; i++) {
				if (techList.get(i).getGanhuoLevel() >= 10
						&& techList.get(i).getGanhuoLevel() <= 13) {
					if (techList.get(i).getTime() < minTechYear) {
						minTechYear = techList.get(i).getTime();
					}
				}
			}
		} else if (mLevel == 5) {
			for (int i = 0; i < techLength; i++) {
				if (techList.get(i).getGanhuoLevel() >= 7
						&& techList.get(i).getGanhuoLevel() <= 13) {
					if (techList.get(i).getTime() < minTechYear) {
						minTechYear = techList.get(i).getTime();
					}
				}
			}
			minTechYear = minTechYear + 5;
		} else if (mLevel == 4) {
			for (int i = 0; i < techLength; i++) {
				if (techList.get(i).getGanhuoLevel() >= 4
						&& techList.get(i).getGanhuoLevel() <= 13) {
					if (techList.get(i).getTime() < minTechYear) {
						minTechYear = techList.get(i).getTime();
					}
				}
			}
			minTechYear = minTechYear + 5;
		} else if (mLevel == 3) {
			for (int i = 0; i < techLength; i++) {
				if (techList.get(i).getGanhuoLevel() >= 4
						&& techList.get(i).getGanhuoLevel() <= 13) {
					if (techList.get(i).getTime() < minTechYear) {
						minTechYear = techList.get(i).getTime();
					}
				}
			}
		}

		int minYear = (manageMinYear < minTechYear) ? manageMinYear
				: minTechYear;

		return (2006 - minYear + 1);
	}

	// 获取专技系列任职年限
	public int getTechOfficeTime(int tLevel, int techMinYear,
			ArrayList<ExperienceInfo> manageList) {
		int minManageYear = 2006;
		int manageLength = manageList.size();

		if (tLevel <= 13 && tLevel >= 10) {
			for (int i = 0; i < manageLength; i++) {
				if (manageList.get(i).getGanhuoLevel() >= 6
						&& manageList.get(i).getGanhuoLevel() <= 10) {
					if (manageList.get(i).getTime() < minManageYear) {
						minManageYear = manageList.get(i).getTime();
					}
				}
			}
		} else if (tLevel <= 9 && tLevel >= 7) {
			for (int i = 0; i < manageLength; i++) {
				if (manageList.get(i).getGanhuoLevel() >= 5
						&& manageList.get(i).getGanhuoLevel() <= 10) {
					if (manageList.get(i).getTime() < minManageYear) {
						minManageYear = manageList.get(i).getTime();
					}
				}
			}
		} else if (tLevel <= 6 && tLevel >= 4) {
			for (int i = 0; i < manageLength; i++) {
				if (manageList.get(i).getGanhuoLevel() >= 3
						&& manageList.get(i).getGanhuoLevel() <= 10) {
					if (manageList.get(i).getTime() < minManageYear) {
						minManageYear = manageList.get(i).getTime();
					}
				}
			}
		}

		int minYear = (techMinYear < minManageYear) ? techMinYear
				: minManageYear;

		return (2006 - minYear + 1);
	}

	// 获取中断工龄
	public int getBreakUpYears(ArrayList<Date> array1, ArrayList<Date> array2,
			int arrayNum) {
		int breakUpYears = 0;
		for (int i = 0; i < arrayNum; i++)
			breakUpYears = breakUpYears + dateDif(array1.get(i), array2.get(i));
		System.out.println("中断工龄：" + breakUpYears);
		return breakUpYears;
	}

	// 获取工作前工龄
	public int getBeforeWorkTime(ArrayList<ExperienceInfo> eduList) {
		int beforeWorkTime = 0;
		int eduLength = eduList.size();
		for (int i = 0; i < eduLength; i++) {
			if (eduList.get(i).getGanhuo().equals("博士")) {
				beforeWorkTime = 5;
			} else if (eduList.get(i).getGanhuo().equals("硕士")) {
				if (beforeWorkTime == 0)
					beforeWorkTime = 2;
			}
		}
		return beforeWorkTime;
	}

	// 获取不计算工龄的在校学习时间
	public int getStudyInSchoolTime(ArrayList<ExperienceInfo> eduList) {
		int studyInSchoolTime = 0;
		int eduLength = eduList.size();
		for (int i = 0; i < eduLength; i++) {
			if (eduList.get(i).getGanhuo().equals("本科")) {
				studyInSchoolTime = 4;
			} else if (eduList.get(i).getGanhuo().equals("专科")) {
				if (studyInSchoolTime == 0)
					studyInSchoolTime = 3;
			}
		}
		return studyInSchoolTime;
	}

	// 获取实际工作年限
	public int getRealWorkTime(Date attendWorkDate, ArrayList<Date> array1,
			ArrayList<Date> array2, int arrayNum) {
		Date baseWorkDate = null;// 基本日期，2006年7月1日，之前套改，之后不套改
		String baseDateStr = "2006-07-01";
		baseWorkDate = strToDate(baseDateStr);
		if (attendWorkDate.after(baseWorkDate))
			return 0;

		int realWorkTime = 0;
		realWorkTime = 2006 - (1900 + attendWorkDate.getYear()) + 1
				- getBreakUpYears(array1, array2, arrayNum);
		return realWorkTime;
	}

	// 获取套改年限
	public int getSalaryChangeYears(Date attendWorkDate,
			ArrayList<Date> array1, ArrayList<Date> array2, int arrayNum,
			ArrayList<ExperienceInfo> eduList, int failTime) {
		Date baseWorkDate = null;// 基本日期，2006年7月1日，之前套改，之后不套改
		String baseDateStr = "2006-07-01";
		baseWorkDate = strToDate(baseDateStr);
		if (attendWorkDate.after(baseWorkDate))
			return 0;

		int salaryChangeTime = 0;

		salaryChangeTime = getRealWorkTime(attendWorkDate, array1, array2,
				arrayNum)
				+ getBeforeWorkTime(eduList)
				+ getStudyInSchoolTime(eduList) - failTime;
		return salaryChangeTime;
	}
	
	// 获取任职年限
	public int getOfficeTime(ArrayList<ExperienceInfo> manageList,
			ArrayList<ExperienceInfo> techList,
			ArrayList<ExperienceInfo> eduList, Date attendWorkDate,
			ArrayList<Date> array1, ArrayList<Date> array2, int arrayNum,
			int failTime, ArrayList<ExperienceInfo> worList) {

		Date baseWorkDate = null;// 基本日期，2006年7月1日，之前套改，之后不套改
		String baseDateStr = "2006-07-01";
		baseWorkDate = strToDate(baseDateStr);

		int officeTime = 0;
		int level = 0;
		int wageMax = 0;

		if (worList.size() == 0) {
			if (attendWorkDate.before(baseWorkDate)) {
				// 管理系第一大，第二大
				int manageMaxLevel = 0;
				int manageMinYear1 = 2006;
				int manageSecMaxLevel = 0;
				int manageMinYear2 = 2006;

				// 专技系第一大，第二大
				int techMaxLevel = 0;
				int techMinYear1 = 2006;
				int techSecMaxLevel = 0;
				int techMinYear2 = 2006;

				int manageLength = manageList.size();
				if (manageLength == 0) {
				} else if (manageLength == 1) {
					if (manageList.get(0).getTime() <= 2006) {
						manageMaxLevel = manageList.get(0).getGanhuoLevel();
						manageMinYear1 = manageList.get(0).getTime();
					} else {
						System.out.println("管理系列倒推");
						int posLevel = manageList.get(0).getGanhuoLevel();
						int startPosYear = manageList.get(0).getTime();// 开始任职年份
						while (startPosYear > 2006) {
							if (posLevel == 7) {
								startPosYear = startPosYear - 3;
								posLevel--;
							} else if (posLevel == 6) {
								startPosYear = startPosYear - 2;
								posLevel--;
							} else if (posLevel == 5) {
								startPosYear = startPosYear - 3;
								posLevel--;
							} else if (posLevel == 4) {
								startPosYear = startPosYear - 2;
								posLevel--;
							} else if (posLevel == 3) {
								startPosYear = startPosYear - 3;
								posLevel--;
							}
						}
						manageMaxLevel = posLevel;
						manageMinYear1 = startPosYear;
					}
				} else {
					for (int i = 0; i < manageLength - 1; i++) {
						for (int j = i + 1; j < manageLength; j++) {
							if (manageList.get(i).getGanhuoLevel() < manageList
									.get(j).getGanhuoLevel()) {
								ExperienceInfo tempExperienceInfo = manageList
										.get(i);
								manageList.set(i, manageList.get(j));
								manageList.set(j, tempExperienceInfo);
							}
						}
					}
					int count1 = 0;
					for (int i = 0; i < manageLength; i++) {
						if (manageList.get(i).getTime() <= 2006) {
							if (count1 == 0) {
								manageMaxLevel = manageList.get(i)
										.getGanhuoLevel();
								manageMinYear1 = manageList.get(i).getTime();
								count1++;
							} else if (count1 == 1) {
								manageSecMaxLevel = manageList.get(i)
										.getGanhuoLevel();
								manageMinYear2 = manageList.get(i).getTime();
								break;
							}
						}
					}

					if (count1 == 0) {
						System.out.println("管理系列倒推");
						for (int i = 0; i < manageLength - 1; i++) {
							for (int j = i + 1; j < manageLength; j++) {
								if (manageList.get(i).getTime() > manageList
										.get(j).getTime()) {
									ExperienceInfo tempExperienceInfo = manageList
											.get(i);
									manageList.set(i, manageList.get(j));
									manageList.set(j, tempExperienceInfo);
								}
							}
						}
						int posLevel = manageList.get(0).getGanhuoLevel();
						int startPosYear = manageList.get(0).getTime();// 开始任职年份
						while (startPosYear > 2006) {
							if (posLevel == 7) {
								startPosYear = startPosYear - 3;
								posLevel--;
							} else if (posLevel == 6) {
								startPosYear = startPosYear - 2;
								posLevel--;
							} else if (posLevel == 5) {
								startPosYear = startPosYear - 3;
								posLevel--;
							} else if (posLevel == 4) {
								startPosYear = startPosYear - 2;
								posLevel--;
							} else if (posLevel == 3) {
								startPosYear = startPosYear - 3;
								posLevel--;
							}
						}
						manageMaxLevel = posLevel;
						manageMinYear1 = startPosYear;
					}
				}

				int eduMax = 0;
				for (int i = 0; i < eduList.size(); i++) {
					if (eduList.get(i).getGanhuo().equals("博士")) {
						eduMax = 4;
						break;
					} else if (eduList.get(i).getGanhuo().equals("硕士")) {
						if (eduMax < 3) {
							eduMax = 3;
						}
					} else if (eduList.get(i).getGanhuo().equals("本科")) {
						if (eduMax < 2) {
							eduMax = 2;
						}
					} else if (eduList.get(i).getGanhuo().equals("专科")) {
						if (eduMax < 1) {
							eduMax = 1;
						}
					}
				}

				int techLength = techList.size();
				if (techLength == 0) {
				} else if (techLength == 1) {
					if (techList.get(0).getTime() <= 2006) {
						techMaxLevel = techList.get(0).getGanhuoLevel();
						techMinYear1 = techList.get(0).getTime();
					} else {
						System.out.println("专技系列倒推");
						int payLevel = techList.get(0).getGanhuoLevel();
						int startPayYear = techList.get(0).getTime();// 开始任职年份
						while (startPayYear > 2006) {
							if (payLevel == 13 || payLevel == 12
									|| payLevel == 11 || payLevel == 10) {
								startPayYear = startPayYear - 5;
								payLevel = 9;
							} else if (payLevel == 9 || payLevel == 8
									|| payLevel == 7) {
								if (eduMax == 4) {
									startPayYear = startPayYear - 3;
									payLevel = 6;
								} else {
									startPayYear = startPayYear - 5;
									payLevel = 6;
								}
							} else if (payLevel == 6 || payLevel == 5
									|| payLevel == 4) {
								if (eduMax == 4) {
									startPayYear = startPayYear - 2;
									payLevel = 3;
								} else if (eduMax == 3) {
									startPayYear = startPayYear - 3;
									payLevel = 3;
								} else if (eduMax == 2) {
									startPayYear = startPayYear - 4;
									payLevel = 3;
								} else if (eduMax == 1) {
									startPayYear = startPayYear - 5;
									payLevel = 3;
								} else {
									startPayYear = startPayYear - 5;
									payLevel = 3;
								}
							}
						}
						techMaxLevel = payLevel;
						techMinYear1 = startPayYear;
					}
				} else {
					for (int i = 0; i < techLength - 1; i++) {
						for (int j = i + 1; j < techLength; j++) {
							if (techList.get(i).getGanhuoLevel() < techList
									.get(j).getGanhuoLevel()) {
								ExperienceInfo tempExperienceInfo = techList
										.get(i);
								techList.set(i, techList.get(j));
								techList.set(j, tempExperienceInfo);
							}
						}
					}
					int count2 = 0;
					for (int i = 0; i < techLength; i++) {
						if (techList.get(i).getTime() <= 2006) {
							if (count2 == 0) {
								techMaxLevel = techList.get(i).getGanhuoLevel();
								techMinYear1 = techList.get(i).getTime();
								count2++;
							} else if (count2 == 1) {
								techSecMaxLevel = techList.get(i)
										.getGanhuoLevel();
								techMinYear2 = techList.get(i).getTime();
								break;
							}
						}
					}

					if (count2 == 0) {
						System.out.println("专技系列倒推");
						for (int i = 0; i < techLength - 1; i++) {
							for (int j = i + 1; j < techLength; j++) {
								if (techList.get(i).getTime() > techList.get(j)
										.getTime()) {
									ExperienceInfo tempExperienceInfo = techList
											.get(i);
									techList.set(i, techList.get(j));
									techList.set(j, tempExperienceInfo);
								}
							}
						}
						int payLevel = techList.get(0).getGanhuoLevel();
						int startPayYear = techList.get(0).getTime();// 开始任职年份
						while (startPayYear > 2006) {
							if (payLevel == 13 || payLevel == 12
									|| payLevel == 11 || payLevel == 10) {
								startPayYear = startPayYear - 5;
								payLevel = 9;
							} else if (payLevel == 9 || payLevel == 8
									|| payLevel == 7) {
								if (eduMax == 4) {
									startPayYear = startPayYear - 3;
									payLevel = 6;
								} else {
									startPayYear = startPayYear - 5;
									payLevel = 6;
								}
							} else if (payLevel == 6 || payLevel == 5
									|| payLevel == 4) {
								if (eduMax == 4) {
									startPayYear = startPayYear - 2;
									payLevel = 3;
								} else if (eduMax == 3) {
									startPayYear = startPayYear - 3;
									payLevel = 3;
								} else if (eduMax == 2) {
									startPayYear = startPayYear - 4;
									payLevel = 3;
								} else if (eduMax == 1) {
									startPayYear = startPayYear - 5;
									payLevel = 3;
								} else {
									startPayYear = startPayYear - 5;
									payLevel = 3;
								}
							}
						}
						techMaxLevel = payLevel;
						techMinYear1 = startPayYear;
					}
				}

				if (manageMaxLevel == 0) {
					;
				} else {
					if (manageSecMaxLevel == 0) {
						System.out.println("管理系列：");
						int curOfficeTime = getManageOfficeTime(manageMaxLevel,
								manageMinYear1, techList);
						System.out.println("职务等级：  " + manageMaxLevel);
						System.out.println("任职年限：  " + curOfficeTime);
						int curLevel = 0;
						if (manageSalaryManage.getPayLevel(
								11 - manageMaxLevel,
								curOfficeTime,
								getSalaryChangeYears(attendWorkDate, array1,
										array2, arrayNum, eduList, failTime)) != null) {
							curLevel = manageSalaryManage.getPayLevel(
									11 - manageMaxLevel,
									curOfficeTime,
									getSalaryChangeYears(attendWorkDate,
											array1, array2, arrayNum, eduList,
											failTime));
						}
						if (curLevel < manageSalaryManage.findManPosSalByLevel(
								11 - manageMaxLevel).getStartPayLevel())
							curLevel = manageSalaryManage.findManPosSalByLevel(
									11 - manageMaxLevel).getStartPayLevel();
						/*if (curLevel > level) {
							level = curLevel;
							officeTime = curOfficeTime;
						}*/
						if (manageSalaryManage.findManPosSalByLevel(manageMaxLevel).getSalaryStandard() + manageSalaryManage.findManPaySalByPayLevel(manageMaxLevel).getSalaryStandard() > wageMax) {
							wageMax = manageSalaryManage.findManPosSalByLevel(manageMaxLevel).getSalaryStandard() + manageSalaryManage.findManPaySalByPayLevel(manageMaxLevel).getSalaryStandard();
							level = curLevel;
							officeTime = curOfficeTime;
						}
						System.out.println("对应薪级：  " + curLevel);
					} else {
						System.out.println("管理系列1：");
						int officeTime1 = getManageOfficeTime(manageMaxLevel,
								manageMinYear1, techList);
						System.out.println("职务等级：  " + manageMaxLevel);
						System.out.println("任职年限：  " + officeTime1);
						int curLevel1 = 0;
						if (manageSalaryManage.getPayLevel(
								11 - manageMaxLevel,
								officeTime1,
								getSalaryChangeYears(attendWorkDate, array1,
										array2, arrayNum, eduList, failTime)) != null) {
							curLevel1 = manageSalaryManage.getPayLevel(
									11 - manageMaxLevel,
									officeTime1,
									getSalaryChangeYears(attendWorkDate,
											array1, array2, arrayNum, eduList,
											failTime));
						}
						if (curLevel1 < manageSalaryManage
								.findManPosSalByLevel(11 - manageMaxLevel)
								.getStartPayLevel())
							curLevel1 = manageSalaryManage
									.findManPosSalByLevel(11 - manageMaxLevel)
									.getStartPayLevel();
						/*if (curLevel1 > level) {
							level = curLevel1;
							officeTime = officeTime1;
						}*/
						if (manageSalaryManage.findManPosSalByLevel(manageMaxLevel).getSalaryStandard() + manageSalaryManage.findManPaySalByPayLevel(manageMaxLevel).getSalaryStandard() > wageMax) {
							wageMax = manageSalaryManage.findManPosSalByLevel(manageMaxLevel).getSalaryStandard() + manageSalaryManage.findManPaySalByPayLevel(manageMaxLevel).getSalaryStandard();
							level = curLevel1;
							officeTime = officeTime1;
						}
						System.out.println("对应薪级：  " + curLevel1);

						System.out.println("管理系列2：");
						int officeTime2 = getManageOfficeTime(
								manageSecMaxLevel, manageMinYear2, techList);
						System.out.println("职务等级：  " + manageSecMaxLevel);
						System.out.println("任职年限：  " + officeTime1);
						int curLevel2 = 0;
						if (manageSalaryManage.getPayLevel(
								11 - manageSecMaxLevel,
								officeTime2,
								getSalaryChangeYears(attendWorkDate, array1,
										array2, arrayNum, eduList, failTime)) != null) {
							curLevel2 = manageSalaryManage.getPayLevel(
									11 - manageSecMaxLevel,
									officeTime2,
									getSalaryChangeYears(attendWorkDate,
											array1, array2, arrayNum, eduList,
											failTime));
						}
						if (curLevel2 < manageSalaryManage
								.findManPosSalByLevel(11 - manageSecMaxLevel)
								.getStartPayLevel())
							curLevel2 = manageSalaryManage
									.findManPosSalByLevel(
											11 - manageSecMaxLevel)
									.getStartPayLevel();
						/*if (curLevel2 > level) {
							level = curLevel2;
							officeTime = officeTime2;
						}*/
						if (manageSalaryManage.findManPosSalByLevel(manageSecMaxLevel).getSalaryStandard() + manageSalaryManage.findManPaySalByPayLevel(manageSecMaxLevel).getSalaryStandard() > wageMax) {
							wageMax = manageSalaryManage.findManPosSalByLevel(manageSecMaxLevel).getSalaryStandard() + manageSalaryManage.findManPaySalByPayLevel(manageSecMaxLevel).getSalaryStandard();
							level = curLevel2;
							officeTime = officeTime2;
						}
						System.out.println("对应薪级：  " + curLevel2);
					}
				}

				if (techMaxLevel == 0) {
					;
				} else {
					if (techSecMaxLevel == 0) {
						System.out.println("专技系列：");
						int curOfficeTime = getTechOfficeTime(techMaxLevel,
								techMinYear1, manageList);
						System.out.println("职务等级：  " + techMaxLevel);
						System.out.println("任职年限：  " + curOfficeTime);
						int curLevel = 0;
						if (profSalaryManage.getPayLevel(
								techMaxLevel,
								curOfficeTime,
								getSalaryChangeYears(attendWorkDate, array1,
										array2, arrayNum, eduList, failTime)) != null) {
							curLevel = profSalaryManage.getPayLevel(
									techMaxLevel,
									curOfficeTime,
									getSalaryChangeYears(attendWorkDate,
											array1, array2, arrayNum, eduList,
											failTime));
						}
						if (curLevel < profSalaryManage.findProfPosSalByLevel(
								14 - techMaxLevel).getStartPayLevel())
							curLevel = profSalaryManage.findProfPosSalByLevel(
									14 - techMaxLevel).getStartPayLevel();
						/*if (curLevel > level) {
							level = curLevel;
							officeTime = curOfficeTime;
						}*/
						if (profSalaryManage.findProfPosSalByLevel(techMaxLevel).getSalaryStandard() + profSalaryManage.findProfPaySalByPayLevel(techMaxLevel).getSalaryStandard() > wageMax) {
							wageMax = profSalaryManage.findProfPosSalByLevel(techMaxLevel).getSalaryStandard() + profSalaryManage.findProfPaySalByPayLevel(techMaxLevel).getSalaryStandard();
							level = curLevel;
							officeTime = curOfficeTime;
						}
						System.out.println("对应薪级：  " + curLevel);
					} else {
						System.out.println("专技系列1：");
						int officeTime1 = getTechOfficeTime(techMaxLevel,
								techMinYear1, manageList);
						System.out.println("职务等级：  " + techMaxLevel);
						System.out.println("任职年限：  " + officeTime1);
						int curLevel1 = 0;
						if (profSalaryManage == null) {
							System.out.println("ProfSalaryManage is null!");
						}
						System.out.println(techMaxLevel);
						System.out.println(officeTime1);
						System.out.println(getSalaryChangeYears(attendWorkDate,
								array1, array2, arrayNum, eduList, failTime));
						if (profSalaryManage.getPayLevel(
								techMaxLevel,
								officeTime1,
								getSalaryChangeYears(attendWorkDate, array1,
										array2, arrayNum, eduList, failTime)) != null) {
							curLevel1 = profSalaryManage.getPayLevel(
									techMaxLevel,
									officeTime1,
									getSalaryChangeYears(attendWorkDate,
											array1, array2, arrayNum, eduList,
											failTime));
						}
						if (curLevel1 < profSalaryManage.findProfPosSalByLevel(
								14 - techMaxLevel).getStartPayLevel())
							curLevel1 = profSalaryManage.findProfPosSalByLevel(
									14 - techMaxLevel).getStartPayLevel();
						/*if (curLevel1 > level) {
							level = curLevel1;
							officeTime = officeTime1;
						}*/
						if (profSalaryManage.findProfPosSalByLevel(techMaxLevel).getSalaryStandard() + profSalaryManage.findProfPaySalByPayLevel(techMaxLevel).getSalaryStandard() > wageMax) {
							wageMax = profSalaryManage.findProfPosSalByLevel(techMaxLevel).getSalaryStandard() + profSalaryManage.findProfPaySalByPayLevel(techMaxLevel).getSalaryStandard();
							level = curLevel1;
							officeTime = officeTime1;
						}
						System.out.println("对应薪级：  " + curLevel1);

						System.out.println("专技系列2：");
						int officeTime2 = getTechOfficeTime(techMaxLevel,
								techMinYear2, manageList);
						System.out.println("职务等级：  " + techSecMaxLevel);
						System.out.println("任职年限：  " + officeTime2);
						int curLevel2 = 0;

						if (profSalaryManage.getPayLevel(
								techSecMaxLevel,
								officeTime2,
								getSalaryChangeYears(attendWorkDate, array1,
										array2, arrayNum, eduList, failTime)) != null) {
							curLevel2 = profSalaryManage.getPayLevel(
									techSecMaxLevel,
									officeTime2,
									getSalaryChangeYears(attendWorkDate,
											array1, array2, arrayNum, eduList,
											failTime));
						}
						if (curLevel2 < profSalaryManage.findProfPosSalByLevel(
								14 - techSecMaxLevel).getStartPayLevel())
							curLevel2 = profSalaryManage.findProfPosSalByLevel(
									14 - techSecMaxLevel).getStartPayLevel();
						/*if (curLevel2 > level) {
							level = curLevel2;
							officeTime = officeTime2;
						}*/
						if (profSalaryManage.findProfPosSalByLevel(techSecMaxLevel).getSalaryStandard() + profSalaryManage.findProfPaySalByPayLevel(techSecMaxLevel).getSalaryStandard() > wageMax) {
							wageMax = profSalaryManage.findProfPosSalByLevel(techSecMaxLevel).getSalaryStandard() + profSalaryManage.findProfPaySalByPayLevel(techSecMaxLevel).getSalaryStandard();
							level = curLevel2;
							officeTime = officeTime2;
						}
						System.out.println("对应薪级：  " + curLevel2);
					}
				}
			}
		} else {
			if (attendWorkDate.before(baseWorkDate)) {
				int worMaxLevel = 0;
				int worMinYear1 = 2006;
				int worSecMaxLevel = 0;
				int worMinYear2 = 2006;

				int worLength = worList.size();

				if (worLength == 1) {
					if (worList.get(0).getTime() <= 2006) {
						worMaxLevel = worList.get(0).getGanhuoLevel();
						worMinYear1 = worList.get(0).getTime();
					}
				} else {
					for (int i = 0; i < worLength - 1; i++) {
						for (int j = i + 1; j < worLength; j++) {
							if (worList.get(i).getGanhuoLevel() < worList
									.get(j).getGanhuoLevel()) {
								ExperienceInfo tempExperienceInfo = worList
										.get(i);
								worList.set(i, worList.get(j));
								worList.set(j, tempExperienceInfo);
							}
						}
					}
					int count = 0;
					for (int i = 0; i < worLength; i++) {
						if (worList.get(i).getTime() <= 2006) {
							if (count == 0) {
								worMaxLevel = worList.get(i).getGanhuoLevel();
								worMinYear1 = worList.get(i).getTime();
								count++;
							} else if (count == 1) {
								worSecMaxLevel = worList.get(i)
										.getGanhuoLevel();
								worMinYear2 = manageList.get(i).getTime();
								break;
							}
						}
					}

					if (worMaxLevel == 0) {
						;
					} else {
						if (worSecMaxLevel == 0) {
							System.out.println("工人系列：");
							int curOfficeTime = worMinYear1;
							System.out.println("职务等级：  " + worMaxLevel);
							System.out.println("任职年限：  " + curOfficeTime);
							int curLevel = 0;
							if (workerSalaryManage.getPayLevel(
									worMaxLevel,
									curOfficeTime,
									getSalaryChangeYears(attendWorkDate,
											array1, array2, arrayNum, eduList,
											failTime)) != null) {
								curLevel = workerSalaryManage.getPayLevel(
										worMaxLevel,
										curOfficeTime,
										getSalaryChangeYears(attendWorkDate,
												array1, array2, arrayNum,
												eduList, failTime));
							}
							if (curLevel < workerSalaryManage
									.findWorPosSalByLevel(7 - worMaxLevel)
									.getStartPayLevel())
								curLevel = profSalaryManage
										.findProfPosSalByLevel(7 - worMaxLevel)
										.getStartPayLevel();
							/*if (curLevel > level) {
								level = curLevel;
								officeTime = curOfficeTime;
							}*/
							if (workerSalaryManage.findWorkerPosSalByLevel(curLevel).getSalaryStandard() + workerSalaryManage.findWorkerPaySalByPayLevel(curLevel).getSalaryStandard() > wageMax) {
								wageMax = workerSalaryManage.findWorkerPosSalByLevel(curLevel).getSalaryStandard() + workerSalaryManage.findWorkerPaySalByPayLevel(curLevel).getSalaryStandard();
								level = curLevel;
								officeTime = curOfficeTime;
							}
							System.out.println("对应薪级：  " + curLevel);
						} else {
							System.out.println("工人系列1：");
							int officeTime1 = worMinYear1;
							System.out.println("职务等级：  " + worMaxLevel);
							System.out.println("任职年限：  " + officeTime1);
							int curLevel1 = 0;
							if (workerSalaryManage.getPayLevel(
									worMaxLevel,
									officeTime1,
									getSalaryChangeYears(attendWorkDate,
											array1, array2, arrayNum, eduList,
											failTime)) != null) {
								curLevel1 = workerSalaryManage.getPayLevel(
										worMaxLevel,
										officeTime1,
										getSalaryChangeYears(attendWorkDate,
												array1, array2, arrayNum,
												eduList, failTime));
							}
							if (curLevel1 < workerSalaryManage
									.findWorPosSalByLevel(7 - worMaxLevel)
									.getStartPayLevel())
								curLevel1 = profSalaryManage
										.findProfPosSalByLevel(7 - worMaxLevel)
										.getStartPayLevel();
							/*if (curLevel1 > level) {
								level = curLevel1;
								officeTime = officeTime1;
							}*/
							if (workerSalaryManage.findWorkerPosSalByLevel(curLevel1).getSalaryStandard() + workerSalaryManage.findWorkerPaySalByPayLevel(curLevel1).getSalaryStandard() > wageMax) {
								wageMax = workerSalaryManage.findWorkerPosSalByLevel(curLevel1).getSalaryStandard() + workerSalaryManage.findWorkerPaySalByPayLevel(curLevel1).getSalaryStandard();
								level = curLevel1;
								officeTime = officeTime1;
							}
							System.out.println("对应薪级：  " + curLevel1);

							System.out.println("工人系列2：");
							int officeTime2 = worMinYear1;
							System.out.println("职务等级：  " + worMaxLevel);
							System.out.println("任职年限：  " + officeTime2);
							int curLevel2 = 0;
							if (workerSalaryManage.getPayLevel(
									worMaxLevel,
									officeTime2,
									getSalaryChangeYears(attendWorkDate,
											array1, array2, arrayNum, eduList,
											failTime)) != null) {
								curLevel2 = workerSalaryManage.getPayLevel(
										worMaxLevel,
										officeTime2,
										getSalaryChangeYears(attendWorkDate,
												array1, array2, arrayNum,
												eduList, failTime));
							}
							if (curLevel2 < workerSalaryManage
									.findWorPosSalByLevel(7 - worMaxLevel)
									.getStartPayLevel())
								curLevel2 = profSalaryManage
										.findProfPosSalByLevel(7 - worMaxLevel)
										.getStartPayLevel();
							/*if (curLevel2 > level) {
								level = curLevel2;
								officeTime = officeTime2;
							}*/
							if (workerSalaryManage.findWorkerPosSalByLevel(curLevel2).getSalaryStandard() + workerSalaryManage.findWorkerPaySalByPayLevel(curLevel2).getSalaryStandard() > wageMax) {
								wageMax = workerSalaryManage.findWorkerPosSalByLevel(curLevel2).getSalaryStandard() + workerSalaryManage.findWorkerPaySalByPayLevel(curLevel2).getSalaryStandard();
								level = curLevel2;
								officeTime = officeTime2;
							}
							System.out.println("对应薪级：  " + curLevel2);
						}
					}
				}
			}
		}
		return officeTime;
	}

	// 获取薪级
	public int getSalaryLevel(ArrayList<ExperienceInfo> manageList,
			ArrayList<ExperienceInfo> techList,
			ArrayList<ExperienceInfo> eduList, Date attendWorkDate,
			ArrayList<Date> array1, ArrayList<Date> array2, int arrayNum,
			int failTime, ArrayList<ExperienceInfo> worList, posSalaryAndlevelSalary psAls) {
		int level = 0;
		int wageMax = 0;

		Date baseWorkDate = null;// 基本日期，2006年7月1日，之前套改，之后不套改
		String baseDateStr = "2006-07-01";
		baseWorkDate = strToDate(baseDateStr);

		if (worList.size() == 0) {
			if (attendWorkDate.before(baseWorkDate)) {
				// 管理系第一大，第二大
				int manageMaxLevel = 0;
				int manageMinYear1 = 2006;
				int manageSecMaxLevel = 0;
				int manageMinYear2 = 2006;

				// 专技系第一大，第二大
				int techMaxLevel = 0;
				int techMinYear1 = 2006;
				int techSecMaxLevel = 0;
				int techMinYear2 = 2006;

				int manageLength = manageList.size();
				if (manageLength == 0) {
				} else if (manageLength == 1) {
					if (manageList.get(0).getTime() <= 2006) {
						manageMaxLevel = manageList.get(0).getGanhuoLevel();
						manageMinYear1 = manageList.get(0).getTime();
					} else {
						System.out.println("管理系列倒推");
						int posLevel = manageList.get(0).getGanhuoLevel();
						int startPosYear = manageList.get(0).getTime();// 开始任职年份
						while (startPosYear > 2006) {
							if (posLevel == 7) {
								startPosYear = startPosYear - 3;
								posLevel--;
							} else if (posLevel == 6) {
								startPosYear = startPosYear - 2;
								posLevel--;
							} else if (posLevel == 5) {
								startPosYear = startPosYear - 3;
								posLevel--;
							} else if (posLevel == 4) {
								startPosYear = startPosYear - 2;
								posLevel--;
							} else if (posLevel == 3) {
								startPosYear = startPosYear - 3;
								posLevel--;
							}
						}
						manageMaxLevel = posLevel;
						manageMinYear1 = startPosYear;
					}
				} else {
					for (int i = 0; i < manageLength - 1; i++) {
						for (int j = i + 1; j < manageLength; j++) {
							if (manageList.get(i).getGanhuoLevel() < manageList
									.get(j).getGanhuoLevel()) {
								ExperienceInfo tempExperienceInfo = manageList
										.get(i);
								manageList.set(i, manageList.get(j));
								manageList.set(j, tempExperienceInfo);
							}
						}
					}
					int count1 = 0;
					for (int i = 0; i < manageLength; i++) {
						if (manageList.get(i).getTime() <= 2006) {
							if (count1 == 0) {
								manageMaxLevel = manageList.get(i)
										.getGanhuoLevel();
								manageMinYear1 = manageList.get(i).getTime();
								count1++;
							} else if (count1 == 1) {
								manageSecMaxLevel = manageList.get(i)
										.getGanhuoLevel();
								manageMinYear2 = manageList.get(i).getTime();
								break;
							}
						}
					}

					if (count1 == 0) {
						System.out.println("管理系列倒推");
						for (int i = 0; i < manageLength - 1; i++) {
							for (int j = i + 1; j < manageLength; j++) {
								if (manageList.get(i).getTime() > manageList
										.get(j).getTime()) {
									ExperienceInfo tempExperienceInfo = manageList
											.get(i);
									manageList.set(i, manageList.get(j));
									manageList.set(j, tempExperienceInfo);
								}
							}
						}
						int posLevel = manageList.get(0).getGanhuoLevel();
						int startPosYear = manageList.get(0).getTime();// 开始任职年份
						while (startPosYear > 2006) {
							if (posLevel == 7) {
								startPosYear = startPosYear - 3;
								posLevel--;
							} else if (posLevel == 6) {
								startPosYear = startPosYear - 2;
								posLevel--;
							} else if (posLevel == 5) {
								startPosYear = startPosYear - 3;
								posLevel--;
							} else if (posLevel == 4) {
								startPosYear = startPosYear - 2;
								posLevel--;
							} else if (posLevel == 3) {
								startPosYear = startPosYear - 3;
								posLevel--;
							}
						}
						manageMaxLevel = posLevel;
						manageMinYear1 = startPosYear;
					}
				}

				int eduMax = 0;
				for (int i = 0; i < eduList.size(); i++) {
					if (eduList.get(i).getGanhuo().equals("博士")) {
						eduMax = 4;
						break;
					} else if (eduList.get(i).getGanhuo().equals("硕士")) {
						if (eduMax < 3) {
							eduMax = 3;
						}
					} else if (eduList.get(i).getGanhuo().equals("本科")) {
						if (eduMax < 2) {
							eduMax = 2;
						}
					} else if (eduList.get(i).getGanhuo().equals("专科")) {
						if (eduMax < 1) {
							eduMax = 1;
						}
					}
				}

				int techLength = techList.size();
				if (techLength == 0) {
				} else if (techLength == 1) {
					if (techList.get(0).getTime() <= 2006) {
						techMaxLevel = techList.get(0).getGanhuoLevel();
						techMinYear1 = techList.get(0).getTime();
					} else {
						System.out.println("专技系列倒推");
						int payLevel = techList.get(0).getGanhuoLevel();
						int startPayYear = techList.get(0).getTime();// 开始任职年份
						while (startPayYear > 2006) {
							if (payLevel == 13 || payLevel == 12
									|| payLevel == 11 || payLevel == 10) {
								startPayYear = startPayYear - 5;
								payLevel = 9;
							} else if (payLevel == 9 || payLevel == 8
									|| payLevel == 7) {
								if (eduMax == 4) {
									startPayYear = startPayYear - 3;
									payLevel = 6;
								} else {
									startPayYear = startPayYear - 5;
									payLevel = 6;
								}
							} else if (payLevel == 6 || payLevel == 5
									|| payLevel == 4) {
								if (eduMax == 4) {
									startPayYear = startPayYear - 2;
									payLevel = 3;
								} else if (eduMax == 3) {
									startPayYear = startPayYear - 3;
									payLevel = 3;
								} else if (eduMax == 2) {
									startPayYear = startPayYear - 4;
									payLevel = 3;
								} else if (eduMax == 1) {
									startPayYear = startPayYear - 5;
									payLevel = 3;
								} else {
									startPayYear = startPayYear - 5;
									payLevel = 3;
								}
							}
						}
						techMaxLevel = payLevel;
						techMinYear1 = startPayYear;
					}
				} else {
					for (int i = 0; i < techLength - 1; i++) {
						for (int j = i + 1; j < techLength; j++) {
							if (techList.get(i).getGanhuoLevel() < techList
									.get(j).getGanhuoLevel()) {
								ExperienceInfo tempExperienceInfo = techList
										.get(i);
								techList.set(i, techList.get(j));
								techList.set(j, tempExperienceInfo);
							}
						}
					}
					int count2 = 0;
					for (int i = 0; i < techLength; i++) {
						if (techList.get(i).getTime() <= 2006) {
							if (count2 == 0) {
								techMaxLevel = techList.get(i).getGanhuoLevel();
								techMinYear1 = techList.get(i).getTime();
								count2++;
							} else if (count2 == 1) {
								techSecMaxLevel = techList.get(i)
										.getGanhuoLevel();
								techMinYear2 = techList.get(i).getTime();
								break;
							}
						}
					}

					if (count2 == 0) {
						System.out.println("专技系列倒推");
						for (int i = 0; i < techLength - 1; i++) {
							for (int j = i + 1; j < techLength; j++) {
								if (techList.get(i).getTime() > techList.get(j)
										.getTime()) {
									ExperienceInfo tempExperienceInfo = techList
											.get(i);
									techList.set(i, techList.get(j));
									techList.set(j, tempExperienceInfo);
								}
							}
						}
						int payLevel = techList.get(0).getGanhuoLevel();
						int startPayYear = techList.get(0).getTime();// 开始任职年份
						while (startPayYear > 2006) {
							if (payLevel == 13 || payLevel == 12
									|| payLevel == 11 || payLevel == 10) {
								startPayYear = startPayYear - 5;
								payLevel = 9;
							} else if (payLevel == 9 || payLevel == 8
									|| payLevel == 7) {
								if (eduMax == 4) {
									startPayYear = startPayYear - 3;
									payLevel = 6;
								} else {
									startPayYear = startPayYear - 5;
									payLevel = 6;
								}
							} else if (payLevel == 6 || payLevel == 5
									|| payLevel == 4) {
								if (eduMax == 4) {
									startPayYear = startPayYear - 2;
									payLevel = 3;
								} else if (eduMax == 3) {
									startPayYear = startPayYear - 3;
									payLevel = 3;
								} else if (eduMax == 2) {
									startPayYear = startPayYear - 4;
									payLevel = 3;
								} else if (eduMax == 1) {
									startPayYear = startPayYear - 5;
									payLevel = 3;
								} else {
									startPayYear = startPayYear - 5;
									payLevel = 3;
								}
							}
						}
						techMaxLevel = payLevel;
						techMinYear1 = startPayYear;
					}
				}

				if (manageMaxLevel == 0) {
					;
				} else {
					if (manageSecMaxLevel == 0) {
						System.out.println("管理系列：");
						int curOfficeTime = getManageOfficeTime(manageMaxLevel,
								manageMinYear1, techList);
						System.out.println("职务等级：  " + manageMaxLevel);
						System.out.println("任职年限：  " + curOfficeTime);
						int curLevel = 0;
						if (manageSalaryManage.getPayLevel(
								11 - manageMaxLevel,
								curOfficeTime,
								getSalaryChangeYears(attendWorkDate, array1,
										array2, arrayNum, eduList, failTime)) != null) {
							curLevel = manageSalaryManage.getPayLevel(
									11 - manageMaxLevel,
									curOfficeTime,
									getSalaryChangeYears(attendWorkDate,
											array1, array2, arrayNum, eduList,
											failTime));
						}
						if (curLevel < manageSalaryManage.findManPosSalByLevel(
								11 - manageMaxLevel).getStartPayLevel())
							curLevel = manageSalaryManage.findManPosSalByLevel(
									11 - manageMaxLevel).getStartPayLevel();
						/*if (curLevel > level) {
							level = curLevel;
						}*/
						if (manageSalaryManage.findManPosSalByLevel(manageMaxLevel).getSalaryStandard() + manageSalaryManage.findManPaySalByPayLevel(manageMaxLevel).getSalaryStandard() > wageMax) {
							wageMax = manageSalaryManage.findManPosSalByLevel(manageMaxLevel).getSalaryStandard() + manageSalaryManage.findManPaySalByPayLevel(manageMaxLevel).getSalaryStandard();
							level = curLevel;
							psAls.positionSalary = manageSalaryManage.findManPosSalByLevel(level).getStartPayLevel();
							psAls.levelSalary = manageSalaryManage.findManPaySalByPayLevel(level).getSalaryStandard();
						}
						System.out.println("对应薪级：  " + curLevel);
					} else {
						System.out.println("管理系列1：");
						int officeTime1 = getManageOfficeTime(manageMaxLevel,
								manageMinYear1, techList);
						System.out.println("职务等级：  " + manageMaxLevel);
						System.out.println("任职年限：  " + officeTime1);
						int curLevel1 = 0;
						if (manageSalaryManage.getPayLevel(
								11 - manageMaxLevel,
								officeTime1,
								getSalaryChangeYears(attendWorkDate, array1,
										array2, arrayNum, eduList, failTime)) != null) {
							curLevel1 = manageSalaryManage.getPayLevel(
									11 - manageMaxLevel,
									officeTime1,
									getSalaryChangeYears(attendWorkDate,
											array1, array2, arrayNum, eduList,
											failTime));
						}
						if (curLevel1 < manageSalaryManage
								.findManPosSalByLevel(11 - manageMaxLevel)
								.getStartPayLevel())
							curLevel1 = manageSalaryManage
									.findManPosSalByLevel(11 - manageMaxLevel)
									.getStartPayLevel();
						System.out.println("level=" + level);
						/*if (curLevel1 > level) {
							level = curLevel1;
						}*/
						if (manageSalaryManage.findManPosSalByLevel(manageMaxLevel).getSalaryStandard() + manageSalaryManage.findManPaySalByPayLevel(manageMaxLevel).getSalaryStandard() > wageMax) {
							wageMax = manageSalaryManage.findManPosSalByLevel(manageMaxLevel).getSalaryStandard() + manageSalaryManage.findManPaySalByPayLevel(manageMaxLevel).getSalaryStandard();
							level = curLevel1;
							psAls.positionSalary = manageSalaryManage.findManPosSalByLevel(level).getStartPayLevel();
							psAls.levelSalary = manageSalaryManage.findManPaySalByPayLevel(level).getSalaryStandard();
						}
						System.out.println("level=" + level);
						System.out.println("对应薪级：  " + curLevel1);

						System.out.println("管理系列2：");
						int officeTime2 = getManageOfficeTime(
								manageSecMaxLevel, manageMinYear2, techList);
						System.out.println("职务等级：  " + manageSecMaxLevel);
						System.out.println("任职年限：  " + officeTime1);
						int curLevel2 = 0;
						if (manageSalaryManage.getPayLevel(
								11 - manageSecMaxLevel,
								officeTime2,
								getSalaryChangeYears(attendWorkDate, array1,
										array2, arrayNum, eduList, failTime)) != null) {
							curLevel2 = manageSalaryManage.getPayLevel(
									11 - manageSecMaxLevel,
									officeTime2,
									getSalaryChangeYears(attendWorkDate,
											array1, array2, arrayNum, eduList,
											failTime));
						}
						if (curLevel2 < manageSalaryManage
								.findManPosSalByLevel(11 - manageSecMaxLevel)
								.getStartPayLevel())
							curLevel2 = manageSalaryManage
									.findManPosSalByLevel(
											11 - manageSecMaxLevel)
									.getStartPayLevel();
						System.out.println("level=" + level);
						/*if (curLevel2 > level) {
							level = curLevel2;
						}*/
						if (manageSalaryManage.findManPosSalByLevel(manageSecMaxLevel).getSalaryStandard() + manageSalaryManage.findManPaySalByPayLevel(manageSecMaxLevel).getSalaryStandard() > wageMax) {
							wageMax = manageSalaryManage.findManPosSalByLevel(manageSecMaxLevel).getSalaryStandard() + manageSalaryManage.findManPaySalByPayLevel(manageSecMaxLevel).getSalaryStandard();
							level = curLevel2;
							psAls.positionSalary = manageSalaryManage.findManPosSalByLevel(level).getStartPayLevel();
							psAls.levelSalary = manageSalaryManage.findManPaySalByPayLevel(level).getSalaryStandard();
						}
						System.out.println("level=" + level);
						System.out.println("对应薪级：  " + curLevel2);
					}
				}

				if (techMaxLevel == 0) {
					;
				} else {
					if (techSecMaxLevel == 0) {
						System.out.println("专技系列：");
						int curOfficeTime = getTechOfficeTime(techMaxLevel,
								techMinYear1, manageList);
						System.out.println("职务等级：  " + techMaxLevel);
						System.out.println("任职年限：  " + curOfficeTime);
						int curLevel = 0;
						if (profSalaryManage.getPayLevel(
								techMaxLevel,
								curOfficeTime,
								getSalaryChangeYears(attendWorkDate, array1,
										array2, arrayNum, eduList, failTime)) != null) {
							curLevel = profSalaryManage.getPayLevel(
									techMaxLevel,
									curOfficeTime,
									getSalaryChangeYears(attendWorkDate,
											array1, array2, arrayNum, eduList,
											failTime));
						}
						if (curLevel < profSalaryManage.findProfPosSalByLevel(
								14 - techMaxLevel).getStartPayLevel())
							curLevel = profSalaryManage.findProfPosSalByLevel(
									14 - techMaxLevel).getStartPayLevel();
						/*if (curLevel > level) {
							level = curLevel;
						}*/
						if (profSalaryManage.findProfPosSalByLevel(techMaxLevel).getSalaryStandard() + profSalaryManage.findProfPaySalByPayLevel(techMaxLevel).getSalaryStandard() > wageMax) {
							wageMax = profSalaryManage.findProfPosSalByLevel(techMaxLevel).getSalaryStandard() + profSalaryManage.findProfPaySalByPayLevel(techMaxLevel).getSalaryStandard();
							level = curLevel;
							psAls.positionSalary = manageSalaryManage.findManPosSalByLevel(level).getStartPayLevel();
							psAls.levelSalary = manageSalaryManage.findManPaySalByPayLevel(level).getSalaryStandard();
						}
						System.out.println("对应薪级：  " + curLevel);
					} else {
						System.out.println("专技系列1：");
						int officeTime1 = getTechOfficeTime(techMaxLevel,
								techMinYear1, manageList);
						System.out.println("职务等级：  " + techMaxLevel);
						System.out.println("任职年限：  " + officeTime1);
						int curLevel1 = 0;
						if (profSalaryManage.getPayLevel(
								techMaxLevel,
								officeTime1,
								getSalaryChangeYears(attendWorkDate, array1,
										array2, arrayNum, eduList, failTime)) != null) {
							curLevel1 = profSalaryManage.getPayLevel(
									techMaxLevel,
									officeTime1,
									getSalaryChangeYears(attendWorkDate,
											array1, array2, arrayNum, eduList,
											failTime));
						}
						if (curLevel1 < profSalaryManage.findProfPosSalByLevel(
								14 - techMaxLevel).getStartPayLevel())
							curLevel1 = profSalaryManage.findProfPosSalByLevel(
									14 - techMaxLevel).getStartPayLevel();
						/*if (curLevel1 > level) {
							level = curLevel1;
						}*/
						if (profSalaryManage.findProfPosSalByLevel(techMaxLevel).getSalaryStandard() + profSalaryManage.findProfPaySalByPayLevel(techMaxLevel).getSalaryStandard() > wageMax) {
							wageMax = profSalaryManage.findProfPosSalByLevel(techMaxLevel).getSalaryStandard() + profSalaryManage.findProfPaySalByPayLevel(techMaxLevel).getSalaryStandard();
							level = curLevel1;
							psAls.positionSalary = manageSalaryManage.findManPosSalByLevel(level).getStartPayLevel();
							psAls.levelSalary = manageSalaryManage.findManPaySalByPayLevel(level).getSalaryStandard();
						}
						System.out.println("对应薪级：  " + curLevel1);

						System.out.println("专技系列2：");
						int officeTime2 = getTechOfficeTime(techMaxLevel,
								techMinYear2, manageList);
						System.out.println("职务等级：  " + techSecMaxLevel);
						System.out.println("任职年限：  " + officeTime2);
						int curLevel2 = 0;
						if (profSalaryManage.getPayLevel(
								techSecMaxLevel,
								officeTime2,
								getSalaryChangeYears(attendWorkDate, array1,
										array2, arrayNum, eduList, failTime)) != null) {
							curLevel2 = profSalaryManage.getPayLevel(
									techSecMaxLevel,
									officeTime2,
									getSalaryChangeYears(attendWorkDate,
											array1, array2, arrayNum, eduList,
											failTime));
						}
						if (curLevel2 < profSalaryManage.findProfPosSalByLevel(
								14 - techSecMaxLevel).getStartPayLevel())
							curLevel2 = profSalaryManage.findProfPosSalByLevel(
									14 - techSecMaxLevel).getStartPayLevel();
						/*if (curLevel2 > level) {
							level = curLevel2;
						}*/
						if (profSalaryManage.findProfPosSalByLevel(techSecMaxLevel).getSalaryStandard() + profSalaryManage.findProfPaySalByPayLevel(techSecMaxLevel).getSalaryStandard() > wageMax) {
							wageMax = profSalaryManage.findProfPosSalByLevel(techSecMaxLevel).getSalaryStandard() + profSalaryManage.findProfPaySalByPayLevel(techSecMaxLevel).getSalaryStandard();
							level = curLevel2;
							psAls.positionSalary = manageSalaryManage.findManPosSalByLevel(level).getStartPayLevel();
							psAls.levelSalary = manageSalaryManage.findManPaySalByPayLevel(level).getSalaryStandard();
						}
						System.out.println("对应薪级：  " + curLevel2);
					}
				}
				level = level + (new Date().getYear() + 1900 - 2006);
			} else {
				int eduLength = eduList.size();
				for (int i = 0; i < eduLength; i++) {
					if (eduList.get(i).getTime() >= 2006) {
						if (eduList.get(i).getGanhuo().equals("专科")) {
							if ((new Date().getYear() + 1900
									- eduList.get(i).getTime() + 5) > level)
								level = new Date().getYear() + 1900
										- eduList.get(i).getTime() + 5;
						} else if (eduList.get(i).getGanhuo().equals("本科")) {
							if ((new Date().getYear() + 1900
									- eduList.get(i).getTime() + 7) > level)
								level = new Date().getYear() + 1900
										- eduList.get(i).getTime() + 7;
						} else if (eduList.get(i).getGanhuo().equals("双学士")) {
							if ((new Date().getYear() + 1900
									- eduList.get(i).getTime() + 9) > level)
								level = new Date().getYear() + 1900
										- eduList.get(i).getTime() + 9;
						} else if (eduList.get(i).getGanhuo().equals("硕士")) {
							if ((new Date().getYear() + 1900
									- eduList.get(i).getTime() + 11) > level)
								level = new Date().getYear() + 1900
										- eduList.get(i).getTime() + 11;
						} else if (eduList.get(i).getGanhuo().equals("博士")) {
							if ((new Date().getYear() + 1900
									- eduList.get(i).getTime() + 14) > level)
								level = new Date().getYear() + 1900
										- eduList.get(i).getTime() + 14;
						}
					} else {
						if (eduList.get(i).getGanhuo().equals("专科")) {
							if ((new Date().getYear() + 1900 - 2006 + 5) > level)
								level = new Date().getYear() + 1900 - 2006 + 5;
						} else if (eduList.get(i).getGanhuo().equals("本科")) {
							if ((new Date().getYear() + 1900 - 2006 + 7) > level)
								level = new Date().getYear() + 1900 - 2006 + 7;
						} else if (eduList.get(i).getGanhuo().equals("双学士")) {
							if ((new Date().getYear() + 1900 - 2006 + 9) > level)
								level = new Date().getYear() + 1900 - 2006 + 9;
						} else if (eduList.get(i).getGanhuo().equals("硕士")) {
							if ((new Date().getYear() + 1900 - 2006 + 11) > level)
								level = new Date().getYear() + 1900 - 2006 + 11;
						} else if (eduList.get(i).getGanhuo().equals("博士")) {
							if ((new Date().getYear() + 1900 - 2006 + 14) > level)
								level = new Date().getYear() + 1900 - 2006 + 14;
						}
					}
				}
			}
		} else {
			if (attendWorkDate.before(baseWorkDate)) {
				int worMaxLevel = 0;
				int worMinYear1 = 2006;
				int worSecMaxLevel = 0;
				int worMinYear2 = 2006;

				int worLength = worList.size();

				if (worLength == 1) {
					if (worList.get(0).getTime() <= 2006) {
						worMaxLevel = worList.get(0).getGanhuoLevel();
						worMinYear1 = worList.get(0).getTime();
					}
				} else {
					for (int i = 0; i < worLength - 1; i++) {
						for (int j = i + 1; j < worLength; j++) {
							if (worList.get(i).getGanhuoLevel() < worList
									.get(j).getGanhuoLevel()) {
								ExperienceInfo tempExperienceInfo = worList
										.get(i);
								worList.set(i, worList.get(j));
								worList.set(j, tempExperienceInfo);
							}
						}
					}
					int count = 0;
					for (int i = 0; i < worLength; i++) {
						if (worList.get(i).getTime() <= 2006) {
							if (count == 0) {
								worMaxLevel = worList.get(i).getGanhuoLevel();
								worMinYear1 = worList.get(i).getTime();
								count++;
							} else if (count == 1) {
								worSecMaxLevel = worList.get(i)
										.getGanhuoLevel();
								worMinYear2 = manageList.get(i).getTime();
								break;
							}
						}
					}

					if (worMaxLevel == 0) {
						;
					} else {
						if (worSecMaxLevel == 0) {
							System.out.println("工人系列：");
							int curOfficeTime = worMinYear1;
							System.out.println("职务等级：  " + worMaxLevel);
							System.out.println("任职年限：  " + curOfficeTime);
							int curLevel = 0;
							if (workerSalaryManage.getPayLevel(
									worMaxLevel,
									curOfficeTime,
									getSalaryChangeYears(attendWorkDate,
											array1, array2, arrayNum, eduList,
											failTime)) != null) {
								curLevel = workerSalaryManage.getPayLevel(
										worMaxLevel,
										curOfficeTime,
										getSalaryChangeYears(attendWorkDate,
												array1, array2, arrayNum,
												eduList, failTime));
							}
							if (curLevel < workerSalaryManage
									.findWorPosSalByLevel(7 - worMaxLevel)
									.getStartPayLevel())
								curLevel = profSalaryManage
										.findProfPosSalByLevel(7 - worMaxLevel)
										.getStartPayLevel();
							/*if (curLevel > level) {
								level = curLevel;
							}*/
							if (workerSalaryManage.findWorkerPosSalByLevel(curLevel).getSalaryStandard() + workerSalaryManage.findWorkerPaySalByPayLevel(curLevel).getSalaryStandard() > wageMax) {
								wageMax = workerSalaryManage.findWorkerPosSalByLevel(curLevel).getSalaryStandard() + workerSalaryManage.findWorkerPaySalByPayLevel(curLevel).getSalaryStandard();
								level = curLevel;
							}
							System.out.println("对应薪级：  " + curLevel);
						} else {
							System.out.println("工人系列1：");
							int officeTime1 = worMinYear1;
							System.out.println("职务等级：  " + worMaxLevel);
							System.out.println("任职年限：  " + officeTime1);
							int curLevel1 = 0;
							if (workerSalaryManage.getPayLevel(
									worMaxLevel,
									officeTime1,
									getSalaryChangeYears(attendWorkDate,
											array1, array2, arrayNum, eduList,
											failTime)) != null) {
								curLevel1 = workerSalaryManage.getPayLevel(
										worMaxLevel,
										officeTime1,
										getSalaryChangeYears(attendWorkDate,
												array1, array2, arrayNum,
												eduList, failTime));
							}
							if (curLevel1 < workerSalaryManage
									.findWorPosSalByLevel(7 - worMaxLevel)
									.getStartPayLevel())
								curLevel1 = profSalaryManage
										.findProfPosSalByLevel(7 - worMaxLevel)
										.getStartPayLevel();
							/*if (curLevel1 > level) {
								level = curLevel1;
							}*/
							if (workerSalaryManage.findWorkerPosSalByLevel(curLevel1).getSalaryStandard() + workerSalaryManage.findWorkerPaySalByPayLevel(curLevel1).getSalaryStandard() > wageMax) {
								wageMax = workerSalaryManage.findWorkerPosSalByLevel(curLevel1).getSalaryStandard() + workerSalaryManage.findWorkerPaySalByPayLevel(curLevel1).getSalaryStandard();
								level = curLevel1;
							}
							System.out.println("对应薪级：  " + curLevel1);

							System.out.println("工人系列2：");
							int officeTime2 = worMinYear1;
							System.out.println("职务等级：  " + worMaxLevel);
							System.out.println("任职年限：  " + officeTime2);
							int curLevel2 = 0;
							if (workerSalaryManage.getPayLevel(
									worMaxLevel,
									officeTime2,
									getSalaryChangeYears(attendWorkDate,
											array1, array2, arrayNum, eduList,
											failTime)) != null) {
								curLevel2 = workerSalaryManage.getPayLevel(
										worMaxLevel,
										officeTime2,
										getSalaryChangeYears(attendWorkDate,
												array1, array2, arrayNum,
												eduList, failTime));
							}
							if (curLevel2 < workerSalaryManage
									.findWorPosSalByLevel(7 - worMaxLevel)
									.getStartPayLevel())
								curLevel2 = profSalaryManage
										.findProfPosSalByLevel(7 - worMaxLevel)
										.getStartPayLevel();
							/*if (curLevel2 > level) {
								level = curLevel2;
							}*/
							if (workerSalaryManage.findWorkerPosSalByLevel(curLevel2).getSalaryStandard() + workerSalaryManage.findWorkerPaySalByPayLevel(curLevel2).getSalaryStandard() > wageMax) {
								wageMax = workerSalaryManage.findWorkerPosSalByLevel(curLevel2).getSalaryStandard() + workerSalaryManage.findWorkerPaySalByPayLevel(curLevel2).getSalaryStandard();
								level = curLevel2;
							}
							System.out.println("对应薪级：  " + curLevel2);
						}
					}
				}
				level = level + (new Date().getYear() + 1900 - 2006);
			} else {
				int eduLength = eduList.size();
				for (int i = 0; i < eduLength; i++) {
					if (eduList.get(i).getTime() >= 2006) {
						if (eduList.get(i).getGanhuo().equals("专科")) {
							if ((new Date().getYear() + 1900
									- eduList.get(i).getTime() + 5) > level)
								level = new Date().getYear() + 1900
										- eduList.get(i).getTime() + 5;
						} else if (eduList.get(i).getGanhuo().equals("本科")) {
							if ((new Date().getYear() + 1900
									- eduList.get(i).getTime() + 7) > level)
								level = new Date().getYear() + 1900
										- eduList.get(i).getTime() + 7;
						} else if (eduList.get(i).getGanhuo().equals("双学士")) {
							if ((new Date().getYear() + 1900
									- eduList.get(i).getTime() + 9) > level)
								level = new Date().getYear() + 1900
										- eduList.get(i).getTime() + 9;
						} else if (eduList.get(i).getGanhuo().equals("硕士")) {
							if ((new Date().getYear() + 1900
									- eduList.get(i).getTime() + 11) > level)
								level = new Date().getYear() + 1900
										- eduList.get(i).getTime() + 11;
						} else if (eduList.get(i).getGanhuo().equals("博士")) {
							if ((new Date().getYear() + 1900
									- eduList.get(i).getTime() + 14) > level)
								level = new Date().getYear() + 1900
										- eduList.get(i).getTime() + 14;
						}
					} else {
						if (eduList.get(i).getGanhuo().equals("专科")) {
							if ((new Date().getYear() + 1900 - 2006 + 5) > level)
								level = new Date().getYear() + 1900 - 2006 + 5;
						} else if (eduList.get(i).getGanhuo().equals("本科")) {
							if ((new Date().getYear() + 1900 - 2006 + 7) > level)
								level = new Date().getYear() + 1900 - 2006 + 7;
						} else if (eduList.get(i).getGanhuo().equals("双学士")) {
							if ((new Date().getYear() + 1900 - 2006 + 9) > level)
								level = new Date().getYear() + 1900 - 2006 + 9;
						} else if (eduList.get(i).getGanhuo().equals("硕士")) {
							if ((new Date().getYear() + 1900 - 2006 + 11) > level)
								level = new Date().getYear() + 1900 - 2006 + 11;
						} else if (eduList.get(i).getGanhuo().equals("博士")) {
							if ((new Date().getYear() + 1900 - 2006 + 14) > level)
								level = new Date().getYear() + 1900 - 2006 + 14;
						}
					}
				}
			}
		}
		if (level == 0)
			level = 1;
		System.out.println("Final Level=" + level);
		return level;
	}

	public String PosChange() {
		int x = 111111;
		int year = new Date().getYear();
		String title = "TO DO";
		if (isValid(x)) {
			if (employeeManage.findEmployeeById(x) != null) {
				
				//更新Employee数据表中职务信息
				//TODO
				employeeManage.findEmployeeById(x).setHireWork(hireWork);
				employeeManage.findEmployeeById(x).setWorkLevel(workLevel);
				employeeManage.findEmployeeById(x).setStartWorkDate(startWorkDate);
				
				Date baseWorkDate = null;// 基本日期，2006年7月1日，之前套改，之后不套改
				String baseDateStr = "2006-07-01";
				baseWorkDate = strToDate(baseDateStr);
				
				experiencesManage.addExperiences(new Experiences(x, 1, year, title));
				
				ArrayList<ExperienceInfo> manageList = new ArrayList<ExperienceInfo>(), techList = new ArrayList<ExperienceInfo>(), eduList = new ArrayList<ExperienceInfo>(), worList = new ArrayList<ExperienceInfo>();
				ArrayList<Date> array1 = new ArrayList<Date>(), array2 = new ArrayList<Date>();
				
				ArrayList<Experiences> manageExperiencesList = (ArrayList<Experiences>)experiencesManage.findManageExperiencesListByEid(x);
				ArrayList<Experiences> profExperiencesList = (ArrayList<Experiences>)experiencesManage.findProfExperiencesListByEid(x);
				ArrayList<Experiences> workerExperiencesList = (ArrayList<Experiences>)experiencesManage.findWorkerExperiencesListByEid(x);
				
				ArrayList<OffInfo> breakYearsList = (ArrayList<OffInfo>)offInfoManage.findOffInfoByEId(x);
				
				int mLength = manageExperiencesList.size(), pLength = profExperiencesList.size(), wLength = workerExperiencesList.size(), bLength = breakYearsList.size();
				
				for (int i = 0; i < mLength; i++) {
					manageList.add(new ExperienceInfo(manageExperiencesList.get(i).getExRank(), manageExperiencesList.get(i).getExYear()));
				}
				
				for (int j = 0; j < pLength; j++) {
					techList.add(new ExperienceInfo(profExperiencesList.get(j).getExRank(), profExperiencesList.get(j).getExYear()));
				}
				
				for (int k = 0; k < wLength; k++) {
					worList.add(new ExperienceInfo(workerExperiencesList.get(k).getExRank(), workerExperiencesList.get(k).getExYear()));
				}
				
				for (int l = 0; l < bLength; l++) {
					Date sDate = breakYearsList.get(l).getStartDate();
					Date eDate = breakYearsList.get(l).getEndDate();
					if (eDate.before(baseWorkDate)) {
						array1.add(sDate);
						array2.add(eDate);
					}
					else {
						if (sDate.before(baseWorkDate)) {
							array1.add(sDate);
							array2.add(baseWorkDate);
						}
					}
				}
				
				//TODO
				Date attendWorkDate = strToDate(str);
				int failTime = 0;//自己填写
				posSalaryAndlevelSalary psals = new posSalaryAndlevelSalary();
				getSalaryLevel(manageList, techList, eduList, attendWorkDate, array1, array2, array1.size(), failTime, worList, psals);
				
				
				
				//岗位工资确定
				/*startSalaryInfo.setPositionSalary(manageSalaryManage
						.findManPosSalByLevel(
								startSalaryInfo.getPositionLevel())
						.getSalaryStandard());*/
				//薪级工资确定
				/*startSalaryInfo.setLevelSalary(manageSalaryManage
						.findManPaySalByPayLevel(
								startSalaryInfo.getSalaryLevel())
						.getSalaryStandard());*/
				
			}
		}
		return "fail";
	}

	public String PayLevelChange() {
		int x = 111111;
		int year = new Date().getYear();
		String title = "TO DO";
		if (isValid(x)) {
			if (employeeManage.findEmployeeById(x) != null) {
				
				//更新Employee数据表中职务信息
				//TODO
				employeeManage.findEmployeeById(x).setHireTitle(hireTitle);
				employeeManage.findEmployeeById(x).setTitleLevel(workLevel);
				employeeManage.findEmployeeById(x).setHireDate(hireDate);
				
				Date baseWorkDate = null;// 基本日期，2006年7月1日，之前套改，之后不套改
				String baseDateStr = "2006-07-01";
				baseWorkDate = strToDate(baseDateStr);
				
				experiencesManage.addExperiences(new Experiences(x, 2, year, title));
				
				ArrayList<ExperienceInfo> manageList = new ArrayList<ExperienceInfo>(), techList = new ArrayList<ExperienceInfo>(), eduList = new ArrayList<ExperienceInfo>(), worList = new ArrayList<ExperienceInfo>();
				ArrayList<Date> array1 = new ArrayList<Date>(), array2 = new ArrayList<Date>();
				
				ArrayList<Experiences> manageExperiencesList = (ArrayList<Experiences>)experiencesManage.findManageExperiencesListByEid(x);
				ArrayList<Experiences> profExperiencesList = (ArrayList<Experiences>)experiencesManage.findProfExperiencesListByEid(x);
				ArrayList<Experiences> workerExperiencesList = (ArrayList<Experiences>)experiencesManage.findWorkerExperiencesListByEid(x);
				
				ArrayList<OffInfo> breakYearsList = (ArrayList<OffInfo>)offInfoManage.findOffInfoByEId(x);
				
				int mLength = manageExperiencesList.size(), pLength = profExperiencesList.size(), wLength = workerExperiencesList.size(), bLength = breakYearsList.size();
				
				for (int i = 0; i < mLength; i++) {
					manageList.add(new ExperienceInfo(manageExperiencesList.get(i).getExRank(), manageExperiencesList.get(i).getExYear()));
				}
				
				for (int j = 0; j < pLength; j++) {
					techList.add(new ExperienceInfo(profExperiencesList.get(j).getExRank(), profExperiencesList.get(j).getExYear()));
				}
				
				for (int k = 0; k < wLength; k++) {
					worList.add(new ExperienceInfo(workerExperiencesList.get(k).getExRank(), workerExperiencesList.get(k).getExYear()));
				}
				
				for (int l = 0; l < bLength; l++) {
					Date sDate = breakYearsList.get(l).getStartDate();
					Date eDate = breakYearsList.get(l).getEndDate();
					if (eDate.before(baseWorkDate)) {
						array1.add(sDate);
						array2.add(eDate);
					}
					else {
						if (sDate.before(baseWorkDate)) {
							array1.add(sDate);
							array2.add(baseWorkDate);
						}
					}
				}
				
				//TODO
				Date attendWorkDate = strToDate(str);
				int failTime = 0;//自己填写
				posSalaryAndlevelSalary psals = new posSalaryAndlevelSalary();
				getSalaryLevel(manageList, techList, eduList, attendWorkDate, array1, array2, array1.size(), failTime, worList, psals);
								
				//岗位工资确定
				/*startSalaryInfo.setPositionSalary(manageSalaryManage
						.findManPosSalByLevel(
								startSalaryInfo.getPositionLevel())
						.getSalaryStandard());*/
				//薪级工资确定
				/*startSalaryInfo.setLevelSalary(manageSalaryManage
						.findManPaySalByPayLevel(
								startSalaryInfo.getSalaryLevel())
						.getSalaryStandard());*/
				
			}
		}
		return "fail";
	}
	
	public static class posSalaryAndlevelSalary {
		public static int positionSalary;
		public static int levelSalary;
	}
}