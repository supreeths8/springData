package com.evertz.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evertz.contact.model.Balance;
import com.evertz.contact.model.BalanceRepository;

@Service
public class BalanceService {
	
	@Autowired
	private BalanceRepository balanceRepo;
	
	@Transactional
	public List<Balance> listAll() {
		return (List<Balance>) balanceRepo.findAll();	
	}
	
	@Transactional
	public void save(Balance balance) {
		balanceRepo.save(balance);
	}

}
