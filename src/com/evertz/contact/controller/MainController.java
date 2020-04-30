package com.evertz.contact.controller;

import java.net.http.HttpResponse;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.evertz.contact.model.Admin;
import com.evertz.contact.model.Contact;
import com.evertz.contact.service.ContactService;

@Controller
public class MainController {

	@Autowired
	private ContactService service;
	
	@Autowired
	private Admin admin;

	@RequestMapping(value = "/")
	public ModelAndView adminContact(ModelAndView model) {
		model.setViewName("adminlogin");
		List<Contact> listContact = service.listAll();
		model.addObject("listContact", listContact);
		return model;
	}
	
	@RequestMapping(value = "/index")
	public ModelAndView login(HttpSession session, HttpServletRequest req) {
		ModelAndView model = new ModelAndView();
		String msg="Wrong Credentials";
		admin.setId(req.getParameter("id"));
		admin.setPassword(req.getParameter("password"));
		if(admin.getId().equals("testing") && admin.getPassword().equals("admin")) {
			session.setAttribute("user", admin);
		}
		else {
			model.addObject("message", msg);
			model.setViewName("adminlogin");
	        return model;
		}
		model.setViewName("index");
		return model;
		
	}

}
