package com.acts.trekking.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acts.trekking.dto.LocationDto;
import com.acts.trekking.entities.Location;
import com.acts.trekking.exceptions.ResourceNotFoundException;
import com.acts.trekking.repositories.LocationRepo;
import com.acts.trekking.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepo locationRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public LocationDto createLocation(LocationDto locationDto) {
		Location location = this.modelMapper.map(locationDto, Location.class);
		Location savedLoc = this.locationRepo.save(location);
		
		return this.modelMapper.map(savedLoc, LocationDto.class);
	}

	@Override
	public LocationDto updateLocation(LocationDto locationDto, Long locationId) {
		Location location = this.locationRepo.findById(locationId).orElseThrow(()-> new ResourceNotFoundException("Location", "location Id ", locationId));
		
		location.setLocId(locationDto.getLocId());
		location.setLocationName(locationDto.getLocationName());
		location.setDuration(locationDto.getDuration());
		location.setAltitude(locationDto.getAltitude());
		location.setGeoLocation(locationDto.getGeoLocation());
		location.setTrekingKilometres(locationDto.getTrekingKilometres());
		location.setTelephoneAvailability(locationDto.getTelephoneAvailability());
		location.setTransportMode(locationDto.getTransportMode());
		location.setAgeLimit(locationDto.getAgeLimit());
		location.setGradeOfDifficulty(locationDto.getGradeOfDifficulty());
//		location.setImage(locationDto.getImage());
		location.setDescription(locationDto.getDescription());
		
		Location updatedLoc = this.locationRepo.save(location);
		
		return this.modelMapper.map(updatedLoc, LocationDto.class);
	}

	@Override
	public LocationDto getLocationById(Long locationId) {
		Location location = this.locationRepo.findById(locationId).orElseThrow(()-> new ResourceNotFoundException("Location", "location Id ", locationId));
		
		return this.modelMapper.map(location, LocationDto.class);
	}

	@Override
	public List<LocationDto> getAllLocation() {
		List<Location> locations = this.locationRepo.findAll();
		
		List<LocationDto> locationDtos = locations.stream().map((location)-> this.modelMapper.map(location, LocationDto.class)).collect(Collectors.toList());
		
		return locationDtos;
	}

	@Override
	public void deleteLocation(Long locationId) {
		Location location = this.locationRepo.findById(locationId).orElseThrow(()-> new ResourceNotFoundException("Location", "location Id ", locationId));

		this.locationRepo.delete(location);
	}

}
