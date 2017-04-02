package com.group12.domain.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.group12.domain.dao.UserDao;
import com.group12.domain.entity.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public User search(String userName) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		User user=(User) session.get(User.class, userName);
//		System.out.println(user.getUserName());
//		System.out.println(user.getUserPassword());
//		System.out.println(user.getStuNum());
		return user;
	}
	public void update(User user) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.update(user);
		session.flush();
	}

}
