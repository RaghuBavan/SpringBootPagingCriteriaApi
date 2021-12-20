package com.example.demo.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.ImageModel;
import com.example.demo.repository.CommonDao;

import antlr.StringUtils;
@Service
public class ImageServiceImp implements ImageService{
	
	@Autowired
	private CommonDao commonDao;

	@Override
	public ImageModel saveImage(MultipartFile file) throws Exception {
		String fileName = org.springframework.util.StringUtils.cleanPath(file.getOriginalFilename());
			ImageModel image = new ImageModel(fileName, file.getContentType(), file.getBytes());
			commonDao.save(image);
			return image;	
	}
	
	@Override
	public ImageModel getImage(String id){
			return (ImageModel) commonDao.getByID(id, ImageModel.class);
		}
	public ImageModel getImage1(String id){
		return (ImageModel) commonDao.getByID(id, ImageModel.class);
	}
			
	
		

	/*
	 * @Override public Image getImage(String id) { return commonDao.getByID(id,
	 * Image.class); }
	 * 
	 * 
	 * }
	 * 
	 * @Override public String deleteImage(String id) { commonDao.deleteById(id,
	 * Image.class); return "success"; }
	 */
}
