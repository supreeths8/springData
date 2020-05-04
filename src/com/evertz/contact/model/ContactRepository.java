package com.evertz.contact.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer>{
//	@Query("SELECT n from contact n WHERE n.email = ?1")
//	public List<Contact> findByEmail(String email); 
}
