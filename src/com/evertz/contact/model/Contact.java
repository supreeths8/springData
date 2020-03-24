package com.evertz.contact.model;

public class Contact {
	private Integer id;
	private String name;
	private String email;
	private String address;
	private String phone;
	private String password;
	

	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Contact() {
		
	}
	public Contact(Integer id, String name, String email, String address, String phone) {
		this(name, email, address, phone);
		this.id = id;
	}
	
	
	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", phone=" + phone
				+ ", password=" + password + "]";
	}
	
	public Contact(String name, String email, String address, String phone) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}
	
	public Contact(String name, String email, String address, String phone, String password) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

}
