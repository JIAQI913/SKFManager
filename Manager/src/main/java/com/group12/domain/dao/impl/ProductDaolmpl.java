package com.group12.domain.dao.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.group12.domain.dao.ProductDao;
import com.group12.domain.entity.Product;

@Repository
public class ProductDaolmpl implements ProductDao {

	@Autowired
	SessionFactory sessionFactory;

	public Serializable save(Product product) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.save(product);
	}

}
