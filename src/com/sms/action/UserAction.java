package com.sms.action;

import javax.annotation.Resource;

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

	public static boolean isValid(int value) {
		if (value >= 100000 && value <= 999999)
			return true;
		return false;
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
<<<<<<< HEAD
	
	public String addUser()
	{
		System.out.println("-------userAction.addUser--------"+user.getId());
		
		userManage.addUser(user);
		return "success";
	}
	
	public String modifyUser()
	{
		System.out.println("-------userAction.modifyUser--------"+user.getId());
		userManage.modifyUser(user);
		return "success";
	}
	
	public String deleteUser()
	{
		System.out.println("-------userAction.deleteUser--------"+user.getId());
		userManage.deleteUser(user);
		return "success";
=======

	public String addUser() {
		System.out.println("-------userAction.addUser--------" + user.getId());
		if (isPasswordValid(user.getPassword()))
		if (isValid(user.getId()) && isPasswordValid(user.getPassword()))
		{
			user.setPassword(Md5.generatePassword(user.getPassword()));
			System.out.println("用户增加成功");
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
		if (isValid(user.getId()) && userManage.findUserById(user.getId()) != null && isPasswordValid(user.getPassword()))
		{			
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
>>>>>>> 19c56b2b3b44308a6e77a19bd4ad2aa5baa05851
	}
	
}
