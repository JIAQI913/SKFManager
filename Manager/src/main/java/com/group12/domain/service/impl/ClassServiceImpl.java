package com.group12.domain.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group12.domain.dao.ClassDao;
import com.group12.domain.entity.Class;
import com.group12.domain.service.ClassService;

@Service
public class ClassServiceImpl implements ClassService{
	@Autowired
	ClassDao classDao;
	
	@Transactional
	public Serializable insertData(Class c) {
		// TODO Auto-generated method stub
		return classDao.save(c);
	}

	@Transactional
	public List<Class> getAllClass() {
		// TODO Auto-generated method stub
		return classDao.getAllClass();
	}
	@Transactional
	public void update(Class c) {
		// TODO Auto-generated method stub
		classDao.update(c);
	}
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		classDao.delete(id);
	}

}
