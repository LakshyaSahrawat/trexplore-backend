package com.acts.trekking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acts.trekking.dto.AccountDto;
import com.acts.trekking.service.AccountService;

@RestController
@RequestMapping("/api/")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/user/{userId}/account")
	public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto,@PathVariable Long userId ){
		
		AccountDto createdAccountDto = this.accountService.createAccount(accountDto, userId);
		return new ResponseEntity<AccountDto>(createdAccountDto,HttpStatus.CREATED);
		
	}
	
	
	
}
