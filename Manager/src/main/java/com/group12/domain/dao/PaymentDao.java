package com.group12.domain.dao;

import java.io.Serializable;
import java.util.List;

import com.group12.domain.entity.Payment;
import com.group12.domain.entity.PaymentId;

public interface PaymentDao {
	Serializable save(Payment payment);
	
	List<Payment> getAllPayment();
	
	List<Payment> searchByInvNum(int invNum);
	
	List<Payment> searchByStuNum(int stuNum);
	
	void paid(PaymentId id);
}
