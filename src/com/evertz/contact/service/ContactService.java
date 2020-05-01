package com.evertz.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evertz.contact.model.Contact;
import com.evertz.contact.model.ContactRepository;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepository contactRepo;
	
	@Transactional
	public List<Contact> listAll() {
		return (List<Contact>) contactRepo.findAll();	
	}
	
	@Transactional
	public void save(Contact contact) {
		contactRepo.save(contact);
	}
	
	
	
}
