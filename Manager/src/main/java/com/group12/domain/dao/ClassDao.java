package com.group12.domain.dao;

import java.io.Serializable;
import java.util.List;

import com.group12.domain.entity.Class;
import com.group12.domain.entity.Student;

public interface ClassDao {
	Serializable save(Class c);
	
	List<Class> getAllClass();
}
