package com.uti.bankApp.config.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uti.bankApp.models.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
	
	 List<Transaction> findByUserId(long userId);

}
