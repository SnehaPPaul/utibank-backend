package com.uti.bankApp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uti.bankApp.AppUtil;
import com.uti.bankApp.config.repository.AccountRepository;
import com.uti.bankApp.config.repository.TransactionRepository;
import com.uti.bankApp.models.Account;
import com.uti.bankApp.models.Transaction;
import com.uti.bankApp.models.dto.TransactionResponseDTO;

@RestController
@RequestMapping(value="/transaction")
@CrossOrigin("*")
public class TransactionController {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@GetMapping(value="/{id}")
	public List<TransactionResponseDTO> getTransactions(@PathVariable("id") long userId){
		List<Transaction> transactions= transactionRepository.findByUserId(userId);
		List<TransactionResponseDTO> response=new ArrayList<TransactionResponseDTO>();
		for(Transaction t:transactions) {
			TransactionResponseDTO dto=new TransactionResponseDTO();
			Optional<Account> isaccount=accountRepository.findById(t.getAccntIdTo());
			if(isaccount.isPresent()) {
				Account account=isaccount.get();
				dto.setAccountNumber(AppUtil.getEncryptedAccNuumber(account.getAccNumber()));
				dto.setAmount(t.getAmount());
				dto.setTransactionDate(t.getTransactionDate());
				dto.setEmailId(account.getUser().getUsername());
				response.add(dto);
			}
		}
		return response;
	}

}
