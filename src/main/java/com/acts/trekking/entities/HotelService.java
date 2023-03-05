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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "hotel_service")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString


public class HotelService {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long hsId;

	@Column(length = 100)
	private int vacancy;

	@Column(length = 5)
	private int starRating;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "packId")
	private Package packageHotel;



}
