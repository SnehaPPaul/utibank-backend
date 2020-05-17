package com.uti.bankApp.service;

import java.util.List;

import com.uti.bankApp.models.Account;
import com.uti.bankApp.models.dto.AccountDTO;

public interface AccountService {
	
	public Account save(AccountDTO accountDTO);
	
	public Account update(AccountDTO accountDTO);
	
	public void delete(int id);
	
	public Account findbyId(int id);
	
	public List<AccountDTO> findByUserId(long id);
	
	
	
	
	

}