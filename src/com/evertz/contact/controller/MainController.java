package com.evertz.contact.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.evertz.contact.model.Admin;
import com.evertz.contact.model.Balance;
import com.evertz.contact.model.Contact;
import com.evertz.contact.service.BalanceService;
import com.evertz.contact.service.ContactService;

@Controller
public class MainController {

	@Autowired
	private ContactService service;

	@Autowired
	private BalanceService balanceService;

	@Autowired
	private Admin admin;
	
	String msg = "Wrong Credentials";

	public ModelAndView returnIndex(ModelAndView model) {
		List<Contact> listContact = service.listAll();
		List<Balance> listBalance = balanceService.listAll();
		model.addObject("listContact", listContact);
		model.addObject("listBalance", listBalance);
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping(value = "/")
	public ModelAndView adminContact(ModelAndView model) {
		model.setViewName("adminlogin");
		return model;
	}

	@RequestMapping(value = "/index")
	public ModelAndView login(HttpServletRequest req, HttpSession session) {
		ModelAndView model = new ModelAndView();
		admin.setId(req.getParameter("id"));
		admin.setPassword(req.getParameter("password"));
		session.setAttribute("admin",admin);
		if (admin.getId() == null) {
			model.addObject("message", "Session Error");
			model.setViewName("adminlogin");
		} else if (admin.getId().equals("admin") && admin.getPassword().equals("admin")) {
			model = returnIndex(model);
		} else {
			model.addObject("message", msg);
			model.setViewName("adminlogin");
		}
		return model;

	}

	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView model = new ModelAndView();
		session.invalidate();
		model.setViewName("adminlogin");
		return model;
	}

	@RequestMapping(value = "/new")
	public ModelAndView newContact(HttpSession session) {
		Contact newContact = new Contact();
		ModelAndView model = new ModelAndView();

		if (session.getAttribute("admin") != null) {
			model.addObject(newContact);
			model.setViewName("contact_form");
		} else {
			msg = "Session error";
			model.setViewName("adminlogin");
			model.addObject("message", msg);
		}
		return model;
	}

	public void saveFunction(Contact saveContact, Balance saveBalance) {
		saveBalance.setAmount(0);
		service.save(saveContact);
		balanceService.save(saveBalance);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Contact contact, Balance balance) {
		ModelAndView model = new ModelAndView();
		saveFunction(contact, balance);
		model = returnIndex(model);
		return model;
	}
	
	@RequestMapping(value = "/edit")
	public ModelAndView editContact(@RequestParam int id, HttpSession session) {
		ModelAndView model = new ModelAndView();
		Contact editContact = service.get(id);
		System.out.println(editContact);
		if (session.getAttribute("admin") != null) {
			model.addObject(editContact);
			model.setViewName("update_form");
		} else {
			msg = "Session error";
			model.setViewName("adminlogin");
			model.addObject("message", msg);
		}
	
		return model;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updateContact(@ModelAttribute("contact") Contact contact) {
		ModelAndView model = new ModelAndView();
		System.out.println(contact);
		service.save(contact);
		model = returnIndex(model);
		return model;
	}
	
	

}
