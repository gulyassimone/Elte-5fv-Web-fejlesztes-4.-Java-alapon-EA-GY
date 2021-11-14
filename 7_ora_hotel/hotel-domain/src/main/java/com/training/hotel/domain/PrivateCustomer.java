package com.training.hotel.domain;

import javax.persistence.Entity;

@Entity
public class PrivateCustomer extends Customer {

	private String fullName;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
}
