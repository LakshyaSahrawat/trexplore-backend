package com.acts.trekking.service;

import java.util.List;

import com.acts.trekking.dto.PackageDto;

public interface PackageService {

	PackageDto createPackage(PackageDto pakage);

	PackageDto updatePackage(PackageDto pakage, Long packId);

	PackageDto getPackageById(Long packId);

	List<PackageDto> getAllPackages();

	void deletePackage(Long packId);

}
