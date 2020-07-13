package com.niit.webchat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.webchat.dao.EmployeeDao;
import com.niit.webchat.model.ChatMessage;
import com.niit.webchat.model.Employee;

@Controller
public class GroupController
{
	@Autowired
	private Employee employee;
	@Autowired
	private EmployeeDao employeeDao;
	
	
	@RequestMapping(value=("/addGroup"))
	public String groupPage(Model model)
	{
		model.addAttribute("employee", employee);
		model.addAttribute("title", "GroupPage");
	return "group";
	}
	
	@MessageMapping("/chat.register")
	@SendTo("/topic/public")
	public ChatMessage register(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		return chatMessage;
	}

	@MessageMapping("/chat.send")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		return chatMessage;
	}

}
