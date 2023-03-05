package com.acts.trekking.dto;

import java.time.LocalDate;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;

import com.acts.trekking.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PackageDto {

	
	private long packId;

	@NotEmpty
	@Future(message = "travel date is not valid")
	private LocalDate travelDate;

	@NotEmpty
	private double price;
	
	@NotEmpty
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private User userPackage;
	
}
