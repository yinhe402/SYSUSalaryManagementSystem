package com.sms.action;

import java.util.Random;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class InitCaptcha{
    private String captcha;

    public String makeCaptcha() {
    	captcha="";
    	Integer length = new Random().nextInt(3)+4;
    	for(int i=0;i<length;i++){
    		Character temp=  (char)(new Random().nextInt(93)+33);
    		captcha += temp.toString();
    	}

    	ActionContext.getContext().getSession().put("captcha", captcha);
        
        System.out.println(captcha);
        
        return Action.SUCCESS;
    }
 
	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
}
