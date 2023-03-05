package com.acts.trekking.entities;
/*
 * <tr key={employee.id}>
                <td>{employee.firstName}</td>
                <td>{employee.lastName}</td>
                <td>{employee.email}</td>
                <td>{employee.workLocation}</td>
                <td>{employee.department}</td>
                <td>{employee.joinDate}</td>
                <td>{employee.salary}</td>
                <td>
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "package")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Package {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long packId;

	@Future(message = "travel date is not valid")
	private LocalDate travelDate;

	private double price;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private User userPackage;
	
	@OneToMany(mappedBy = "packageGuide",
			cascade = CascadeType.ALL, orphanRemoval = true/* ,fetch = FetchType.EAGER */)
	private List<TourGuide> tourGuides = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "packageShop",
			cascade = CascadeType.ALL, orphanRemoval = true/* ,fetch = FetchType.EAGER */)
	private List<GearShop> gearShops = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "packageHotel",
			cascade = CascadeType.ALL, orphanRemoval = true/* ,fetch = FetchType.EAGER */)
	private List<HotelService> hotels = new ArrayList<>();
	
	
	@OneToOne(mappedBy = "packageLocation",
			cascade = CascadeType.ALL, orphanRemoval = true/* ,fetch = FetchType.EAGER */)
	private Location location;
	
	
	@OneToOne(mappedBy = "packagePayment",
			cascade = CascadeType.ALL, orphanRemoval = true/* ,fetch = FetchType.EAGER */)
	private Payment payment;
	


	

}
