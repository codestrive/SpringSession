package com.dev.backend.customer;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

@Component
public class CustomerResourceAssembler implements ResourceAssembler<Customer, Resource<Customer>> {

	@Override
	public Resource<Customer> toResource(Customer customer) {
		 Resource<Customer> resource = new Resource<Customer>(customer);
	        resource.add(linkTo(CustomerController.class).withRel("customers"));
	        resource.add(linkTo(CustomerController.class).slash(customer.getCode()).withSelfRel());
		return resource;
	}
}
