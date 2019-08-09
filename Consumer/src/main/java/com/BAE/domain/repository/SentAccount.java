package com.BAE.domain.repository;

public class SentAccount {

    private Long id;

    private String accountnumber;

    private String userName;
    
    private String search;

    

    public SentAccount(){}

	public String getsearch() {
		return search;
	}


	public void setId(String search) {
		this.search = search;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getAccountnumber() {
		return accountnumber;
	}


	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public SentAccount(Long id, String accountnumber, String userName ,String search) {
		super();
		this.id = id;
		this.accountnumber = accountnumber;
		this.userName = userName;
	}

   
}