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

@Controller
public class MainController {

	@Autowired
	private ContactDAO contactDAO;

	@RequestMapping(value = "/")
	public ModelAndView welcomeContact(ModelAndView model) {
		model.setViewName("welcome");
		return model;
	}
	
	@RequestMapping(value = "/adminlogin")
	public ModelAndView adminLoginContact(ModelAndView model) {
		model.setViewName("adminlogin");
		return model;
	}
	
	@RequestMapping(value = "/userlogin")
	public ModelAndView userLoginContact(ModelAndView model) {
		model.setViewName("userlogin");
		return model;
	}

	@RequestMapping(value = "/index")
	public ModelAndView listContact(ModelAndView model, HttpServletRequest req) {
		List<Contact> listContact = contactDAO.list();
		model.addObject("listContact", listContact);
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		if (id.equals("admin") && password.equals("admin")) {
			model.setViewName("index");
			return model;
		} else {
			return new ModelAndView("redirect:/adminlogin");
		}
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Contact newContact = new Contact();
		model.addObject("contact", newContact);
		model.setViewName("contact_form");
		return model;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Contact contact) {
		contactDAO.save(contact);
		return returnList();


	}
	
	public ModelAndView returnList() {
		List<Contact> listContact = contactDAO.list();
		ModelAndView model = new ModelAndView();
		model.addObject("listContact", listContact);
		model.setViewName("index");
		return model;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Contact contact = contactDAO.get(id);

		ModelAndView model = new ModelAndView("update_form");

		model.addObject("contact", contact);
		return model;

	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView updateContact(@ModelAttribute Contact contact, HttpServletRequest request) {
		contactDAO.update(contact);
		return returnList();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteContact(@ModelAttribute Contact contact, HttpServletRequest request) {
		contactDAO.delete(contact);
		return returnList();

	}

}
