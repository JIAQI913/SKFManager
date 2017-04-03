package com.group12.domain.service;

import java.io.Serializable;
import java.util.List;

import com.group12.domain.entity.Student;

public interface StudentService {
	Serializable insertData(Student student);
	
	Student getStudent(int id);
	
	List<Student> getAllStudent();
	
	void updateStudent(Student student);
}
