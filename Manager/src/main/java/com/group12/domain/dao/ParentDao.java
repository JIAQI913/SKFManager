package com.group12.domain.dao;

import java.io.Serializable;
import java.util.List;

import com.group12.domain.entity.Parent;
import com.group12.domain.entity.Student;

public interface ParentDao {
	Serializable save(Parent parent);
	
	Parent search(int id);
	
	List<Parent> getAllStudent();
	
	void update(Parent parent);
	
	List<Parent> getParentS(int studentId);
	
	void delete(int id);
}
