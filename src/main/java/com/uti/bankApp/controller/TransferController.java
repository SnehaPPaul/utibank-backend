package com.uti.bankApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uti.bankApp.models.dto.TransferDTO;
import com.uti.bankApp.service.impl.TransferServiceImpl;

@RestController
@RequestMapping(value="/transfer")
@CrossOrigin("*")
public class TransferController {
	
	@Autowired
	private TransferServiceImpl transferServiceImpl;
	
	@PostMapping
	public ResponseEntity<Boolean> transfer(@RequestBody TransferDTO dto) {
		
		boolean result=transferServiceImpl.transfer(dto);
		if(result) {
			return new ResponseEntity<Boolean>(result,HttpStatus.OK);
		}else {
			return new ResponseEntity<Boolean>(result,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
