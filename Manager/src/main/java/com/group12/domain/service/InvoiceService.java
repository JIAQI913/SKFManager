package com.group12.domain.service;

import java.io.Serializable;

import com.group12.domain.entity.Invoice;

public interface InvoiceService {
	Invoice searchById(int id);
	
	Serializable insert(Invoice invoice);
}
