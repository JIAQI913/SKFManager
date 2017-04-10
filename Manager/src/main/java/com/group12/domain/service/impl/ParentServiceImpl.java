package com.group12.domain.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group12.domain.dao.ParentDao;
import com.group12.domain.entity.Parent;
import com.group12.domain.service.ParentService;

@Service
public class ParentServiceImpl implements ParentService{
	@Autowired
	ParentDao parentDao;

	@Transactional
	public Serializable insertData(Parent parent) {
		// TODO Auto-generated method stub
		return parentDao.save(parent);
	}
	
	@Transactional
	public Parent getParent(int id) {
		// TODO Auto-generated method stub
		return parentDao.search(id);
	}

	@Transactional
	public List<Parent> getAllParent() {
		// TODO Auto-generated method stub
		return parentDao.getAllStudent();
	}

	@Transactional
	public void updateParent(Parent parent) {
		// TODO Auto-generated method stub
		parentDao.update(parent);
	}
	@Transactional
	public List<Parent> getParentS(int studentId) {
		// TODO Auto-generated method stub
		return parentDao.getParentS(studentId);
	}
	@Transactional
	public void deleteParent(int id) {
		// TODO Auto-generated method stub
		parentDao.delete(id);
	}
	
}
