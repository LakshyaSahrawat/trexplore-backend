package com.acts.trekking.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acts.trekking.exceptions.*;
import com.acts.trekking.dto.UserDto;
import com.acts.trekking.entities.User;
import com.acts.trekking.repositories.UserRepo;
import com.acts.trekking.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto,long userId) {
		User user = userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		
		user.setUserId(userDto.getUserId());
		user.setUserName(userDto.getUserName());
		user.setEmail(userDto.getEmail());
		user.setContact(userDto.getContact());
//		user.setAccount(userDto.getAccount());
		user.setAddress(userDto.getAddress());
//		user.setRole(userDto.getRole());
		
		User updateUser = this.userRepo.save(user);
		UserDto userDto1 = this.userToDto(updateUser);
		
		return userDto1;
	}

	@Override
	public UserDto getUserById(long userId) {
		User user = userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		
		
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = this.userRepo.findAll();
		
		List<UserDto> userDtos = users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	public void deleteUser(long userId) {

		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
		this.userRepo.delete(user);
	}
	
	private User dtoToUser(UserDto userDto)
	{
		User user = this.modelMapper.map(userDto, User.class);
		
//		user.setUserId(userDto.getUserId());
//		user.setUserName(userDto.getUserName());
//		user.setEmail(userDto.getEmail());
//		user.setContact(userDto.getContact());
//		user.setAccount(userDto.getAccount());
//		user.setAddress(userDto.getAddress());
//		user.setRole(userDto.getRole());
//		
		return user;
	}

	
	private UserDto userToDto(User user)
	{
		UserDto userDto = this.modelMapper.map(user, UserDto.class);

		
		return userDto;
	}
}
