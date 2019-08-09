package com.BAE.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.BAE.domain.Account;

public interface AccountService {

	List<Account> findAll();

	Account createAccount(Account account);

	boolean findAccount(Long accountId);
	
	ResponseEntity<Object> findByNumber(String number, Long accountId);

	ResponseEntity<Object> findByName(String name);

	ResponseEntity<Object> getpokemon( String name);

}