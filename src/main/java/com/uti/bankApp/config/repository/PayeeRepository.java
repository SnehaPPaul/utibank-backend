package com.uti.bankApp.config.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uti.bankApp.models.Payee;

@Repository
public interface PayeeRepository extends JpaRepository<Payee, Integer>{
	
	List<Payee> findByUserId(long userId);
	Payee findByPayeeUserId(long payeeUserId);
	}
