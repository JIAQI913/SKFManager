package com.group12.domain.service;

import java.io.Serializable;
import java.util.List;

import com.group12.domain.entity.Rank;

public interface RankService {
	Serializable insertData(Rank rank);
	
	List<Rank> getAllRank();
	
	void update(Rank rank);
	
	void delete(int id);
	
	int getNum(String belt);
}
