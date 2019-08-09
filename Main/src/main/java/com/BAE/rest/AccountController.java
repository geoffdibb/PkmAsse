package com.BAE.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.BAE.domain.Account;
import com.BAE.service.AccountService;

@RestController
@RequestMapping("/Account")
public class AccountController {
	@Autowired
	public AccountController( AccountService service, RestTemplate restTemplate) {
		this.service = service;
		this.restTemplate = restTemplate;
	}
	
	public AccountController() {
		// TODO Auto-generated constructor stub
	}

	public AccountService service;

	
	private RestTemplate restTemplate;

	

	@RequestMapping("/getAllAccount")
	public List<Account> getAllAccount() {

		return service.findAll();
	}

	@PostMapping(value = "/createAccount")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		Account retVal = service.createAccount(account);
		return new ResponseEntity<>(retVal, HttpStatus.CREATED);
	}

	@GetMapping("/findAccount/{accountId}")
	public boolean findAccount(@PathVariable Long accountId) {

		return service.findAccount(accountId);
 
	}
	

	@GetMapping("/findbynumber/{accountID}/{number}")
	public ResponseEntity<Object> findByNumber(@PathVariable("accountID") Long accountId ,@PathVariable("number") String number) {
		if (service.findAccount(accountId)) {
		
		return service.findByNumber(number);
		}
		else {
		return null;
		}
	}


	@GetMapping("/findbyname/{accountID}/{name}")
	public ResponseEntity<Object> findByName(@PathVariable("accountID") Long accountId ,@PathVariable("name") String name) {
		if (service.findAccount(accountId)) {
			
		return service.findByName(name);
		}
		else
		return null;
		
	}
}


