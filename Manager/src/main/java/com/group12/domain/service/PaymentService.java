package com.group12.domain.service;

import java.io.Serializable;
import java.util.List;

import com.group12.domain.entity.Payment;
import com.group12.domain.entity.PaymentId;

public interface PaymentService {
	List<Payment> getAllPayment();
	
	List<Payment> searchByInvNum(int invNum);
	
	List<Payment> searchByStuNum(int stuNum);
	
	void paid(PaymentId id);
	
	Serializable insert(Payment payment);
}
