package com.group12.domain.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group12.domain.dao.MembershipDao;
import com.group12.domain.entity.Membership;
import com.group12.domain.service.MembershipService;

@Service
public class MembershipServiceImpl implements MembershipService{
	@Autowired
	MembershipDao membershipDao;

	@Transactional
	public Membership searchByInv(int id) {
		// TODO Auto-generated method stub
		return membershipDao.searchByInv(id);
	}
}
