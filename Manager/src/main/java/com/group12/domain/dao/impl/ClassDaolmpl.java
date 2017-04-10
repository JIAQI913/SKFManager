package com.group12.domain.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.group12.domain.entity.Class;
import com.group12.domain.entity.Parent;
import com.group12.domain.dao.ClassDao;

@Repository
public class ClassDaolmpl implements ClassDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public Serializable save(Class c) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		return session.save(c);
	}

	public List<Class> getAllClass() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Class");
		List<Class> list=query.list();
		return list;
	}

	public void update(Class c) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.update(c);
		session.flush();
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.delete(session.get(Class.class, id));
		session.flush();
	}
	
}
