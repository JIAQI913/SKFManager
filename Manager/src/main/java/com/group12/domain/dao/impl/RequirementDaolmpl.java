package com.group12.domain.dao.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.group12.domain.dao.RequirementDao;
import com.group12.domain.entity.Requirement;

@Repository
public class RequirementDaolmpl implements RequirementDao {

	@Autowired
	SessionFactory sessionFactory;

	public Serializable save(Requirement requirement) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.save(requirement);
	}

}
