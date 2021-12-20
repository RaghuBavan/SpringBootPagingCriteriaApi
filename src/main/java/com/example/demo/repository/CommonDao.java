package com.example.demo.repository;

import com.example.demo.model.ImageModel;

public interface CommonDao<T> {
	
	//public ImageModel saveImage(MultipartFile file);
	
	//public ImageModel getImage(String id);
	
	//public String deleteImage(String id);

	//public T save(T object, Class<T> clazz) throws Exception;

	T save(T object) throws Exception;
	T getByID(String id, Class<T> clazz);
	T getByID1(String id, Class<T> clazz);
	public T update(T object, Class<T> clazz);
}
