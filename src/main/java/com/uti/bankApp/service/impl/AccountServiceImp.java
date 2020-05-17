package com.uti.bankApp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uti.bankApp.AppUtil;
import com.uti.bankApp.config.repository.AccountRepository;
import com.uti.bankApp.config.repository.UserRepository;
import com.uti.bankApp.models.Account;
import com.uti.bankApp.models.User;
import com.uti.bankApp.models.dto.AccountDTO;
import com.uti.bankApp.service.AccountService;


@Service
public class AccountServiceImp implements AccountService{
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Account save(AccountDTO accountDTO) {
		Account account=new Account();
		BeanUtils.copyProperties(accountDTO, account);
		Optional<User> isUser=userRepository.findById(accountDTO.getUserId());
		User user=null;
		if(isUser.isPresent()) {
			user=isUser.get();
		}
		account.setUser(user);
		accountRepository.save(account);
		return null;
	}

	@Override
	public Account update(AccountDTO accountDTO) {
		Account account=new Account();
		BeanUtils.copyProperties(accountDTO, account);
		accountRepository.save(account);
		return null;
	}

	@Override
	public void delete(int id) {
		accountRepository.save(findbyId(id));		
	}

	@Override
	public Account findbyId(int id) {
		Optional<Account> isaccount=accountRepository.findById(id);
		Account account=null;
		if(isaccount.isPresent()) {
			account=isaccount.get();
		}
		return account;
	}

	@Override
	public List<AccountDTO> findByUserId(long id) {
		List<Account> accounts=accountRepository.findByUserId(id);
		
		List<AccountDTO> accountDTOList=new ArrayList<AccountDTO>();
    	for(Account account:accounts) {
    		AccountDTO dto=new AccountDTO();
    		dto.setAccId(account.getAccntId());
    		dto.setAccNumber(AppUtil.getEncryptedAccNuumber(account.getAccNumber()));
    		dto.setAccBalance(account.getAccBalance());
    		dto.setAccountType(account.getAccountType());
    		accountDTOList.add(dto);
    	}
    	
    	return accountDTOList;
	}	
	}
	
	




