package com.group12.domain.service;

import java.util.List;

import com.group12.domain.entity.Attain;

public interface AttainService {
	List<Attain> getAllAttain();
	
	List<Attain> searchByStuNum(int stuNum);
	
	void update(Attain attain);
	
	void delete(int id);
	
	Attain searchByInv(int id);
}
