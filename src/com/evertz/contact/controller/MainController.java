package com.evertz.contact.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.evertz.contact.dao.ContactDAO;
import com.evertz.contact.model.Contact;
import com.evertz.contact.service.ContactService;

@Controller
public class MainController {

	@Autowired
	private ContactService service;
	
	@RequestMapping(value = "/")
	public ModelAndView welcomeContact(ModelAndView model) {
		model.setViewName("index");
		 List<Contact> listContact = service.listAll();
		 model.addObject("listContact", listContact);
		return model;
	}

}
