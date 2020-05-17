package com.uti.bankApp.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uti.bankApp.models.Account;
import com.uti.bankApp.models.dto.AccountDTO;
import com.uti.bankApp.service.AccountService;

@RestController
@RequestMapping(value="/account")
@CrossOrigin("*")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	
	@PostMapping
	public Account save(@RequestBody AccountDTO accountDTO) {
		return accountService.save(accountDTO);
	}
	
	@PutMapping
	public Account update(@RequestBody AccountDTO accountDTO ) {
		return accountService.update(accountDTO);
	}
	
	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable("id") int id) {
		accountService.delete(id);
		
	}
    
	@GetMapping(value="/{id}")
    public Account findbyId(@PathVariable("id") int id) {
    	return accountService.findbyId(id);
    }
	
	@GetMapping(value="/user/{userId}")
    public List<AccountDTO> findAccountsbyUserId(@PathVariable("userId") long userId) {
    	return accountService.findByUserId(userId);
    }

}
