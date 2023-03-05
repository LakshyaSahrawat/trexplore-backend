package com.acts.trekking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="tour_guide")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class TourGuide {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long guideId;
		@Column(length = 20)
		@NotBlank(message = "Product Name is required!!!!")
		private String guideName;
		
		private String languageknown;
		
		@Column(length = 30 ,precision = 1)
		private Float guideRating;
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "packId")
		private Package packageGuide;
}
