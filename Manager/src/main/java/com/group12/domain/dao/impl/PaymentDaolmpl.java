package com.group12.domain.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.group12.domain.dao.PaymentDao;
import com.group12.domain.entity.Payment;

@Repository
public class PaymentDaolmpl implements PaymentDao {

	@Autowired
	SessionFactory sessionFactory;

	public Serializable save(Payment payment) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.save(payment);
	}

	public List<Payment> getAllPayment() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Payment");
		List<Payment> list=query.list();
		return list;
	}

}
