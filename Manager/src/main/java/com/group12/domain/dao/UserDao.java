package com.group12.domain.dao;

import java.io.Serializable;

import com.group12.domain.entity.User;

public interface UserDao {
	User search(String userName);
	 
	void update(User user);
}