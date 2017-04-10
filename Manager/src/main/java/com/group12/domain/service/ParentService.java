package com.group12.domain.service;

import java.io.Serializable;
import java.util.List;

import com.group12.domain.entity.Parent;

public interface ParentService {
	Serializable insertData(Parent parent);
	
	Parent getParent(int id);
	
	List<Parent> getAllParent();
	
	void updateParent(Parent parent);
	
	List<Parent> getParentS(int studentId);
	
	void deleteParent(int id);
}
