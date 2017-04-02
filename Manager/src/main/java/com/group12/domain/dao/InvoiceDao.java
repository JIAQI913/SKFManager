package com.group12.domain.dao;

import java.io.Serializable;

import com.group12.domain.entity.Invoice;

public interface InvoiceDao {
	Serializable save(Invoice invoice);
}
