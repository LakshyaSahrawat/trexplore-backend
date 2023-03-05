package com.acts.trekking.service;

import java.util.List;

import com.acts.trekking.dto.AccountDto;
import com.acts.trekking.dto.UserDto;

public interface AccountService {

	AccountDto createAccount(AccountDto accountDto,Long userId);

	AccountDto updateAccount(AccountDto accountDto, Long accountID);

	AccountDto getAccountById(Long accountID);

	List<AccountDto> getAllAccounts();

	void deleteAccount(Long accountID);
	
	UserDto getUserById(Long userId);

}
