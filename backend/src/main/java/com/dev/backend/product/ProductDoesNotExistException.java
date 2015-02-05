package com.dev.backend.product;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public final class ProductDoesNotExistException extends Exception {

	 public ProductDoesNotExistException(String code) {
	        super(String.format("Product '%d' does not exist", code));
	    }

}
