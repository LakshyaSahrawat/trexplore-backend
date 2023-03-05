package com.acts.trekking.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LocationDto {

	
	private Long locId;
	
	@Column(length = 20)
	@NotBlank(message = "Location is required!!!!")
	private String locationName;
	
	@Column(length = 20)
	private String duration;
	
	@Column(length = 30)
	private String gradeOfDifficulty;
	
	@Column(length = 20)
	private Long altitude;
	
	private String geoLocation;
	
	private Double trekingKilometres;
	
	@Column(length = 10)
	private Boolean telephoneAvailability;

	private String transportMode;

	private Integer ageLimit;
	
	@Column(length = 300)
	private String image;
	
	@Column(length = 300)
	private String description;
	
	
}
