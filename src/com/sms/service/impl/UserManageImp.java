package com.sms.service.impl;

import javax.annotation.Resource;

import com.sms.dao.IUserDao;
import com.sms.entity.User;
import com.sms.security.Md5;
import com.sms.service.IUserManage;

public class UserManageImp implements IUserManage {
	
	@Resource  
	private IUserDao userDao;
	
	public IUserDao getUserDao() {	
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void addUser(User user) {
		user.setPassword(Md5.generatePassword(user.getPassword()));
		userDao.AddUser(user);
	}

	@Override
	public void modifyUser(User user) {
		user.setPassword(Md5.generatePassword(user.getPassword()));
		userDao.modifyUser(user);
	}

	@Override
	public void deleteUser(User user) {		
		userDao.deleteUser(user);
	}

	@Override
	public User findUserById(Integer id) {
		return userDao.findUserById(id);
	}

}
