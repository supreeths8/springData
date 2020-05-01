package com.evertz.contact.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
		return model;
	}
	
	@RequestMapping(value = "/index")
	public ModelAndView login(HttpServletRequest req, HttpSession session) {
		ModelAndView model = new ModelAndView();
		String msg="Wrong Credentials";
		admin.setId(req.getParameter("id"));
		admin.setPassword(req.getParameter("password"));
		if(admin.getId()==null) {
			model.addObject("message", "Session Error");
			model.setViewName("adminlogin");
		}
		else if(admin.getId().equals("admin") && admin.getPassword().equals("admin")) {
			session.setAttribute("user", admin);
			List<Contact> listContact = service.listAll();
			model.addObject("listContact", listContact);
			model.setViewName("index");
		}
		else {
			model.addObject("message", msg);
			model.setViewName("adminlogin");
		}
		return model;

		
	}
	
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView model= new ModelAndView();
		session.invalidate();
		model.setViewName("adminlogin");
		return model;
	}
	
	@RequestMapping(value = "/new")
	public ModelAndView newContact(HttpSession session) {
		String msg = "";
		Contact newContact = new Contact();
		ModelAndView model = new ModelAndView();
		
		if(session.getAttribute("user")!=null) {
			model.addObject(newContact);
			model.setViewName("contact_form");
		}
		else {
			msg = "Session error";
			model.setViewName("adminlogin");
			model.addObject("message", msg);
		}
		return model;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Contact contact) {
		ModelAndView model = new ModelAndView();
		service.save(contact);
		model.setViewName("index");
		return model;
	}
	
	

}
