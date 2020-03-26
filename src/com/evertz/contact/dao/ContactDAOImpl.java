package com.evertz.contact.dao;

import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.evertz.contact.model.Contact;

public class ContactDAOImpl implements ContactDAO {
	
	
	private JdbcTemplate jdbcTemplate;
	
	public ContactDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int saveBalance(Contact contact) {
		String sql = "INSERT INTO balance (amount) VALUE (?)";
		return jdbcTemplate.update(sql,0);
	}
	@Override
	public int save(Contact contact) {
		String sql = "INSERT INTO contact (name,email,address,phone,password) VALUE (?,?,?,?,?)";
		saveBalance(contact);
		return jdbcTemplate.update(sql, contact.getName(), contact.getEmail(),contact.getAddress(),contact.getPhone(),contact.getPassword());
	
	}

	@Override
	public int update(Contact contact) {
		String sql = "UPDATE contact SET name=?, email=?, address=?, phone=? WHERE contact_id=?";
		return jdbcTemplate.update(sql, contact.getName(), contact.getEmail(),contact.getAddress(),contact.getPhone(), contact.getId());
	}
	
	public int updateBalance(Contact contact) {
	
		String sql = "UPDATE balance SET amount=? WHERE contact_id=?";
		return jdbcTemplate.update(sql,contact.getBalance(),contact.getId());
	}
	
	
	
	public Contact getBalance(Contact contact) {
		String sql = "SELECT * FROM balance WHERE contact_id="+contact.getId();
		ResultSetExtractor<Contact> extractor = new ResultSetExtractor<Contact>() {

			@Override
			public Contact extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					int id  = rs.getInt("contact_id");
					float amount = rs.getFloat("amount");
					
					return new Contact(id, contact.getName(), contact.getEmail(), contact.getAddress(), contact.getPhone(), contact.getPassword(),amount);

				}
				return null;
			}
		};
		return jdbcTemplate.query(sql, extractor);
	}
	
	
	
	@Override
	public Contact get(Integer id) {
		String sql = "SELECT * FROM contact WHERE contact_id="+id;
		ResultSetExtractor<Contact> extractor = new ResultSetExtractor<Contact>() {

			@Override
			public Contact extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					String name  = rs.getString("name");
					String email  = rs.getString("email");
					String address  = rs.getString("address");
					String phone  = rs.getString("phone");
					String password = rs.getString("password");					
					return new Contact(id, name, email, address, phone, password);

				}
				return null;
			}
		};
		return jdbcTemplate.query(sql, extractor);
	}

	
	
	public int deleteBalance(int id) {
		String sql = "DELETE FROM balance WHERE contact_id="+id;
		return jdbcTemplate.update(sql);
	}
	
	
	@Override
	public int delete(Contact contact) {
		int id = contact.getId();
		deleteBalance(id);
		String sql = "DELETE FROM contact WHERE contact_id="+id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Contact> list() {
		String sql = "SELECT * FROM contact";
		
		RowMapper<Contact> rowMapper = new RowMapper<Contact>() {

			@Override
			public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
				int id  = rs.getInt("contact_id");
				String name  = rs.getString("name");
				String email  = rs.getString("email");
				String address  = rs.getString("address");
				String phone  = rs.getString("phone");
				String password = rs.getString("password");
				Contact c = new Contact(id, name, email, address, phone,password);
				
				return getBalance(c);
			}
			
		};
		
		
		return jdbcTemplate.query(sql, rowMapper);
		
	
	}
	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM contact WHERE contact_id="+id;
		return jdbcTemplate.update(sql);
	}


}
