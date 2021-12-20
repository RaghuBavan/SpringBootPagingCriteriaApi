package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.Customer;

public interface CustomRepository<T> {
	Customer save(Customer customer);
	Page<Customer> getInfo(Pageable pageable);
	//Page<Customer> getInfoWithPagination(int pageNumber, int pageSize);
	//public T update(T object, Class<T> clazz);
	//T update(T object, Class<T> clazz);
	public void  updategetImageid(int id,String imageid);
	
	public Customer getId(int id);

}
