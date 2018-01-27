package com.cust.service;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cust.dao.CustomerDaoInerface;
import com.cust.dao.KeyDaoInterface;
import com.cust.model.Customer;
import com.cust.model.Key;
import com.cust.model.Account;
@Service
public class KeyService implements KeyDaoInterface {
	@Autowired
	KeyDaoInterface keyDao;
	

	public KeyDaoInterface getKeyDao() {
		return keyDao;
	}

	public void setKeyDao(KeyDaoInterface keyDao) {
		this.keyDao = keyDao;
	}

	@Override
	public Key getLastKey() {
		// TODO Auto-generated method stub
		return keyDao.getLastKey();
	}

	@Override
    @Transactional
	public void addKey(Key k) {
		keyDao.addKey(k);
		
	}

	@Override
    @Transactional
	public void updateKey(Key k) {
		keyDao.updateKey(k);
		
	}

	@Override
    @Transactional
	public void deleteKey(Key k) {
		keyDao.deleteKey(k);
		
	}

	@Override
    @Transactional
	public List getallKeys() {
		
		return keyDao.getallKeys();
	}

	@Override
    @Transactional
	public Key getKey(Integer id) {
		
		return keyDao.getKey(id);
	}



}
