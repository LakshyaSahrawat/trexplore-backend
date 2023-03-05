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
@Table(name="Gear_Shop")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class GearShop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	
	@Column(length = 20)
	@NotBlank(message = "Product Name is required!!!!")
	private String productName;
	
	private Double productPrice;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "packId")
	private Package packageShop;
	
	
}
