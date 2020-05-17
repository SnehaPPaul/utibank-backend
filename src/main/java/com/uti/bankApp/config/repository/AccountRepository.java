package com.uti.bankApp.config.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uti.bankApp.models.Account;


@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
      
	public List<Account> findByUserId(long id);
	
	public List<Account> findByAccountTypeAndUserId(String accntType,long id);
	
}
