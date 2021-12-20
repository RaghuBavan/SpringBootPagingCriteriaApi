package com.example.demo.repository;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ImageModel;



@Repository
@Transactional
public class CommonDaoImp<T> implements CommonDao<T> {
	
	@Autowired
	EntityManager entityManager;

	@Override
	public T save(T object)throws Exception {
		try {
				entityManager.persist(object);
				return object;
		}
		catch (Exception e) {
			throw new Exception(e.getMessage());
		}
			} 
	
	public T getByID(String id, Class<T> clazz){
		
		T t = entityManager.find(clazz,id);
		return t;
	}
	
public T getByID1(String id, Class<T> clazz){
		
		T t = entityManager.find(clazz,id);
		return t;
	}



public T update(T object, Class<T> clazz){
	
		entityManager.merge(object);
		return object;
	}

}



			/*
			 * @Override public ImageModel getImage(String id) { return null; }
			 * 
			 * @Override public String deleteImage(String id) {
			 * 
			 * return null; }
			 */





