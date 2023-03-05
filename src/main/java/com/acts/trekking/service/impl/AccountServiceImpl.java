package com.acts.trekking.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acts.trekking.dto.AccountDto;
import com.acts.trekking.dto.UserDto;
import com.acts.trekking.entities.Account;
import com.acts.trekking.entities.User;
import com.acts.trekking.exceptions.ResourceNotFoundException;
import com.acts.trekking.repositories.AccountRepo;
import com.acts.trekking.repositories.UserRepo;
import com.acts.trekking.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepo accountRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	
	@Override
	public AccountDto createAccount(AccountDto accountDto,Long userId) {
		
		User user = userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		
		
		Account account = this.modelMapper.map(accountDto, Account.class);
		account.setUserAccount(user);
		Account savedAccount = this.accountRepo.save(account);
		
		return this.modelMapper.map(savedAccount, AccountDto.class);
	}

	@Override
	public AccountDto updateAccount(AccountDto accountDto, Long accountID) {
		
		return null;
	}

	@Override
	public AccountDto getAccountById(Long accountID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountDto> getAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAccount(Long accountID) {
		// TODO Auto-generated method stub

	}

//	@Override
//	public UserDto getUserById(Long userId) {
//		User user = userRepo.findById(userId)
//				.orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
//		
//		return this.modelMapper.map(user, UserDto.class);
//	}

}
