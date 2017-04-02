package com.group12.domain.dao.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.group12.domain.dao.RankDao;
import com.group12.domain.entity.Rank;

@Repository
public class RankDaolmpl implements RankDao {

	@Autowired
	SessionFactory sessionFactory;

	public Serializable save(Rank rank) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.save(rank);
	}

}
