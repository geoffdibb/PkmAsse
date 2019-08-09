package com.BAE.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BAE.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long>  {


}