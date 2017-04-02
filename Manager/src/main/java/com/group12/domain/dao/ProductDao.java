package com.group12.domain.dao;

import java.io.Serializable;

import com.group12.domain.entity.Product;

public interface ProductDao {
	Serializable save(Product product);
}
