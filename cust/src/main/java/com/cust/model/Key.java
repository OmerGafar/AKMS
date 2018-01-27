package com.cust.model;



import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Key {

	@Id
	private int keyId ;
	private String activationKey;
	private String status;
		
	public Key() {}
	public Key(int id,String a,String s) 
	{keyId=id;activationKey=a;status=s;}
	//getters and setters	
	
	public String getActivationKey() {
		return activationKey;
	}
	public int getKeyId() {
		return keyId;
	}
	public void setKeyId(int keyId) {
		this.keyId = keyId;
	}
	public void setActivationKey(String activationKey) {
		this.activationKey = activationKey;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

	

}
