package com.acts.trekking.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.acts.trekking.apiresponse.ApiResponse;


public interface ImageHandlingService {

	ApiResponse uploadImage(Long locationId, MultipartFile imageFile) throws IOException;
	byte[] serveImage(Long locationId) throws IOException;

}
