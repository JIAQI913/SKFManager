package com.group12.domain.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.group12.domain.dao.AttainDao;
import com.group12.domain.entity.Attain;

@Repository
public class AttainDaolmpl implements AttainDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public Serializable save(Attain attain) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		return session.save(attain);
	}
	public List<Attain> getAllAttain() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Attain");
		List<Attain> list=query.list();
		return list;
	}
	public List<Attain> searchByStuNum(int stuNum) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Attain where id.stuNum=?").setParameter(0, stuNum);
		List<Attain> list=query.list();
		return list;
	}
	public void update(Attain attain) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.update(attain);
		session.flush();
	}
	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.delete(session.get(Attain.class, id));
		session.flush();
	}
	public Attain searchByInv(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		return (Attain) session.get(Attain.class, id);
	}

}
