package com.sms.test;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.sms.dao.IEmployeeDao;
import com.sms.dao.IUserDao;
import com.sms.dao.impl.EmployeeDaoImp;
import com.sms.entity.Employee;
import com.sms.entity.User;

public class TestOffInfo {
	 public static IUserDao iemployeeDao;
	 
	@BeforeClass
	public static void setUp() {
		
	}

	@Test
	public void testFindUserById() {
	}

	@Test
	public void testAddUser() {
		
	}

	@Test
	public void testDeleteUser() {

	}

	@Test
	public void testModifyUser() {

	}

}
