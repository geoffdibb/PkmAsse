package com.BAE.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String accountnumber;
	private String userName;
	

	
	public Account() {

	}

	public Account(int id, String accountnumber, String userName) {
		this.id = id;
		this.accountnumber = accountnumber;
		this.userName = userName;



	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getuserName() {
		return userName;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}
	
	
	public String getaccountnumber() {
		return accountnumber;
	}

	public void setaccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}



}
