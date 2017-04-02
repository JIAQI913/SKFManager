package com.group12.domain.dao;

import java.io.Serializable;
import java.util.List;

import com.group12.domain.entity.Student;

public interface StudentDao {
	Serializable save(Student student);
	
	Student search(int id);
	
	List<Student> getAllStudent(); 
	
	void update(Student student);
}
