package com.sms.test;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.sms.dao.IEmployeeDao;
import com.sms.dao.ISalaryDao;
import com.sms.dao.IUserDao;
import com.sms.dao.impl.EmployeeDaoImp;
import com.sms.entity.Employee;
import com.sms.entity.User;

public class TestSalaryDaoImp {
	 public static ISalaryDao iSalaryDao;
	 
	@BeforeClass
	public static void setUp() {
		
	}

	@Test
	public void testFindSalaryById() {
	}

	@Test
	public void testAddSalary() {
		
	}

	@Test
	public void testDeleteSalary() {

	}

	@Test
	public void testModifySalary() {

	}

}
