package com.acts.trekking.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acts.trekking.dto.PackageDto;
import com.acts.trekking.entities.Package;
import com.acts.trekking.exceptions.ResourceNotFoundException;
import com.acts.trekking.repositories.PackageRepo;
import com.acts.trekking.service.PackageService;

@Service
public class PackageServiceImpl implements PackageService {

	@Autowired
	private PackageRepo packageRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public PackageDto createPackage(PackageDto packageDto) {
		Package pakage = this.modelMapper.map(packageDto, Package.class);
		Package addedPackage = this.packageRepo.save(pakage);
		return this.modelMapper.map(addedPackage, PackageDto.class);
	}


	@Override
	public PackageDto updatePackage(PackageDto packageDto, Long packId) {

		Package pack = this.packageRepo.findById(packId).orElseThrow(()->new ResourceNotFoundException("Package", "Package Id", packId));
		pack.setPackId(packageDto.getPackId());
		pack.setTravelDate(packageDto.getTravelDate());
		pack.setPrice(packageDto.getPrice());
		pack.setUserPackage(packageDto.getUserPackage());

		Package updatedPack = this.packageRepo.save(pack);
		
		return this.modelMapper.map(updatedPack, PackageDto.class);
	}

	@Override
	public PackageDto getPackageById(Long packId) {
		Package pack = this.packageRepo.findById(packId).orElseThrow(()-> new ResourceNotFoundException("Package","Package Id",packId ));
		
		return this.modelMapper.map(pack,PackageDto.class);
	}

	@Override
	public List<PackageDto> getAllPackages() {
		List<Package> packages = this.packageRepo.findAll();
		List<PackageDto> collect = packages.stream().map((pack)->this.modelMapper.map(pack, PackageDto.class)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public void deletePackage(Long packId) {
		Package pack= this.packageRepo.findById(packId).orElseThrow(()-> new ResourceNotFoundException("Package","package Id", packId));
		 this.packageRepo.delete(pack);
	}



}
