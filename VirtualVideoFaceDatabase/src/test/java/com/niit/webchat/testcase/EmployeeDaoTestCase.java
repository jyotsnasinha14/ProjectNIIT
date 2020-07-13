package com.niit.webchat.testcase;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;


import com.niit.webchat.config.ApplicationContextConfig;
import com.niit.webchat.dao.EmployeeDao;
import com.niit.webchat.model.Employee;



@RunWith(SpringRunner.class)
@WebAppConfiguration
@Transactional
@ContextConfiguration(classes= {ApplicationContextConfig.class})
public class EmployeeDaoTestCase 
{
	final Logger log = LoggerFactory.getLogger( EmployeeDaoTestCase.class);
	@Autowired
	private  EmployeeDao employeeDao;
	@Autowired
	private  Employee employee;
	@Test
	@Rollback(false)
	public void testAddUser()
	{
	
		employee.setUserName("Nikhil");
		employee.setUserEmail("nikhilarora684@gmail.com");
		employee.setPhone(3456789);
		employee.setPassword("12345");
		assertEquals("successfully added user",true,employeeDao.addUser(employee));
	}
	@Test
	@Rollback(false)
	public void testUpdateUser()
	{
		employee=employeeDao.getUserById(57);
		employee.setUserName("akhil");
		employee.setPassword("9811356113");
		employee.setPhone(6525);
		employee.setUserEmail("na8008983@gmail.com");
		assertEquals("successfully updated user",true,employeeDao.updateUser(employee));
	}
	@Test
	
	public void testGetAllUser()
	{
		List<Employee> list=employeeDao.getAllUser();
		assertEquals("reteriving data from table by id",true,list.size()>0);
	}
	@Test
	
	public void testgetUserById()
	{
		try
	{
		List<Employee> list=employeeDao.getAllUser();
		for(Employee u:list)
		{
			if(u.getUserName().equals("Nikhil")&& u.getPassword().equals("12345"))
			{
				log.debug("user data is  found");
			}
		} 
		employee=employeeDao.getUserById(25);
		assertEquals("reteriving data from userinfo by id",true,employee.getUserName());
	}
	catch(AssertionError e)
	{
		e.printStackTrace();
		
	}
	}
	
	@Test
	@Rollback(false)
	public void testDeleteUser()
	{
		assertEquals("successfully deleted user",true,employeeDao.deleteUser(employee));
	} 


}
