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
		if (this.ganhuo.equals("正部级")) {
			this.ganhuoLevel = 10;
		}else if (this.ganhuo.equals("副部级")) {
			this.ganhuoLevel = 9;
		}else if (this.ganhuo.equals("正厅级")) {
			this.ganhuoLevel = 8;
		}else if (this.ganhuo.equals("副厅级")) {
			this.ganhuoLevel = 7;
		}else if (this.ganhuo.equals("正处级")) {
			this.ganhuoLevel = 6;
		}else if (this.ganhuo.equals("副处级")) {
			this.ganhuoLevel = 5;
		}else if (this.ganhuo.equals("正科级")) {
			this.ganhuoLevel = 4;
		}else if (this.ganhuo.equals("副科级")) {
			this.ganhuoLevel = 3;
		}else if (this.ganhuo.equals("科员")) {
			this.ganhuoLevel = 2;
		}else if (this.ganhuo.equals("办事员")) {
			this.ganhuoLevel = 1;
		}else if (this.ganhuo.equals("正高一级")) {
			this.ganhuoLevel = 13;
		}else if (this.ganhuo.equals("正高二级")) {
			this.ganhuoLevel = 12;
		}else if (this.ganhuo.equals("正高三级")) {
			this.ganhuoLevel = 11;
		}else if (this.ganhuo.equals("正高四级")) {
			this.ganhuoLevel = 10;
		}else if (this.ganhuo.equals("副高五级")) {
			this.ganhuoLevel = 9;
		}else if (this.ganhuo.equals("副高六级")) {
			this.ganhuoLevel = 8;
		}else if (this.ganhuo.equals("副高七级")) {
			this.ganhuoLevel = 7;
		}else if (this.ganhuo.equals("中八级")) {
			this.ganhuoLevel = 6;
		}else if (this.ganhuo.equals("中九级")) {
			this.ganhuoLevel = 5;
		}else if (this.ganhuo.equals("中十级")) {
			this.ganhuoLevel = 4;
		}else if (this.ganhuo.equals("助理十一级")) {
			this.ganhuoLevel = 3;
		}else if (this.ganhuo.equals("助理十二级")) {
			this.ganhuoLevel = 2;
		}else if (this.ganhuo.equals("员十三级")) {
			this.ganhuoLevel = 1;
		}else if (this.ganhuo.equals("技工一级")) {
			this.ganhuoLevel = 6;
		}else if (this.ganhuo.equals("技工二级")) {
			this.ganhuoLevel = 5;
		}else if (this.ganhuo.equals("技工三级")) {
			this.ganhuoLevel = 4;
		}else if (this.ganhuo.equals("技工四级")) {
			this.ganhuoLevel = 3;
		}else if (this.ganhuo.equals("技工五级")) {
			this.ganhuoLevel = 2;
		}else if (this.ganhuo.equals("普通工")) {
			this.ganhuoLevel = 1;
		}
	}
}
