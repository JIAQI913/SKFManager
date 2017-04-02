package com.group12.domain.dao.impl;

import java.io.Serializable;

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

}
