package com.group12.domain.dao;

import java.io.Serializable;

import com.group12.domain.entity.Membership;

public interface MembershipDao {
	Serializable save(Membership membership);
	
	Membership searchByInv(int id);
	
	void update(Membership membership);
}
