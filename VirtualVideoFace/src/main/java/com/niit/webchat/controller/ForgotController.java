package com.niit.webchat.controller;

import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.webchat.dao.EmployeeDao;
import com.niit.webchat.emailservice.EmailService;
import com.niit.webchat.model.Employee;

@Controller
public class ForgotController {
	@Autowired
	private Employee employee;
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private EmailService emailService;
	
	static String myRandomNumber = "";
	static String userEmail = "";

	
	@RequestMapping(value=("/forget"))
	public String forgetPage(Model model)
	{
		model.addAttribute("employee", employee);
		model.addAttribute("title", "forgetPage");
	return "forget";
	}
	
	
	@RequestMapping(value=("/forgten"))
	public String otpPage(@ModelAttribute("employee") Employee employee, Model model)
	{
		List<Employee> users = employeeDao.getAllUser();
		boolean isEmailValid = false;

		for (Employee user : users) {

			if (user.getUserEmail().equalsIgnoreCase(employee.getUserEmail())) {
				isEmailValid = true;
				userEmail = user.getUserEmail();
			}
		}

		if (isEmailValid) {
			String randomNumber = getRandomNumberString();
			myRandomNumber = randomNumber;
			System.out.println("My Random Nymber is : " + myRandomNumber);
			emailService.createdUserMessage(employee, "\nYour OTP is " + randomNumber);

		} else {
			return "redirect:/forget";
		}
		return "verifyOtp";
	}
	@RequestMapping(value=("/otpverify"))
	public String updatePasswordPage(Model model)
	{
		model.addAttribute("employee", employee);
		model.addAttribute("title", "Update Password");
	return "updatePassword";
	}
	 @RequestMapping(value=("/passwordUpdate"),method=RequestMethod.POST)
		public String otpVerifyPage(@ModelAttribute("userInfo") Employee employee,BindingResult result)
		{
		 Employee user = employeeDao.getUserEmail(userEmail);
		 user.setPassword(user.getPassword());
		 user.setConfrimPassword(user.getConfrimPassword());

		 employeeDao.updateUser(user);
			emailService.createdUserMessage(user,
					"\nYour password has been updated Successfully\n The Updates password is " + employee.getConfrimPassword());
			
			return "login";

		}
	 private String getRandomNumberString() {
		// It will generate 6 digit random Number.
		// from 0 to 999999
		Random rnd = new Random();
		// This line is used to send 6 digit of OTP number
		int number = rnd.nextInt(999999);

		/*
		 * // This line is used to send 4 digit of OTP number int number =
		 * rnd.nextInt(9999);
		 */

		// this will convert any number sequence into 6 character.

		return String.format("%06d", number);

		/*
		 * // this will convert any number sequence into 4 character.
		 * 
		 * return String.format("%04d", number);
		 */
		
	 }
	 
	
	
	
	
}
