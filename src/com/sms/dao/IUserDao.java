package com.sms.dao;

import com.sms.entity.User;

public interface IUserDao {
	public void AddUser(User user);
	public void modifyUser(User user);
	public void deleteUser(User user);
	public User findUserById(Integer id);
}
