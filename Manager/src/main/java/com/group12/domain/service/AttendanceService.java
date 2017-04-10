package com.group12.domain.service;

import java.io.Serializable;
import java.util.List;

import com.group12.domain.entity.Attendance;

public interface AttendanceService {
	List<Attendance> getAllAttendance();
	
	void deleteAttendance(int id);
	
	Serializable insertAttendance(Attendance attendance);
}
