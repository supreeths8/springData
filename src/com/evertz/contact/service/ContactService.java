package com.evertz.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evertz.contact.model.Contact;
import com.evertz.contact.model.ContactRepository;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepository repo;
	
	public List<Contact> listAll() {
		return (List<Contact>) repo.findAll();	
	}
	
	
	
}
