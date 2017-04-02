package com.group12.domain.service;

import com.group12.domain.entity.User;

public interface UserService {
/**	 0: Administrator
*	-1: PassWord or UserName is wrong
*	<0: Student and the number is steNum
*/ 
	int judgeUser(User user, User userS);
	
	User getUser(User user);
	
	void changePassword(User user);
}
