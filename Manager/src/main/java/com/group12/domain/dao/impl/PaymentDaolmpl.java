package com.group12.domain.dao.impl;

import java.io.Serializable;

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

}
