package com.example.demo.controller;

import java.util.List;

import javax.management.relation.Role;
import javax.persistence.EntityExistsException;

import org.apache.catalina.User;
import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.assembler.Assambler;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@Autowired
	PagedResourcesAssembler<Customer> res;
	
	
	  @Autowired private Assambler assembler;
	 

	@PostMapping("/save")
	public Customer createCustomer(@RequestBody Customer customer) {
		Customer create = customerService.customerSave(customer);
		return create;
	}

	@GetMapping(value="/getInfo")
	public ResponseEntity<PagedModel<EntityModel<Customer>>> getInfo(@PageableDefault(value = 10) Pageable pageable) {
		System.out.println("------------------------------------");
		Page<Customer> page = customerService.getInfo(pageable);
		PagedModel<EntityModel<Customer>>  model=res.toModel(page, assembler);
		return new ResponseEntity<PagedModel<EntityModel<Customer>>>(model, HttpStatus.OK);
	}

//		@GetMapping("/get/{pageNo}/{pageSize}")
//		public List<Customer> getInfoWithPagination(@PathVariable("pageNo") int pageNo,@PathVariable("pageSize") int pageSize){
//			//int pageSize = 5;
//			Page<Customer> page = customerService.getInfo(pageNo,pageSize);	
//			List<Customer> list = page.getContent();
//			return list;	
	@PutMapping("/image/{id}")
	public void  updateid(@PathVariable int id,@RequestParam String imageid) {
		 customerService.updateid(id,imageid);
	}
	
	@GetMapping(value = "/get/{id}")
	//@ManagedOperation(value = "get user by id")
	public ResponseEntity<EntityModel<Customer>> get(@PathVariable(value = "id") int id,Assambler assembler){
			
		Customer cs = customerService.getByid(id);
	 	return new ResponseEntity<EntityModel<Customer>>(assembler.toModel(cs), HttpStatus.OK);
	}


	
	/*@PostMapping("/image/{id}")
	public void  getByid(@PathVariable int id) {
		 customerService.getByid(id);
	}*/
}