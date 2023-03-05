package com.acts.trekking.service;

import java.util.List;

import com.acts.trekking.dto.UserDto;

public interface HotelService {

	UserDto createUser(UserDto user);

	UserDto updateUser(UserDto user, Integer userId);

	UserDto getUserById(Integer userId);

	List<UserDto> getAllUsers();

	void deleteUser(Integer userId);

}
