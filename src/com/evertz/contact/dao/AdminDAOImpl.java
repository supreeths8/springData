package com.evertz.contact.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import com.evertz.contact.model.Admin;

public class AdminDAOImpl implements AdminDAO {

	private JdbcTemplate jdbcTemplate;

	public AdminDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int save(Admin admin) {
		String sql = "INSERT INTO contact (name,email,address,phone,password) VALUE (?,?,?,?,?)";
		return jdbcTemplate.update(sql, admin.getName(), admin.getEmail(), admin.getAddress(), admin.getPhone(),
				admin.getPassword());
	}

	@Override
	public int update(Admin admin) {
		String sql = "UPDATE contact SET name=?, email=?, address=?, phone=?, password=? WHERE contact_id=?";
		return jdbcTemplate.update(sql, admin.getName(), admin.getEmail(), admin.getAddress(), admin.getPhone(),
				admin.getPassword(), admin.getId());
	}

	@Override
	public Admin get(Integer id) {
		String sql = "SELECT * FROM contact WHERE contact_id=" + id;
		ResultSetExtractor<Admin> extractor = new ResultSetExtractor<Admin>() {

			@Override
			public Admin extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					String name = rs.getString("name");
					String email = rs.getString("email");
					String address = rs.getString("address");
					String phone = rs.getString("phone");
					return new Admin(id, name, email, address, phone);

				}
				return null;
			}
		};
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM contact WHERE contact_id=" + id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Admin> list() {
		String sql = "SELECT * FROM contact";

		RowMapper<Admin> rowMapper = new RowMapper<Admin>() {

			@Override
			public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
				int id = rs.getInt("contact_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				return new Admin(id, name, email, address, phone);
			}

		};

		return jdbcTemplate.query(sql, rowMapper);

	}

	@Override
	public int delete(Admin admin) {
		int id = admin.getId();
		String sql = "DELETE FROM contact WHERE contact_id=" + id;
		return jdbcTemplate.update(sql);
	}

}
