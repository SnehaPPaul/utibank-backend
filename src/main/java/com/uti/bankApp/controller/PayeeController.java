package com.uti.bankApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uti.bankApp.models.dto.PayeeRequestDTO;
import com.uti.bankApp.models.dto.PayeeResponseDTO;
import com.uti.bankApp.service.impl.PayeeServiceImpl;

@RestController
@RequestMapping(value="/payee")
@CrossOrigin("*")
public class PayeeController {
	
	@Autowired
	private PayeeServiceImpl pServiceImpl;

	@PostMapping
	public boolean save(@RequestBody PayeeRequestDTO payeeRequestDTO){
		return pServiceImpl.save(payeeRequestDTO);
	}
	
	@GetMapping(value="/{userId}")
	public List<PayeeResponseDTO> getPayees(@PathVariable("userId") long userId){
		return pServiceImpl.getPayees(userId);
	}
}
