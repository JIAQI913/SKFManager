package com.group12.domain.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group12.domain.dao.ProductDao;
import com.group12.domain.entity.Product;
import com.group12.domain.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductDao productDao;
	
	@Transactional
	public List<Product> searchByInv(int id) {
		// TODO Auto-generated method stub
		return productDao.searchByInv(id);
	}
}
