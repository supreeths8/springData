package com.evertz.contact.dao;

import java.util.List;

import com.evertz.contact.model.Admin;

public interface AdminDAO {
	public int save(Admin admin);

	public int update(Admin admin);

	public Admin get(Integer id);

	public int delete(Integer id);

	public List<Admin> list();

	int delete(Admin admin);

}
