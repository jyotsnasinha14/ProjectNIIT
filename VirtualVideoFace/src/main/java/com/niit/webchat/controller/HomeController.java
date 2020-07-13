package com.niit.webchat.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.webchat.dao.EmployeeDao;
import com.niit.webchat.model.Employee;


@Controller
public class HomeController {
	@Autowired
	private Employee employee;
	@Autowired
	private EmployeeDao employeeDao;
	
	@RequestMapping(value={"/","/index"})
	public String homePage(Model model)
	{
		model.addAttribute("title", "VedioChatApp");
		return "index";
	}
	
	@RequestMapping(value=("/login"))
	public String loginPage(Model model)
	{
		model.addAttribute("title", "Login");
	return "login";
	}
	
	@RequestMapping(value=("/register"))
   public String registerPage(Model model)
   {
		
		model.addAttribute("title", "Registration");
		model.addAttribute("employee", employee);
		
	   return "register";
	   
   }
	//This is User page profile page mapping for update and delete  on same page that is profile page 
	@RequestMapping(value="/tik")
	public String displayPage(Principal p,Model model)
	{
		String emailId= p.getName();
		Employee employee=employeeDao.getUserEmail(emailId);
		model.addAttribute("employee",employee);
        return "profile";
	}
	@RequestMapping(value="/update/{userId}")
	public String profilePage(@PathVariable("userId") int userId,Model model)
	{
		
		Employee employee=employeeDao.getUserById(userId);
		model.addAttribute("title","Profile Page");
		model.addAttribute("employee",employee);
        return "profile";
	}
	//This is User page profile page mapping for update and delete  on same page that is profile page 
	@RequestMapping(value="/tok")
	public String deleteUser(Principal p,Model model)
	{
		String emailId=p.getName();
		Employee employee = employeeDao.getUserEmail(emailId);
		model.addAttribute("employee",employee);
        return "delete";
	}
	
	@RequestMapping(value="/Delete/{userId}")
	public String deletePage(@PathVariable("userId") int userId,Model model)
	{
		
		Employee employee=employeeDao.getUserById(userId);
		model.addAttribute("title","Delete Account Permanently");
		model.addAttribute("employee",employee);
        return "delete";
	}
	@RequestMapping("/admin/Home")
	public String adminPage(Model model)
	{
		
		model.addAttribute("title","Admin");
		return "admin";
	}
	@RequestMapping("/user/Home")
	public String userPage(Model model)
	{
		
		model.addAttribute("title","Home");
		return "userPage";
	}
	@RequestMapping("/UserList")
	public String adminUserList(Model model)
	{
		model.addAttribute("userList",employeeDao. getAllUser());
		model.addAttribute("title","AdminUserList");
		return "userList";
	}
	@RequestMapping("/logout")
	public String logoutPage(Model model)
	{
		model.addAttribute("msg","Logout successfully");
		return "login";
	}
	
	
	
	
	
	
	
	/*@RequestMapping(value=("/vedio"))
	public String vedioPage(Model model)
	{
		model.addAttribute("employee", employee);
		model.addAttribute("title", "VedioBox");
	return "video";
	}*/
	
	
	@RequestMapping(value="/editUser")
	public String editUser(Model model)
	{
		return "editUser";
	}
	@RequestMapping("/srch")
	public String searchList(Model model)
	{
		model.addAttribute("userList",employeeDao. getAllUser());
		model.addAttribute("title","UserList");
		return "searchList";
	}
	/*@RequestMapping(value="/Delete")
	public String deletePage(Principal p,Model model)
	{
		String emailId=p.getName();
		Employee userInfo=employeeDao.getUserEmail(emailId);
		model.addAttribute("title","Delete Account Permanently");
		model.addAttribute("employee",employee);
        return "delete";
	}*/

	
}
