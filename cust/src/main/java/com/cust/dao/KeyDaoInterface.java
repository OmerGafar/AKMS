package com.cust.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cust.model.Customer;
import com.cust.model.Key;
//@Service
public interface KeyDaoInterface {
	public void addKey(Key k);
	public void updateKey(Key k);
	public void deleteKey(Key k);
	public List getallKeys();
	public Key getKey(Integer id);
	public Key getLastKey();
}
