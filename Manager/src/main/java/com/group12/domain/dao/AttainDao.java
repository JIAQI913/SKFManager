package com.group12.domain.dao;

import java.io.Serializable;
import java.util.List;

import com.group12.domain.entity.Attain;

public interface AttainDao {
	Serializable save(Attain attain);
	
	List<Attain> getAllAttain();
	
	List<Attain> searchByStuNum(int stuNum);
	
	void update(Attain attain);
	
	void delete(int id);
	
	Attain searchByInv(int id);
}
