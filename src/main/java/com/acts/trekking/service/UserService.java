package com.acts.trekking.service;

import java.util.List;

import com.acts.trekking.dto.UserDto;

public interface UserService {

	UserDto createUser(UserDto user);

	UserDto updateUser(UserDto user, long userId);

	UserDto getUserById(long userId);

	List<UserDto> getAllUsers();

	void deleteUser(long userId);

}
