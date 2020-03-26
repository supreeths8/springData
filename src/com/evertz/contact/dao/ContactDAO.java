package com.evertz.contact.dao;

import java.util.List;

import com.evertz.contact.model.Contact;

public interface ContactDAO {
	public int save(Contact contact);

	public int update(Contact contact);

	public Contact get(Integer id);

	public int delete(Integer id);

	public List<Contact> list();

	int delete(Contact contact);
	
	public Contact getBalance(Contact contact);

	public int updateBalance(Contact contact);

	
}
