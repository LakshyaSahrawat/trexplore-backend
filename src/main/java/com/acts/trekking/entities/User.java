package com.acts.trekking.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;

	@NotBlank(message = "First Name Must be supplied")
	@Length(min = 3, max = 30, message = "Invalid length of the first name")
	@Column(length = 20)
	private String userName;

	@Column(length = 30, unique = true)
	@NotBlank(message = "Email Name is required")
	@Email(message = "Invalid Email Format")
	private String email;

	@Column(length = 10, unique = true)
	private String contact;

	@Column(length = 100)
	private String address;
	
	@OneToOne(mappedBy = "userAccount",
			cascade = CascadeType.ALL, orphanRemoval = true/* ,fetch = FetchType.EAGER */)
	private Account account;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToMany(mappedBy = "userPackage",
			cascade = CascadeType.ALL, orphanRemoval = true/* ,fetch = FetchType.EAGER */)
	private List<Package> packages = new ArrayList<>();


	
	
	

}
