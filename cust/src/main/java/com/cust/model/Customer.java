package com.cust.model;

import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	
	@Id
	private int custId ;
	private String name ;
	private String email ;
	private String phone ;
	private String lastKey;
	public String getLastKey() {
		return lastKey;
	}
	public void setLastKey(String lastKey) {
		this.lastKey = lastKey;
	}
	public Customer(){}
	public Customer(int id ,String n,String e,String ph)
	{custId=id;name=n;email=e;phone=ph;}

//////getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}

}
