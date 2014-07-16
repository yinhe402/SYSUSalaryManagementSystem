package com.sms.test;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.sms.dao.IEmployeeDao;
import com.sms.dao.impl.EmployeeDaoImp;

public class TestEmployeeDaoImp {
	 public static IEmployeeDao iemployeeDao;
	 
	@BeforeClass
	public static void setUp() {
		iemployeeDao = new EmployeeDaoImp();
		ApplicationContext ctx = new  FileSystemXmlApplicationContext("WebContent/WEB-INF/applicationContext.xml"); 
	}


	@Test
	public void testFindEmployeeById() {
		Calendar calendar = Calendar.getInstance();
		
		fail("Not yet implemented");
	}

	@Test
	public void testAddEmployee() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteEmployee() {
		fail("Not yet implemented");
	}

	@Test
	public void testModifyEmployee() {
		fail("Not yet implemented");
	}

}
