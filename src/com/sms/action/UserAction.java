package com.sms.action;

import javax.annotation.Resource;

import oracle.net.aso.MD5;

import com.opensymphony.xwork2.ActionSupport;
import com.sms.entity.User;
import com.sms.security.Md5;
import com.sms.service.IUserManage;

public class UserAction extends ActionSupport {

	private User user;

	@Resource
	private IUserManage userManage;
	
	public boolean isPasswordValid(String password)
	{
		if (password.length() < 6)
			return false;
		return true;
	}

	public void setUserManage(IUserManage userManage) {
		this.userManage = userManage;
	}

	public IUserManage getUserManage() {
		return userManage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String addUser() {
		System.out.println("-------userAction.addUser--------" + user.getId());
		if (isPasswordValid(user.getPassword()))
		{
			user.setPassword(Md5.generatePassword(user.getPassword()));
			userManage.addUser(user);
			return "success";
		}
		System.out.println("密码长度不够");
		return "fail";
	}

	public String modifyUser() {
		System.out.println("-------userAction.modifyUser--------" + user.getId());
		if (isPasswordValid(user.getPassword()))
		{
			
			user.setPassword(Md5.generatePassword(user.getPassword()));
			userManage.modifyUser(user);
			return "success";
		}
		System.out.println("密码长度不够");
		return "fail";
	}

	public String deleteUser() {
		System.out.println("-------userAction.deleteUser--------" + user.getId());
		
		if (Md5.validatePassword(userManage.findUserById(user.getId()).getPassword(), user.getPassword()))
		{
			userManage.deleteUser(user);
			return "success";
		}
		System.out.println("密码错误");
		return "fail";
	}
	
}
