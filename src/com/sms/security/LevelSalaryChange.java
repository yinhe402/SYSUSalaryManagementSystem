package com.sms.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class LevelSalaryChange {
	// 字符串到日期格式转化函数，输入字符串，返回日期
	public static Date strToDate(String str) {
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
	public static int dateDif(Date d1, Date d2) {
		int yearDif = d2.getYear() - d1.getYear();
		int monthDif = d2.getMonth() - d1.getMonth();
		int dayDif = d2.getDay() - d1.getDay();

		if (monthDif < 0) {
			yearDif = yearDif - 1;
			monthDif = 12 - monthDif;
		}
		if (dayDif < 0) {
			monthDif = monthDif - 1;
		}

		System.out.println("中断时间" + yearDif + "年" + monthDif + "月");
		if ((monthDif == 6 && dayDif > 0) || monthDif > 6) {
			return yearDif + 1;
		} else {
			return yearDif;
		}
	}
	
	// 获取管理系列任职时间
	public static int getManageOfficeTime(int mLevel, int manageMinYear, ArrayList<ExperienceInfo> techList) {
		int minTechYear = 2006;
		int techLength = techList.size();
		
		if (mLevel == 7) {
			for (int i = 0; i < techLength; i++) {
				if (techList.get(i).getGanhuoLevel() >= 10 && techList.get(i).getGanhuoLevel() <= 13) {
					if (techList.get(i).getTime() < minTechYear) {
						minTechYear = techList.get(i).getTime();
					}
				}
			}
			minTechYear = minTechYear + 5;
		} else if (mLevel == 6) {
			for (int i = 0; i < techLength; i++) {
				if (techList.get(i).getGanhuoLevel() >= 10 && techList.get(i).getGanhuoLevel() <= 13) {
					if (techList.get(i).getTime() < minTechYear) {
						minTechYear = techList.get(i).getTime();
					}
				}
			}
		} else if (mLevel == 5) {
			for (int i = 0; i < techLength; i++) {
				if (techList.get(i).getGanhuoLevel() >= 7 && techList.get(i).getGanhuoLevel() <= 13) {
					if (techList.get(i).getTime() < minTechYear) {
						minTechYear = techList.get(i).getTime();
					}
				}
			}
			minTechYear = minTechYear + 5;
		} else if (mLevel == 4) {
			for (int i = 0; i < techLength; i++) {
				if (techList.get(i).getGanhuoLevel() >= 4 && techList.get(i).getGanhuoLevel() <= 13) {
					if (techList.get(i).getTime() < minTechYear) {
						minTechYear = techList.get(i).getTime();
					}
				}
			}
			minTechYear = minTechYear + 5;
		} else if (mLevel == 3) {
			for (int i = 0; i < techLength; i++) {
				if (techList.get(i).getGanhuoLevel() >= 4 && techList.get(i).getGanhuoLevel() <= 13) {
					if (techList.get(i).getTime() < minTechYear) {
						minTechYear = techList.get(i).getTime();
					}
				}
			}
		}
		
		int minYear = (manageMinYear < minTechYear) ? manageMinYear : minTechYear;
		
		return (2006 - minYear + 1);
	}
	
	// 获取专技系列任职年限
	public static int getTechOfficeTime(int tLevel, int techMinYear, ArrayList<ExperienceInfo> manageList) {
		int minManageYear = 2006;
		int manageLength = manageList.size();
		
		if (tLevel <= 13 && tLevel >= 10) {
			for (int i = 0; i < manageLength; i++) {
				if (manageList.get(i).getGanhuoLevel() >= 6 && manageList.get(i).getGanhuoLevel() <= 10) {
					if (manageList.get(i).getTime() < minManageYear) {
						minManageYear = manageList.get(i).getTime();
					}
				}
			}
		} else if (tLevel <= 9 && tLevel >= 7) {
			for (int i = 0; i < manageLength; i++) {
				if (manageList.get(i).getGanhuoLevel() >= 5 && manageList.get(i).getGanhuoLevel() <= 10) {
					if (manageList.get(i).getTime() < minManageYear) {
						minManageYear = manageList.get(i).getTime();
					}
				}
			}
		} else if (tLevel <= 6 && tLevel >= 4) {
			for (int i = 0; i < manageLength; i++) {
				if (manageList.get(i).getGanhuoLevel() >= 3 && manageList.get(i).getGanhuoLevel() <= 10) {
					if (manageList.get(i).getTime() < minManageYear) {
						minManageYear = manageList.get(i).getTime();
					}
				}
			}
		}
		
		int minYear = (techMinYear < minManageYear) ? techMinYear : minManageYear;
		
		return (2006 - minYear + 1);
	}

	public static void main(String[] args) throws IOException {

		Integer level = 0;// 套改薪级

		// 套改年限计算
		System.out.println("=====套改年限计算=====");

		Date baseWorkDate = null;// 基本日期，2006年7月1日，之前套改，之后不套改
		String baseDateStr = "2006-07-01";
		baseWorkDate = strToDate(baseDateStr);

		Date attendWorkDate = null;// 参加工作时间，手动输入
		System.out.println("请输入参加工作时间YYYY-MM-DD：");
		Scanner sc = new Scanner(System.in);
		String dateStr = null;// 获取输入时间
		dateStr = sc.nextLine();
		attendWorkDate = strToDate(dateStr);

		int breakTime = 0;// 中断工龄，手动输入中断工作起始日期和结束日期，系统自动计算
		System.out.println("输入中断工作时间？");
		int yesorno = sc.nextInt();
		sc.nextLine();
		while (yesorno == 1) {
			Date breakWorkStartTime = null, breakWorkEndTime = null;

			System.out.println("请输入中断工作起始时间YYYY-MM-DD：");
			String bwStartTimeString = null;
			bwStartTimeString = sc.nextLine();
			breakWorkStartTime = strToDate(bwStartTimeString);

			System.out.println("请输入中断工作结束时间YYYY-MM-DD：");
			String bwEndTimeString = null;
			bwEndTimeString = sc.nextLine();
			breakWorkEndTime = strToDate(bwEndTimeString);

			if (breakWorkStartTime.before(breakWorkEndTime)) {
				breakTime = breakTime
						+ dateDif(breakWorkStartTime, breakWorkEndTime);
			} else {
				System.out.println("您的输入有误，请检查后再次输入！");
			}
			System.out.println("输入中断工作时间？");
			yesorno = sc.nextInt();
			sc.nextLine();
		}

		int realWorkTime = 2006 - (1900 + attendWorkDate.getYear()) + 1
				- breakTime;// 实际工作年限

		int beforeWorkTime = 0;// 工作前工龄
		int studyInSchoolTime = 0;// 不计算工龄的在校学习时间

		String maxDegree = null;
		System.out.println("请输入学历：");
		maxDegree = sc.nextLine();

		if (maxDegree.contains("博士")) {
			beforeWorkTime = beforeWorkTime + 5;
		} else if (maxDegree.contains("硕士")) {
			beforeWorkTime = beforeWorkTime + 2;
		}

		if (maxDegree.contains("本科")) {
			studyInSchoolTime = studyInSchoolTime + 4;
		} else if (maxDegree.contains("专科")) {
			studyInSchoolTime = studyInSchoolTime + 3;
		}

		int workTime = realWorkTime + beforeWorkTime;// 工作年限

		int failTime = 0;
		System.out.println("请输入其1993年以来除见习期外年度考核不合格或不计考核等级的年限：");
		failTime = sc.nextInt();
		sc.nextLine();

		int salaryChangeTime = workTime + studyInSchoolTime - failTime;

		System.out.println("=====套改年限计算完毕=====");
		// 套改年限计算完毕

		// 任职年限计算
		System.out.println("=====任职年限计算=====");

		int officeTime = 0;

		System.out.println("请输入任职经历(管理方面)：");
		ArrayList<ExperienceInfo> manageList = new ArrayList<ExperienceInfo>();
		System.out.println("添加任职经历(管理方面)？");
		yesorno = sc.nextInt();
		sc.nextLine();
		while (yesorno == 1) {
			String ganhuo;
			Integer time;
			ganhuo = sc.nextLine();
			time = sc.nextInt();
			sc.nextLine();
			manageList.add(new ExperienceInfo(ganhuo, time));

			System.out.println("添加任职经历(管理方面)？");
			yesorno = sc.nextInt();
			sc.nextLine();
		}

		System.out.println("请输入任职经历(专技方面)：");
		ArrayList<ExperienceInfo> techList = new ArrayList<ExperienceInfo>();
		System.out.println("添加任职经历(专技方面)？");
		yesorno = sc.nextInt();
		sc.nextLine();
		while (yesorno == 1) {
			String ganhuo;
			Integer time;
			ganhuo = sc.nextLine();
			time = sc.nextInt();
			sc.nextLine();
			techList.add(new ExperienceInfo(ganhuo, time));

			System.out.println("添加任职经历(专技方面)？");
			yesorno = sc.nextInt();
			sc.nextLine();
		}

		System.out.println("请输入教育经历：");
		ArrayList<ExperienceInfo> eduList = new ArrayList<ExperienceInfo>();
		System.out.println("添加教育经历？");
		yesorno = sc.nextInt();
		sc.nextLine();
		while (yesorno == 1) {
			String ganhuo;
			Integer time;
			ganhuo = sc.nextLine();
			time = sc.nextInt();
			sc.nextLine();
			eduList.add(new ExperienceInfo(ganhuo, time));

			System.out.println("添加教育经历？");
			yesorno = sc.nextInt();
			sc.nextLine();
		}

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
				}
			} else {
				for (int i = 0; i < manageLength; i++) {
					for (int j = i + 1; j < manageLength; j++) {
						if (manageList.get(i).getGanhuoLevel() < manageList.get(j).getGanhuoLevel()) {
							ExperienceInfo tempExperienceInfo = manageList.get(i);
							manageList.set(i, manageList.get(j));
							manageList.set(j, tempExperienceInfo);
						}
					}
				}
				int count1 = 0;
				for (int i = 0; i < manageLength; i++) {
					if (manageList.get(i).getTime() <= 2006) {
						if (count1 == 0) {
							manageMaxLevel = manageList.get(i).getGanhuoLevel();
							manageMinYear1 = manageList.get(i).getTime();
							count1++;
						} else if (count1 == 1) {
							manageSecMaxLevel = manageList.get(i).getGanhuoLevel();
							manageMinYear2 = manageList.get(i).getTime();
							break;
						}
					}
				}
			}

			int techLength = techList.size();
			if (techLength == 0) {
			} else if (techLength == 1) {
				if (techList.get(0).getTime() <= 2006) {
					techMaxLevel = techList.get(0).getGanhuoLevel();
					techMinYear1 = techList.get(0).getTime();
				}
			} else {
				for (int i = 0; i < techLength; i++) {
					for (int j = i + 1; j < techLength; j++) {
						if (techList.get(i).getGanhuoLevel() < techList.get(j).getGanhuoLevel()) {
							ExperienceInfo tempExperienceInfo = techList.get(i);
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
							techSecMaxLevel = techList.get(i).getGanhuoLevel();
							techMinYear2 = techList.get(i).getTime();
							break;
						}
					}
				}
			}

			if (manageMaxLevel == 0) {
				;
			} else {
				if (manageSecMaxLevel == 0) {
					System.out.println("管理系列：");
					officeTime = getManageOfficeTime(manageMaxLevel, manageMinYear1, techList);
					System.out.println(officeTime);
				} else {
					System.out.println("管理系列1：");
					int officeTime1 = getManageOfficeTime(manageMaxLevel, manageMinYear1, techList);
					System.out.println(officeTime1);
					
					System.out.println("管理系列2：");
					int officeTime2 = getManageOfficeTime(manageSecMaxLevel, manageMinYear2, techList);
					System.out.println(officeTime2);
					
					officeTime = (officeTime1 < officeTime2) ? officeTime1 : officeTime2;
				}
			}
			
			
			if (techMaxLevel == 0) {
				;
			} else {
				if (techSecMaxLevel == 0) {
					System.out.println("专技系列：");
					officeTime = getTechOfficeTime(techMaxLevel, techMinYear1, manageList);
					System.out.println(officeTime);
				} else {
					System.out.println("专技系列1：");
					int officeTime1 = getTechOfficeTime(techMaxLevel, techMinYear1, manageList);
					System.out.println(officeTime1);
					
					System.out.println("专技系列2：");
					int officeTime2 = getTechOfficeTime(techMaxLevel, techMinYear2, manageList);
					System.out.println(officeTime2);
					
					officeTime = (officeTime1 < officeTime2) ? officeTime1 : officeTime2;
				}
			}
		} else {
			int eduLength = eduList.size();
			for (int i = 0; i < eduLength; i++) {
				if (eduList.get(i).getTime() >= 2006) {
					if (eduList.get(i).getGanhuo() == "专科") {
						if ((2014 - eduList.get(i).getTime() + 5) > level)
							level = 2014 - eduList.get(i).getTime() + 5;
					} else if (eduList.get(i).getGanhuo() == "本科") {
						if ((2014 - eduList.get(i).getTime() + 7) > level)
							level = 2014 - eduList.get(i).getTime() + 7;
					} else if (eduList.get(i).getGanhuo() == "双学士") {
						if ((2014 - eduList.get(i).getTime() + 9) > level)
							level = 2014 - eduList.get(i).getTime() + 9;
					} else if (eduList.get(i).getGanhuo() == "硕士") {
						if ((2014 - eduList.get(i).getTime() + 11) > level)
							level = 2014 - eduList.get(i).getTime() + 11;
					} else if (eduList.get(i).getGanhuo() == "博士") {
						if ((2014 - eduList.get(i).getTime() + 14) > level)
							level = 2014 - eduList.get(i).getTime() + 14;
					}
				} else {
					if (eduList.get(i).getGanhuo() == "专科") {
						if ((2014 - 2006 + 5) > level)
							level = 2014 - 2006 + 5;
					} else if (eduList.get(i).getGanhuo() == "本科") {
						if ((2014 - 2006 + 7) > level)
							level = 2014 - 2006 + 7;
					} else if (eduList.get(i).getGanhuo() == "双学士") {
						if ((2014 - 2006 + 9) > level)
							level = 2014 - 2006 + 9;
					} else if (eduList.get(i).getGanhuo() == "硕士") {
						if ((2014 - 2006 + 11) > level)
							level = 2014 - 2006 + 11;
					} else if (eduList.get(i).getGanhuo() == "博士") {
						if ((2014 - 2006 + 14) > level)
							level = 2014 - 2006 + 14;
					}
				}
			}
		}

		System.out.println("=====任职年限计算完毕=====");
		// 任职年限计算完毕
		sc.close();
	}
}
