package com.uti.bankApp.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uti.bankApp.models.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);
//	User findByEmail(String email);
	
}