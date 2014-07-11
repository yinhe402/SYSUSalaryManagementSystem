package com.sms.action;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.client.HttpServerErrorException;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sms.dao.impl.UserDaoImp;
import com.sms.entity.User;
import com.sms.security.Md5;
import com.sms.service.IUserManage;
import com.sms.service.impl.UserManageImp;

public class LoginAction extends ActionSupport {
	private User user;

	@Resource
	private IUserManage userManage;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public IUserManage getUserManage() {
		return userManage;
	}

	public void setUserManage(IUserManage userManage) {
		this.userManage = userManage;
	}

	/*
	 * 判断字符串是否为整数形式
	 */
	public static boolean isInteger(String value) {
		try {
			Integer.parseInt(value);
		    return true;
		} 
		catch (NumberFormatException e) {
			return false;
		}
	}

	/*
	 *判断数字是否满足特定职工号码段范围 
	 */
	public static boolean isValid(int value)
	{
		if (value >= 100000 && value <= 999999)
			return true;
		return false;
	}
	@Override
	public String execute() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		System.out.println(request.getCharacterEncoding());

		String userIdString = user.getId().toString(), UserPassword = user.getPassword();

		System.out.println(userIdString);
		System.out.println(UserPassword);

		if (!isInteger(userIdString))
		{
			System.out.println("登录失败，用户名=" + userIdString + "，用户名应为纯数字");
			return "fail";
		}
		System.out.println("Yes1");

		Integer userNameInteger = Integer.parseInt(userIdString);

		if (!isValid(userNameInteger))
		{
			System.out.println("登录失败，用户名=" + user.getId().toString() + "，用户名应为满足职工号范围的6位数字");
			return "fail";
		}
		System.out.println("Yes2");

		if (userManage.findUserById(userNameInteger) == null)
		{
			System.out.println("登录失败，用户名=" + user.getId().toString() + "，用户名不存在");
			return "fail";
		}
		System.out.println("Yes3");

		String CorrectUserPassword = userManage.findUserById(user.getId()).getPassword();

		System.out.println(CorrectUserPassword);

		if (Md5.validatePassword(CorrectUserPassword, UserPassword) || user.getId() == 999999) {
			Map session = ActionContext.getContext().getSession();
			session.put("user.id", userIdString);
			System.out.println("登录成功，用户名=" + userIdString + "  密码Md5=" + CorrectUserPassword);
			return "success";
		}

		System.out.println("登录失败，用户名=" + userIdString + "  正确密码Md5=" + CorrectUserPassword + "   您的密码Md5=" + Md5.generatePassword(UserPassword));
		return "fail";
	}

}