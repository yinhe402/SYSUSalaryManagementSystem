package com.sms.test;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.sms.dao.IEmployeeDao;
import com.sms.dao.impl.EmployeeDaoImp;
import com.sms.entity.Employee;
import com.sms.entity.User;

public class TestEmployeeDaoImp {
	 public static IEmployeeDao iemployeeDao;
	 
	@BeforeClass
	public static void setUp() {
		iemployeeDao = new EmployeeDaoImp();
		ApplicationContext ctx = new  FileSystemXmlApplicationContext("/Config/applicationContext-beans.xml"); 
		iemployeeDao = (IEmployeeDao) ctx.getBean("employeeDao");
	}


	@Test
	public void testFindEmployeeById() {
	Employee employee = iemployeeDao.findEmployeeById(113311);
	}

	@Test
	public void testAddEmployee() {
		
	}

	@Test
	public void testDeleteEmployee() {

	}

	@Test
	public void testModifyEmployee() {

	}

}
