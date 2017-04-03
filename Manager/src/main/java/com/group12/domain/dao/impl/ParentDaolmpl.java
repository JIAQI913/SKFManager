package com.group12.domain.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.group12.domain.dao.ParentDao;
import com.group12.domain.entity.Parent;

@Repository
public class ParentDaolmpl implements ParentDao {

	@Autowired
	SessionFactory sessionFactory;

	public Serializable save(Parent parent) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.save(parent);
	}

	public Parent search(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Parent parent=(Parent)session.get(Parent.class, id);
		return parent;
	}

	public List<Parent> getAllStudent() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Parent");
		List<Parent> list=query.list();
		return list;
	}

	public void update(Parent parent) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.update(parent);
		session.flush();
	}

	public List<Parent> getParentS(int studentId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Parent where id = ?").setParameter(0, studentId);
		return query.list();
	}

}
