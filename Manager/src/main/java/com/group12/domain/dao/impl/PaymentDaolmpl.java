package com.group12.domain.dao.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.group12.domain.dao.PaymentDao;
import com.group12.domain.entity.Payment;
import com.group12.domain.entity.PaymentId;

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

	public List<Payment> searchByInvNum(int invNum) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Payment where id.invNum=?").setParameter(0, invNum);
		List<Payment> list=query.list();
		return list;
	}

	public List<Payment> searchByStuNum(int stuNum) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Payment where id.stuNum=?").setParameter(0, stuNum);
		List<Payment> list=query.list();
		return list;
	}

	public void paid(PaymentId id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Payment payment=(Payment) session.get(Payment.class, id);
		payment.setPayFailed(true);
		payment.setPayPayTime(new Date());
		session.update(payment);
		session.flush();
	}

}
