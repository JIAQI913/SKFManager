package com.group12.domain.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
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

	public List<Product> searchByInv(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Product where id.invNum=?").setParameter(0, id);
		return (List<Product>) query.list();
	}

	public void update(Product product) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.update(product);
		session.flush();
	}
}
