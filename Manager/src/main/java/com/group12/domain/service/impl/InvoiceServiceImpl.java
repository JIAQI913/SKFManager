package com.group12.domain.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group12.domain.dao.InvoiceDao;
import com.group12.domain.entity.Invoice;
import com.group12.domain.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService{
	@Autowired
	InvoiceDao invoiceDao;
	
	@Transactional
	public Invoice searchById(int id) {
		// TODO Auto-generated method stub
		return invoiceDao.search(id);
	}

}
