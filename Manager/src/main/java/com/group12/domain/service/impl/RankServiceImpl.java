package com.group12.domain.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group12.domain.dao.RankDao;
import com.group12.domain.entity.Rank;
import com.group12.domain.service.RankService;

@Service
public class RankServiceImpl implements RankService{
	@Autowired
	RankDao rankDao;

	@Transactional
	public Serializable insertData(Rank rank) {
		// TODO Auto-generated method stub
		return rankDao.save(rank);
	}
	@Transactional
	public List<Rank> getAllRank() {
		// TODO Auto-generated method stub
		return rankDao.getAllRank();
	}
	@Transactional
	public void update(Rank rank) {
		// TODO Auto-generated method stub
		rankDao.Update(rank);
	}
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		rankDao.delete(id);
	}
	
	
}
