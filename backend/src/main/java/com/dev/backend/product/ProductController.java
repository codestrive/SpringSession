package com.dev.backend.product;

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
@RequestMapping("product")
public class ProductController {
	
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	private ProductRepository productRepository;
	private ProductResourceAssembler productResourceAssembler;

	@Autowired
	public ProductController(ProductRepository productRepository,ProductResourceAssembler productResourceAssembler) {
		this.productRepository = productRepository;
		this.productResourceAssembler = productResourceAssembler;
	}
	
	@RequestMapping(value="", method=RequestMethod.GET ,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Product> getAllProducts(){
		log.debug("getAllProducts");
		return productRepository.findAll();
	}
	
	@RequestMapping(value="/{code}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	Resource<Product> getProduct(@PathVariable String code) throws ProductDoesNotExistException{
		log.debug("Get Product from code "+code);
		Product product = productRepository.findOne(code);
		return productResourceAssembler.toResource(product);
	}
	
	@RequestMapping(value="",method=RequestMethod.POST,
			consumes={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_FORM_URLENCODED_VALUE},
			produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
	public Product saveProduct(Product product){
		log.debug("Product save via POST" + product.getCode());
		return productRepository.save(product);
	}
	
	@RequestMapping(value="/{code}",method=RequestMethod.PUT,
			consumes={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_FORM_URLENCODED_VALUE},
			produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	@ResponseStatus(HttpStatus.OK)
	public Product updateProduct(@RequestBody Product product, @PathVariable String code){
		log.info("Product save via PUT");
		return productRepository.save(product);
	}
	
	@RequestMapping(value="/{code}",method=RequestMethod.DELETE,
			produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	public void deleteProduct(@PathVariable String code){
		log.debug("Delete Product for product code "+code);
		productRepository.delete(code);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String handleBadRequests(Exception e) {
        return e.getMessage();
    }

}
