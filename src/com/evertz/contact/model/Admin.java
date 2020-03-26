package com.evertz.contact.model;

public class Admin {
	private Integer id;
	private String name;
	private String email;
	private String address;
	private String phone;
	private String password;

public Admin() {
		
	}
	public Admin(Integer id, String name, String email, String address, String phone) {
		this(name, email, address, phone);
		this.id = id;
	}
	
	public Admin(String name, String email, String address, String phone) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}
	
	public Admin(String name, String email, String address, String phone, String password) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.password = password;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", phone=" + phone
				+ ", password=" + password + "]";
	}

}
