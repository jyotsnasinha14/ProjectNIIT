package com.niit.webchat.testcase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.webchat.dao.EmployeeDao;
import com.niit.webchat.model.Employee;



public class App 
{
    public static void main( String[] args )
    {
    	final Logger logger = LoggerFactory.getLogger(App.class);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		logger.debug("Starting hello");
		context.scan("com.niit.chat");
		logger.debug("Starting hi");
	     context.refresh();
	     logger.debug("Starting bye");
	     Employee employee = (Employee)context.getBean("employee");
	     EmployeeDao employeeDao =(EmployeeDao)context.getBean("employeeDao");
	    
	     
	     logger.debug("Done.!!!");
	     context.close();
    	
	}
    }

