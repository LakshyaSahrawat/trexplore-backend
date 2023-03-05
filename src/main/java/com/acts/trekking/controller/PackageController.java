package com.acts.trekking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acts.trekking.apiresponse.ApiResponse;
import com.acts.trekking.dto.PackageDto;
import com.acts.trekking.service.PackageService;

@RestController
@RequestMapping("/api/packages")
@CrossOrigin(origins = "http://localhost:3000")
public class PackageController {
	
	@Autowired
	private PackageService packageService;
	
	//create
	@PostMapping("/")
	public ResponseEntity<PackageDto> createPackage(@RequestBody PackageDto packageDto)
	{
		PackageDto createPackage = this.packageService.createPackage(packageDto);
		return new ResponseEntity<PackageDto>(createPackage,HttpStatus.CREATED);
	}
	//update
	@PutMapping("/{packId}")
	public ResponseEntity<PackageDto> updatePackage(@RequestBody PackageDto packageDto,@PathVariable Long packId)
	{
		PackageDto updatedPackage = this.packageService.updatePackage(packageDto,packId);
		return new ResponseEntity<PackageDto>(updatedPackage,HttpStatus.OK);
	}
	//delete
	
	public ResponseEntity<ApiResponse> deletePackage(@PathVariable Long packId)
	{
		this.packageService.deletePackage(packId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Package is delete successfully",true),HttpStatus.OK);
	}
	
	//get
	@GetMapping("/{packId}")
	public ResponseEntity<PackageDto> getPackage(@PathVariable Long packId)
	{
		PackageDto packageDto = this.packageService.getPackageById(packId);
		return new ResponseEntity<PackageDto>(packageDto,HttpStatus.OK);
	}
	//getAll
	@GetMapping("/")
	public ResponseEntity<List<PackageDto>> getPackage()
	{
	List<PackageDto> packages =	this.packageService.getAllPackages();
	return ResponseEntity.ok(packages);
		
	}
}
