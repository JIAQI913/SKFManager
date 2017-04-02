package com.group12.domain.dao.impl;

import java.io.Serializable;

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

}
