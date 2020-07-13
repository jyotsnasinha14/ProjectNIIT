package com.niit.webchat.controller;

import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.webchat.dao.EmployeeDao;
import com.niit.webchat.emailservice.EmailService;
import com.niit.webchat.model.Employee;



@Controller
public class UserController 
{
	@Autowired
	private EmailService emailService;
	@Autowired
	private EmployeeDao  employeeDao;
	@RequestMapping(value=("/Sucess"),method=RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("employee") Employee employee,BindingResult result)
	{
//		if(result.hasErrors())
//		{
//			return "register";
//			
//		}
		 
		
		employeeDao.addUser(employee);
	emailService.createdUserMessage(employee, "Hello");
		
		
		return "userPage";
      
	}
	@RequestMapping(value=("/edit"),method=RequestMethod.POST)
	public String updateUser(@Valid @ModelAttribute("employee") Employee employee,BindingResult result)
	{
		/*if(result.hasErrors())
		{
			return "profile";
			
		}*/
		employeeDao.updateUser(employee);
		return "userPage";
      
	}
	
	 @RequestMapping(value=("/del"),method=RequestMethod.GET)
	public String deleteUser(@Valid @ModelAttribute("employee") Employee employee,BindingResult result)
	{
	    /*  if(result.hasErrors())
		{
			return "delete";
		}*/
		
		 employeeDao.deleteUser(employee);
		return "userPage";
		
      
	}
	 
			
	      
		
	 
	
	

}





