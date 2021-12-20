package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.Customer;
public interface CustomerService {

	Customer customerSave(Customer customer);
	Page<Customer> getInfo(Pageable pageable);
	//Page<Customer> getInfowithPagination(int pageNumber, int pageSize);
	public void updateid(int id, String imageid);
	public Customer getByid(int id);

}
