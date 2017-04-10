package com.group12.domain.service;

import java.io.Serializable;
import java.util.List;

import com.group12.domain.entity.Class;;

public interface ClassService {
	Serializable insertData(Class c);
	
	List<Class> getAllClass();
	
	void update(Class c);
	
	void delete(int id);
}
