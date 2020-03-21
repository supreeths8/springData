package com.evertz.contact.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.evertz.contact.model.Contact;

public class ContactDAOImpl implements ContactDAO {
	
	
	private JdbcTemplate jdbcTemplate;
	
	public ContactDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public int save(Contact contact) {
		String sql = "INSERT INTO contact (name,email,address,phone) VALUE (?,?,?,?)";
		jdbcTemplate.update(sql, contact.getName(), contact.getEmail(),contact.getAddress(),contact.getPhone());
		return 0;
	}

	@Override
	public int update(Contact contact) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Contact get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Contact> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
