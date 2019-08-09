package com.BAE.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
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
	
		 
	
	public ResponseEntity<Object> getpokemon(String name) {

		return restTemplate.exchange("http://localhost:8082/pokemon/getpokemon/" + name,
				HttpMethod.GET, null, Object.class);
		
		
	}
	

    private void sendToQueue(Search search){
        jmsTemplate.convertAndSend("AccountQueue", search);
    }

}