package com.BAE.domain.repository;

public class Search {

    private Long id;

    private String accountnumber;

    private String userName;
    
    private String searchterm;
    
    private String time;

    

    public Search(){}

	public String getsearchterm() {
		return searchterm;
	}


	public void setsearchterm(String searchterm) {
		this.searchterm = searchterm;
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


	public Search(Long id, String accountnumber, String userName ,String searchterm, String time) {
		super();
		this.id = id;
		this.accountnumber = accountnumber;
		this.userName = userName;
		this.searchterm = searchterm;
		this.time = time;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

   
}