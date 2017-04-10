package com.group12.domain.dao;

import java.io.Serializable;
import java.util.List;

import com.group12.domain.entity.Rank;

public interface RankDao {
	Serializable save(Rank rank);
	
	List<Rank> getAllRank();
	
	void Update(Rank rank);
	
	void delete(int id);
	
	int getNum(String belt);
}
