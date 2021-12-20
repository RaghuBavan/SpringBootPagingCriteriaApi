package com.example.demo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

import javax.activation.DataSource;
import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.ImageModel;
import com.example.demo.service.ImageService;
@RestController
public class ImageContoller<T> {
	
	@Autowired
	private ImageService<T> imageService;

	
	
	  @PostMapping("/save") 
	  public ResponseEntity<String> saveImage(@RequestParam("file") MultipartFile file) throws IOException,
	  Exception{ ImageModel image = imageService.saveImage(file); 
	  return new ResponseEntity<String>(image.getId(),HttpStatus.OK); }
	 
	
	  @GetMapping("/get/{id}") 
	  public ResponseEntity<ImageModel> getImage(@PathVariable("id") String id) throws IOException, Exception{
	  ImageModel image = imageService.getImage(id); 
	  return new ResponseEntity<ImageModel>(image,HttpStatus.OK); }
	 
	
	@GetMapping(value="/get/image/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> getImage1(@PathVariable("id") String id) throws IOException, Exception{
		ImageModel image = imageService.getImage(id);
		byte[] a=image.getImage();
		
		return new ResponseEntity<byte[]>(a,HttpStatus.OK);
	}
}
