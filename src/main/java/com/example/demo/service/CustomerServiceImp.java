package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomRepository;
@Service
public class CustomerServiceImp implements CustomerService {
	@Autowired
	CustomRepository  customerRepository;
	
	@Override
	public Customer customerSave(Customer customer) {
		return customerRepository.save(customer);
	}

	/*
	 * @Override public Page<Customer> getInfo(int pageNo,int pageSize) { Pageable
	 * pageable = PageRequest.of(pageNo-1,pageSize); return
	 * customerRepository.getInfo(pageable); }
	 */
	/*
	 * @Override public Page<Customer> getInfowithPagination(int pageNumber, int
	 * pageSize) { return customerRepository.getInfoWithPagination(pageNumber,
	 * pageSize); }
	 */

	@Override
	public Page<Customer> getInfo(Pageable pageable) {
		//Pageable pageable1 = PageRequest.of(pageNo-1,pageSize);
		return customerRepository.getInfo(pageable);	
	}
	@Override
	public void  updateid(int id,String imageid) {
		 customerRepository.updategetImageid(id,imageid);
	}
	
	@Override
	public Customer getByid(int id) {
		return customerRepository.getId(id);
	}
	

}
