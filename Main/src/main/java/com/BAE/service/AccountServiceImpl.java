package com.BAE.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.BAE.domain.Account;
import com.BAE.domain.Search;
import com.BAE.respository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	private AccountRepository accountRepository;
	private RestTemplate restTemplate;
	private JmsTemplate jmsTemplate;

	public AccountServiceImpl() {

	}

	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository, RestTemplate restTemplate, JmsTemplate jmsTemplate) {
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

	@Override
	public boolean findAccount(Long accountId) {

		Optional<Account> optAcc = accountRepository.findById(accountId);

		if (optAcc.isPresent()) {

			return true;
		} else {
			
			return false;
		}
				
	}
	
	@Override
	public ResponseEntity<Object> findByNumber(String number) {

		HttpHeaders headers = new HttpHeaders();
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
//		Search acc = new Search();
//		acc.setsearchterm(number);
//		acc.setTime(LocalDateTime.now().toString());
//		acc.getAccountnumber();
//		acc.getId();
//		acc.getUserName();
//		
//		sendToQueue(acc);
		
		return restTemplate.exchange("https://pokeapi.co/api/v2/pokemon/"+number, HttpMethod.GET, entity, Object.class);

	}

	
	@Override
	public ResponseEntity<Object> findByName(String name) {

		HttpHeaders headers = new HttpHeaders();
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		return restTemplate.exchange("https://pokeapi.co/api/v2/pokemon/"+name, HttpMethod.GET, entity, Object.class);

	}
	
//    private void sendToQueue(Search search){
//        jmsTemplate.convertAndSend("AccountQueue", search);
//    }

}