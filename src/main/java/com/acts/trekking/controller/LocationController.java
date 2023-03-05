package com.acts.trekking.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.acts.trekking.apiresponse.ApiResponse;
import com.acts.trekking.dto.LocationDto;
import com.acts.trekking.service.ImageHandlingService;
import com.acts.trekking.service.LocationService;

@RestController
@RequestMapping("/api/locations")
@CrossOrigin(origins = "http://localhost:3000")
public class LocationController {

	@Autowired
	private LocationService locationService;
	
	@Autowired
	private ImageHandlingService imageService;
	
	@PostMapping("/")
	public ResponseEntity<LocationDto> createUser(@Valid @RequestBody LocationDto locationDto)
	{
		LocationDto createUserDto = this.locationService.createLocation(locationDto);
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/{locationId}")
	public ResponseEntity<LocationDto> updateUser(@RequestBody LocationDto locationDto, @PathVariable Long locationId)
	{
		LocationDto updateUserDto = this.locationService.updateLocation(locationDto, locationId);
		return ResponseEntity.ok(updateUserDto);
	}
	
	@DeleteMapping("/{locationId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long locationId)
	{
		this.locationService.deleteLocation(locationId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully",true),HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<LocationDto>> getAllUsers()
	{
		return ResponseEntity.ok(this.locationService.getAllLocation());
	}
	
	@GetMapping("/{locationId}")
	public ResponseEntity<LocationDto> getSingleUser(@PathVariable Long locationId)
	{
		return ResponseEntity.ok(this.locationService.getLocationById(locationId));
	}
	
	@PostMapping(value="/{locationId}/image",consumes = "multipart/form-data")
	public ResponseEntity<?> uploadImageToServerSideFolder(@RequestParam MultipartFile imageFile,
			@PathVariable Long locationId
			) throws IOException {
		System.out.println("in upload img " + locationId + " " + imageFile.getOriginalFilename());
		return new ResponseEntity<>(imageService.uploadImage(locationId, imageFile), HttpStatus.CREATED);
	}
	
//	@GetMapping(value = "/{empId}/image", produces = { MediaType.IMAGE_GIF_VALUE, 
//			MediaType.IMAGE_JPEG_VALUE,
//			MediaType.IMAGE_PNG_VALUE })
//	public ResponseEntity<?> serveImageFromServerSideFolder(@PathVariable Long empId) throws IOException {
//		System.out.println("in serve img " + empId);
//		return new ResponseEntity<>(imageService.serveImage(empId), HttpStatus.OK);
//	}
}
