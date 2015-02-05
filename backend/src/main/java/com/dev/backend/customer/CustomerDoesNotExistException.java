package com.dev.backend.customer;

public class CustomerDoesNotExistException extends Exception {
	
	public CustomerDoesNotExistException(String code){
		super(String.format("Customer '%d' does not exist", code));
	}

}
