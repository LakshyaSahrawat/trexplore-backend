package com.acts.trekking.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.acts.trekking.entities.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountDto {

	private long accountId;

	@NotBlank(message = "User Name Must be supplied")
	@Length(min = 5, max = 30, message = "Invalid length of the user name")
	@Column(length = 20)
	private String userName;

	@JsonProperty(access = Access.WRITE_ONLY)
//	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20}", message = "Invalid Password!")
	private String password;
	
	private User userAccount;
	
}
