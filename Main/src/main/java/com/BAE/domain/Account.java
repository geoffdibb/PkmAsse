package com.BAE.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String accountnumber;
	private String userName;
	

	
	public Account() {

	}

	public Account(long id, String accountnumber, String userName) {
		this.id = id;
		this.accountnumber = accountnumber;
		this.userName = userName;



	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
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


	@Override
	public String toString() {

		return "id: " + id + ", username: " + userName;
	}
}
