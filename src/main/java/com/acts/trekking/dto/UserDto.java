package com.acts.trekking.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.acts.trekking.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {

	private long userId;
	@NotEmpty
	@Size(min = 4,message = "Username must be of 4 characters")
	private String userName;
	
	@Email(message = "Email address is not valid")
	private String email;
	
	@NotNull
	@Size(min = 10,max = 10,message = "Please enter the valid number")
	@Pattern(regexp = "^$|[0-9]{10}")     
	private String contact;
	
	@NotEmpty
	private String address;
	
	
	@NotNull
	private Role role;

}
