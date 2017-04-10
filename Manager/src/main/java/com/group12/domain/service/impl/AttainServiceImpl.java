package com.group12.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group12.domain.dao.AttainDao;
import com.group12.domain.entity.Attain;
import com.group12.domain.service.AttainService;

@Service
public class AttainServiceImpl implements AttainService{

	@Autowired
	AttainDao attainDao;
	
	@Transactional
	public List<Attain> getAllAttain() {
		// TODO Auto-generated method stub
		return attainDao.getAllAttain();
	}
	@Transactional
	public List<Attain> searchByStuNum(int stuNum) {
		// TODO Auto-generated method stub
		return attainDao.searchByStuNum(stuNum);
	}
	@Transactional
	public void update(Attain attain) {
		// TODO Auto-generated method stub
		attainDao.update(attain);
	}
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		attainDao.delete(id);
	}
	@Transactional
	public Attain searchByInv(int id) {
		// TODO Auto-generated method stub
		return attainDao.searchByInv(id);
	}

}
