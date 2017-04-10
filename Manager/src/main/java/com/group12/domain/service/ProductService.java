package com.group12.domain.service;

import java.util.List;

import com.group12.domain.entity.Product;

public interface ProductService {
	List<Product> searchByInv(int id);
}
