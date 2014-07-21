package com.sms.service;

import com.sms.entity.User;

public interface IUserManage {
	public void addUser(User user);
	public void modifyUser(User user);
	public void deleteUser(User user);
	public User findUserById(Integer id);
}
