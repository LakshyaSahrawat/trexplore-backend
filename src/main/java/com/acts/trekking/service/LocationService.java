package com.acts.trekking.service;

import java.util.List;

import com.acts.trekking.dto.LocationDto;

public interface LocationService {

	LocationDto createLocation(LocationDto location);

	LocationDto updateLocation(LocationDto location, Long locationId);

	LocationDto getLocationById(Long locationId);

	List<LocationDto> getAllLocation();

	void deleteLocation(Long locationId);

}
