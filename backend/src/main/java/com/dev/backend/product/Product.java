package com.dev.backend.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	/*
	 * 	Each product has:
		Code: Text Field 
		Description: Text Field 
		Price: Decimal
		Field Quantity : Integer Field
	 */
	
	
	@Id
	private String code;
	@Column
	private String description;
	@Column
	private double price;
	@Column
	private int quantity;
	

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Product [code=" + code + ", description=" + description
				+ ", price=" + price + ", quantity=" + quantity + "]";
	}
	
}
