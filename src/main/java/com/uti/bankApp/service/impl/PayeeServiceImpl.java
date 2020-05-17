package com.uti.bankApp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uti.bankApp.AppUtil;
import com.uti.bankApp.config.repository.AccountRepository;
import com.uti.bankApp.config.repository.PayeeRepository;
import com.uti.bankApp.config.repository.UserRepository;
import com.uti.bankApp.constants.AppConstants;
import com.uti.bankApp.models.Account;
import com.uti.bankApp.models.Payee;
import com.uti.bankApp.models.User;
import com.uti.bankApp.models.dto.PayeeRequestDTO;
import com.uti.bankApp.models.dto.PayeeResponseDTO;

@Service
public class PayeeServiceImpl {
	
	@Autowired
	private PayeeRepository payeeRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	
	public boolean save(PayeeRequestDTO payeeRequestDTO) {
		boolean result;
		User payeeUser=userRepository.findByUsername(payeeRequestDTO.getPayeeEmailId());
//		if(isPayeeExists(payeeUser.getId())) {
//			return false;
//		}
		Optional<User> actualUser=userRepository.findById(payeeRequestDTO.getUserId());
		Payee p=new Payee();
		if(actualUser.isPresent() && payeeUser!=null) {
			p.setUser(actualUser.get());
			p.setPayeeUserId(payeeUser.getId());
			
			payeeRepository.save(p);
			result=true;
		}else {
			result=false;
		}
		
		
		return result;
		
	}
	
	private boolean isPayeeExists(long payeeUserId){
		if(payeeRepository.findByPayeeUserId(payeeUserId)!=null) {
			return true;
		}else {
			return false;
		}
	}
	

	public List<PayeeResponseDTO> getPayees(long userId){
		List<PayeeResponseDTO> payeeResponse=new ArrayList<PayeeResponseDTO>();
		
		List<Payee> payees=payeeRepository.findByUserId(userId);
		
		for(Payee p:payees) {
			PayeeResponseDTO prd=new PayeeResponseDTO();
			List<Account> accounts=accountRepository.findByAccountTypeAndUserId(AppConstants.CHECKINGACCOUNT, p.getPayeeUserId());
			if(accounts!=null) {
				Account account=accounts.get(0);
				prd.setAccntId(account.getAccntId());
				prd.setAccNumber(AppUtil.getEncryptedAccNuumber(account.getAccNumber()));
				prd.setEmailId(account.getUser().getUsername());
				prd.setFirstName(account.getUser().getFirstName());
				prd.setLastName(account.getUser().getLastName());
				payeeResponse.add(prd);
			}
			
			
			
			
		}
		
		
	
		
		return payeeResponse;
	}

}
