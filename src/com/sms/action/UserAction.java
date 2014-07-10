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
		user.setPassword(Md5.generatePassword(user.getPassword()));
		userManage.addUser(user);
		return "success";
	}

	public String modifyUser() {
		System.out.println("-------userAction.modifyUser--------"
				+ user.getId());
		userManage.modifyUser(user);
		return "success";
	}

	public String deleteUser() {
		System.out.println("-------userAction.deleteUser--------"
				+ user.getId());
		userManage.deleteUser(user);
		return "success";
	}
	
	public User findUserById(Integer id) {
		System.out.println("-------userAction.findUserById--------"
				+ id);
		return userManage.findUserById(id);
	}

}
