package com.example.demo.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.ImageModel;

public interface ImageService<T> {

	
    public ImageModel saveImage(MultipartFile file) throws IOException, Exception;
	public ImageModel getImage(String id);
	public ImageModel getImage1(String id);
	  
  
	  //public ImageModel getImage(String id);
	  
	  //public String deleteImage(String id);

	 

}
