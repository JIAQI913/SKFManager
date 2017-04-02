package com.group12.domain.dao.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.group12.domain.dao.MembershipDao;
import com.group12.domain.entity.Membership;

@Repository
public class MembershipDaolmpl implements MembershipDao {

	@Autowired
	SessionFactory sessionFactory;

	public Serializable save(Membership membership) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.save(membership);
	}

}
