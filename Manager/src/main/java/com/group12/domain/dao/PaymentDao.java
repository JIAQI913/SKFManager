package com.group12.domain.dao;

import java.io.Serializable;

import com.group12.domain.entity.Payment;

public interface PaymentDao {
	Serializable save(Payment payment);
}
