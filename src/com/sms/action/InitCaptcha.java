package com.sms.action;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.sms.security.SecurityCode;
import com.sms.security.SecurityImage;

import java.io.ByteArrayInputStream;

public class InitCaptcha{  
    //图片流
    private ByteArrayInputStream imageStream;

    public ByteArrayInputStream getImageStream() {
        return imageStream;
    }

    public void setImageStream(ByteArrayInputStream imageStream) {
        this.imageStream = imageStream;
    }

    
    public String execute() throws Exception {     
        //获取默认难度和长度的验证码
        String securityCode = SecurityCode.getSecurityCode();
        System.out.println(securityCode);
        imageStream = SecurityImage.getImageAsInputStream(securityCode);
        //放入session中
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("SESSION_SECURITY_CODE", securityCode);
        
        return Action.SUCCESS;
    }
}
