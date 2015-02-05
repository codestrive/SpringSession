package com.dev.backend.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	
	/*
	 *  Code: Text Field
		Name: Text Field
		Address : Text Field
		Phone 1: Text Field
		Phone 2: Text Field
		Credit Limit: Decimal Field Current Credit: Decimal Field
	 */
	
	
	@Id
	private String code;
	@Column
	private String name;
	@Column
	private String address;
	@Column
	private String phone1;
	@Column
	private String phone2;
	@Column
	private double creditLimit;

	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public double getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
	
	@Override
	public String toString() {
		return "Customer [code=" + code + ", name=" + name + ", address="
				+ address + ", phone1=" + phone1 + ", phone2=" + phone2
				+ ", creditLimit=" + creditLimit + "]";
	}

}
