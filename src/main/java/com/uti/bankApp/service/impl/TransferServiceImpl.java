package com.uti.bankApp.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uti.bankApp.config.repository.AccountRepository;
import com.uti.bankApp.config.repository.TransactionRepository;
import com.uti.bankApp.models.Account;
import com.uti.bankApp.models.Transaction;
import com.uti.bankApp.models.dto.TransferDTO;

@Service
public class TransferServiceImpl {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private TransactionRepository transactionRepo;
	
	public boolean transfer(TransferDTO dto) {
		boolean result=false;
		Optional<Account> isFromAccount=accountRepository.findById(dto.getAccountIdFrom());
		Optional<Account> isToAccount=accountRepository.findById(dto.getAccountIdTo());
		
		if(isFromAccount.isPresent() && isToAccount.isPresent()) {
			Account toAccount=isToAccount.get();
			Account fromAccount=isFromAccount.get();
			
			if(dto.getMoney()>fromAccount.getAccBalance() || dto.getMoney()<=0) {
				result= false;
				return result;
			}
			fromAccount.setAccBalance(fromAccount.getAccBalance()-dto.getMoney());
			toAccount.setAccBalance(toAccount.getAccBalance()+dto.getMoney());
			
			accountRepository.save(fromAccount);
			accountRepository.save(toAccount);
			
			Transaction t=new Transaction();
			t.setAccntIdFrom(fromAccount.getAccntId());
			t.setAccntIdTo(toAccount.getAccntId());
			t.setTransactionDate(new Date());
			t.setAmount(dto.getMoney());
			t.setUserId(dto.getUserId());
			transactionRepo.save(t);
			result=true;
			
		}
		
		return result;
	}
	
	
}
