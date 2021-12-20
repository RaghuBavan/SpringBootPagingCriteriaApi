package com.example.demo.assembler;

import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.example.demo.controller.ImageContoller;
import com.example.demo.model.Customer;

import lombok.extern.java.Log;

@EnableSpringDataWebSupport
@Component
public class Assambler implements RepresentationModelAssembler<Customer, EntityModel<Customer>> {
	
	@Override
	public EntityModel<Customer> toModel(Customer entity) {
		EntityModel<Customer> model = EntityModel.of(entity);
		imagelink(model);

		return model;

	}

	private void imagelink(EntityModel<Customer> entityModel) {
		try {
			entityModel.add(WebMvcLinkBuilder.linkTo(
					WebMvcLinkBuilder.methodOn(ImageContoller.class).getImage1(entityModel.getContent().getImageid()))
					.withRel("imageLink"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
