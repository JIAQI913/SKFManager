package com.group12.domain.dao.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.group12.domain.dao.InvoiceDao;
import com.group12.domain.entity.Invoice;

@Repository
public class InvoiceDaolmpl implements InvoiceDao {

	@Autowired
	SessionFactory sessionFactory;

	public Serializable save(Invoice invoice) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.save(invoice);
	}

	public Invoice search(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		return (Invoice) session.get(Invoice.class, id);
	}

}
