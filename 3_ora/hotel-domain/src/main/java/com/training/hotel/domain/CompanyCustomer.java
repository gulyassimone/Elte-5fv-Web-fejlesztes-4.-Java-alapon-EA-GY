package com.training.hotel.domain;

import javax.persistence.Entity;

@Entity
public class CompanyCustomer extends Customer {

	String taxnumber;

	public String getTaxnumber() {
		return taxnumber;
	}

	public void setTaxnumber(String taxnumber) {
		this.taxnumber = taxnumber;
	}
}
