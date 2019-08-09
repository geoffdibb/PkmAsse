package com.BAE.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.BAE.domain.Account;
import com.BAE.respository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	private AccountRepository accountRepository;
	private RestTemplate restTemplate;
	private JmsTemplate jmsTemplate;

	public AccountServiceImpl() {

	}

	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
		this.restTemplate = restTemplate;
		this.jmsTemplate = jmsTemplate;
		
	}

	@Override
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public Account createAccount(Account account) {

				return accountRepository.save(account);

	}


	
//    private void sendToQueue(Account account){
//        SentAccount accountToStore =  new SentAccount(account);
//        jmsTemplate.convertAndSend("AccountQueue", accountToStore);
//    }

}