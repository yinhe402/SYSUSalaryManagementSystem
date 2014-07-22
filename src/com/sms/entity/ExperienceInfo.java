package com.sms.entity;

public class ExperienceInfo {
	private String ganhuo;
	
	public String getGanhuo() {
		return ganhuo;
	}
	public void setGanhuo(String ganhuo) {
		this.ganhuo = ganhuo;
	}
	
	private Integer ganhuoLevel;
	
	public Integer getGanhuoLevel() {
		return ganhuoLevel;
	}
	public void setGanhuoLevel(Integer ganhuoLevel) {
		this.ganhuoLevel = ganhuoLevel;
	}

	private Integer time;

	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}	
	
	public ExperienceInfo(String s, Integer i) {
		this.ganhuo = s;
		this.time = i;
		if (this.ganhuo == "��") {
			this.ganhuoLevel = 10;
		}else if (this.ganhuo == "������") {
			this.ganhuoLevel = 9;
		}else if (this.ganhuo == "����") {
			this.ganhuoLevel = 8;
		}else if (this.ganhuo == "����") {
			this.ganhuoLevel = 7;
		}else if (this.ganhuo == "��") {
			this.ganhuoLevel = 6;
		}else if (this.ganhuo == "������") {
			this.ganhuoLevel = 5;
		}else if (this.ganhuo == "��Ƽ�") {
			this.ganhuoLevel = 4;
		}else if (this.ganhuo == "���Ƽ�") {
			this.ganhuoLevel = 3;
		}else if (this.ganhuo == "��Ա") {
			this.ganhuoLevel = 2;
		}else if (this.ganhuo == "����Ա") {
			this.ganhuoLevel = 1;
		}else if (this.ganhuo == "���һ��") {
			this.ganhuoLevel = 13;
		}else if (this.ganhuo == "��߶���") {
			this.ganhuoLevel = 12;
		}else if (this.ganhuo == "�����") {
			this.ganhuoLevel = 11;
		}else if (this.ganhuo == "����ļ�") {
			this.ganhuoLevel = 10;
		}else if (this.ganhuo == "�����弶") {
			this.ganhuoLevel = 9;
		}else if (this.ganhuo == "������") {
			this.ganhuoLevel = 8;
		}else if (this.ganhuo == "�����߼�") {
			this.ganhuoLevel = 7;
		}else if (this.ganhuo == "�а˼�") {
			this.ganhuoLevel = 6;
		}else if (this.ganhuo == "�оż�") {
			this.ganhuoLevel = 5;
		}else if (this.ganhuo == "��ʮ��") {
			this.ganhuoLevel = 4;
		}else if (this.ganhuo == "����ʮһ��") {
			this.ganhuoLevel = 3;
		}else if (this.ganhuo == "����ʮ����") {
			this.ganhuoLevel = 2;
		}else if (this.ganhuo == "Աʮ��") {
			this.ganhuoLevel = 1;
		}
	}
}
