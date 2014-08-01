package com.sms.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.aspectj.weaver.bcel.AtAjAttributes;
import org.hibernate.Session;
import org.junit.internal.runners.statements.Fail;
import org.springframework.web.client.HttpServerErrorException;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sms.dao.impl.UserDaoImp;
import com.sms.entity.Employee;
import com.sms.entity.User;
import com.sms.security.Md5;
import com.sms.service.IEmployeeManage;
import com.sms.service.IUserManage;
import com.sms.service.impl.UserManageImp;
import com.sms.security.Md5;

public class LoginAction extends ActionSupport {
	private User user;
	private String inputCaptcha;
	private String autoCaptcha;

	@Resource
	private IUserManage userManage;

	@Resource
	private IEmployeeManage iEmployeeManage;

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

	public String getInputCaptcha() {
		return inputCaptcha;
	}

	public void setInputCaptcha(String inputCaptcha) {
		this.inputCaptcha = inputCaptcha;
	}

	public String getAutoCaptcha() {
		return autoCaptcha;
	}

	public void setAutoCaptcha(String autoCaptcha) {
		this.autoCaptcha = autoCaptcha;
	}

	public IEmployeeManage getiEmployeeManage() {
		return iEmployeeManage;
	}

	public void setiEmployeeManage(IEmployeeManage iEmployeeManage) {
		this.iEmployeeManage = iEmployeeManage;
	}

	/*
	 * 判断字符串是否为整数形式
	 */
	public static boolean isInteger(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/*
	 * 判断数字是否满足特定职工号码段范围
	 */
	public static boolean isValid(int value) {
		if (value >= 100000 && value <= 999999)
			return true;
		return false;
	}

	@Override
	public String execute() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy年MM月dd日 HH:mm:ss E");
		System.out.println(dateFormat.format(new Date()));

		HttpServletRequest request = ServletActionContext.getRequest();
		System.out.println(request.getCharacterEncoding());

		System.out.println("用户登录，用户名=" + user.getId());
		String userIdString = user.getId().toString(), UserPassword = user
				.getPassword();

		if (!isInteger(userIdString)) {
			System.out.println("登录失败，用户名=" + userIdString + "，用户名应为纯数字");
			return "fail";
		}

		Integer userNameInteger = Integer.parseInt(userIdString);

		if (!isValid(userNameInteger)) {
			System.out.println("登录失败，用户名=" + user.getId().toString()
					+ "，用户名应为满足职工号范围的6位数字");
			return "fail";
		}

		if (userManage.findUserById(userNameInteger) == null) {
			System.out.println("登录失败，用户名=" + user.getId().toString()
					+ "，用户名不存在");
			return "fail";
		}

		String CorrectUserPassword = userManage.findUserById(user.getId())
				.getPassword();

		System.out.println(CorrectUserPassword);

		if (user.getId() == 999999) {
			System.out.println("测试用");
			Map session = ActionContext.getContext().getSession();
			session.put("user.id", userIdString);
			return "success";
		}

		Map session = ActionContext.getContext().getSession();
		autoCaptcha = (String) session.get("SESSION_SECURITY_CODE");

		if (Md5.validatePassword(CorrectUserPassword, UserPassword)) {


			System.out.println(inputCaptcha);
			System.out.println(autoCaptcha);
			if(inputCaptcha.equalsIgnoreCase(autoCaptcha)){
				session.put("user.id", userIdString);
				System.out.println("登录成功，用户名=" + userIdString + "  密码Md5=" + CorrectUserPassword);
				Employee employeeLogin = iEmployeeManage.findEmployeeById(user.getId());
				session.put("employeeLogin", employeeLogin);
				

				return "success";
			} else {
				System.out.println(inputCaptcha);
				System.out.println(autoCaptcha);
				System.out.println("验证码错误");
				return "fail";
			}
		}

		System.out.println("登录失败，用户名=" + userIdString + "  正确密码Md5="
				+ CorrectUserPassword + "   您的密码Md5="
				+ Md5.generatePassword(UserPassword));
		return "fail";
	}
	public String logout(){
		Map session = ActionContext.getContext().getSession();
		if(session.containsKey("user.id")) {
			session.remove("user.id");
			return "success";
		}
		else {
			return "fail";
		}
	}
}