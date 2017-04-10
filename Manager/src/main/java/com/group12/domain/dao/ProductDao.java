package com.group12.domain.dao;

import java.io.Serializable;
import java.util.List;

import com.group12.domain.entity.Product;

public interface ProductDao {
	Serializable save(Product product);
	
	List<Product> searchByInv(int id);
	
	void update(Product product);
}
