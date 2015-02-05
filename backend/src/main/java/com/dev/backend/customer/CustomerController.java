package com.dev.backend.customer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("customer")
public class CustomerController {
	
	protected final Logger log = LoggerFactory.getLogger(getClass());
	 
	
	private CustomerRepository customerRepository;
	private CustomerResourceAssembler customerResourceAssembler;

	@Autowired
	public CustomerController(CustomerRepository customerRepository, CustomerResourceAssembler customerResourceAssembler) {
		this.customerRepository = customerRepository;
		this.customerResourceAssembler = customerResourceAssembler;
	}
	
	@RequestMapping(value="", method=RequestMethod.GET ,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> getAllCustomer(){
		log.debug("getAllCustomer");
		return customerRepository.findAll();
	}
	
	@RequestMapping(value="/{code}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	Resource<Customer> getCustomer(@PathVariable String code) throws CustomerDoesNotExistException{
		log.debug("Get Customer from code "+code);
		Customer customer = customerRepository.findOne(code);
		return customerResourceAssembler.toResource(customer);
	}
	
	@RequestMapping(value="",method=RequestMethod.POST,
			consumes={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_FORM_URLENCODED_VALUE},
			produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
	public Customer saveCustomer(Customer customer){
		log.debug("Customer save via POST" + customer.getCode());
		return customerRepository.save(customer);
	}
	
	@RequestMapping(value="/{code}",method=RequestMethod.PUT,
			consumes={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_FORM_URLENCODED_VALUE},
			produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	@ResponseStatus(HttpStatus.OK)
	public Customer updateCustomer(@RequestBody Customer customer, @PathVariable String code){
		log.info("Customer save via PUT");
		return customerRepository.save(customer);
	}
	
	@RequestMapping(value="/{code}",method=RequestMethod.DELETE,
			produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	public void deleteCustomer(@PathVariable String code){
		log.debug("Delete Customer for customer code "+code);
		customerRepository.delete(code);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String handleBadRequests(Exception e) {
        return e.getMessage();
    }

}
