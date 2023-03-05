package com.acts.trekking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Location")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long locId;
	
	@Column(length = 20)
	@NotBlank(message = "Location is required!!!!")
	private String locationName;
	
	@Column(length = 20)
	private String duration;
	
	@Column(length = 30)
	private String gradeOfDifficulty;
	
	@Column(length = 20)
	private long altitude;
	
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
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "packId")
	private Package packageLocation;
	
	

}
