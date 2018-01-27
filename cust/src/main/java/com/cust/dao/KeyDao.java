package com.cust.dao;




import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;


import com.cust.model.Key;
@Service
@Configuration
@EnableTransactionManagement
@ImportResource({ "classpath:ApplicationContext.xml" })
public class KeyDao implements KeyDaoInterface {
	@Autowired
	HibernateTemplate template;
	
	@Override
	public Key getLastKey() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Key.class).setProjection( Projections.max("id") );
		Integer id=(Integer)template.findByCriteria(criteria).get(0);
		 return template.get(Key.class, id);
	}

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	@Transactional
	@Override
	public void addKey(Key k) {
		template.saveOrUpdate(k);
		//template.
	}
	@Transactional
	@Override
	public void updateKey(Key k) {
		template.update(k);
		
	}
	@Transactional
	@Override
	public void deleteKey(Key k) {
		template.delete(k);
		
	}
	@Transactional
	@Override
	public List getallKeys() {
		//template.findby
		 return template.loadAll(Key.class);
	}
	@Transactional
	@Override
	public Key getKey(Integer id) {
		//DetachedCriteria criteria = DetachedCriteria.forClass(Key.class).setProjection( Projections.max("id") );
		//id=(Integer)template.findByCriteria(criteria).get(0);
		 return template.get(Key.class, id);
		
	}

}
