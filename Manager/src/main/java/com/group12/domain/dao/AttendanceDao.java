package com.group12.domain.dao;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.group12.domain.entity.Attain;
import com.group12.domain.entity.Attendance;

public interface AttendanceDao {
	Serializable save(Attendance attain);
	
	List<Attendance> getAllAttendance();
	
	void delete(int id);
}
