package com.group12.domain.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.group12.domain.dao.RankDao;
import com.group12.domain.entity.Class;
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

	public List<Rank> getAllRank() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Rank");
		List<Rank> list=query.list();
		return list;
	}

	public void Update(Rank rank) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(rank);
		session.flush();
		
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.delete(session.get(Rank.class, id));
		session.flush();
	}

	public int getNum(String belt) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Rank where rankBelt=?").setParameter(0, belt);
		List<Rank> list=query.list();
		return list.get(0).getRankNum();
	}

}
