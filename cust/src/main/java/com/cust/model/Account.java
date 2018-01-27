package com.cust.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	private int act_id ;


	private int balance;
	private String sataus; // SATAUS
	private String act_no;	
	private String note ;
	public Account(){}
	public Account(int id,String n){act_id=id;note=n;}
	public int getAct_id() {
		return act_id;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int blance) {
		this.balance = blance;
	}
	
	public String getSataus() {
		return sataus;
	}
	public void setSataus(String sataus) {
		this.sataus = sataus;
	}
	public String getAct_no() {
		return act_no;
	}
	public void setAct_no(String act_no) {
		this.act_no = act_no;
	}
	public void setAct_id(int act_id) {
		this.act_id = act_id;
	}
	/*
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	*/
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
