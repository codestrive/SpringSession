package com.dev.backend.product;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

@Component
public class ProductResourceAssembler implements ResourceAssembler<Product, Resource<Product>> {

	@Override
	public Resource<Product> toResource(Product product) {
		 Resource<Product> resource = new Resource<Product>(product);
	        resource.add(linkTo(ProductController.class).withRel("products"));
	        resource.add(linkTo(ProductController.class).slash(product.getCode()).withSelfRel());
		return resource;
	}

}
