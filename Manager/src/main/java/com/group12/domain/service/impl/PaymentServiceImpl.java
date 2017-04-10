package com.group12.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group12.domain.dao.PaymentDao;
import com.group12.domain.entity.Payment;
import com.group12.domain.entity.PaymentId;
import com.group12.domain.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	PaymentDao paymentDao;

	@Transactional
	public List<Payment> getAllPayment() {
		// TODO Auto-generated method stub
		return paymentDao.getAllPayment();
	}
	@Transactional
	public List<Payment> searchByInvNum(int invNum) {
		// TODO Auto-generated method stub
		return paymentDao.searchByInvNum(invNum);
	}
	@Transactional
	public List<Payment> searchByStuNum(int stuNum) {
		// TODO Auto-generated method stub
		return paymentDao.searchByStuNum(stuNum);
	}
	@Transactional
	public void paid(PaymentId id) {
		// TODO Auto-generated method stub
		paymentDao.paid(id);
	}

}
