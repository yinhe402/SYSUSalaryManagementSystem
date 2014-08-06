package com.sms.test;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.sms.dao.IEmployeeDao;
import com.sms.dao.IManageSalaryDao;
import com.sms.dao.IProfSalaryDao;
import com.sms.dao.ISalaryDao;
import com.sms.dao.IUserDao;
import com.sms.dao.IWorkerSalaryDao;
import com.sms.dao.impl.EmployeeDaoImp;
import com.sms.entity.Employee;
import com.sms.entity.User;
import com.sms.service.IWorkerSalaryManage;

public class TestSalaryStandardDaoImp {
	 public static IWorkerSalaryDao iWorkerSalaryDao;
	 public static IManageSalaryDao iManageSalaryDao;
	 public static IProfSalaryDao iProfSalaryDao;
	@BeforeClass
	public static void setUp() {
		
	}


}
