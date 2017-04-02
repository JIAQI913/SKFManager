package com.group12.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group12.domain.dao.UserDao;
import com.group12.domain.entity.User;
import com.group12.domain.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDao userDao;
	
	@Transactional
	public User getUser(User user){
		return userDao.search(user.getUserName());
	}
	
	@Transactional
	public void changePassword(User user){
		userDao.update(user);
	}
	
	public int judgeUser(User user, User userS) {
		// TODO Auto-generated method stub
		if(userS==null||!userS.getUserPassword().equals(user.getUserPassword())){
			return -1;
		}
		else{
			if(userS.getStuNum()!=null){
				return userS.getStuNum();
			}
		}
		return 0;
	}
}
