package com.group12.domain.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group12.domain.dao.StudentDao;
import com.group12.domain.entity.Student;
import com.group12.domain.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	StudentDao studentDao;
	
	@Transactional
	public Serializable insertData(Student student) {
		// TODO Auto-generated method stub
		return studentDao.save(student);
	}
	@Transactional
	public Student getStudent(int id) {
		// TODO Auto-generated method stub
		return studentDao.search(id);
	}
	
	public boolean isEmpty(Student student){
		if(student==null){
			return false;
		}
		return true;
	}
	@Transactional
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub		
		return studentDao.getAllStudent();
	}
	@Transactional
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		studentDao.update(student);
	}
}
